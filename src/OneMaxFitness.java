import java.util.Arrays;
public class OneMaxFitness implements FitnessFunction {
    public int getFitness(Individual ind) {
        return Arrays.stream(ind.getChromosomeArray()).sum();
    }
}