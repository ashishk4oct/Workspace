package com.lld.tictactoe;

public class TicTacToe {
    private final int[][] board;
    private final int n;
    private final int rowSum[], colSum[];
    private int diagSum, revDiagSum;
    private int winner;

    public TicTacToe(final int n) {
        this.n = n;
        board = new int[n][n];
        rowSum = new int[n];
        colSum = new int[n];
    }


    /**
     * make a move on the board and returns the winner if the move is a winning  move.
     *
     * @param player is either 0 or 1
     * @param row    is the move's row index
     * @param col    is the move's column index
     * @return winner +1 if first player, -1 if second player and zero otherwise
     * @throws IllegalArgumentException if the move is an illegal move
     */
    public int move(int player, int row, int col) throws IllegalArgumentException {
        if (row >= n || col >= n || row < 0 || col < 0)
            throw new IllegalArgumentException("Move out of boundary");
        if (board[row][col] != 0)
            throw new IllegalArgumentException("Square if already occupied");
        if (player != 0 && player != 1)
            throw new IllegalArgumentException("Invalid player");
        if(getWinner() != 0)
            throw new IllegalStateException("Board is decided");

        player = player == 0 ? -1 : 1;
        board[row][col] = player;

        rowSum[row] += player;
        colSum[col] += player;
        if (row == col) {
            diagSum += player;
        }
        if (row == n - 1 - col) {
            revDiagSum += player;
        }
        if (n == Math.abs(rowSum[row]) || n == Math.abs(colSum[col]) || n == diagSum || n == revDiagSum) {
            winner = player;
        }
        return getWinner();
    }
    private int getWinner(){
        return winner;
    }
}