import java.util.*;
import java.io.*;

public class Game {
    private List<Player> players = new ArrayList<>();
    private List<Player> topPlayers = new ArrayList<>();
    private Dice dice1 = new Dice();
    private Dice dice2 = new Dice();

    public void addPlayer(Player player) {
        for (Player p : players) {
            if (p.getBet() == player.getBet()) {
                System.out.println("Número já apostado! Escolha outro.");
                return;
            }
        }
        players.add(player);
    }

    public void play() {
        if (players.isEmpty()) {
            System.out.println("Nenhum jogador registrado.");
            return;
        }

        int roll1 = dice1.roll();
        int roll2 = dice2.roll();
        int result = roll1 + roll2;

        System.out.println("Resultado dos dados: " + result);
        boolean winnerFound = false;

        for (Player player : players) {
            if (player.getBet() == result) {
                System.out.println("Vencedor: " + player.getName());
                player.incrementVictories();
                saveWinner(player);
                winnerFound = true;
                break;
            }
        }

        if (!winnerFound) {
            System.out.println("A máquina venceu!");
        }
    }

    public void loadRanking() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ranking.dat"))) {
            topPlayers = (List<Player>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Nenhum ranking encontrado.");
        }
    }

    public void saveWinner(Player winner) {
        boolean updated = false;
        for (Player player : topPlayers) {
            if (player.getName().equals(winner.getName())) {
                player.incrementVictories();
                updated = true;
                break;
            }
        }
        if (!updated) {
            topPlayers.add(winner);
        }
        topPlayers.sort((p1, p2) -> Integer.compare(p2.getVictories(), p1.getVictories()));
        if (topPlayers.size() > 5) {
            topPlayers = topPlayers.subList(0, 5);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ranking.dat"))) {
            oos.writeObject(topPlayers);
        } catch (IOException e) {
            System.out.println("Erro ao salvar ranking.");
        }
    }

    public void displayTopFive() {
        System.out.println("TOP FIVE:");
        for (Player player : topPlayers) {
            System.out.println(player.getName() + " - Vitórias: " + player.getVictories());
        }
    }
}
