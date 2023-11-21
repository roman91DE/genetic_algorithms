public class GeneticAlgorithm {
    private final Population population;
    private final float crossoverRate;
    private final float mutationRate;
    private final int maxGeneration;
    private final FitnessFunction fitnessFunction;
    private final CrossoverOperator crossoverOperator;
    private final MutationOperator mutationOperator;


    public GeneticAlgorithm(int populationSize, int chromosomeLength, int lowerBound, int upperBound, float crossoverRate, float mutationRate, int maxGeneration, FitnessFunction fitnessFunction, CrossoverOperator crossoverOperator, MutationOperator mutationOperator) {
        this.population = new Population(fitnessFunction, populationSize, chromosomeLength, lowerBound, upperBound);
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        this.maxGeneration = maxGeneration;
        this.fitnessFunction = fitnessFunction;
        this.crossoverOperator = crossoverOperator;
        this.mutationOperator = mutationOperator;
    }
}
