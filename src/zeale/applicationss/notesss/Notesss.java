package zeale.applicationss.notesss;

import static zeale.applicationss.notesss.utilities.colors.ColorList.DARK_CERULEAN;
import static zeale.applicationss.notesss.utilities.colors.ColorList.JET;
import static zeale.applicationss.notesss.utilities.colors.ColorList.MYRTLE_GREEN;
import static zeale.applicationss.notesss.utilities.colors.ColorList.SMOKY_BLACK;
import static zeale.applicationss.notesss.utilities.colors.ColorList.TANGERINE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map.Entry;

import javafx.scene.paint.Paint;
import zeale.applicationss.notesss.launch.JavaFXNotesLauncher;
import zeale.applicationss.notesss.utilities.Utilities;
import zeale.applicationss.notesss.utilities.generators.Generator;
import zeale.apps.tools.console.std.StandardConsole;

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
// TODO Make app download/set up its own dependencies bc it makes me feel better about myself.
public class Notesss {

	private static final String DEFAULT_FILESTORAGE_PATH = System.getProperty("user.home", "C:/Program Files")
			+ "/Notesss/File Storage";

	public static StandardConsole CONSOLE = new StandardConsole();

	public static ApplicationProperties properties() {
		return ApplicationProperties.getDefault();
	}

	private static final double DEFAULT_BASE_WINDOW_WIDTH = 1920, DEFAULT_BASE_WINDOW_HEIGHT = 1080;

	// PROV This sort of API (with a Utilities object) may not be very pleasing in
	// practice, so it's been marked as provisional.
	public static final Utilities utilities = new Utilities(DEFAULT_BASE_WINDOW_WIDTH, DEFAULT_BASE_WINDOW_HEIGHT);

	public static Utilities getUtilities() {
		return utilities;
	}

	public static void main(String[] args) {
		JavaFXNotesLauncher.launchNotesss(args);
	}

	private static Generator<Paint> colorGenerator = Generator.arrayLoop(SMOKY_BLACK, DARK_CERULEAN, TANGERINE, JET,
			MYRTLE_GREEN);

	public static void setColorGenerator(Generator<Paint> colorGenerator) {
		if (colorGenerator == null)
			throw new IllegalArgumentException();
		Notesss.colorGenerator = colorGenerator;
	}

	public static final Paint getNextColor() {
		return colorGenerator.next();
	}

	public static OutputStream streamOut(String path) throws FileNotFoundException {
		return new FileOutputStream(new File(DEFAULT_FILESTORAGE_PATH, path));
	}

	public static InputStream streamIn(String path) throws FileNotFoundException {
		return new FileInputStream(new File(DEFAULT_FILESTORAGE_PATH, path));
	}

}
