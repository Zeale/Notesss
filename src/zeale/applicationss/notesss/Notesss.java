package zeale.applicationss.notesss;

import java.io.File;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import zeale.applicationss.notesss.launch.JavaFXNotesLauncher;
import zeale.applicationss.notesss.utilities.Utilities;
import zeale.applicationss.notesss.utilities.generators.Generator;

/**
 * <p>
 * API features may later be moved to their own class. (Maybe named something
 * like <code>NotesssAPI</code>.) Currently, there is the {@link Utilities}
 * class for general utility related code. This class will expose application
 * specific API functions and functionality, until a separate API class exists,
 * if ever.
 * </p>
 * <p>
 * Functionality that directly affects, or is a result of this application, that
 * is also meant to be publicly accessible, will be accessible through here.
 * Functions and code that are not application-specific, will be stored in
 * {@link Utilities}, or a sibling/sibling-child class/package.
 * </p>
 * 
 * @author Zeale
 *
 */
public class Notesss {

	public static void main(String[] args) {
		JavaFXNotesLauncher.launchNotesss(args);
	}
	
	private static Generator<Paint> colorGenerator = Generator.arrayLoop(Color.RED, Color.GREEN, Color.BLUE, Color.GOLD);
	
	public static void setColorGenerator(Generator<Paint> colorGenerator) {
		if(colorGenerator==null)
			throw new IllegalArgumentException();
		Notesss.colorGenerator = colorGenerator;
	}
	
	public static final Paint getNextColor() {
		return colorGenerator.next();
	}

}
