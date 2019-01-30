package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.Notesss;
import zeale.applicationss.notesss.utilities.Utilities;
import zeale.apps.tools.console.std.StandardConsole.EmbeddedStandardConsoleView;

public class AdvancedHomePage implements Page {

	private final EmbeddedStandardConsoleView view = Notesss.CONSOLE.getEmbeddedView();

	private final Text title = new Text("Notesss");
	private final TextField searchBar = new TextField();

	private final VBox titleBox = new VBox(20, title, searchBar);
	private final TilePane flow = new TilePane(view);
	private final VBox root = new VBox(75, titleBox, flow);
	private final ScrollPane scrollWrapper = new ScrollPane(root);
	private final Scene scene = new Scene(scrollWrapper);

	{
		root.setBackground(Utilities.getBackgroundFromColor(Notesss.getNextColor()));
		view.setBackground(Utilities.getBackgroundFromColor(Notesss.getNextColor()));
		Utilities.setAllAnchors(25d, view);
	}

	@Override
	public Stage display(Stage stage, ApplicationProperties properties) {
		stage.setScene(scene);
		return stage;
	}

}
