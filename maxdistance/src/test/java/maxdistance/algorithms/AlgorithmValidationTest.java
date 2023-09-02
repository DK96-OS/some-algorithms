package maxdistance.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import maxdistance.data.IntegerArrayDataProvider;

/** Testing the Initial Algorithm
 */
public final class AlgorithmValidationTest {

	private final int[] smallEvenData;

	private final int[] smallOddData;

	private final int[] pseudoRngData;

	/** Initialize data arrays during construction.
	 */
	public AlgorithmValidationTest() {
		smallEvenData = IntegerArrayDataProvider.valleyDistribution(
			200, 5000
		);
		smallOddData = IntegerArrayDataProvider.valleyDistribution(
			201, 5000
		);
		pseudoRngData = IntegerArrayDataProvider.pseudoRandomRange(
			1000, 20, 100, 1
		);
	}

	@ParameterizedTest
	@ArgumentsSource(
		AlgorithmArgumentsProvider.class
	)
	public void testSearchMaxDistanceSmallEvenData(
		final MaxDistanceInterface algorithm
	) {
		var result = algorithm.searchMaxDistance(
			smallEvenData
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
		final MaxDistanceInterface algorithm
	) {
		var result = algorithm.searchMaxDistance(
			smallOddData
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
		final MaxDistanceInterface algorithm
	) {
		var result = algorithm.searchMaxDistance(
			pseudoRngData
		);
		assertEquals(
			994, result
		);
	}

}