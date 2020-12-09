package games.common.packet.crossword;

import games.common.packet.Packet;

/**
 * Результат оценки сервером попытки клиента заполнить кроссворд.
 * Содержит флаг результата
 */
public class CrosswordResultPacket extends Packet {

    private final boolean result;

    public CrosswordResultPacket(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }
}
