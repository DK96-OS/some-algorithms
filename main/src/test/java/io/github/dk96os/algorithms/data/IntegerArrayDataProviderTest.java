package io.github.dk96os.algorithms.data;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static io.github.dk96os.algorithms.data.IntegerArrayDataProvider.pseudoRandomRange;
import static io.github.dk96os.algorithms.data.IntegerArrayDataProvider.valleyDistribution;

import org.junit.jupiter.api.Test;

/** Testing the Integer Array Data Provider
 * @author DK96-OS : 2022
 */
public final class IntegerArrayDataProviderTest {

	@Test
	public void testValleyDistributionSmallEvenLength() {
		var data = valleyDistribution(
			10, 20
		);
		assertArrayEquals(
			new int[]{
				20, 19, 18, 17, 16, 16, 17, 18, 19, 20
			}, data
		);
	}

	@Test
	public void testValleyDistributionSmallOddLength() {
		var data = valleyDistribution(
			9, 20
		);
		assertArrayEquals(
			new int[]{
				20, 19, 18, 17, 16, 17, 18, 19, 20
			}, data
		);
	}

	@Test
	public void testPseudoRandomSmallEqualSeeds() {
		var result1 = pseudoRandomRange(
			100, 40, 20, 88L
		);
		var result2 = pseudoRandomRange(
			100, 40, 20, 88L
		);
		assertArrayEquals(
			result1, result2
		);
	}

}