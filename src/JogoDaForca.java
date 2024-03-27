import java.util.Scanner;

public class JogoDaForca {

    public static void main(String[] args) {
        String[] palavras = {"python", "golang", "java", "cobol", "lua"};
        int posicaoSorteada = (int) (Math.random() * 5);
        String palavraSorteada = palavras[posicaoSorteada];
        String palavraEscondida = "";
        int vidas = 6;
        Scanner s1 = new Scanner(System.in);

        // Inicializa a palavra escondida com "_ "
        for (int i = 0; i < palavraSorteada.length(); i++) {
            palavraEscondida += "_ ";
        }

        do {
            // Imprime a palavra escondida com espaços entre cada letra
            System.out.println(palavraEscondida.replaceAll("(.)", "$1 "));
            System.out.println("Numero de vidas: " + vidas);
            System.out.println("Digite uma letra da palavra: ");
            String letraInput = s1.nextLine();

            boolean letraCorreta = false;
            char letra = letraInput.charAt(0); // Obter a primeira letra digitada

            // Verifica se a letra está presente na palavra
            for (int i = 0; i < palavraSorteada.length(); i++) {
                if (palavraSorteada.charAt(i) == letra) {
                    // Atualiza a palavra escondida para mostrar a letra correta
                    palavraEscondida = palavraEscondida.substring(0, 2 * i) + letra + palavraEscondida.substring(2 * i + 1);
                    letraCorreta = true;
                }
            }

            if (!letraCorreta) {
                vidas--;
            }

        } while (vidas > 0 && palavraEscondida.contains("_"));
        if (vidas > 0) {
            System.out.println("Parabéns! Você ganhou. A palavra era: " + palavraSorteada);
        } else {
            System.out.println("Você perdeu. A palavra era: " + palavraSorteada);
        }

        s1.close();
    }
}