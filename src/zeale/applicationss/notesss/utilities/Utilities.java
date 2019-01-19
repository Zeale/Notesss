package zeale.applicationss.notesss.utilities;

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

	public static final void executeOnFXThread(Runnable task) {
		if (Platform.isFxApplicationThread())
			task.run();
		else
			Platform.runLater(task);
	}

}
