package GameStats;

import java.io.Serializable;

public class Result implements Serializable {

    private Integer player1;
    private Integer player2;

    public Result() {
        this.player1 = 0;
        this.player2 = 0;
    }

    public void incrementPlayer1() {
        player1++;
    }

    public void incrementPlayer2() {
        player2++;
    }

    public int getPlayer1Wins(){
        return player1;
    }

    public int getPlayer2Wins(){
        return player2;
    }

    @Override
    public String toString() {
        return "player1 = " + player1 +
                ", player2 = " + player2;
    }
}
