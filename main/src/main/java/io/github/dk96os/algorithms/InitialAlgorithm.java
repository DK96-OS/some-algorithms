package io.github.dk96os.algorithms;

/** The starting point for developing an algorithm
 */
public final class InitialAlgorithm {

	/** A function that looks for the maximum distance between equal values.
	 * @param array An input array of integer values.
	 * @return The largest distance between any two equal integers.
	 */
	public static int searchMaxDistance(
		final int[] array
	) {
		int distance = 0;
		for (
			int i = 0; i < array.length; ++i
		) for (
			int j = i + 1; j < array.length; ++j
		) {
			if (array[i] == array[j]) {
				distance = Math.max(
					distance, j - i
				);
			}
		}
		return distance;
	}

}