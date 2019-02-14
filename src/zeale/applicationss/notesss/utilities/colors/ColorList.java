package zeale.applicationss.notesss.utilities.colors;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import static zeale.applicationss.notesss.utilities.Utilities.array;

public final class ColorList<CT extends Paint> extends ColorWheel<CT> {

	public static final ColorList<Color> ORANGE_BLUE_BLACK = new ColorList<>(
			array(color(0x08, 0x48, 0x87), color(0xF5, 0x8A, 0x07), color(0x3c, 0x6e, 0x71)), color(0x0f), color(0x35));
	public static final ColorList<Color> AUTMN = new ColorList<>(
			array(color(0xA4, 0x42, 0x00), color(0xD1, 0x7A, 0x23), color(0xFF, 0xC4, 0x44)), color(0x3C, 0x15, 0x18),
			color(0x69, 0x14, 0x0E));

	private static Color color(int red, int green, int blue) {
		return new Color(red / 255d, green / 255d, blue / 255d, 1);
	}

	private static Color color(int red_green_blue) {
		return color(red_green_blue, red_green_blue, red_green_blue);
	}

	@SafeVarargs
	private ColorList(CT[] foregroundColors, CT... backgroundColors) {
		super(foregroundColors, backgroundColors);
	}
}
