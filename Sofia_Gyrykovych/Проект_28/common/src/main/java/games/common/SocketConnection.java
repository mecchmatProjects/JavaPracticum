package games.common;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Класс для отправки и получения объектов через сокет
 */
public class SocketConnection implements AutoCloseable {

    private final Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public SocketConnection(Socket socket) {
        this.socket = socket;
    }

    /**
     * Отправить объект
     */
    public void send(Object obj) throws Exception {
        if (outputStream == null) {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        }
        outputStream.writeObject(obj);
    }

    /**
     * Получить объект
     */
    @SuppressWarnings("unchecked")
    public <T> T recv() throws Exception {
        if (inputStream == null) {
            inputStream = new ObjectInputStream(socket.getInputStream());
        }
        return (T) inputStream.readObject();
    }

    @Override
    public void close() throws Exception {
        socket.close();
    }
}
