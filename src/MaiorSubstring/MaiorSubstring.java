package MaiorSubstring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MaiorSubstring {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String menor, maior, temp;
        menor = "";
        maior = "";

        while ((menor = in.readLine()) != null) {
            maior = in.readLine();
            if (menor.length() > maior.length()) {
                temp = menor;
                menor = maior;
                maior = temp;
            }

            int menorComp = menor.length();
            int maiorSub = menorComp;
            boolean teste = true;
            while (maiorSub > 0 && teste) { //altere as variaveis, se achar necessario
                int diff = menorComp - maiorSub;
                for (int i = 0; i <= diff; i++) { //complete o laco de repeticao

                    var menorSub = menor.substring(i, i + maiorSub);

                    if (maior.contains(menorSub)) {
                        teste = false;
                        maiorSub++;
                        break;
                    }
                }
                maiorSub--;
            }
            System.out.println(maiorSub);
        }
        out.close();
    }
}