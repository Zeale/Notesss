package zeale.apps.notesss;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Notesss extends Application {
	private final Menu save = new Menu("Save");
	private final MenuBar menubar = new MenuBar(save);

	private final TextArea area = new TextArea();
	{
		area.setPromptText("Type something here...");
	}
	private final BorderPane pane = new BorderPane(area);
	{
		pane.setTop(menubar);
	}
	private final Scene scene = new Scene(pane);

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
