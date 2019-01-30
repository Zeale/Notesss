package zeale.applicationss.notesss.utilities.colors;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public final class ColorList extends ColorWheel {

	public static final ColorList ORANGE_BLUE_BLACK = new ColorList(color(0x0f), color(0x08, 0x48, 0x87),
			color(0xf5, 0x8a, 0x07), color(0x35), color(0x3c, 0x6e, 0x71));

	private static Color color(int red, int green, int blue) {
		return new Color(red / 255d, green / 255d, blue / 255d, 1);
	}

	private static Color color(int red_green_blue) {
		return color(red_green_blue, red_green_blue, red_green_blue);
	}

	private ColorList(Paint... colors) {
		super(colors);
	}
}
