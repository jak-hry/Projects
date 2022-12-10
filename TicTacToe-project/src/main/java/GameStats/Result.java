package GameStats;

import java.io.Serializable;

public class Result implements Serializable {

    private Integer player1;
    private Integer player2;

    public Result(Integer player1, Integer player2) {
        this.player1 = 0;
        this.player2 = 0;
    }

    public void incrementPlayer1(){
        player1++;
    }

    public void incrementPlayer2(){
        player2++;
    }
}
