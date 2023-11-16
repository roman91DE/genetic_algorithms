// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        FitnessFunction fitnessFunction = new OneMaxFitness();
        Individual ind = new Individual(fitnessFunction, 10,1, 10);
        ind.print();
        }
    }