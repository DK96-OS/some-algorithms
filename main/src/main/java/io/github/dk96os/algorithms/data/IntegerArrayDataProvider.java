package io.github.dk96os.algorithms.data;

/** Provides Testing Data
 * @author DK96-OS : 2022
 */
public final class IntegerArrayDataProvider {

	public static int[] valleyDistribution(
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
		// Validate Edge Values
		if (edgeValues < 0)
			throw new IllegalArgumentException(
				"Edge Values must be non-negative"
			);
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
		return array;
	}

}