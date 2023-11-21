// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        FitnessFunction fitnessFunction = new OneMaxFitness();
        CrossoverOperator cf = new OnePointCrossover();
        Individual mom = new Individual(fitnessFunction, 10,1, 10);
        Individual dad = new Individual(fitnessFunction, 10,1, 10);
        Individual child = cf.mate(mom, dad, 0.5f);

        }
    }