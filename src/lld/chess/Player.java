package lld.chess;

public abstract class Player {
    public boolean isWhitePlayer;

    public Player(boolean isWhite) {
        this.isWhitePlayer = isWhite;
    }

    public boolean isWhitePlayer() {
        return isWhitePlayer;
    }

    public void setWhitePlayer(boolean whitePlayer) {
        isWhitePlayer = whitePlayer;
    }
}
