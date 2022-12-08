package TicTacToeCounter;

public class GameCounterTest {

    public static void main(String[] args) {

        TicTacToeGameCounter counter = new TicTacToeGameCounter();

        int gamesPlayed = counter.getGamesPlayed();

        System.out.println("Liczba rozegranych gier: " + gamesPlayed);
    }
}
