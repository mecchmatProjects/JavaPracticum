package games.server.handler;

import games.common.packet.hangman.HangmanGuessPacket;
import games.common.packet.hangman.HangmanStatePacket;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HangmanHandlerTest {

    @Test
    void handle() throws Exception {
        HangmanHandler handler = new HangmanHandler();

        Set<Character> chars = handler.getPhrase().chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.toSet());

        HangmanStatePacket statePacket = null;

        for (char c : chars) {
            statePacket = handler.handle(new HangmanGuessPacket(c));
            assertEquals(1, statePacket.getStage());
        }

        assertNotNull(statePacket);
        assertEquals(handler.getPhrase(), statePacket.getEncodedPhrase());
    }
}
