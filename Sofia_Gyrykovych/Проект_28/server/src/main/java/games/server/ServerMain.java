package games.server;

import games.common.Constants;
import games.common.SocketConnection;
import games.common.packet.NewGamePacket;
import games.common.packet.Packet;
import games.server.handler.CrosswordHandler;
import games.server.handler.GameHandler;
import games.server.handler.HangmanHandler;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Главный класс сервера
 */
public class ServerMain {

    private final SocketConnection client;
    private GameHandler<?> handler;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(Constants.DEFAULT_PORT);

        Socket socket = serverSocket.accept();
        serverSocket.close();

        new ServerMain(new SocketConnection(socket)).mainLoop();
    }

    public ServerMain(SocketConnection client) {
        this.client = client;
    }

    public void mainLoop() throws Exception {
        //noinspection InfiniteLoopStatement
        while (true) {
            Packet packet = client.recv();

            if (packet instanceof NewGamePacket) {
                NewGamePacket newGame = (NewGamePacket) packet;

                switch (newGame.getGameType()) {
                    case HANGMAN:
                        handler = new HangmanHandler();
                        break;
                    case CROSSWORD:
                        handler = new CrosswordHandler();
                        break;
                }

                client.send(handler.create());

            } else if (handler != null) {

                client.send(handler.handlePacket(packet));
            }
        }
    }
}
