import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int TAM = 11;
    private static int index;
    private static final File DIR = new File("C:\\Users\\matheus.tosin\\Desktop\\PUCRS\\IA\\Algoritmo_Genetico");
    private static final File ARQ = new File(DIR, "duplos4.txt");
    private static String[][] preferences;
    private static int[][] population;

    public static void main(String[] args) throws FileNotFoundException {
        init();
        population();
        printMatrix();
    }

    public static void population() {
        Random rand = new Random();
        population = new int[TAM][index];
        for(int i = 0; i < population.length; i++) {
            List<Integer> aux = new ArrayList<>(3);
            for(int j = 0; j < index; j++) {
                int nextVal = rand.nextInt(index)+1;
                if(!aux.contains(nextVal)){
                    aux.add(nextVal);
                    population[i][j] = nextVal;
                } else {
                    j--;
                }
            }
        }
    }

    public static void printMatrix() {
        for(int i = 0; i < TAM; i++) {
            for(int j = 0; j < index; j++) {
                    System.out.print(population[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void init() throws FileNotFoundException {
        loadTxt(ARQ);
        printMatrixPreferencia();
        System.out.println("==============================================");
    }

    private static void printMatrixPreferencia() {
        for (String[] preference : preferences) {
            for (int j = 0; j < (preferences.length / 2) + 1; j++) {
                System.out.print(preference[j] + " ");
            }
            System.out.println();
        }
    }

    private static void loadTxt(File file) throws FileNotFoundException {
        try {
            int lineAux = 0;
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            int size = Integer.parseInt(bufferedReader.readLine());
            index = size;
            preferences = new String[size*2][size+1];
                while ( ( line = bufferedReader.readLine() ) != null) {
                    String[] data = line.split(" ");
                    for(int i = 0; i < data.length; i++) {
                        preferences[lineAux][i] = data[i];
                    }
                    lineAux++;
                }
                fileReader.close();
                bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
