package games.server.handler;

import games.common.packet.crossword.CrosswordGuessPacket;
import games.common.packet.crossword.CrosswordResultPacket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CrosswordHandlerTest {

    @Test
    void handle() throws Exception {
        CrosswordHandler handler = new CrosswordHandler();
        CrosswordResultPacket resultPacket = handler.handle(new CrosswordGuessPacket(handler.getCrossword()));

        assertTrue(resultPacket.getResult());
    }
}