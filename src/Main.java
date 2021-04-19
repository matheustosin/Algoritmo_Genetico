import java.io.*;

public class Main {
    private static final int TAM = 11;
    private static File dir = new File("C:\\Users\\matheus.tosin\\Desktop\\PUCRS\\IA\\Algoritmo_Genetico");
    private static  File arq = new File(dir, "duplos50.txt");
    private static String[][] preferencias;

    public static void main(String[] args) throws FileNotFoundException {
        carregaTxt(arq);

        printMatriz();
    }

    public static void printMatriz() {
        for(int i = 0; i < (preferencias.length); i++) {
            for(int j = 0; j < (preferencias.length/2)+1; j++) {
                System.out.print(preferencias[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void carregaTxt(File arq) throws FileNotFoundException {
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
