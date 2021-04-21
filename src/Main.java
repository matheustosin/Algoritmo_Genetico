import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int TAM = 11;
    private static int index;
    private static final File DIR = new File("C:\\Users\\matheus.tosin\\Desktop\\PUCRS\\IA\\Algoritmo_Genetico");
    private static final File ARQ = new File(DIR, "duplos4ideal.txt");
    private static String[][] preferences;
    private static int[][] population;
    //private static int[][] intermediaria;

    public static void main(String[] args) throws FileNotFoundException {
        init();
        population();
        //System.out.println("==========================================================================================================================================");

        for (int g=0; g<300; g++) {
            System.out.println("Geração: " + g);
            aptidao();
            printMatrix();
        }
    }

    public static void population() {
        Random rand = new Random();
        population = new int[TAM][index+1];
        for(int i = 0; i < population.length; i++) {
            List<Integer> aux = new ArrayList<>();
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
            System.out.print("C: ");
            for(int j = 0; j < index+1; j++) {
                    System.out.print(population[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void init() throws FileNotFoundException {
        loadTxt(ARQ);
        //rintMatrixPreferencia();
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

    public static void aptidao() {
        //percorre as linhas da populacao
        for(int i = 0; i < TAM; i++) {
            int somaMatch = 0;
            //percorre as colunas da populacao
            for(int j = 0; j < index; j++) {
                //percorre de uma coluna da preferencia
                for(int k = 1; k <= index; k++) {
                    if (population[i][j] == Character.getNumericValue(preferences[j][k].charAt(1))){
                        somaMatch += k;
                        break;
                    }
                }
                for(int k = 1; k <= index; k++) {
                    if (population[i][j] == Character.getNumericValue(preferences[j+index][k].charAt(1))){
                        somaMatch += k;
                        break;
                    }
                }
            }
            population[i][index] = somaMatch;
        }
    }
}
