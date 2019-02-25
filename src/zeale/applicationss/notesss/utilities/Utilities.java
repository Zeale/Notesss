package zeale.applicationss.notesss.utilities;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Paint;

public final class Utilities {

	public @SafeVarargs static <E> E[] array(E... elements) {
		return elements;
	}

	public @SafeVarargs static <E> E[] array(int size, E... elements) {
		return Arrays.copyOf(elements, size);
	}

	public static List<Node> deepGetChildren(List<Node> list, Node parent) {
		if (parent instanceof Parent)
			for (Node n : ((Parent) parent).getChildrenUnmodifiable()) {
				list.add(n);
				deepGetChildren(list, n);
			}
		return list;
	}

	public static List<Node> deepGetChildren(Node parent) {
		return deepGetChildren(new LinkedList<>(), parent);
	}

	public static final void executeOnFXThread(Runnable task) {
		if (Platform.isFxApplicationThread())
			task.run();
		else
			Platform.runLater(task);
	}

	public static Background getBackgroundFromColor(Paint color) {
		return new Background(new BackgroundFill(color, null, null));
	}

	public static Border getBorderFromColor(Paint color, double width) {
		return new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, null, new BorderWidths(width)));
	}

	public static void scaleHeight(Node node, double anchorHeight) {
		node.setScaleY(node.getScene().getWindow().getHeight() / anchorHeight);
	}

	public static void scaleToWindow(Node node, double anchorWidth, double anchorHeight) {
		scaleHeight(node, anchorHeight);
		scaleWidth(node, anchorWidth);
	}

	public static void scaleWidth(Node node, double anchorWidth) {
		node.setScaleX(node.getScene().getWindow().getWidth() / anchorWidth);
	}

	public static final void setAllAnchors(Double top, Double left, Double right, Double bottom, Node... nodes) {
		for (Node n : nodes) {
			AnchorPane.setTopAnchor(n, top);
			AnchorPane.setLeftAnchor(n, left);
			AnchorPane.setRightAnchor(n, right);
			AnchorPane.setBottomAnchor(n, bottom);
		}
	}

	public static final void setAllAnchors(Double anchor, Node... nodes) {
		setAllAnchors(anchor, anchor, anchor, anchor, nodes);
	}

	public static <E> E[] toArray(Collection<E> collection) {
		E[] array = array(collection.size());
		int pos = 0;
		for (E e : collection)
			array[pos++] = e;
		return array;
	}

	private final double anchorWidth, anchorHeight;

	public Utilities(double anchorWidth, double anchorHeight) {
		this.anchorWidth = anchorWidth;
		this.anchorHeight = anchorHeight;
	}

	public void scaleHeight(Node node) {
		scaleHeight(node, anchorHeight);
	}

	public void scaleToWindow(Node node) {
		scaleToWindow(node, anchorWidth, anchorHeight);
	}

	public void scaleWidth(Node node) {
		scaleWidth(node, anchorWidth);
	}

}
