package lld.chess;

public class Bishop extends Piece {

    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Spot start, Spot end, Board board) {
        return false;
    }
}
