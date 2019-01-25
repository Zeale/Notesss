package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;

// Fullscreen will have a side menu, window mode will have a regular menu bar.
public class HomePage implements Page {

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
	private final ScrollPane rootScroll = new ScrollPane(root);
	{
		rootScroll.setFitToHeight(false);
		rootScroll.setFitToWidth(true);
		rootScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
	}
	private final BorderPane wrapper = new BorderPane(rootScroll);
	private final Scene scene = new Scene(wrapper);

	@Override
	public Stage display(Stage stage, ApplicationProperties properties) {
		stage.setScene(scene);
		// TODO Auto-generated method stub
		return stage;
	}

}
