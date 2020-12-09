package games.common.packet.crossword;

import games.common.packet.Packet;

/**
 * Пакет попытки клиента заполнить кроссворд.
 * Содержит двумерный массив символов каждой ячейки кроссворда
 */
public class CrosswordGuessPacket extends Packet {

    private final char[][] guess;

    public CrosswordGuessPacket(char[][] guess) {
        this.guess = guess;
    }

    public char[][] getGuess() {
        return guess;
    }
}
