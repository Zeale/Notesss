package zeale.applicationss.notesss.utilities.colors;

import java.util.LinkedList;
import java.util.List;

import org.alixia.chatroom.api.QuickList;

import javafx.scene.paint.Paint;
import zeale.applicationss.notesss.utilities.generators.Generator;

public class ColorWheel implements Generator<Paint> {

	private final List<Paint> colors;

	public ColorWheel(List<Paint> colors) {
		this.colors = new LinkedList<>(colors);
	}

	public ColorWheel(Paint... colors) {
		this.colors = new QuickList<>(colors);
	}

	private int pos;

	@Override
	public Paint next() {
		return colors.get(++pos >= colors.size() ? (pos = 0) : pos);
	}

}
