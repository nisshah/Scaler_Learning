package lld.chess;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Spot start, Spot end, Board board) {
        return false;
    }
}
