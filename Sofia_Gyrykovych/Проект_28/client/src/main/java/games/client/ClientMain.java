package games.client;

import games.client.controller.Controller;
import games.common.Constants;
import games.common.SocketConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.Socket;

/**
 * Главный класс клиента, а также менеджер экранов
 */
public class ClientMain extends Application {

    /**
     * Путь к .fxml ресурсу главного экрана
     */
    public static final String VIEW_MAIN = "/main.fxml";

    /**
     * Путь к .fxml ресурсу экрана виселицы
     */
    public static final String VIEW_HANGMAN = "/hangman.fxml";

    /**
     * Путь к .fxml ресурсу экрана кроссворда
     */
    public static final String VIEW_CROSSWORD = "/crossword.fxml";

    private SocketConnection connection;
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        connection = new SocketConnection(new Socket("localhost", Constants.DEFAULT_PORT));
        scene = new Scene(load(VIEW_MAIN));

        primaryStage.setTitle("My Games");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Устанавливает новый экран
     *
     * @param resourceName путь к .fxml ресурсу
     */
    public void setSceneRoot(String resourceName) {
        scene.setRoot(load(resourceName));
    }

    private Parent load(String resourceName) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resourceName));

            Parent parent = fxmlLoader.load();

            Controller controller = fxmlLoader.getController();
            controller.setClient(this);
            controller.setConnection(connection);
            controller.afterInit();

            return parent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
