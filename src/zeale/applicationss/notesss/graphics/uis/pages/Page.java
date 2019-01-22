package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.Notesss;

public interface Page {

	default Stage display() {
		return display(new Stage());
	}

	/**
	 * Displays this {@link Page} on the given {@link Stage} and returns the
	 * {@link Stage} when finished.
	 * 
	 * @return The {@link Stage} that this {@link Page} was displayed on.
	 */
	default Stage display(Stage stage) {
		return display(stage, Notesss.properties());
	}

	default Stage display(ApplicationProperties properties) {
		return display(new Stage(), Notesss.properties());
	}

	Stage display(Stage stage, ApplicationProperties properties);

	enum StageState {
		FULLSCREEN, WINDOWED
	}

	default void onStateChanged(StageState state) {
	}
}
