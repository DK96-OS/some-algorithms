package maxdistance.algorithms;

/** Search Maximum Distance - Algorithm Interface
 * @author DK96-OS : 2022
 */
public interface MaxDistanceAlgorithm {

	/** A function that looks for the maximum distance between equal values.
	 * @param array An input array of integer values.
	 * @return The largest distance between any two equal integers.
	 */
	int searchMaxDistance(
		final int[] array
	);

}