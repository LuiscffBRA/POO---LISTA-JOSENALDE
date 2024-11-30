import java.util.Random;

public class Dice {
    private final int sides = 6;

    public int roll() {
        Random random = new Random();
        return random.nextInt(sides) + 1;
    }
}
