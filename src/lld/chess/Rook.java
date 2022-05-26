package lld.chess;

public class Rook extends Piece {
    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Spot start, Spot end, Board board) {
        return false;
    }
}
