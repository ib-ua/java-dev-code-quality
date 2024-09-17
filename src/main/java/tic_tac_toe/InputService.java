package tic_tac_toe;

import java.util.Scanner;

public class InputService implements GameInput {
    Scanner scan = new Scanner(System.in);
    private static InputService instance = null;
    private InputService() {}

    public static InputService getInstance() {
        if (instance == null) {
            instance = new InputService();
        }
        return instance;
    }

    @Override
    public byte readInput() {
        return scan.nextByte();
    }
}
