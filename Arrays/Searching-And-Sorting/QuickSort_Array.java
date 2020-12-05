/* The main function that implements QuickSort() (present in a class 
   different from QuickSort)
   arr[] --> Array to be sorted,   low  --> Starting index,  high  --> Ending index 
static void quickSort(int arr[], int low, int high)
{
    if (low < high)
    {
        
        int pi = new QuickSort().partition(arr, low, high);
        quickSort(arr, low, pi-1);
        quickSort(arr, pi+1, high);
    } }*/
class QuickSort
{
    
    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /* This function takes last element as pivot, places  the pivot element 
    at its correct position in sorted  array, and places all smaller (smaller
    than pivot) to left of pivot and all greater elements to right  of pivot */
    static int partition(int arr[], int low, int high)
    {
        // add your code here
        int pivot = arr[high];
        int lowValuesIndex = low - 1;
        for (int j=low;j<high;j++) {
            if (arr[j] <= pivot) {
                lowValuesIndex++;
                swap(arr, lowValuesIndex, j);
            }
        }
        lowValuesIndex = lowValuesIndex+1;
        swap(arr, lowValuesIndex, high);
        return lowValuesIndex;
    } 
}