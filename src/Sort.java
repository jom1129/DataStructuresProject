/**
 * Utility class that contains Sorting algorithms
 * and helper methods.
 * Code adapted From R. Sedgewick's Algorithms 4th ed.
 * Book homepage: https://algs4.cs.princeton.edu/home/
 */
public class Sort {

    /**
     * Prevent instantiation of this utility class.
     */
    private Sort() { }

    /**
     * Records the number of instructions
     * when executing sorting algorithms.
     */
    protected static double counter = 0;


    /**
     * @param prev previous value
     * @param next subsequent value
     * @return tests if previous is less than the following value.
     */
    private static boolean lessThan(int prev, int next) {
        incrementCounter(1);    // prev < next test
        return prev < next;
    }

    /** Sets the counter variable to the passed parameter.
     * @param c set the counter variable to the value of this.
     */
    private static void setCounter(int c) {
        counter = c;
    }

    /**
     * @param i add this value to the counter variable.
     */
    private static void incrementCounter(int i) {
        counter += i;
    }

    /** Swaps the values of an array, to be used with lessThan()
     * @param arr the array to be sorted
     * @param i base index
     * @param j swap with i, j usually succeeds i
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        incrementCounter(3);
    }

    /** Implementation of the Selection Sort algorithm
     * @param arr array to be sorted
     */
    protected static void selection(int[] arr) {
        setCounter(0); // set counter to zero
        int n = arr.length;
        incrementCounter(2);    // int n, initialization for i
        for (int i = 0; i < n; i++, incrementCounter(6)) { // i < n test, minIndex, i++ and
                                                             // j reinitialization (2 operations)
            int minIndex = i;
            for (int j = i + 1; j < n; j++, incrementCounter(2)) { // j < n test, j++
                if (lessThan(arr[j], arr[minIndex])) {
                    minIndex = j;
                    incrementCounter(1);    // minIndex
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /** Implementation of the Insertion Sort Algorithm.
     * @param arr array to be sorted.
     */
    protected static void insertion(int[] arr) {
        setCounter(0); // set counter to 0
        int n = arr.length;
        incrementCounter(2);    // int n, initialization for i
        for (int i = 1; i < n; i++, incrementCounter(3)) {  // i < n, i++ and j reinitialization
            for (int j = i; j > 0 && lessThan(arr[j], arr[j-1]); j--, incrementCounter(3))  // j > 0 test, j--
                swap(arr, j, j - 1);                                                        // j -1
        }
    }

    /** Implementation of the Bubble Sort Algorithm.
     * @param arr array to be sorted
     */
    protected static void bubble(int[] arr) {
        setCounter(0);  // set counter to 0
        int n = arr.length;
        incrementCounter(2);    // int n, initialization for i
        for (int i = 0; i < n-1; i++, incrementCounter(4))  // i < n -1 test (2 op), j reinitialization, i++
            for (int j = 0; j < n- i - 1; j++, incrementCounter(5)) // j < n - i - 1 (3 op), j++ and arr[j+1]
                if (lessThan(arr[j + 1], arr[j])) {
                    swap(arr, j, j + 1);
                }
    }
}
