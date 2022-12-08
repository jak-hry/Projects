package TicTacToeCounter;

public class TicTacToeGameCounter {

    private int gamesPlayed;

    public TicTacToeGameCounter() {
        this.gamesPlayed = 0;
    }

    public void incrementGamesPlayed() {
        this.gamesPlayed++;
    }

    public int getGamesPlayed() {
        return this.gamesPlayed;
    }
}
