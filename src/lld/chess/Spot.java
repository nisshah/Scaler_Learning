package lld.chess;

public class Spot {
    private int x;
    private int y;
    private Piece piece;

    public Spot(int i, int i1, Piece piece) {
        this.x = i;
        this.y = i1;
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
