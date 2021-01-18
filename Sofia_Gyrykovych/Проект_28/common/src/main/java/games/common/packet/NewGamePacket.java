package games.common.packet;

/**
 * Пакет для запроса клиента создания сервером новой игры.
 * Содержит тип игры
 */
public class NewGamePacket extends Packet {

    private final GameType gameType;

    public NewGamePacket(GameType gameType) {
        this.gameType = gameType;
    }

    public GameType getGameType() {
        return gameType;
    }

    /**
     * Тип игры
     */
    public enum GameType {

        /**
         * Виселица
         */
        HANGMAN,

        /**
         * Кроссворд
         */
        CROSSWORD
    }
}
