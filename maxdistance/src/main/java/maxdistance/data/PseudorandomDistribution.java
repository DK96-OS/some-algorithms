package maxdistance.data;

import java.util.Random;

/** Generates Pseudorandom Numbers for the Algorithm.
 */
public final class PseudorandomDistribution
	implements AlgorithmDataProvider {

	public final int arrayLength;
	public final int minRange;
	public final int count;
	public final long seed;

	private final int[] mArray;

	/**
	 * @param arrayLength The length of the new array.
	 * @param min The lowest value in the range.
	 * @param count The number of values in the range.
	 * @param seed The Random seed.
	 */
	public PseudorandomDistribution(
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
		//
		var rng = new Random(seed);
		final int[] array = new int[arrayLength];
		int index = 0;
		for (;
		     index < arrayLength;
		     ++index
		) array[index] = min + rng.nextInt(count);
		// Set Member Properties
		this.arrayLength = arrayLength;
		this.minRange = min;
		this.count = count;
		this.seed = seed;
		mArray = array;
	}

	@Override
	public int[] getArray() {
		return mArray;
	}

}