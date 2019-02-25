package zeale.applicationss.notesss.utilities.colors;

import static zeale.applicationss.notesss.utilities.Utilities.array;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public final class ColorList<CT extends Paint> extends ColorWheel<CT> {

	public static final ColorList<Color> ORANGE_BLUE_BLACK = new ColorList<>(
			array(color(0x08, 0x48, 0x87), color(0xF5, 0x8A, 0x07), color(0x3c, 0x6e, 0x71)), color(0x0f), color(0x35));
	public static final ColorList<Color> AUTMN = new ColorList<>(
			array(color(0xA4, 0x42, 0x00), color(0xD1, 0x7A, 0x23), color(0xFF, 0xC4, 0x44)), color(0x3C, 0x15, 0x18),
			color(0x69, 0x14, 0x0E));
	public static final ColorList<Color> GREENS = new ColorList<>(
			array(color(0x31, 0xCB, 0x00), color(0x11, 0x98, 0x22), color(0x2A, 0x72, 0x21)), color(0x15, 0x26, 0x14),
			color(0x1E, 0x44, 0x1E));
	public static final ColorList<Color> SOFT_RAINBOW = new ColorList<>(
			array(color(0xF2, 0xDC, 0x5D), color(0x69, 0xA2, 0xB0), color(0x65, 0x91, 0x57)), color(0xE0, 0x52, 0x63),
			color(0xF3, 0x92, 0x37));
	public static ColorList<Color> PURE = new ColorList<>(
			array(color(0x0D, 0x07, 0x7A), color(0xF4, 0x6E, 0x07), color(0x45)), color(0x0F));

	private static Color color(int red_green_blue) {
		return color(red_green_blue, red_green_blue, red_green_blue);
	}

	private static Color color(int red, int green, int blue) {
		return new Color(red / 255d, green / 255d, blue / 255d, 1);
	}

	@SafeVarargs
	private ColorList(CT[] foregroundColors, CT... backgroundColors) {
		super(foregroundColors, backgroundColors);
	}
}
