package io.github.dk96os.algorithms.data;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

}