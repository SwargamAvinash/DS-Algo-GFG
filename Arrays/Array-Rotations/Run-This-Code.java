import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person {
    private String name;
    private long birthTime;

    public Person() {}
    public Person(String name, long birthTime) {
        this.name = name;
        this.birthTime = birthTime;
    }

    @Override public int hashCode() { return Objects.hash(name, birthTime); }
    @Override public boolean equals(Object obj) {
        if (this == obj)              { return true;  }
        if (!(obj instanceof Person)) { return false; }
        Person other = (Person) obj;
        return Objects.equals(name, other.name)
                && birthTime == other.birthTime;
    }
    public String getName()                    { return name;                }
    public void   setName(String name)         { this.name = name;           }
    public long   getBirthTime()               { return birthTime;           }
    public void   setBirthTime(long birthTime) { this.birthTime = birthTime; }

    public static void main(String[] args) {
        Map<Person, Person> map = new HashMap<>();
        Person p = new Person("alice", 3);
        System.out.println("1. " + map.containsKey(p)); // false
        map.put(p, p);
        System.out.println("2. " + map.containsKey(p)); // true
        p.setName("charlie");
        System.out.println("3. " + map.containsKey(p)); // false
        Person p2 = new Person("alice", 3);
        System.out.println("4. " + map.containsKey(p2)); // true
        Person p3 = new Person("charlie", 3);
        System.out.println("5. " + map.containsKey(p3)); // false
	}
}