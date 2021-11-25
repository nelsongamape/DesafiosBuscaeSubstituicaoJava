package ValidacaoSenha;

import java.util.Locale;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.regex.Pattern;

public class ValidacaoSenha {

    public final static int MAX = 200;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("Insira uma senha para validação: ");

        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {

            var linha = input.nextLine();

            if (linha != null) {
                if (!isValid(linha) || linha.length() < 6 || linha.length() > 32) {
                    System.out.println("Senha invalida.");
                } else {
                    System.out.println("Senha valida.");
                    break;
                }
            } else {
                System.out.println("Senha invalida2.");
            }
        }
        input.close();

    }
// Requisitos da senha: precisa ser entre 6 e 32 caracteres, ter letras maiúsculas e minúsculas,
// não pode conter caracteres especiais nem pontuação e nem pode ter espaços e branco.
    public static boolean isValid(String value) {
        return containsLowerCase(value) &&
                containsUpperCase(value) &&
                containsNumber(value) &&
                NOTcontainsWhitespace(value) &&
                NOTcontainsSpecialCharacters(value);
    }

    private static boolean containsLowerCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }

    private static boolean containsUpperCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    private static boolean containsNumber(String value) {
        return contains(value, Character::isDigit);
    }

    private static boolean NOTcontainsWhitespace(String value) {
        return !contains(value, Character::isWhitespace);
    }

    private static boolean NOTcontainsSpecialCharacters(String value) {
        // Necessário declarar os caracteres especiais
        var checkPattern = Pattern.compile("[^a-zA-Z0-9]");
        // Declare matcher to match with String
        var match = checkPattern.matcher(value);
        // Use find( ) function to check
        return !(match.find());
    }

    private static boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }
}