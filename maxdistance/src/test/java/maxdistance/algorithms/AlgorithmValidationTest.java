package maxdistance.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import maxdistance.data.PseudorandomDistribution;
import maxdistance.data.ValleyDistribution;

/** Testing the Initial Algorithm
 */
public final class AlgorithmValidationTest {

	private final ValleyDistribution smallEvenData;

	private final ValleyDistribution smallOddData;

	private final PseudorandomDistribution pseudoRngData1;
	private final PseudorandomDistribution pseudoRngData2;
	private final PseudorandomDistribution pseudoRngData3;

	/** Initialize data arrays during construction.
	 */
	public AlgorithmValidationTest() {
		smallEvenData = new ValleyDistribution(
			200, 5000
		);
		smallOddData = new ValleyDistribution(
			201, 5000
		);
		pseudoRngData1 = new PseudorandomDistribution(
			1000, 20, 100, 1
		);
		pseudoRngData2 = new PseudorandomDistribution(
			2000, 200, 1000, 1
		);
		pseudoRngData3 = new PseudorandomDistribution(
			5000, -1200, 10000, 1
		);
	}

	@ParameterizedTest
	@ArgumentsSource(
		AlgorithmArgumentsProvider.class
	)
	public void testSearchMaxDistanceSmallEvenData(
		final MaxDistanceAlgorithm algorithm
	) {
		var result = algorithm.searchMaxDistance(
			smallEvenData.getArray()
		);
		assertEquals(
			199, result
		);
	}

	@ParameterizedTest
	@ArgumentsSource(
		AlgorithmArgumentsProvider.class
	)
	public void testSearchMaxDistanceSmallOddData(
		final MaxDistanceAlgorithm algorithm
	) {
		var result = algorithm.searchMaxDistance(
			smallOddData.getArray()
		);
		assertEquals(
			200, result
		);
	}

	@ParameterizedTest
	@ArgumentsSource(
		AlgorithmArgumentsProvider.class
	)
	public void testSearchMaxDistancePseudoRNG(
		final MaxDistanceAlgorithm algorithm
	) {
		var result = algorithm.searchMaxDistance(
			pseudoRngData1.getArray()
		);
		assertEquals(
			994, result
		);
	}

	@ParameterizedTest
	@ArgumentsSource(
		AlgorithmArgumentsProvider.class
	)
	public void testSearchMaxDistancePseudoRNG2(
		final MaxDistanceAlgorithm algorithm
	) {
		var result = algorithm.searchMaxDistance(
			pseudoRngData2.getArray()
		);
		assertEquals(
			1952, result
		);
	}

	@ParameterizedTest
	@ArgumentsSource(
		AlgorithmArgumentsProvider.class
	)
	public void testSearchMaxDistancePseudoRNG3(
		final MaxDistanceAlgorithm algorithm
	) {
		var result = algorithm.searchMaxDistance(
			pseudoRngData3.getArray()
		);
		assertEquals(
			4691, result
		);
	}

}