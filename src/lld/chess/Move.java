package lld.chess;

public class Move {
    private Spot source;
    private Spot target;
    private Player player;
    private Piece pieceMoved;
    private Piece pieceKilled;

    public Spot getSource() {
        return source;
    }

    public void setSource(Spot source) {
        this.source = source;
    }

    public Spot getTarget() {
        return target;
    }

    public void setTarget(Spot target) {
        this.target = target;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public void setPieceMoved(Piece pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }
}
