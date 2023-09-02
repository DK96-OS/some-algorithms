package maxdistance.bench;

import static maxdistance.data.IntegerArrayDataProvider.pseudoRandomRange;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import maxdistance.algorithms.AlgorithmArgumentsProvider;
import maxdistance.algorithms.MaxDistanceInterface;

/** Benchmarking the Algorithms against pseudo-random data sets.
 * @author DK96-OS : 2022
 */
public final class AlgorithmPseudoRandomBench {

	/** Dataset 1
	 */
	private static int[] data1;
	private static final int data1Answer = 93;

	/** Dataset 2
	 */
	private static int[] data2;
	private static final int data2Answer = 48994;

	/** Dataset 3
	 */
	private static int[] data3;
	private static final int data3Answer = 9997;

	@BeforeAll
	public static void testSetup() {
		data1 = pseudoRandomRange(
			100, 40, 20, 88L
		);
		data2 = pseudoRandomRange(
			50_000, 1, 100_000, 12345L
		);
		data3 = pseudoRandomRange(
			20_000, 1, 100_000_000, 12345L
		);
	}

	@ParameterizedTest
	@ArgumentsSource(
		AlgorithmArgumentsProvider.class
	)
	public void testDataset1(
		final MaxDistanceInterface algorithm
	) {
		long timeRequired = AlgorithmBenchmarkHelper.nanoTime(
			algorithm, data1, data1Answer
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
		final MaxDistanceInterface algorithm
	) {
		long timeRequired = AlgorithmBenchmarkHelper.nanoTime(
			algorithm, data2, data2Answer
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
	public void testDataset3(
		final MaxDistanceInterface algorithm
	) {
		long timeRequired = AlgorithmBenchmarkHelper.nanoTime(
			algorithm, data3, data3Answer
		);
		AlgorithmBenchmarkHelper.print(
			algorithm, timeRequired
		);
	}

}