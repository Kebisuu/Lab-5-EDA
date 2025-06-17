import java.util.*;
class Scoreboard {
    private Map<String, Player> playerTable = new HashMap<>();
    private TreeMap<Integer, List<Player>> winTree = new TreeMap<>();
    private int totalGames = 0;
    public void registerPlayer(String playerName) {
        if (!playerTable.containsKey(playerName)) {
            Player newPlayer = new Player(playerName, 0, 0, 0); // Usando tu constructor
            playerTable.put(playerName, newPlayer);
            winTree.computeIfAbsent(0, k -> new ArrayList<>()).add(newPlayer);
        }
    }
    public boolean checkPlayer(String playerName) {
        return playerTable.containsKey(playerName);
    }
    public void addGameResult(String winnerName, String loserName, boolean draw) {
        if (!playerTable.containsKey(winnerName) || !playerTable.containsKey(loserName)) return;
        Player winner = playerTable.get(winnerName);
        Player loser = playerTable.get(loserName);
        if (draw) {
            winner.addDraw();
            loser.addDraw();
        } else {
            updateWins(winner);
            loser.addLoss();
        }
        totalGames++;
    }
    private void updateWins(Player player) {
        winTree.get(player.getWins()).remove(player);
        if (winTree.get(player.getWins()).isEmpty()) winTree.remove(player.getWins());

        player.addWin();
        winTree.computeIfAbsent(player.getWins(), k -> new ArrayList<>()).add(player);
    }
    public List<Player> winRange(int lo, int hi) {
        List<Player> result = new ArrayList<>();
        winTree.subMap(lo, true, hi, true).values().forEach(result::addAll);
        return result;
    }
    public Player winSuccessor(int wins) {
        Map.Entry<Integer, List<Player>> entry = winTree.higherEntry(wins);
        return (entry != null && !entry.getValue().isEmpty()) ? entry.getValue().get(0) : null;
    }
}
