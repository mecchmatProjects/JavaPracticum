package generator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Класс контроллера главного экрана
 *
 * @author Herasymenko Mariia 09.12.2020 12 p.m.
 */
public class MainController {

    @FXML
    private MenuItem menuItemSave;

    @FXML
    private ImageView imageViewPreview;

    @FXML
    private ListView<Item> listViewItems;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonRemove;

    @FXML
    private TextField textFieldText;

    @FXML
    private Slider sliderHorizontal;

    @FXML
    private Slider sliderVertical;

    @FXML
    private ColorPicker colorPickerColor;

    @FXML
    private TextField textFieldWatermark;

    private Image backgroundImage;
    private BufferedImage resultImage;
    private Graphics2D graphics;
    private Font textFont;

    public void initialize() {
        listViewItems.getSelectionModel().selectedItemProperty().addListener(this::onSelect);
        textFieldWatermark.textProperty().addListener((observable, oldValue, newValue) -> updateImage());
    }

    public void onOpen() throws IOException {
        Window window = imageViewPreview.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));

        File file = fileChooser.showOpenDialog(window);

        if (file == null) {
            return;
        }

        final int width = 1024;
        final int height = 1024;

        backgroundImage = ImageIO.read(file).getScaledInstance(width, height, Image.SCALE_SMOOTH);
        resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics = resultImage.createGraphics();
        textFont = new Font("Impact", Font.PLAIN, 96);
        graphics.setFont(new Font("Impact", Font.ITALIC, 30));

        // устанавливаем высокие параметры качества изображения
        graphics.setStroke(new BasicStroke(4.0f));
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        imageViewPreview.setImage(new WritableImage(width, height));
        updateImage();

        buttonAdd.setDisable(false);
        menuItemSave.setDisable(false);
        textFieldWatermark.setDisable(false);
    }

    public void onAdd() {
        Item item = new Item();

        ChangeListener<Object> objectChangeListener = (observable, oldValue, newValue) ->
                updateImage();

        ChangeListener<Number> numberChangeListener = (observable, oldValue, newValue) -> {
            if (Math.round(newValue.doubleValue()) != Math.round(oldValue.doubleValue())) {
                updateImage();
            }
        };

        item.textProperty().addListener(objectChangeListener);
        item.horizontalAlignProperty().addListener(numberChangeListener);
        item.verticalAlignProperty().addListener(numberChangeListener);
        item.colorProperty().addListener(objectChangeListener);

        listViewItems.getItems().add(item);
        listViewItems.getSelectionModel().select(item);

        updateImage();
    }

    public void onRemove() {
        listViewItems.getItems().remove(listViewItems.getSelectionModel().getSelectedItem());
        updateImage();
    }

    public void onSelect(ObservableValue<? extends Item> observable, Item oldValue, Item newValue) {
        boolean disable = (newValue == null);
        buttonRemove.setDisable(disable);
        textFieldText.setDisable(disable);
        sliderHorizontal.setDisable(disable);
        sliderVertical.setDisable(disable);
        colorPickerColor.setDisable(disable);

        if (oldValue != null) {
            textFieldText.textProperty().unbindBidirectional(oldValue.textProperty());
            sliderHorizontal.valueProperty().unbindBidirectional(oldValue.horizontalAlignProperty());
            sliderVertical.valueProperty().unbindBidirectional(oldValue.verticalAlignProperty());
            colorPickerColor.valueProperty().unbindBidirectional(oldValue.colorProperty());
        }

        if (newValue != null) {
            textFieldText.textProperty().bindBidirectional(newValue.textProperty());
            sliderHorizontal.valueProperty().bindBidirectional(newValue.horizontalAlignProperty());
            sliderVertical.valueProperty().bindBidirectional(newValue.verticalAlignProperty());
            colorPickerColor.valueProperty().bindBidirectional(newValue.colorProperty());
        }
    }

    public void onSave() throws IOException {
        Window window = imageViewPreview.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
        fileChooser.setInitialFileName("meme.png");

        File file = fileChooser.showSaveDialog(window);

        if (file == null) {
            return;
        }

        ImageIO.write(resultImage, "png", file);
    }

    private void updateImage() {
        final int width = resultImage.getWidth();
        final int height = resultImage.getHeight();

        graphics.drawImage(backgroundImage, 0, 0, width, height, null);

        for (Item item : listViewItems.getItems()) {
            int horizontalAlign = (int) Math.round(item.getHorizontalAlign());
            int verticalAlign = (int) Math.round(item.getVerticalAlign());
            String text = item.getText().toUpperCase();

            Shape outline = textFont.createGlyphVector(graphics.getFontRenderContext(), text).getOutline();
            Rectangle bounds = outline.getBounds();

            double tx, ty;

            // переводим значение слайдера в соответствующий сдвиг по оси x
            switch (horizontalAlign) {
                case 1:
                    tx = 10.0;
                    break;
                case 2:
                    tx = (width - bounds.width) / 2.0;
                    break;
                case 3:
                    tx = width - bounds.width - 15.0;
                    break;
                default:
                    throw new IllegalArgumentException();
            }

            // переводим значение слайдера в соответствующий сдвиг по оси y
            switch (verticalAlign) {
                case 1:
                    ty = height - 10.0;
                    break;
                case 2:
                    ty = (height + bounds.height) / 2.0;
                    break;
                case 3:
                    ty = bounds.height + 10.0;
                    break;
                default:
                    throw new IllegalArgumentException();
            }

            outline = AffineTransform.getTranslateInstance(tx, ty).createTransformedShape(outline);

            graphics.setColor(toAwtColor(item.getColor()));
            graphics.fill(outline);
            graphics.setColor(Color.BLACK);
            graphics.draw(outline);
        }

        graphics.setColor(new Color(255, 255, 255, 150));
        graphics.drawString(textFieldWatermark.getText(), 10, height - 20);

        SwingFXUtils.toFXImage(resultImage, (WritableImage) imageViewPreview.getImage());
    }

    /**
     * Конвертирует объект цвета JavaFX в объект цвета Swing/Awt
     */
    private static Color toAwtColor(javafx.scene.paint.Color color) {
        return new Color(
                (float) color.getRed(),
                (float) color.getGreen(),
                (float) color.getBlue(),
                (float) color.getOpacity());
    }
}
