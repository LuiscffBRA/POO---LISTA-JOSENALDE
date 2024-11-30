import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        game.loadRanking();
        game.displayTopFive();

        System.out.println("Pressione qualquer tecla para iniciar o jogo.");
        scanner.nextLine();

        for (int i = 1; i <= 11; i++) {
            System.out.println("Jogador " + i + ":");
            System.out.print("Nome: ");
            String name = scanner.nextLine();
            System.out.print("Aposta (1-12): ");
            int bet = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            if (bet < 1 || bet > 12) {
                System.out.println("Aposta inválida. Tente novamente.");
                i--;
                continue;
            }
            game.addPlayer(new Player(name, bet));

            System.out.print("Adicionar outro jogador? (s/n): ");
            String continueInput = scanner.nextLine();
            if (!continueInput.equalsIgnoreCase("s")) {
                break;
            }
        }

        game.play();
    }
}
