class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getLength() {
        return this.y - this.x;
    }
    
    public boolean contains(int val) {
        if (val > x && val < y) return true;
        return false;
    }
    
    public List<Point> split(int split) {
        List<Point> splits = new ArrayList<>();
        splits.add(new Point(this.x, split));
        splits.add(new Point(split, this.y));
        
        return splits;
    }
    
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Point)) {
			return false;
		}
		Point point = (Point) o;
		return x == point.x && y == point.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
    
    @Override
    public String toString() {
        return "{ x :" + x + ", y :" + y + " }";
    }
}
class Solution {
    public int minCost(int n, int[] cuts) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, n));
        
        System.out.println(points);
        int cost = 0;
        for (int i=0 ; i < cuts.length; i++) {
            for (Point point : points) {
                if (point.contains(cuts[i])) {
                    cost += point.getLength();
                    points.remove(point);
                    points.addAll(point.split(cuts[i]));
                    break;
                }
            }
            System.out.println(points);
        }
        
        return cost;
    }
}