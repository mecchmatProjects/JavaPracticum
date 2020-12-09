package games.client.controller;

import games.client.ClientMain;
import games.common.SocketConnection;

/**
 * Базовый контроллер для экранов. Позволяет внедрять необходимые зависимости
 */
public abstract class Controller {

    protected ClientMain client;
    protected SocketConnection connection;

    /**
     * Вызывается при инициализации контроллера, после внедрения зависимостей
     */
    public void afterInit() throws Exception {
    }

    public void setClient(ClientMain client) {
        this.client = client;
    }

    public void setConnection(SocketConnection connection) {
        this.connection = connection;
    }
}
