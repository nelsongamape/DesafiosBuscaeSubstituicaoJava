package OrdenacaoPalavras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenacaoPalavras {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCasos = Integer.parseInt(br.readLine());

        List<String> frases = new ArrayList<>();

        for (int i = 0; i < numCasos; i++) {
            var palavras = br.readLine();
            frases.addAll(Arrays.stream(palavras.split(" ")).collect(Collectors.toList()));

            var listaFrasesOrdenadas = frases.stream()
                    .sorted(Comparator.comparing(String::length).reversed()
                            .thenComparing(String::compareTo)).collect(Collectors.joining(" "));

            System.out.println(listaFrasesOrdenadas);

            frases.clear();
        }
    }
}