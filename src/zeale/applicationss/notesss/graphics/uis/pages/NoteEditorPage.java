package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;

public class NoteEditorPage implements Page {

	private final Menu fileMenu = new Menu("File");
	private final MenuBar menubar = new MenuBar(fileMenu);
	private final BorderPane root = new BorderPane();
	{	root.setTop(menubar);	}
	private final Scene scene = new Scene(root);

	@Override
	public Stage display(Stage stage, ApplicationProperties properties) {
		stage.setScene(scene);
		return stage;
	}

}
