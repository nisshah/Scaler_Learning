package lld.chess;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentTurn;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        board = new Board(8, 8);

        if (player1.isWhitePlayer()) {
            this.currentTurn = player1;
        } else {
            this.currentTurn = player2;
        }
    }

    public boolean playerMove(Player player, int x1, int y1, int x2, int y2) {
        Spot s1 = board.getBox(x1, y1);
        Spot s2 = board.getBox(x2, y2);

        if (validate(player, s1, s2, board)) {
            Move m = makeMove(player, s1, s2);
            return true;
        }
        return false;
    }

    public boolean validate(Player player, Spot s1, Spot s2, Board board) {
        if(player.isWhitePlayer() && s1.getPiece().isWhite() && !s2.getPiece().isWhite()){
            return s1.getPiece().canMove(s1, s2, board);
        } else if(!player.isWhitePlayer() && !s1.getPiece().isWhite() && s2.getPiece().isWhite()) {
            return s1.getPiece().canMove(s1, s2, board);
        }
        return false;
    }

    private Move makeMove(Player player, Spot source, Spot target) {
        Move move = new Move();
        move.setPlayer(player);
        move.setSource(source);
        move.setTarget(target);
        move.setPieceMoved(source.getPiece());
        if ((source.getPiece().isWhite() && !target.getPiece().isWhite()) || (!source.getPiece().isWhite() && target.getPiece().isWhite())) {
            move.setPieceKilled(target.getPiece());
        }
        return move;
    }

}
