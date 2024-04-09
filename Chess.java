import java.util.Scanner;

enum PieceType {
    KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN
}

class Piece {
    private PieceType type;
    private boolean isWhite;

    public Piece(PieceType type, boolean isWhite) {
        this.type = type;
        this.isWhite = isWhite;
    }

    public PieceType getType() {
        return type;
    }

    public boolean isWhite() {
        return isWhite;
    }
}

class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize white pieces
        board[0][0] = new Piece(PieceType.ROOK, true);
        board[0][1] = new Piece(PieceType.KNIGHT, true);
        board[0][2] = new Piece(PieceType.BISHOP, true);
        board[0][3] = new Piece(PieceType.QUEEN, true);
        board[0][4] = new Piece(PieceType.KING, true);
        board[0][5] = new Piece(PieceType.BISHOP, true);
        board[0][6] = new Piece(PieceType.KNIGHT, true);
        board[0][7] = new Piece(PieceType.ROOK, true);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Piece(PieceType.PAWN, true);
        }

        // Initialize black pieces
        board[7][0] = new Piece(PieceType.ROOK, false);
        board[7][1] = new Piece(PieceType.KNIGHT, false);
        board[7][2] = new Piece(PieceType.BISHOP, false);
        board[7][3] = new Piece(PieceType.QUEEN, false);
        board[7][4] = new Piece(PieceType.KING, false);
        board[7][5] = new Piece(PieceType.BISHOP, false);
        board[7][6] = new Piece(PieceType.KNIGHT, false);
        board[7][7] = new Piece(PieceType.ROOK, false);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Piece(PieceType.PAWN, false);
        }
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print("- ");
                } else {
                    if (board[i][j].isWhite()) {
                        System.out.print("W");
                    } else {
                        System.out.print("B");
                    }
                    switch (board[i][j].getType()) {
                        case KING:
                            System.out.print("K ");
                            break;
                        case QUEEN:
                            System.out.print("Q ");
                            break;
                        case ROOK:
                            System.out.print("R ");
                            break;
                        case BISHOP:
                            System.out.print("B ");
                            break;
                        case KNIGHT:
                            System.out.print("N ");
                            break;
                        case PAWN:
                            System.out.print("P ");
                            break;
                    }
                }
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int startX, int startY, int endX, int endY, boolean isWhite) {
        // Check if start and end positions are within the board
        if (startX < 0 || startX >= 8 || startY < 0 || startY >= 8 ||
                endX < 0 || endX >= 8 || endY < 0 || endY >= 8) {
            return false;
        }
        // Check if start position has a piece and it belongs to the player making the move
        if (board[startX][startY] == null || board[startX][startY].isWhite() != isWhite) {
            return false;
        }
        // Implement specific move validation logic for each piece type (not included in this example)
        // For simplicity, this method currently allows any move without validation
        return true;
    }

    public void movePiece(int startX, int startY, int endX, int endY) {
        if (isValidMove(startX, startY, endX, endY, board[startX][startY].isWhite())) {
            // Capture the opponent's piece if it exists at the end position
            if (board[endX][endY] != null) {
                System.out.println("Capturing " + board[endX][endY].getType() + " at position (" + endX + ", " + endY + ")");
            }
            // Move the piece to the end position
            board[endX][endY] = board[startX][startY];
            board[startX][startY] = null;
            System.out.println("Piece moved from position (" + startX + ", " + startY + ") to position (" + endX + ", " + endY + ")");
        } else {
            System.out.println("Invalid move!");
        }
    }
}

public class Chess {
    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter start position (x y): ");
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            System.out.println("Enter end position (x y): ");
            int endX = scanner.nextInt();
            int endY = scanner.nextInt();
            board.movePiece(startX, startY, endX, endY);
            board.printBoard();
        }
    }
}
