package games.server.handler;

import games.common.Constants;
import games.common.packet.hangman.HangmanGuessPacket;
import games.common.packet.hangman.HangmanStatePacket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Обработчик пакетов виселицы
 */
public class HangmanHandler extends GameHandler<HangmanGuessPacket> {

    private final String phrase;
    private final StringBuilder encodedPhrase;
    private int stage;

    public HangmanHandler() throws IOException {
        this.phrase = getRandomWord(getClass().getResourceAsStream("/hangman.txt"));
        this.encodedPhrase = new StringBuilder("_".repeat(phrase.length()));
        this.stage = 1;
    }

    @Override
    public HangmanStatePacket create() {
        return new HangmanStatePacket(encodedPhrase.toString(), stage);
    }

    public HangmanStatePacket handle(HangmanGuessPacket packet) {
        if (stage == Constants.HANGMAN_LAST_STAGE || encodedPhrase.indexOf("_") == -1) {
            throw new IllegalStateException();
        }

        boolean any = false;
        char guess = Character.toUpperCase(packet.getGuess());

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == guess) {
                encodedPhrase.setCharAt(i, phrase.charAt(i));
                any = true;
            }
        }

        if (!any) {
            stage += 1;

            if (stage == Constants.HANGMAN_LAST_STAGE) {
                encodedPhrase.setLength(0);
                encodedPhrase.append(phrase);
            }
        }

        return new HangmanStatePacket(encodedPhrase.toString(), stage);
    }

    public String getPhrase() {
        return phrase;
    }

    private static String getRandomWord(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<String> words = reader.lines()
                    .collect(Collectors.toUnmodifiableList());

            int randomIndex = ThreadLocalRandom.current().nextInt(words.size());
            return words.get(randomIndex).toUpperCase();
        }
    }
}
