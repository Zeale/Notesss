package zeale.applicationss.notesss.launch;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import zeale.applicationss.notesss.graphics.uis.pages.DataViewerPage;

public class JavaFXNotesLauncher extends Application {

	public static void launchNotesss(String... args) {
		Application.launch(args);
	}

	public static void main(String[] args) {
		launchNotesss(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new DataViewerPage().display(primaryStage);
		primaryStage.show();
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			if (KeyCode.F11 == event.getCode())
				primaryStage.setFullScreen(!primaryStage.isFullScreen());
		});
	}

}
