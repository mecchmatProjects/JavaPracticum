package generator;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    @Test
    void defaultProperties() {
        Item item = new Item();

        assertEquals("<no text>", item.getText());
        assertEquals(2.0, item.getHorizontalAlign());
        assertEquals(2.0, item.getVerticalAlign());
        assertEquals(Color.WHITE, item.getColor());

        assertEquals("Item #1", item.toString());
    }
}
