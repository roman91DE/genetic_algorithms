import java.util.Arrays;
import java.util.Comparator;

public class Population {
    final private Individual[] individuals;

    public Population(FitnessFunction fitnessFunction, int size, int length, int lowerBound, int upperBound) {
        this.individuals = new Individual[size];
        for (int idx = 0; idx < size; idx++) {
            this.individuals[idx] = new Individual(fitnessFunction, length, lowerBound, upperBound);
        }
    }

    public void sortPopulation() {
        Arrays.sort(this.individuals, Comparator.comparingInt(Individual::getFitness));
    }
}
