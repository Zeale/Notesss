package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// Fullscreen will have a side menu, window mode will have a regular menu bar.
public class HomePage implements Page {

	private final AnchorPane root = new AnchorPane();
	private final BorderPane wrapper = new BorderPane(root);
	private final Scene scene = new Scene(wrapper);

	@Override
	public Stage display(Stage stage) {
		stage.setScene(scene);
		return stage;
	}
}