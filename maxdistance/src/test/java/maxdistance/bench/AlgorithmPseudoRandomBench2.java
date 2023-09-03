package maxdistance.bench;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import maxdistance.algorithms.AlgorithmArgumentsProvider;
import maxdistance.algorithms.MaxDistanceAlgorithm;
import maxdistance.data.PseudorandomDistribution;

/** Benchmarking the Algorithms against pseudo-random data sets.
 * @author DK96-OS : 2022
 */
public final class AlgorithmPseudoRandomBench2 {

	/** Dataset 1
	 */
	private static PseudorandomDistribution data1;
	private static final int data1Answer = 48243;

	/** Dataset 2
	 */
	private static PseudorandomDistribution data2;
	private static final int data2Answer = 48717;

	@BeforeAll
	public static void testSetup() {
		data1 = new PseudorandomDistribution(
			50_000, 0, 1_000_000, 88L
		);
		data2 = new PseudorandomDistribution(
			50_000, -1_000_000, 1_000_000, 12345L
		);
	}

	@ParameterizedTest
	@ArgumentsSource(
		AlgorithmArgumentsProvider.class
	)
	public void testDataset1(
		final MaxDistanceAlgorithm algorithm
	) {
		long timeRequired = AlgorithmBenchmarkHelper.nanoTime(
			algorithm, data1.getArray(), data1Answer
		);
		AlgorithmBenchmarkHelper.print(
			algorithm, timeRequired
		);
	}

	@Tag("Slow")
	@ParameterizedTest
	@ArgumentsSource(
		AlgorithmArgumentsProvider.class
	)
	public void testDataset2(
		final MaxDistanceAlgorithm algorithm
	) {
		long timeRequired = AlgorithmBenchmarkHelper.nanoTime(
			algorithm, data2.getArray(), data2Answer
		);
		AlgorithmBenchmarkHelper.print(
			algorithm, timeRequired
		);
	}

}