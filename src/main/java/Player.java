public class Player {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void increaseScore() {
        this.score += 1;
    }

    public String name() {
        return name;
    }

    public int score() {
        return score;
    }
}
