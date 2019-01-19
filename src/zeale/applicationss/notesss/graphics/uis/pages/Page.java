package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.stage.Stage;

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
	Stage display(Stage stage);

	enum StageState {
		FULLSCREEN, WINDOWED
	}
	
	default void onStateChanged(StageState state) {		}
}
