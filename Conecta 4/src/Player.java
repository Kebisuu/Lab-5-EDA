class Player {
    String playerName;
    int wins;
    int draws;
    int losses;
    Player(String playerName, int wins, int draws, int losses) {
        this.playerName = playerName;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }
    public int getWins() {return wins}
    public int getDraws() {return draws;}
    public int getLosses() {return losses;}
    public String getPlayerName() {return playerName;}
    public void addWin() {
        wins++;
    }
    public void addDraw() {
        draws++;
    }
    public void addLoss() {
        losses++;
    }
    public float winRate() {
        if (getWins() == 0) {
            return 0;
        }
        else {
            float percentage = getWins()/(getWins()+getDraws()+getLosses());
            return percentage;
        }
    }
}
