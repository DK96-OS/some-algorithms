package maxdistance.algorithms;

/** An Updated IndexTraversalEnhancedWithBreakAlgorithm that includes:
 * Breaking the outer loop when the distance is greater than the remaining indices.
 */
public final class DistanceAwareBreakingAlgorithm
	implements MaxDistanceAlgorithm {

	@Override
	public int searchMaxDistance(
		final int[] array
	) {
		int distance = 0;
		for (
			int i = 0; i < array.length; ++i
		) {
			final int remainingIndices = array.length - 1 - i;
			if (distance > remainingIndices)
				break;
			for (
				// Reverse Array Index Traversal order
				int j = array.length - 1; j > i; --j
			) {
				if (array[i] == array[j]) {
					distance = Math.max(
						distance, j - i
					);
					break;
				}
			}
		}
		return distance;
	}

}