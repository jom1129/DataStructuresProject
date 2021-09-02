// Code adapted From R. Sedgewick's Algorithms 4th ed.
// Book homepage: https://algs4.cs.princeton.edu/home/

public final class Timer {  // Do not extend the timer class
    /*
        Usage:
            1. Instantiate. Upon instantiation the current system time
               is recorded. // Timer timer = new Timer();
            2. After performing the sorting operations, invoke
               timeElapsed(). // timer.timeElapsed()
     */


    private long startTime; // holds the beginning time

    /**
     * Records the current system time upon instantiation.
     * This is why it is necessary that the instantiation procedure
     * Be the FIRST** statement in a sorting algorithm
     */
    public Timer() { startTime = System.currentTimeMillis(); }  // Assigns the current time
                                                                // to startTime
                                                                // upon instantiation
    /**
     * Subtracts the beginning time from the current system time
     * to compute for the elapsed time
     * division by 1000.00 is necessary because time is represented
     * using in milliseconds.
     * @return the elapsed time
     */

    public double timeElapsed() {
        long currentTime = System.currentTimeMillis(); // Re-invocation of the method
        return (currentTime - startTime) / 1000.0;     // returns the updated time
    }
}
