public class TwoPointCrossover implements CrossoverFunction{
    @Override
    public Individual crossOver(Individual mother, Individual father, float crossoverRate) {
        int crossoverPointOne, crossoverPointTwo;
        do {
            crossoverPointOne = Individual.generator.nextInt(0, mother.getLength());
            crossoverPointTwo = Individual.generator.nextInt(0, mother.getLength());
        } while (crossoverPointOne > crossoverPointTwo);

        int[] newChromosome = mother.getChromosomeArray().clone();
        if (mother.getLength() - crossoverPointTwo >= 0)
            System.arraycopy(father.getChromosomeArray(), crossoverPointOne, newChromosome, crossoverPointOne, crossoverPointTwo - crossoverPointOne);
        Individual offspring = new Individual(mother.getFitnessFunction(), mother.getLength(), mother.getLowerBound(), mother.getUpperBound());
        offspring.setChromosome(newChromosome);
        return offspring;
}
}
