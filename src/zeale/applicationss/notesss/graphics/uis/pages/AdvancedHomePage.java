package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.Notesss;
import zeale.applicationss.notesss.utilities.Utilities;
import zeale.apps.tools.console.std.StandardConsole.EmbeddedStandardConsoleView;

public class AdvancedHomePage implements Page {

	private final EmbeddedStandardConsoleView view = Notesss.CONSOLE.getEmbeddedView();

	private final AnchorPane root = new AnchorPane();
	private final ScrollPane scrollWrapper = new ScrollPane(root);
	private final Scene scene = new Scene(scrollWrapper);

	{
		root.getChildren().add(view);
		Utilities.setAllAnchors(25d, view);
		root.setPrefWidth(1200);
	}

	@Override
	public Stage display(Stage stage, ApplicationProperties properties) {
		stage.setScene(scene);
		return stage;
	}

}
