package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Fullscreen will have a side menu, window mode will have a regular menu bar.
public class HomePage extends Page {

	private final Text title = new Text("Notesss");

	private final AnchorPane root = new AnchorPane();
	{
		StackPane wrapper = new StackPane(title);
		root.getChildren().add(wrapper);
		title.setFont(Font.font(72));
		title.setFill(Color.LIGHTGRAY);
		AnchorPane.setLeftAnchor(wrapper, 0d);
		AnchorPane.setRightAnchor(wrapper, 0d);
		AnchorPane.setTopAnchor(wrapper, 25d);
	}
	private final BorderPane wrapper = new BorderPane(root);
	private final Scene scene = new Scene(wrapper);

	@Override
	public Stage display(Stage stage) {
		stage.setScene(scene);
		return stage;
	}

}
