import java.io.*;

public class Main {
    private static final int TAM = 11;
    private static final File DIR = new File("C:\\Users\\matheus.tosin\\Desktop\\PUCRS\\IA\\Algoritmo_Genetico");
    private static final File ARQ = new File(DIR, "duplos50.txt");
    private static String[][] preferencias;

    public static void main(String[] args) throws FileNotFoundException {
        init();
    }

    public static void init() throws FileNotFoundException {
        carregaTxt(ARQ);
        printMatriz();
    }

    private static void printMatriz() {
        for (String[] preferencia : preferencias) {
            for (int j = 0; j < (preferencias.length / 2) + 1; j++) {
                System.out.print(preferencia[j] + " ");
            }
            System.out.println();
        }
    }

    private static void carregaTxt(File arq) throws FileNotFoundException {
        try {
            int lin = 0;
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = "";
            int tamanho = Integer.parseInt(bufferedReader.readLine());
            preferencias = new String[tamanho*2][tamanho+1];
                while ( ( linha = bufferedReader.readLine() ) != null) {
                    String[] dados = linha.split(" ");
                    for(int i = 0; i < dados.length; i++) {
                        preferencias[lin][i] = dados[i];
                    }
                    lin++;
                }
                fileReader.close();
                bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
