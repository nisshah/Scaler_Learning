package lld.chess;

public class King extends Piece {

    public King(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Spot start, Spot end, Board board) {
        return false;
    }
}
