package maxdistance.algorithms;

/** An Updated DistanceAwareBreakingAlgorithm that includes:
 * Breaking the inner loop when the distance is greater than the remaining indices.
 */
public final class DoubleDistanceBreakingAlgorithm
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
			final int innerIndexBound = i + distance;
			final int leftValue = array[i];
			for (
				// Reverse Array Index Traversal order
				int j = array.length - 1; j > innerIndexBound; --j
			) {
				if (leftValue == array[j]) {
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