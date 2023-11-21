import java.util.Random;

public class TournamentSelection implements SelectionOperator{

    final static Random generator = new Random();
    @Override
    public Population select(Population population, int selectionSize) {
        Individual[] selectedIndividuals = new Individual[selectionSize];
        for (int i = 0; i < selectionSize; i++) {
            int randomIndex1 = generator.nextInt(0, population.getSize());
            int randomIndex2 = generator.nextInt(0, population.getSize());
            if (population.getIndividual(randomIndex1).getFitness() > population.getIndividual(randomIndex2).getFitness()) {
                selectedIndividuals[i] = population.getIndividual(randomIndex1);
            } else {
                selectedIndividuals[i] = population.getIndividual(randomIndex2);
            }
        }
        return new Population(selectedIndividuals);
    }

}
