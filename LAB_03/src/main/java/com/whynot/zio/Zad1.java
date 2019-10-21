package com.whynot.zio;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class Zad1 {
    private static final char EMPTY = '\u0000';
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';

    private char current;
    private char[][] board;

    public void clearBoard() {
        board = new char[][]{
                new char[]{EMPTY, EMPTY, EMPTY},
                new char[]{EMPTY, EMPTY, EMPTY},
                new char[]{EMPTY, EMPTY, EMPTY}
        };
        setCurrent(PLAYER_X);
    }

    public void setValue(char c, int posX, int posY) {
        if (board[posX][posY] != EMPTY) {
            throw new RuntimeException("Field not empty");
        }
        if (posX > board.length) {
            throw new RuntimeException("Position X out of index");
        }
        if (posY > board[0].length) {
            throw new RuntimeException("Position Y out of index");
        }
        board[posX][posY] = c;
    }

    public char getCurrent() {
        return current;
    }

    public void setCurrent(char player) {
        current = player;
    }

    public void setPosition(int posX, int posY) {
        setValue(current, posX, posY);
        if (current == PLAYER_O) {
            setCurrent(PLAYER_X);
        } else {
            setCurrent(PLAYER_O);
        }
    }

    public boolean isWon() {
        return (board[0][0] != EMPTY && (board[0][0] == board[0][1] && board[0][1] == board[0][2])) ||
                (board[1][0] != EMPTY && (board[1][0] == board[1][1] && board[1][1] == board[1][2])) ||
                (board[2][0] != EMPTY && (board[2][0] == board[2][1] && board[2][1] == board[2][2])) ||
                (board[0][0] != EMPTY && (board[0][0] == board[1][0] && board[1][0] == board[2][0])) ||
                (board[0][1] != EMPTY && (board[0][1] == board[1][1] && board[1][1] == board[2][1])) ||
                (board[0][2] != EMPTY && (board[0][2] == board[1][2] && board[1][2] == board[2][2])) ||
                (board[0][0] != EMPTY && (board[0][0] == board[1][1] && board[1][1] == board[2][2])) ||
                (board[0][2] != EMPTY && (board[0][2] == board[1][1] && board[1][1] == board[2][0]));
    }

    public boolean isFilled() {
        boolean isFilled = true;
        for (char[] x : board) {
            for (char c : x) {
                isFilled &= (c != EMPTY);
            }
        }
        return isFilled;
    }

    public static void main(String[] args) {
        Zad1 zad1 = new Zad1();
        zad1.clearBoard();
        zad1.setPosition(0,0);
        zad1.setPosition(1,0);
        zad1.setPosition(0,1);
        zad1.setPosition(1,1);
        zad1.setPosition(0,2);
        System.out.println(zad1.isWon());
    }
}
