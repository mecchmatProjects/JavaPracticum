package games.server.handler;

import games.common.packet.Packet;

/**
 * Базовый обработчик пакетов
 *
 * @param <T> тип обрабатываемого пакета
 */
public abstract class GameHandler<T extends Packet> {

    /**
     * Создаёт первый пакет (скорее всего с начальными данными) для отправки клиенту
     */
    public abstract Packet create();

    /**
     * Принимает пакет на обработку и возвращает пакет который будет переслан клиенту
     */
    public abstract Packet handle(T packet);

    @SuppressWarnings("unchecked")
    public Packet handlePacket(Packet packet) {
        return handle((T) packet);
    }
}
