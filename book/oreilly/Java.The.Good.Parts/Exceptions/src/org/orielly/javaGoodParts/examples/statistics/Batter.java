package org.orielly.javaGoodParts.examples.statistics;


/**
 * An interface that defines the notion of a batter
 * in a baseball statistics package. Each at-bat will
 * be recorded for the hitter, along with the result of
 * that at-bat. Running totals of the important statistics
 * will be available.
 * @author waldo
 *
 */
public interface Batter {
	/**
	 * The possible results of an at-bat for the hitter
	 * @author waldo
	 *
	 */
	public enum AtBatResult {
		strikeOut, fieldOut, base1, base2, base3, base4, walk, 
		reachOnError, sacrifice
	}
	/**
         * Return the name of the batter, as a <code>String</code>
         */
        public String getName();
        
	/**
	 * Method used to record an at-bat. The result
	 * of the at-bat is passed in and recorded
	 * @param what The result of the at-bat
	 */
	public void atBat(AtBatResult what);
	/**
	 * Returns the batting average for the hitter, defined as
	 * number of hits divided by the number of at-bats
	 * @return The batting average, as a float
	 * @throws NotEnoughAtBatsException if the number of at-bats is
	 * insufficient to establish a meaningful average
	 */
	float getAverage() throws NotEnoughAtBatsException;
	/**
	 * Returns the on-base percentage for this hitter, defined as
	 * (hits + walks)/at-bats
	 * @return the on-base percentage
	 * @throws NotEnoughAtBatsException if the number of at-bats, walks,
	 * and sacrifices is insufficient to establish a meaningful on-base
	 * percentage
	 */
	float getOBP() throws NotEnoughAtBatsException;
	/**
	 * Return the slugging percentage for the batter, defined as
	 * total number of bases / at bats
	 * @return The slugging percentage, as a float
	 * @throws NotEnoughAtBatsException if the number of at-bats is 
	 * insufficient to establish a meaningful average
	 */
	float getSlugging() throws NotEnoughAtBatsException;
	/**
	 * Return the total number of bases for the hitter
	 * @return Total bases, as an integer
	 * @throws NotEnoughAtBatsException if the number of at-bats is 
	 * insufficient to establish a meaningful average
	 */
	int getTotalBases() throws NotEnoughAtBatsException;
	/**
	 * return the total number of at-bats for this hitter. Note that
	 * walks and sacrifices do not count as at-bats
	 * @return
	 */
	int getAtBats();

}
