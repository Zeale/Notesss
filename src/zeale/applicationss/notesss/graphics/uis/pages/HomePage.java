package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;

// Fullscreen will have a side menu, window mode will have a regular menu bar.
public class HomePage implements Page {

	private final Text title = new Text("Notesss");
	private final TextArea input = new TextArea();

	private final AnchorPane root = new AnchorPane();
	{
		VBox wrapper = new VBox(30d, title, input);
		wrapper.setAlignment(Pos.CENTER);

		root.getChildren().add(wrapper);

		title.setFont(Font.font(72));
		title.setFill(Color.LIGHTGRAY);

		input.setPrefSize(800, 600);

		AnchorPane.setLeftAnchor(wrapper, 50d);
		AnchorPane.setRightAnchor(wrapper, 50d);
		AnchorPane.setTopAnchor(wrapper, 25d);
		AnchorPane.setBottomAnchor(wrapper, 25d);
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
