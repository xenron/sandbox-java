package org.orielly.javaGoodParts.examples.statistics;


public interface Catcher extends Fielder {
    /**
     * Record a passed ball
     */
    public void PassedBall();

    /**
     * Get how many passed balls this catcher
     * has allowed
     */
    int getPassedBalls();
}
