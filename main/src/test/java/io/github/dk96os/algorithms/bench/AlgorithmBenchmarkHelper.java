package io.github.dk96os.algorithms.bench;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.dk96os.algorithms.MaxDistanceInterface;

/** Benchmark Methods for use in Tests.
 * @author DK96-OS : 2022
 */
public final class AlgorithmBenchmarkHelper {

	/** Runs the Algorithm on the given data set.
	 *  Performs an assertion on the output of the Algorithm.
	 * @param algorithm The algorithm to run and measure.
	 * @param dataset The data set to provide to the algorithm.
	 * @param expectedResult The expected output of the algorithm.
	 * @return The system time in nanoseconds to process the data set.
	 */
	public static long nanoTime(
		final MaxDistanceInterface algorithm,
		final int[] dataset,
		final int expectedResult
	) {
		final long initialTime = System.nanoTime();
		int result = algorithm.searchMaxDistance(dataset);
		long finalTime = System.nanoTime();
		assertEquals(
			expectedResult, result
		);
		return finalTime - initialTime;
	}

	/** Prints the name of the Algorithm, and then an integer value.
	 * @param algorithm The Algorithm whose name will be shown.
	 * @param value The value to print beside the Algorithm name.
	 */
	public static void print(
		final MaxDistanceInterface algorithm,
		final long value
	) {
		final String algName = algorithm.getClass().getSimpleName();
		System.out.printf(
			"%s : %d\n", algName, value
		);
	}

}