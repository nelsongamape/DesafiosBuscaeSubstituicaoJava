package PedraPapelTesoura;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PedraPapelTesoura {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String jogador1 = "Fernanda";
        String jogador2 = "Marcia";

        int qtdJogadas = input.nextInt();

        List<Resultado> resultados = new ArrayList<>();
        resultados.add(new Resultado("tesoura", "papel")); //tesoura corta papel
        resultados.add(new Resultado("papel", "pedra")); //papel cobre pedra
        resultados.add(new Resultado("pedra", "lagarto")); //pedra derruba lagarto
        resultados.add(new Resultado("lagarto", "spock")); //lagarto adormece spock
        resultados.add(new Resultado("spock", "tesoura")); //spock derrete tesoura
        resultados.add(new Resultado("tesoura", "lagarto")); // tesoura prende lagarto
        resultados.add(new Resultado("lagarto", "papel")); //lagarto come papel
        resultados.add(new Resultado("papel", "spock")); // papel refuta spock
        resultados.add(new Resultado("spock", "pedra")); //spock vaporiza pedra
        resultados.add(new Resultado("pedra", "tesoura")); //pedra quebra tesoura

        for (int i = 0; i < qtdJogadas; i++) {
            String jogada1 = input.next();
            String jogada2 = input.next();

            if (jogada1.equals(jogada2)) {
                System.out.println("empate");
            } else {
                boolean jogador1Venceu = false;
                for (Resultado result : resultados) {
                    if (result.getVencedor().equals(jogada1) && result.getPerdedor().equals(jogada2)) {
                        jogador1Venceu = true;
                        break;
                    }
                }
                if (jogador1Venceu) {
                    System.out.println(jogador1);
                } else {
                    System.out.println(jogador2);
                }
            }
        }
    }

    private static class Resultado {
        private final String vencedor;
        private final String perdedor;

        public Resultado(String vencedor, String perdedor) {
            this.vencedor = vencedor;
            this.perdedor = perdedor;
        }

        public String getVencedor() {
            return vencedor;
        }

        public String setVencedor() {
            return vencedor;
        }

        public String getPerdedor() {
            return perdedor;
        }

        public String setPerdedor() {
            return perdedor;
        }
    }
}