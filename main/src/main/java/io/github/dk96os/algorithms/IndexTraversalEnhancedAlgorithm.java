package io.github.dk96os.algorithms;

/** Searches secondary indices in reverse order.
 * @author DK96-OS : 2022
 */
public class IndexTraversalEnhancedAlgorithm
	implements MaxDistanceInterface {

	@Override
	public int searchMaxDistance(
		final int[] array
	) {
		int distance = 0;
		for (
			int i = 0; i < array.length; ++i
		) for (
			// Reverse Array Index Traversal order
			int j = array.length - 1; j > i; --j
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