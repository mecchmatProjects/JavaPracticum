package games.server.handler;

import games.common.Constants;
import games.common.packet.crossword.CrosswordDataPacket;
import games.common.packet.crossword.CrosswordGuessPacket;
import games.common.packet.crossword.CrosswordResultPacket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Обработчик пакетов кроссворда
 */
public class CrosswordHandler extends GameHandler<CrosswordGuessPacket> {

    private final int[][] cells;
    private final char[][] crossword;
    private final String hints;

    public CrosswordHandler() throws IOException {
        this.cells = new int[Constants.CROSSWORD_SIZE][Constants.CROSSWORD_SIZE];
        this.crossword = new char[Constants.CROSSWORD_SIZE][Constants.CROSSWORD_SIZE];
        this.hints = readCrosswordAndHints();
    }

    @Override
    public CrosswordDataPacket create() {
        return new CrosswordDataPacket(cells, hints);
    }

    @Override
    public CrosswordResultPacket handle(CrosswordGuessPacket packet) {
        boolean result = true;
        char[][] guess = packet.getGuess();

        for (int i = 0; i < Constants.CROSSWORD_SIZE; i++) {
            for (int j = 0; j < Constants.CROSSWORD_SIZE; j++) {
                if (Character.toLowerCase(guess[i][j]) != Character.toLowerCase(crossword[i][j])) {
                    result = false;
                    break;
                }
            }
        }

        return new CrosswordResultPacket(result);
    }

    public char[][] getCrossword() {
        return crossword;
    }

    private String readCrosswordAndHints() throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/crossword.txt")))) {

            for (int i = 0; i < Constants.CROSSWORD_SIZE; i++) {
                String line = reader.readLine();

                for (int j = 0; j < Constants.CROSSWORD_SIZE; j++) {
                    char c = line.charAt(j);

                    if (c != '_') {
                        cells[i][j] = CrosswordDataPacket.CELL_STATE_LETTER;
                        crossword[i][j] = c;
                    } else {
                        cells[i][j] = CrosswordDataPacket.CELL_STATE_EMPTY;
                        crossword[i][j] = ' ';
                    }
                }
            }

            int nextWord = 1;

            for (String str : reader.readLine().split(" ")) {
                String[] ij = str.split(";");

                int i = Integer.parseInt(ij[0]) - 1;
                int j = Integer.parseInt(ij[1]) - 1;
                cells[i][j] = nextWord++;
            }

            return reader.lines().collect(Collectors.joining("\n"));
        }
    }
}
