package tic_tac_toe;
import java.util.Arrays;


public class Game {
    private final Player playerX = new PlayerX();
    private final Player playerO = new PlayerO();
    char[] box = new char[9];

    GameOutput gameOutput = OutputService.getInstance();

    public static void main(String[] args) {
        var game = new Game();
        game.play();
    }

    public void play() {
        initGame();

        for (int i = 0; i < box.length; i++) {
            Player currentPlayer = i % 2 == 0 ? playerX : playerO;
            currentPlayer.getMarkPlacement(box);
            renderGameView();
            if (isWinner(currentPlayer)) {
                String message = currentPlayer.equals(playerX) ?
                        GameProperties.Message.ON_WIN.toString() :
                        GameProperties.Message.ON_LOSE.toString();
                outputResult(message);
                return;
            }
        }

        outputResult(GameProperties.Message.ON_DRAW.toString());
    }
    
    private void initGame() {
        printGreetings();
        Arrays.fill(box, GameProperties.EMPTY_FIELD);
    }

    private void printGreetings() {
        char[] blueprint = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        gameOutput.print(
            String.format("%s%n", GameProperties.Message.GREETINGS)
        );
        gameOutput.renderGameView(blueprint);
    }

    private void renderGameView() {
        gameOutput.renderGameView(box);
    }

    private void outputResult(String result) {
        gameOutput.print(
            String.format(
                "%s%n%s", result, GameProperties.Message.COPYRIGHT
            )
        );
    }

    private boolean isWinner(Player player) {
        char mark = player.mark;
        return (
            (box[0] == mark && box[1] == mark && box[2] == mark) ||
            (box[3] == mark && box[4] == mark && box[5] == mark) ||
            (box[6] == mark && box[7] == mark && box[8] == mark) ||
            (box[0] == mark && box[3] == mark && box[6] == mark) ||
            (box[1] == mark && box[4] == mark && box[7] == mark) ||
            (box[2] == mark && box[5] == mark && box[8] == mark) ||
            (box[0] == mark && box[4] == mark && box[8] == mark) ||
            (box[2] == mark && box[4] == mark && box[6] == mark)
        );
    }
}