package com.leetcode.problems;

import java.util.Arrays;

public class SudokuSolver {

    private static final String POSSIBLE_VALUES= "123456789";

    public void solveSudoku(char[][] board) {

        String possibileCaseInBlock [][] = fillPossibileCaseInBlock(board);
        String possibleCaseVertical [] = fillVerticalPossibleCase(board);
        String possibleCaseHorizontal [] = fillHorizontalPossibleCase(board);

        System.out.println();
    }

    public String[] fillHorizontalPossibleCase(char[][] board){
        String possibleCaseHorizontal [] = new String[9];

        for (int i = 0; i < 9 ; i++) {
            possibleCaseHorizontal[i] = POSSIBLE_VALUES;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.'){
                    possibleCaseHorizontal[i] = updatePossibility(c, possibleCaseHorizontal[i]);
                }
            }
        }

        return possibleCaseHorizontal;
    }

    public String[] fillVerticalPossibleCase(char[][] board){
        String possibleCaseVertical [] = new String[9];

        for (int i = 0; i < 9 ; i++) {
            possibleCaseVertical[i] = POSSIBLE_VALUES;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if(c != '.'){
                    possibleCaseVertical[i] = updatePossibility(c, possibleCaseVertical[i]);
                }
            }
        }

        return possibleCaseVertical;
    }
    public String[][] fillPossibileCaseInBlock(char[][] board){
        String possibileCaseInBlock [][] = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                possibileCaseInBlock[i][j] = POSSIBLE_VALUES;
            }
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.'){
                    possibileCaseInBlock[i/3][j/3] = updatePossibility(c, possibileCaseInBlock[i/3][j/3]);
                }
            }
        }

        return possibileCaseInBlock;
    }

    private String updatePossibility(char c, String possibility){
        int index = possibility.indexOf(c);
        if( index >= 0 ){
            possibility = possibility.substring(0, index) + possibility.substring(index+1);
        }

        return possibility;
    }
    public static void main(String[] args) {
        char[][] board = new char[9][9];
        createTestSudoku(board);
        printSudoku(board);
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(board);
        printSudoku(board);
    }

    private static void printSudoku(char[][] board) {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            if(i%3 == 0){
                for (int j = 0; j < 39; j++)
                    System.out.print("-");
                System.out.println();
            }
            for (int j = 0; j < 9; j++) {
                if(j%3 == 0){
                    System.out.print("|");
                }
                System.out.printf(" %c |", board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void createTestSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = '.';
            }
        }

        board[0][0] = '5';
        board[0][1] = '3';
        board[0][4] = '7';

        board[1][0] = '6';
        board[1][3] = '1';
        board[1][4] = '9';
        board[1][5] = '5';

        board[2][1] = '9';
        board[2][2] = '8';
        board[2][7] = '6';

        board[3][0] = '8';
        board[3][4] = '6';
        board[3][8] = '3';

        board[4][0] = '4';
        board[4][3] = '8';
        board[4][5] = '3';
        board[4][8] = '1';

        board[5][0] = '7';
        board[5][4] = '2';
        board[5][8] = '6';

        board[6][1] = '6';
        board[6][6] = '2';
        board[6][7] = '8';

        board[7][3] = '4';
        board[7][4] = '1';
        board[7][5] = '9';
        board[7][8] = '5';

        board[8][4] = '8';
        board[8][7] = '7';
        board[8][8] = '9';
    }
}
