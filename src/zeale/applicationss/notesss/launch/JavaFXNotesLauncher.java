package zeale.applicationss.notesss.launch;

import javafx.application.Application;
import javafx.stage.Stage;
import zeale.applicationss.notesss.graphics.uis.pages.AdvancedHomePage;

public class JavaFXNotesLauncher extends Application {

	public static void launchNotesss(String... args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new AdvancedHomePage().display(primaryStage);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launchNotesss(args);
	}

}
