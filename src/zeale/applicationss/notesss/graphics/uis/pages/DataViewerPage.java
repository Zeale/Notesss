package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.utilities.Utilities;

public class DataViewerPage implements Page {

	private final TilePane layout = new TilePane();
	private final TextField search = new TextField();
	private final VBox topVBox = new VBox(search);
	private final StackPane topLayout = new StackPane(topVBox);
	private final AnchorPane center = new AnchorPane(layout), top = new AnchorPane(topLayout);
	private final BorderPane root = new BorderPane(center);
	{
		root.setTop(top);
		Utilities.setAllAnchors(0d, topLayout);
	}

	@Override
	public Stage display(Stage stage, ApplicationProperties properties) {
		boolean fullscreen = stage.isFullScreen();
		stage.setScene(new Scene(root));
		if (fullscreen)
			stage.setFullScreen(true);

		stage.setHeight(600);
		stage.setWidth(800);
		return stage;
	}

}
