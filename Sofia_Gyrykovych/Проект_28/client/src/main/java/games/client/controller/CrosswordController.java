package games.client.controller;

import games.client.ClientMain;
import games.common.Constants;
import games.common.packet.crossword.CrosswordDataPacket;
import games.common.packet.crossword.CrosswordGuessPacket;
import games.common.packet.crossword.CrosswordResultPacket;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Контроллер кроссворда
 */
public class CrosswordController extends Controller {

    @FXML
    private Label labelHints;

    @FXML
    private VBox vboxCrossword;

    private TextField[][] textFields;

    @Override
    public void afterInit() throws Exception {
        CrosswordDataPacket packet = connection.recv();

        int[][] cells = packet.getCells();
        textFields = new TextField[Constants.CROSSWORD_SIZE][Constants.CROSSWORD_SIZE];

        for (int i = 0; i < Constants.CROSSWORD_SIZE; i++) {
            for (int j = 0; j < Constants.CROSSWORD_SIZE; j++) {
                String selector = String.format("#textField%d%d", i + 1, j + 1);
                textFields[i][j] = (TextField) vboxCrossword.lookup(selector);

                switch (cells[i][j]) {
                    case CrosswordDataPacket.CELL_STATE_EMPTY:
                        textFields[i][j].setDisable(true);
                        textFields[i][j].setVisible(false);
                        break;
                    case CrosswordDataPacket.CELL_STATE_LETTER:
                        break;
                    default:
                        textFields[i][j].setPromptText(String.valueOf(cells[i][j]));
                }
            }
        }

        labelHints.setText(packet.getHints());
    }

    public void onHome() {
        client.setSceneRoot(ClientMain.VIEW_MAIN);
    }

    public void onCheck() throws Exception {
        char[][] guess = new char[Constants.CROSSWORD_SIZE][Constants.CROSSWORD_SIZE];

        for (int i = 0; i < Constants.CROSSWORD_SIZE; i++) {
            for (int j = 0; j < Constants.CROSSWORD_SIZE; j++) {
                String text = textFields[i][j].getText();
                if (text.isEmpty()) {
                    text = " ";
                }
                guess[i][j] = text.charAt(0);
            }
        }

        connection.send(new CrosswordGuessPacket(guess));
        CrosswordResultPacket packet = connection.recv();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(packet.getResult() ? "You Win!" : "Try Again!");
        alert.showAndWait();

        if (packet.getResult()) {
            client.setSceneRoot(ClientMain.VIEW_MAIN);
        }
    }
}
