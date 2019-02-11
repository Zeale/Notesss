package zeale.applicationss.notesss.utilities.colors;

import java.util.Arrays;

import javafx.scene.paint.Paint;
import zeale.applicationss.notesss.utilities.Lengthed;
import zeale.applicationss.notesss.utilities.generators.Generator;

public class ColorWheel implements Generator<Paint>, Lengthed {

	// TODO Make ColorWheel generic (so instances that only hold Color objects can
	// return Color arrays instead of Paint arrays).

	private final Paint[] foregrounds, backgrounds;

	public Paint[] getForegrounds() {
		return Arrays.copyOf(foregrounds, foregrounds.length);
	}

	public Paint getForegroundColor(int index) {
		return foregrounds[index % foregrounds.length];
	}

	public Paint getBackgroundColor(int index) {
		return backgrounds[index % backgrounds.length];
	}

	public Paint getf(int index) {
		return getForegroundColor(index);
	}

	public Paint getb(int index) {
		return getBackgroundColor(index);
	}

	public Paint[] getBackgrounds() {
		return Arrays.copyOf(backgrounds, backgrounds.length);
	}

	public Paint[] getColors() {
		Paint[] colors = Arrays.copyOf(foregrounds, len());
		System.arraycopy(backgrounds, 0, foregrounds, foregrounds.length, backgrounds.length);
		return colors;
	}

	public Paint getColor(int index) {
		return (index %= (len())) > foregrounds.length ? backgrounds[index -= foregrounds.length] : foregrounds[index];
	}

	public ColorWheel(Paint[] foregrounds, Paint... backgrounds) {
		this.foregrounds = Arrays.copyOf(foregrounds, foregrounds.length);
		this.backgrounds = Arrays.copyOf(backgrounds, backgrounds.length);
	}

	private int pos;

	public Paint startOver() {
		Paint color = getColor(pos);
		pos = 0;
		return color;
	}

	@Override
	public Paint next() {
		return getColor(++pos >= len() ? (pos = 0) : pos);
	}

	@Override
	public int length() {
		return foregrounds.length + backgrounds.length;
	}

}
