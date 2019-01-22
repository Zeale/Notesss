package zeale.applicationss.notesss.utilities.colors;

import javafx.scene.paint.Color;

public final class ColorList {
	public static final Color SMOKY_BLACK = color(0x0f), DARK_CERULEAN = color(0x08, 0x48, 0x87),
			TANGERINE = color(0xf5, 0x8a, 0x07), JET = color(0x35), MYRTLE_GREEN = color(0x3c, 0x6e, 0x71);

	private static Color color(int red, int green, int blue) {
		return new Color(red / 255d, green / 255d, blue / 255d, 1);
	}

	private static Color color(int red_green_blue) {
		return color(red_green_blue, red_green_blue, red_green_blue);
	}
	
	private ColorList() {	}
}
