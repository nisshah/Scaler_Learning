package lld.chess;

public class Pawn extends Piece {

    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Spot start, Spot end, Board board) {
        return false;
    }
}
