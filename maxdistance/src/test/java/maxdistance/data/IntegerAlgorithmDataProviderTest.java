package maxdistance.data;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/** Testing the Integer Array Data Provider
 * @author DK96-OS : 2022
 */
public final class IntegerAlgorithmDataProviderTest {

	@Test
	public void testValleyDistributionSmallEvenLength() {
		var data = new ValleyDistribution(
			10, 20
		);
		assertArrayEquals(
			new int[]{
				20, 19, 18, 17, 16, 16, 17, 18, 19, 20
			}, data.getArray()
		);
	}

	@Test
	public void testValleyDistributionSmallOddLength() {
		var data = new ValleyDistribution(
			9, 20
		);
		assertArrayEquals(
			new int[]{
				20, 19, 18, 17, 16, 17, 18, 19, 20
			}, data.getArray()
		);
	}

	@Test
	public void testPseudoRandomSmallEqualSeeds() {
		var result1 = new PseudorandomDistribution(
			100, 40, 20, 88L
		);
		var result2 = new PseudorandomDistribution(
			100, 40, 20, 88L
		);
		assertArrayEquals(
			result1.getArray(),
			result2.getArray()
		);
	}

}