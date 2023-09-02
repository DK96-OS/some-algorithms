package maxdistance.bench;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import maxdistance.algorithms.MaxDistanceInterface;
import maxdistance.data.ValleyDistribution;
import maxdistance.algorithms.AlgorithmArgumentsProvider;

/** Benchmarking the Algorithms against Valley-shaped data sets.
 * @author DK96-OS : 2022
 */
public final class AlgorithmValleyBench {

	private static final ValleyDistribution data1 = new ValleyDistribution(
		1000, 100_000
	);
	private static final int data1Answer = data1.arrayLength - 1;

	private static final ValleyDistribution data2 = new ValleyDistribution(
		20_000, Integer.MAX_VALUE
	);
	private static final int data2Answer = data2.arrayLength - 1;

	@ParameterizedTest
	@ArgumentsSource(
		AlgorithmArgumentsProvider.class
	)
	public void testDataset1(
		final MaxDistanceInterface algorithm
	) {
		long timeRequired = AlgorithmBenchmarkHelper.nanoTime(
			algorithm,
			data1.getArray(),
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
			data2.getArray(),
			data2Answer
		);
		AlgorithmBenchmarkHelper.print(
			algorithm, timeRequired
		);
	}

}