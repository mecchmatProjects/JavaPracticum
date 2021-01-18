package games.common.packet.hangman;

import games.common.packet.Packet;

/**
 * Пакет попытки клиента с символом для виселицы
 */
public class HangmanGuessPacket extends Packet {

    private final char guess;

    public HangmanGuessPacket(char guess) {
        this.guess = guess;
    }

    public char getGuess() {
        return guess;
    }
}
