import java.util.Arrays;
import java.util.Random;
public class Individual {
    final private int[] chromosome;
    private int fitness;
    final private FitnessFunction fitnessFunction;

    final private int _lowerBound, _upperBound, _length;
    final static Random generator = new Random();

    public Individual(FitnessFunction fitnessFunction, int length, int lowerBound, int upperBound) {

        if (length <= 0 || upperBound <= 0 || lowerBound < 0) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }

        if (lowerBound >= upperBound) {
            throw new IllegalArgumentException("Lower bound must be smaller than upper bound");
        }

        this.chromosome = new int[length];
        this.fitnessFunction = fitnessFunction;
        this._lowerBound = lowerBound;
        this._upperBound = upperBound;
        this._length = length;

        for (int idx = 0; idx < length; idx++) {
            this.chromosome[idx] = Individual.generator.nextInt(lowerBound, upperBound);
        }
        this.fitness = fitnessFunction.getFitness(this);
    }

    public int getFitness(){
        return this.fitness;
    }

    public void recomputeFitness(){
        this.fitness = fitnessFunction.getFitness(this);
    }

    private void setChromosome(int[] chromosome){
        if (chromosome.length != this._length) {
            throw new IllegalArgumentException("Chromosome must have the same length as the individual");
        }
        if (Arrays.stream(chromosome).anyMatch(x -> x < this._lowerBound) || Arrays.stream(chromosome).anyMatch(x -> x >= this._upperBound)) {
            throw new IllegalArgumentException("Chromosome must have values between lower and upper bound");
        }
        System.arraycopy(chromosome, 0, this.chromosome, 0, chromosome.length);
    }

    public void mutateChromosome(float mutationRate){
        boolean mutated = false;
        for (int idx = 0; idx < this._length; idx++) {
            if (Individual.generator.nextFloat() < mutationRate) {
                mutated = true;
                this.chromosome[idx] = generator.nextInt(this._lowerBound, this._upperBound);
            }
        }
        if (mutated) {
            this.recomputeFitness();
        }
    }
    public Individual applyCrossover(Individual other, float crossoverRate){
        if (this._length != other._length) {
            throw new IllegalArgumentException("Individuals must have the same length");
        }
        if (this._lowerBound != other._lowerBound || this._upperBound != other._upperBound) {
            throw new IllegalArgumentException("Individuals must have the same lower and upper bound");
        }

        if (Individual.generator.nextFloat() < crossoverRate) {
            return this.createCrossoverOffspring(other);
        }
        return this;
    }

    private Individual createCrossoverOffspring(Individual other) {
        int crossoverPoint = Individual.generator.nextInt(0, this._length);
        int[] newChromosome = this.getChromosomeArray().clone();
        if (this._length - crossoverPoint >= 0)
            System.arraycopy(other.chromosome, crossoverPoint, newChromosome, crossoverPoint, this._length - crossoverPoint);
        Individual offspring = new Individual(this.fitnessFunction, this._length, this._lowerBound, this._upperBound);
        offspring.setChromosome(newChromosome);
        return offspring;
    }

    public int[] getChromosomeArray(){
        return this.chromosome;
    }

    public void print(){
        for (int al : this.chromosome) {
            System.out.printf("%d ", al);
        }
        System.out.print("\n");
    }
}
