package games.client.controller;

import games.client.ClientMain;
import games.common.packet.NewGamePacket;

public class MainController extends Controller {

    public void onPlayHangman() throws Exception {
        connection.send(new NewGamePacket(NewGamePacket.GameType.HANGMAN));
        client.setSceneRoot(ClientMain.VIEW_HANGMAN);
    }

    public void onPlayCrossword() throws Exception {
        connection.send(new NewGamePacket(NewGamePacket.GameType.CROSSWORD));
        client.setSceneRoot(ClientMain.VIEW_CROSSWORD);
    }
}
