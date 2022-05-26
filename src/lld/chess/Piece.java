package lld.chess;

public abstract class Piece {

    private boolean white = false;
    private boolean isKilled = false;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return this.white;
    }

    public abstract boolean canMove(Spot start, Spot end, Board board);
}
