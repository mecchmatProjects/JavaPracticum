package games.common.packet.crossword;

import games.common.packet.Packet;

/**
 * Пакет с необходимой для клиента информацией о кроссворде:
 * двумерный массив состояний ячеек и строка с подсказками
 */
public class CrosswordDataPacket extends Packet {

    /**
     * Состояние ячейки: не используется
     */
    public static final int CELL_STATE_EMPTY = 0;

    /**
     * Состояние ячейки: должна содержать первую букву слова
     */
    public static final int CELL_STATE_LETTER = 1000;

    private final int[][] cells;
    private final String hints;

    public CrosswordDataPacket(int[][] cells, String hints) {
        this.cells = cells;
        this.hints = hints;
    }

    public int[][] getCells() {
        return cells;
    }

    public String getHints() {
        return hints;
    }
}
