package tic_tac_toe;

public class GameProperties {
    static final char EMPTY_FIELD = ' ';
    private GameProperties() {}
    enum Message {
        GREETINGS("Enter box number to select. Enjoy!"),
        ON_WIN("You won the game!"),
        ON_LOSE("You lost the game!"),
        ON_DRAW("It's a draw!"),
        COPYRIGHT("Created by Shreyas Saha. Thanks for playing!");
        private final String text;

        Message(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

}


