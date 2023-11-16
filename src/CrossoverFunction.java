public interface CrossoverFunction {
    public Individual applyCrossover(Individual mother, Individual father, float crossoverRate);

    private void checkCompatibility(Individual mother, Individual father) {
        if (mother.getLength() != father.getLength()) {
            throw new IllegalArgumentException("Individuals must have the same length");
        }
        if (mother.getLowerBound() != father.getLowerBound() || mother.getUpperBound() != father.getUpperBound()) {
            throw new IllegalArgumentException("Individuals must have the same lower and upper bound");
        }
    }

    Individual executeCrossover(Individual mother, Individual father, float crossoverRate) {
        try {
            checkCompatibility(mother, father);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        if (Individual.generator.nextFloat() < crossoverRate) {
            return this.applyCrossover(mother, father, crossoverRate);
        }
        if (Individual.generator.nextFloat() < 0.5) {
            return mother;
        }
        return father;
    }
}