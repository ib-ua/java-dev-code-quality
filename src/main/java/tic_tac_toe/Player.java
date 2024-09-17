package tic_tac_toe;

public abstract class Player {
    final char mark;

    Player(char mark) {
        this.mark = mark;
    }

    abstract void getMarkPlacement(char[] box);
}