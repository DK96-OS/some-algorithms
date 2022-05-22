package io.github.dk96os.algorithms.data;

import java.util.Random;

/** Provides Testing Data
 * @author DK96-OS : 2022
 */
public final class IntegerArrayDataProvider {

	/** Create a sequence of numbers that descend at first,
	 *  and start to reascend halfway.
	 * @param arrayLength The length of the array to create.
	 * @param edgeValues The values at the ends of the array (symmetric).
	 * @return A new array of integers.
	 */
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

	/** Create a pseudo-random array of integers.
	 * @param arrayLength The length of the new array.
	 * @param min The lowest value in the range.
	 * @param count The number of values in the range.
	 * @param seed The Random seed.
	 * @return A new integer array of pseudo-random numbers.
	 */
	public static int[] pseudoRandomRange(
		final int arrayLength,
		final int min,
		final int count,
		final long seed
	) {
		if (100_000_000 < arrayLength || 1 > arrayLength)
			throw new IllegalArgumentException(
				String.format(
					"Invalid ArrayLength: %d", arrayLength
				)
			);
		if (1 > count)
			throw new IllegalArgumentException(
				String.format(
					"Invalid count: %d", count
				)
			);
		// todo: If min + count is greater than Int Max
		// The Random should return specific values for a seed
		var rng = new Random(seed);
		final int[] array = new int[arrayLength];
		int index = 0;
		for (;
			index < arrayLength;
			++index
		) array[index] = min + rng.nextInt(count);
		return array;
	}

}