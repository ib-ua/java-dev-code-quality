package tic_tac_toe;

import java.util.logging.Logger;

public class OutputService implements GameOutput {
    private static OutputService instance = null;
    Logger logger = Logger.getLogger(getClass().getName());

    private OutputService() {}

    public static OutputService getInstance() {
        if (instance == null) {
            instance = new OutputService();
        }
        return instance;
    }

    @Override
    public void print(String text) {
        logger.info(text);
    }

    @Override
    public void renderGameView(char[] box) {
        if (box.length != 9) {
            throw new IllegalArgumentException("Invalid number of chars");
        } else {
            print(
                String.format(
                    "%n%n %c | %c | %c %n-----------%n %c | %c | %c %n-----------%n %c | %c | %c %n",
                    box[0], box[1], box[2], box[3], box[4], box[5], box[6], box[7], box[8]
                )
            );
        }
    }




}