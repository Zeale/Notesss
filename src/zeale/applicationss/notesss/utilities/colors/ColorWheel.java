package zeale.applicationss.notesss.utilities.colors;

import java.util.Arrays;

import javafx.scene.paint.Paint;
import zeale.applicationss.notesss.utilities.Lengthed;
import zeale.applicationss.notesss.utilities.generators.Generator;

public class ColorWheel<CT extends Paint> implements Generator<CT>, Lengthed {

	// TODO Make ColorWheel generic (so instances that only hold Color objects can
	// return Color arrays instead of Paint arrays).

	private final CT[] foregrounds, backgrounds;

	private int pos;

	@SafeVarargs
	public ColorWheel(CT[] foregrounds, CT... backgrounds) {
		if (foregrounds.length == 0 || backgrounds.length == 0)
			throw new IllegalArgumentException("Neither the foreground nor background arrays may be of size 0.");
		this.foregrounds = Arrays.copyOf(foregrounds, foregrounds.length);
		this.backgrounds = Arrays.copyOf(backgrounds, backgrounds.length);
	}

	public CT getb(int index) {
		return getBackgroundColor(index);
	}

	public CT getBackgroundColor(int index) {
		return backgrounds.length == 0 ? null : backgrounds[index % backgrounds.length];
	}

	public CT[] getBackgrounds() {
		return Arrays.copyOf(backgrounds, backgrounds.length);
	}

	public int getBSize() {
		return backgrounds.length;
	}

	public CT getColor(int index) {
		return (index %= len()) > foregrounds.length ? backgrounds[index -= foregrounds.length] : foregrounds[index];
	}

	public CT[] getColors() {
		CT[] colors = Arrays.copyOf(foregrounds, len());
		System.arraycopy(backgrounds, 0, foregrounds, foregrounds.length, backgrounds.length);
		return colors;
	}

	public CT getf(int index) {
		return getForegroundColor(index);
	}

	public CT getForegroundColor(int index) {
		return foregrounds.length == 0 ? null : foregrounds[index % foregrounds.length];
	}

	public CT[] getForegrounds() {
		return Arrays.copyOf(foregrounds, foregrounds.length);
	}

	public int getFSize() {
		return foregrounds.length;
	}

	@Override
	public int length() {
		return foregrounds.length + backgrounds.length;
	}

	@Override
	public CT next() {
		return getColor(++pos >= len() ? (pos = 0) : pos);
	}

	public CT startOver() {
		CT color = getColor(pos);
		pos = 0;
		return color;
	}

}
