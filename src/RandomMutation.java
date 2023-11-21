public class RandomMutation implements MutationOperator{
    @Override
    public void mutate(Individual ind, float mutationRate) {
        for (int i = 0; i < ind.getLength(); i++) {
            if (Individual.generator.nextFloat() < mutationRate) {
                ind.getChromosomeArray()[i] = Individual.generator.nextInt(ind.getLowerBound(), ind.getUpperBound());
            }
        }
    }
}
