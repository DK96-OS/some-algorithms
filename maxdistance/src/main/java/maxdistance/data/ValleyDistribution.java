package maxdistance.data;

/** A Distribution that starts at some peak value at the edges,
 * and decreases linearly towards the center.
 */
public final class ValleyDistribution
	implements AlgorithmDataProvider {

	public final int arrayLength;
	public final int edgeValue;
	private final int[] mArray;

	public ValleyDistribution(
		final int arrayLength,
		final int edgeValues
	) {
		// Validate Array Length
		if (arrayLength > 1_000_000)
			throw new IllegalArgumentException(
				"Array Length too large"
			);
		else if (arrayLength < 3)
			throw new IllegalArgumentException(
				"Array Length too small"
			);
		this.arrayLength = arrayLength;
		// Validate Edge Values
		if (edgeValues < 0)
			throw new IllegalArgumentException(
				"Edge Values must be non-negative"
			);
		this.edgeValue = edgeValues;
		// Check Array Indexing properties
		final boolean isArrayEven = arrayLength % 2 == 0;
		final int[] array = new int[arrayLength];
		//
		final int mirrorIndex = -1 + arrayLength / 2;
		// Insert value pairs into Array
		int pairValue = edgeValues;
		for (
			int i = 0;
			i <= mirrorIndex;
		) {
			array[i++] = pairValue;
			array[arrayLength - i] = pairValue;
			pairValue--;
		}
		// For Odd Length Arrays, insert one additional value
		if (!isArrayEven) {
			array[mirrorIndex + 1] = pairValue;
		}
		mArray = array;
	}

	/** Returns the Distribution's Data Array.
	 * @return The Array.
	 */
	@Override
	public int[] getArray() {
		return mArray;
	}

}