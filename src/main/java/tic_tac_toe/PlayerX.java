package tic_tac_toe;

public class PlayerX extends Player {
    GameInput gameInput = InputService.getInstance();
    GameOutput gameOutput = OutputService.getInstance();

    public PlayerX() {
        super('X');
    }

    @Override
    void getMarkPlacement(char[] box) {
        while (true) {
            try {
                byte input = gameInput.readInput();
                if (input > 0 && input < 10) {
                    if (box[input - 1] != GameProperties.EMPTY_FIELD) {
                        gameOutput.print("That one is already in use. Enter another.");
                    } else {
                        box[input - 1] = mark;
                        break;
                    }
                } else {
                    gameOutput.print("Invalid input. Enter again.");
                }
            } catch (RuntimeException e) {
                gameOutput.print("Invalid input. Enter again.");
            }

        }
    }
}
