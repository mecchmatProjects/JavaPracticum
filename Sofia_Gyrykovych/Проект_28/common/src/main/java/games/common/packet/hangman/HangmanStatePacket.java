package games.common.packet.hangman;

import games.common.packet.Packet;

/**
 * Пакет текущего состояния виселицы.
 * Содержит закодированную фразу и уровень виселицы.
 * Отправляется сервером после создания игры
 * и оценки попытки пользователя
 */
public class HangmanStatePacket extends Packet {

    private final String encodedPhrase;
    private final int stage;

    public HangmanStatePacket(String encodedPhrase, int stage) {
        this.encodedPhrase = encodedPhrase;
        this.stage = stage;
    }

    public String getEncodedPhrase() {
        return encodedPhrase;
    }

    public int getStage() {
        return stage;
    }
}
