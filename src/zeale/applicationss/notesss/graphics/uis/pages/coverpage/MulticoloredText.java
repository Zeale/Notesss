package zeale.applicationss.notesss.graphics.uis.pages.coverpage;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import zeale.applicationss.notesss.utilities.generators.Generator;

/**
 * This class serves as an {@link HBox} that encapsulates multiple {@link Text}
 * objects, each of which hold a single character. the
 * 
 * @author Zeale
 *
 */
class MulticoloredText extends HBox {
	public String getText() {
		String txt = "";
		for (Node n : getChildren())
			if (n instanceof Text)
				txt += ((Text) n).getText();
		return txt;
	}

	private Generator<? extends Paint> colorSupplier;

	public MulticoloredText(Generator<? extends Paint> colorSupplier) {
		if ((this.colorSupplier = colorSupplier) == null)
			throw new IllegalArgumentException("Color supplier cannot be null.");
	}

	public void setColorSupplier(Generator<? extends Paint> colorSupplier) {
		this.colorSupplier = colorSupplier;
	}

	public void setText(String text) {
//		for (Iterator<Node> iterator = getChildren().iterator(); iterator.hasNext();)
//			if (isSpecialText(iterator.next()))
//				iterator.remove();
		getChildren().clear();
		for (char c : text.toCharArray()) {
			Text node = getText(c + "");
			getChildren().add(node);
			Paint color = colorSupplier.next();
			node.setFill(color == null ? Color.WHITE : color);
		}

	}

	private static final Object SPECIAL_TEXT_KEY = new Object();

	private static final Text getText(String text) {
		Text txt = new Text(text);
		txt.getProperties().put(SPECIAL_TEXT_KEY, true);
		return txt;
	}

	@SuppressWarnings("unused")
	private static final boolean isSpecialText(Node text) {
		return text.getProperties().containsKey(SPECIAL_TEXT_KEY);
	}

}
