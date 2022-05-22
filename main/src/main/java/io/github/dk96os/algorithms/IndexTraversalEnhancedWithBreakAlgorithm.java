package io.github.dk96os.algorithms;

/** Searches secondary indices in reverse order,
 *  and uses a breaking condition (enabled by reverse order)
 * @author DK96-OS : 2022
 */
public class IndexTraversalEnhancedWithBreakAlgorithm
	implements MaxDistanceInterface {

	@Override
	public int searchMaxDistance(
		final int[] array
	) {
		int distance = 0;
		for (
			int i = 0; i < array.length; ++i
		) for (
			int j = array.length - 1; j > i; --j
		) {
			if (array[i] == array[j]) {
				distance = Math.max(
					distance, j - i
				);
				// Add a break because any other matches
				// with index i will have a smaller distance
				break;
			}
		}
		return distance;
	}

}