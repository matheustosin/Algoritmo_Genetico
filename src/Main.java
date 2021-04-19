import java.io.*;

public class Main {
    private static final int TAM = 11;
    private static File dir = new File("C:\\Users\\matheus.tosin\\Desktop\\PUCRS\\IA\\T1");
    private static  File arq = new File(dir, "duplos4.txt");
    private static int[][] preferencias;

    public static void main(String[] args) throws FileNotFoundException {
        carregaTxt(arq);
    }

    public static void carregaTxt(File arq) throws FileNotFoundException {
        try {

        FileReader fileReader = new FileReader(arq);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linha = "";
        while ( ( linha = bufferedReader.readLine() ) != null) {
            for (int i=0; i < 8; i++) {
                for (int j=0; j < 5; j++) {
                    preferencias[i] = linha;
                }
        }
        fileReader.close();
        bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
