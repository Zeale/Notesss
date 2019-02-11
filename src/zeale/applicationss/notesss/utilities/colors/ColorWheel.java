package zeale.applicationss.notesss.utilities.colors;

import java.util.Arrays;

import javafx.scene.paint.Paint;
import zeale.applicationss.notesss.utilities.Lengthed;
import zeale.applicationss.notesss.utilities.generators.Generator;

public class ColorWheel implements Generator<Paint>, Lengthed {

	private final Paint[] colors;

	public Paint[] getColors() {
		return Arrays.copyOf(colors, colors.length);
	}

	public Paint getColor(int index) {
		return colors[index % len()];
	}

	public ColorWheel(Paint... colors) {
		this.colors = Arrays.copyOf(colors, colors.length);
	}

	private int pos;

	public Paint startOver() {
		Paint color = colors[pos];
		pos = 0;
		return color;
	}

	@Override
	public Paint next() {
		return colors[++pos >= colors.length ? (pos = 0) : pos];
	}

	@Override
	public int length() {
		return colors.length;
	}

}
