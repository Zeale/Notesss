package zeale.applicationss.notesss.utilities.colors;

import java.util.Arrays;

import javafx.scene.paint.Paint;
import zeale.applicationss.notesss.utilities.generators.Generator;

public class ColorWheel implements Generator<Paint> {

	private final Paint[] colors;

	public Paint[] getColors() {
		return Arrays.copyOf(colors, colors.length);
	}

	public ColorWheel(Paint... colors) {
		this.colors = Arrays.copyOf(colors, colors.length);
	}

	private int pos;

	@Override
	public Paint next() {
		return colors[++pos >= colors.length ? (pos = 0) : pos];
	}

}
