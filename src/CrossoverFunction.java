public interface CrossoverFunction {
    Individual crossOver(Individual mother, Individual father, float crossoverRate);

    default void checkCompatibility(Individual mother, Individual father) throws IllegalArgumentException{
        if (mother.getLength() != father.getLength()) {
            throw new IllegalArgumentException("Individuals must have the same length");
        }
        if (mother.getLowerBound() != father.getLowerBound() || mother.getUpperBound() != father.getUpperBound()) {
            throw new IllegalArgumentException("Individuals must have the same lower and upper bound");
        }
    }

    default Individual mate(Individual mother, Individual father, float crossoverRate) {
        try {
            checkCompatibility(mother, father);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        if (Individual.generator.nextFloat() < crossoverRate) {
            return crossOver(mother, father, crossoverRate);
        }
        if (Individual.generator.nextFloat() < 0.5) {
            return mother;
        } else {
            return father;
        }
    }
}