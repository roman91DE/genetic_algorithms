import junit.framework.TestCase;
import static org.junit.Assert.assertThrows;

import java.util.Random;
import java.util.Arrays;


public class IndividualTest extends TestCase {

    public void testConstructorOneMax() {

        int testLength, testUpperBound, testLowerBound;
        FitnessFunction f = new OneMaxFitness();
        Random generator = new Random();

        for (int i = 0; i < 100; i++) {

            testLength = generator.nextInt(0,10_000);
            testUpperBound = generator.nextInt(-1000, 1000);
            testLowerBound = generator.nextInt(-1000, 1000);

            int finalTestLength = testLength;
            int finalTestLowerBound = testLowerBound;
            int finalTestUpperBound = testUpperBound;

            if (finalTestLowerBound >= finalTestUpperBound) {
                assertThrows(IllegalArgumentException.class, () -> new Individual(f, finalTestLength, finalTestLowerBound, finalTestUpperBound));
            } else if (finalTestLowerBound < 0) {
                assertThrows(IllegalArgumentException.class, () -> new Individual(f, finalTestLength, finalTestLowerBound, finalTestUpperBound));
            }
            else {
                Individual ind = new Individual(f, finalTestLength, testLowerBound, testUpperBound);

            assertEquals(testLength, ind.getChromosomeArray().length);

            assertTrue(Arrays.stream(ind.getChromosomeArray()).allMatch(x -> x >= finalTestLowerBound));
            assertTrue(Arrays.stream(ind.getChromosomeArray()).allMatch(x -> x < finalTestUpperBound));

        }

    }
}
}
