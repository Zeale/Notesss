package zeale.applicationss.notesss.api;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import zeale.application.notesss._resources.ResourceObtainer;

public interface Note {
	default Image icon() {
		return new Image(ResourceObtainer.resource("graphics/ui/pages/home/Notepad-v1-2.png"));
	}

	String title();

	/*
	 * Convenience methods provided (for now)
	 */

	static Note note(File file) throws FileNotFoundException {
		if (!file.exists())
			throw new FileNotFoundException("Couldn't find (then generate a note off of) the specified file.");
		String name = file.getName();
		return () -> name;
	}

	static Note note(String text) {
		return () -> text.length() > 10 ? text.substring(0, 7) + "..." : text;
	}
}
