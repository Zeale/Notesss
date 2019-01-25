package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.scene.Scene;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.Notesss;

/**
 * <p>
 * A {@link Page} is a graphical user interface element of the program. Most of
 * the individual scenes in the program are split into separate {@link Page}s.
 * </p>
 * <p>
 * A Page is an individual scene of the application, that can be displayed on
 * {@link Stage}s at will. By default, a {@link Page} can only be displayed on a
 * single {@link Stage}, and can do so by setting the {@link Scene} of the
 * {@link Stage}. It should read any properties of the {@link Stage} that it
 * needs to for layout or any other displaying purposes, but not modify the
 * {@link Stage} itself. Ideally, a {@link Page} will adjust its scenery to
 * maximize viewer pleasure based on the properties of the {@link Stage} it is
 * being displayed on, and any {@link ApplicationProperties} it is given (with
 * any given {@link ApplicationProperties} taking priority).
 * </p>
 * 
 * @author Zeale
 *
 */
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
