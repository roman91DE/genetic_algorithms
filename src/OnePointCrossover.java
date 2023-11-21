public class OnePointCrossover implements CrossoverOperator {
    @Override
    public Individual crossOver(Individual mother, Individual father, float crossoverRate) {
        int crossoverPoint = Individual.generator.nextInt(0, mother.getLength());
        int[] newChromosome = mother.getChromosomeArray().clone();
        if (mother.getLength() - crossoverPoint >= 0)
            System.arraycopy(father.getChromosomeArray(), crossoverPoint, newChromosome, crossoverPoint, mother.getLength() - crossoverPoint);
        Individual offspring = new Individual(mother.getFitnessFunction(), mother.getLength(), mother.getLowerBound(), mother.getUpperBound());
        offspring.setChromosome(newChromosome);
        return offspring;
    }
}