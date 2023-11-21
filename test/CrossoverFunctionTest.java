import junit.framework.TestCase;

public class CrossoverFunctionTest extends TestCase {

    CrossoverFunction[] cfs = new CrossoverFunction[] {
            new OnePointCrossover(),
            new TwoPointCrossover(),
            //new UniformCrossover()
    };

    public void testCompatibility() {

        int lengthMin = 1;
        int lengthMax = 100;

        for (int i = lengthMin; i < lengthMax; i++) {
            Individual mother = new Individual(new OneMaxFitness(), i, 1, 10);
            Individual father = new Individual(new OneMaxFitness(), i, 1, 10);
            for (CrossoverFunction cf : cfs) {
                Individual child = cf.mate(mother, father, 0.5f);
                assertEquals(i, child.getLength());
            }
        }
    }
}
