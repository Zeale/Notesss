package zeale.applicationss.notesss.utilities;

import java.util.Arrays;
import java.util.Collection;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public final class Utilities {

	public static final void setAllAnchors(Double anchor, Node... nodes) {
		for (Node n : nodes) {
			AnchorPane.setTopAnchor(n, anchor);
			AnchorPane.setLeftAnchor(n, anchor);
			AnchorPane.setRightAnchor(n, anchor);
			AnchorPane.setBottomAnchor(n, anchor);
		}
	}

	public @SafeVarargs static <E> E[] array(E... elements) {
		return elements;
	}

	public @SafeVarargs static <E> E[] array(int size, E... elements) {
		return Arrays.copyOf(elements, size);
	}

	public static <E> E[] toArray(Collection<E> collection) {
		E[] array = array(collection.size());
		int pos = 0;
		for (E e : collection) {
			array[pos] = e;
			pos++;
		}
		return array;
	}

	public static final void executeOnFXThread(Runnable task) {
		if (Platform.isFxApplicationThread())
			task.run();
		else
			Platform.runLater(task);
	}

	public Utilities(double anchorWidth, double anchorHeight) {
		this.anchorWidth = anchorWidth;
		this.anchorHeight = anchorHeight;
	}

	private final double anchorWidth, anchorHeight;

	public static void scaleToWindow(Node node, double anchorWidth, double anchorHeight) {
		scaleHeight(node, anchorHeight);
		scaleWidth(node, anchorWidth);
	}

	public static void scaleWidth(Node node, double anchorWidth) {
		node.setScaleX(node.getScene().getWindow().getWidth() / anchorWidth);
	}

	public static void scaleHeight(Node node, double anchorHeight) {
		node.setScaleY(node.getScene().getWindow().getHeight() / anchorHeight);
	}

	public void scaleWidth(Node node) {
		scaleWidth(node, anchorWidth);
	}

	public void scaleHeight(Node node) {
		scaleHeight(node, anchorHeight);
	}

	public void scaleToWindow(Node node) {
		scaleToWindow(node, anchorWidth, anchorHeight);
	}

}
