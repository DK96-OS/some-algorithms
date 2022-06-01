package io.github.dk96os.algorithms.bench;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import io.github.dk96os.algorithms.AlgorithmArgumentsProvider;
import io.github.dk96os.algorithms.MaxDistanceInterface;
import io.github.dk96os.algorithms.data.IntegerArrayDataProvider;

/** Benchmarking the Algorithms against Valley-shaped data sets.
 * @author DK96-OS : 2022
 */
public final class AlgorithmValleyBench {

	private static final int[] data1 = IntegerArrayDataProvider.valleyDistribution(
		1000, 100_000
	);
	private static final int data1Answer = data1.length - 1;

	private static final int[] data2 = IntegerArrayDataProvider.valleyDistribution(
		20_000, Integer.MAX_VALUE
	);
	private static final int data2Answer = data2.length - 1;

	@ParameterizedTest
	@ArgumentsSource(
		AlgorithmArgumentsProvider.class
	)
	public void testDataset1(
		final MaxDistanceInterface algorithm
	) {
		long timeRequired = AlgorithmBenchmarkHelper.nanoTime(
			algorithm,
			data1,
			data1Answer
		);
		AlgorithmBenchmarkHelper.print(
			algorithm, timeRequired
		);
	}

	@ParameterizedTest
	@ArgumentsSource(
		AlgorithmArgumentsProvider.class
	)
	public void testDataset2(
		final MaxDistanceInterface algorithm
	) {
		long timeRequired = AlgorithmBenchmarkHelper.nanoTime(
			algorithm,
			data2,
			data2Answer
		);
		AlgorithmBenchmarkHelper.print(
			algorithm, timeRequired
		);
	}

}