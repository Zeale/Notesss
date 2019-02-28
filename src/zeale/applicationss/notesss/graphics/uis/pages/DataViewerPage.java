package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;

public class DataViewerPage implements Page {
	
	private final TilePane layout = new TilePane();
	private final AnchorPane center = new AnchorPane(layout);
	private final BorderPane root = new BorderPane(center);

	@Override
	public Stage display(Stage stage, ApplicationProperties properties) {
		stage.setScene(new Scene(root));
		return stage;
	}

}
