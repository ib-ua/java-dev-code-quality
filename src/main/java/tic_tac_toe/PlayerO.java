package tic_tac_toe;

public class PlayerO extends Player {
    public PlayerO() {
        super('O');
    }

    @Override
    void getMarkPlacement(char[] box) {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * 9 + 1);
            if (box[rand - 1] == GameProperties.EMPTY_FIELD) {
                box[rand - 1] = mark;
                break;
            }
        }
    }
}
