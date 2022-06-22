import java.util.AbstractMap;

public class TennisGame1 implements TennisGame {

    private Player playerOne;
    private Player playerTwo;

    private final String[] messageScore = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame1(String playerOneName, String playerTwoName) {
        this.playerOne = new Player(playerOneName);
        this.playerTwo = new Player(playerTwoName);
    }

    public void wonPoint(String playerName) {
        if (playerOne.name().equalsIgnoreCase(playerName)) {
            playerOne.increaseScore();
            return;
        }
        playerTwo.increaseScore();
    }

    public String getScore() {

        if (isEqualScore()) {
            return (playerOne.score() < 3) ? messageScore[playerOne.score()].concat("-All") : "Deuce";
        }

        if (isMinScoreToWin()) {
            AbstractMap.SimpleEntry<Player, Integer> player = getAdvantagePlayer();
            Player key = player.getKey();
            Integer value = player.getValue();
            return (value > 1) ? "Win for ".concat(key.name()): "Advantage ".concat(key.name());
        }
        return messageScore[playerOne.score()].concat("-").concat(messageScore[playerTwo.score()]);
    }

    private boolean isEqualScore() {
        return playerOne.score() == playerTwo.score();
    }

    private boolean isMinScoreToWin() {
        return playerOne.score() >= 4 || playerTwo.score() >= 4;
    }

    private AbstractMap.SimpleEntry<Player, Integer> getAdvantagePlayer() {
        int minus = playerOne.score() - playerTwo.score();
        return (minus < 0) ? new AbstractMap.SimpleEntry(playerTwo, Math.abs(minus)) : new AbstractMap.SimpleEntry(playerOne, Math.abs(minus));
    }
}
