package euclidean;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEuclidian {

	@Test
	public void testGCD() {
		//13 * 5 * 5 -> 5, 65, 25, 13, 325
		//13 * 2 * 2 * 2 * 2 -> 13, 26, 52, 104, 2, 4, 8, 16,  
		Euclidean firstTest = new Euclidean(13*25, 13*16);
		assertTrue(13 == firstTest.getGCD());
		firstTest.showEuclidianAlgorithm();
		Euclidean secondTest = new Euclidean(24*16, 24*13);
		assertTrue(24 == secondTest.getGCD());
		secondTest.showEuclidianAlgorithm();
		Euclidean thirdTest = new Euclidean(12367*67, 12367*355);
		assertTrue(12367 == thirdTest.getGCD());
		thirdTest.showEuclidianAlgorithm();
	}

}
