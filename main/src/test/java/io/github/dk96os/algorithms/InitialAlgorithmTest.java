package io.github.dk96os.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.github.dk96os.algorithms.data.IntegerArrayDataProvider;

/** Testing the Initial Algorithm
 */
public final class InitialAlgorithmTest {

	private final int[] smallEvenData = IntegerArrayDataProvider.valleyDistribution(
		200, 5000
	);

	private final int[] smallOddData = IntegerArrayDataProvider.valleyDistribution(
		201, 5000
	);

	@Test
	public void testSearchMaxDistanceSmallEvenData() {
		var result = InitialAlgorithm.searchMaxDistance(
			smallEvenData
		);
		assertEquals(
			199, result
		);
	}

	@Test
	public void testSearchMaxDistanceSmallOddData() {
		var result = InitialAlgorithm.searchMaxDistance(
			smallOddData
		);
		assertEquals(
			200, result
		);
	}

}