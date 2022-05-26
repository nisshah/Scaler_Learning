package lld.chess;

public class Board {
    int rows;
    int cols;
    private Spot[][] board;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        resetBoard();
    }

    public void resetBoard() {
        board = new Spot[rows][cols];
        initializeBoard();
    }

    private void initializeBoard() {
        board[0][0] = new Spot(0, 0, new Rook(true));
        board[0][1] = new Spot(0, 1, new Knight(true));
        board[0][2] = new Spot(0, 2, new Bishop(true));
        //...
        board[1][0] = new Spot(1, 0, new Pawn(true));
        board[1][1] = new Spot(1, 1, new Pawn(true));
        //...

        // initialize black pieces
        board[7][0] = new Spot(7, 0, new Rook(false));
        board[7][1] = new Spot(7, 1, new Knight(false));
        board[7][2] = new Spot(7, 2, new Bishop(false));
        //...
        board[6][0] = new Spot(6, 0, new Pawn(false));
        board[6][1] = new Spot(6, 1, new Pawn(false));

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Spot(i, j, null);
            }
        }
    }

    public Spot getBox(int x, int y) {
        if(x < 0 || x >= rows || y < 0 || y >= cols) throw new RuntimeException("Out of box");
        return board[x][y];
    }
}
