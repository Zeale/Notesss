package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.Notesss;
import zeale.apps.tools.console.std.StandardConsole.EmbeddedStandardConsoleView;

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
		EmbeddedStandardConsoleView console = Notesss.CONSOLE.getEmbeddedView();
//		console.setScaleX(0.8);
//		console.setScaleY(0.8);

		VBox leftColumn = new VBox(15, console), rightColumn = new VBox(15);
		root.getChildren().addAll(leftColumn, rightColumn);

		leftColumn.setFillWidth(false);
		rightColumn.setFillWidth(false);

		AnchorPane.setTopAnchor(leftColumn, 125d);
		AnchorPane.setLeftAnchor(leftColumn, 15d);
		AnchorPane.setBottomAnchor(leftColumn, 30d);

		AnchorPane.setTopAnchor(rightColumn, 125d);
		AnchorPane.setRightAnchor(rightColumn, 15d);
		AnchorPane.setBottomAnchor(rightColumn, 30d);
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
