package ohtu;

public class TennisGame {
    
    private int score1 = 0;
    private int score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            score1 += 1;
        else
            score2 += 1;
    }

    public String getScore() {
        if (score1 == score2) {
            return even();
        } else if (score1 >= 4 || score2 >= 4) {
            return atLeastForty();
        }
        return bothUnderForty();
    }

    private String even() {
        if (score1 < 4) {
            return scoreToString(score1) + "-All";
        } else {
            return "Deuce";
        }
    }
    
    private String atLeastForty() {
        return score1 > score2? leadingPlayer(1) : leadingPlayer(2);
    }
    
    private String leadingPlayer(int player) {
        if (Math.abs(score1 - score2) == 1) {
            return "Advantage player" + player;
        } else {
            return "Win for player" + player;
        }
    }

    private String bothUnderForty() {
        return scoreToString(score1) + "-" + scoreToString(score2);
    }
    
    private String scoreToString(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }
}