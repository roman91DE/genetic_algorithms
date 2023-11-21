import java.util.Arrays;
import java.util.Random;
public class Individual {
    final private int[] chromosome;
    private int fitness;


    final private FitnessFunction fitnessFunction;

    final private int lowerBound, upperBound, length;
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
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.length = length;

        for (int idx = 0; idx < length; idx++) {
            this.chromosome[idx] = Individual.generator.nextInt(lowerBound, upperBound);
        }
        this.fitness = fitnessFunction.getFitness(this);
    }

    public int getFitness(){
        return this.fitness;
    }

    public int getLowerBound(){
        return this.lowerBound;
    }

    public int getUpperBound(){
        return this.upperBound;
    }

    public int getLength(){
        return this.length;
    }

    public FitnessFunction getFitnessFunction() {
        return fitnessFunction;
    }

    public void recomputeFitness(){
        this.fitness = fitnessFunction.getFitness(this);
    }

    public void setChromosome(int[] chromosome){
        if (chromosome.length != this.length) {
            throw new IllegalArgumentException("Chromosome must have the same length as the individual");
        }
        if (Arrays.stream(chromosome).anyMatch(x -> x < this.lowerBound) || Arrays.stream(chromosome).anyMatch(x -> x >= this.upperBound)) {
            throw new IllegalArgumentException("Chromosome must have values between lower and upper bound");
        }
        System.arraycopy(chromosome, 0, this.chromosome, 0, chromosome.length);
    }

    public void mutateChromosome(float mutationRate){
        boolean mutated = false;
        for (int idx = 0; idx < this.length; idx++) {
            if (Individual.generator.nextFloat() < mutationRate) {
                mutated = true;
                this.chromosome[idx] = generator.nextInt(this.lowerBound, this.upperBound);
            }
        }
        if (mutated) {
            this.recomputeFitness();
        }
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
