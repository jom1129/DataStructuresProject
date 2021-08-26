
// Code adapted From R. Sedgewick's Algorithms 4th ed.
// Book homepage: https://algs4.cs.princeton.edu/home/

public class Timer {
    /*
        Usage:
            1. Instantiate. Upon instantiation the current system time
               is recorded. // Timer timer = new Timer();
            2. After performing the sorting operations, invoke
               timeElapsed(). // timer.timeElapsed()
     */

    private long startTime; // holds the beginning time
    public Timer() { startTime = System.currentTimeMillis(); }  // Assigns the current time
                                                                // to startTime
                                                                // upon instantiation
    public double timeElapsed() {
        long currentTime = System.currentTimeMillis(); // Re-invocation of the method
        return (currentTime - startTime) / 1000.0;     // returns the updated time
    }
}
