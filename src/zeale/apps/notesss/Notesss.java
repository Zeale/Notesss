package zeale.apps.notesss;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Notesss extends Application {

	private final TextArea area = new TextArea();
	private final Scene scene = new Scene(area);
	{
		area.setPromptText("Type something here...");
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
