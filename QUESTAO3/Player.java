public class Player {
    private String name;
    private int bet;
    private int victories;

    public Player(String name, int bet) {
        this.name = name;
        this.bet = bet;
        this.victories = 0;
    }

    public String getName() {
        return name;
    }

    public int getBet() {
        return bet;
    }

    public int getVictories() {
        return victories;
    }

    public void incrementVictories() {
        victories++;
    }
}
