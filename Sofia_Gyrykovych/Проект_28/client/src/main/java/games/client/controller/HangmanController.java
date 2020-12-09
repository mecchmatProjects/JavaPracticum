package games.client.controller;

import games.client.ClientMain;
import games.common.Constants;
import games.common.packet.hangman.HangmanGuessPacket;
import games.common.packet.hangman.HangmanStatePacket;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Контроллер виселицы
 */
public class HangmanController extends Controller {

    @FXML
    private ImageView imageViewHangman;

    @FXML
    private Label labelPhrase;

    @FXML
    private TextField textFieldGuess;

    @Override
    public void afterInit() throws Exception {
        update();
    }

    public void onGuess() throws Exception {
        String guess = textFieldGuess.getText();

        if (guess.isEmpty()) {
            return;
        }

        connection.send(new HangmanGuessPacket(guess.charAt(0)));
        update();

        textFieldGuess.setText("");
    }

    public void onHome() {
        client.setSceneRoot(ClientMain.VIEW_MAIN);
    }

    private void update() throws Exception {
        HangmanStatePacket packet = connection.recv();

        String imageUrl = String.format("/images/hangman/%d.png", packet.getStage());
        imageViewHangman.setImage(new Image(imageUrl));

        if (packet.getStage() != Constants.HANGMAN_LAST_STAGE) {
            labelPhrase.setText(packet.getEncodedPhrase());
        }

        String message = null;

        if (packet.getStage() == Constants.HANGMAN_LAST_STAGE) {
            message = "You Lose! The word was: " + packet.getEncodedPhrase();
        } else if (!packet.getEncodedPhrase().contains("_")) {
            message = "You Win!";
        }

        if (message != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();

            client.setSceneRoot(ClientMain.VIEW_MAIN);
        }
    }
}
