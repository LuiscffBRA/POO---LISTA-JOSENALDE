public class Robo {
    private int linha;
    private int coluna;
    private int passo;
    private final int LIMITE_LINHA = 20;
    private final int LIMITE_COLUNA = 40;

    // Construtor
    public Robo(int linha, int coluna, int passo) {
        this.linha = linha;
        this.coluna = coluna;
        this.passo = passo;
    }

    // Método para mostrar a posição atual do robô
    public void mostrarPosicaoAtual() {
        System.out.println("Posição Atual: (" + linha + ", " + coluna + ")");
    }

    // Métodos para movimentação
    public void andarFrente() {
        if (linha + passo < LIMITE_LINHA) {
            linha += passo;
        } else {
            linha = LIMITE_LINHA - 1;
        }
    }

    public void andarTras() {
        if (linha - passo >= 0) {
            linha -= passo;
        } else {
            linha = 0;
        }
    }

    public void andarDireita() {
        if (coluna + passo < LIMITE_COLUNA) {
            coluna += passo;
        } else {
            coluna = LIMITE_COLUNA - 1;
        }
    }

    public void andarEsquerda() {
        if (coluna - passo >= 0) {
            coluna -= passo;
        } else {
            coluna = 0;
        }
    }

    // Método para mostrar a sala com o robô na posição atual
    public void mostrarSala() {
        for (int i = 0; i < LIMITE_LINHA; i++) {
            for (int j = 0; j < LIMITE_COLUNA; j++) {
                if (i == linha && j == coluna) {
                    System.out.print("1");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Instanciação do robô
        Robo r1 = new Robo(0, 0, 1);
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            r1.mostrarSala();
            r1.mostrarPosicaoAtual();
            System.out.println("Escolha o movimento: 1 - Frente, 2 - Trás, 3 - Direita, 4 - Esquerda, 0 - Sair");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    r1.andarFrente();
                    break;
                case 2:
                    r1.andarTras();
                    break;
                case 3:
                    r1.andarDireita();
                    break;
                case 4:
                    r1.andarEsquerda();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }
}
