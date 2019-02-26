package zeale.applicationss.notesss.graphics.uis.pages;

import static zeale.applicationss.notesss.utilities.Utilities.getBackgroundFromColor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.Notesss;
import zeale.applicationss.notesss.utilities.Utilities;
import zeale.apps.tools.api.data.files.filesystem.storage.FileStorage;

public class NoteEditorPage implements Page {

	private final MenuItem exportToPlaintext = new MenuItem("Plaintext (Plain Text File)");
	private Window stage;

	private final FileChooser fileChooser = new FileChooser();

	private final Menu exportMenu = new Menu("Export to...", null, exportToPlaintext);
	private final Menu fileMenu = new Menu("File", null, exportMenu);
	private final MenuBar menubar = new MenuBar(fileMenu);
	private final TextArea input = new TextArea();
	private final AnchorPane center = new AnchorPane(input);
	private final BorderPane root = new BorderPane(center);

	{
		FileStorage initialDir = Notesss.DATA_DIRECTORY.createChild("Raw Notesss");
		if (initialDir.isAvailable())
			fileChooser.setInitialDirectory(initialDir.getFile());
		
		Utilities.setAllAnchors(80d, input);
		root.setTop(menubar);
		center.setFocusTraversable(true);
		center.setOnMouseClicked(event -> center.requestFocus());

		DropShadow shadow = new DropShadow();
		input.setEffect(shadow);
		menubar.setEffect(shadow);
	}

	{
		exportToPlaintext.setOnAction(event -> {
			File file = fileChooser.showSaveDialog(stage);
			if (file != null) {
				try (PrintWriter out = new PrintWriter(file)) {
					out.print(input.getText());
				} catch (FileNotFoundException e) {
					Notesss.error(e, "Failed to save the document to the specified file. (" + e.getMessage() + ")");
				}
			}
		});
	}

	private final Scene scene = new Scene(root);

	@Override
	public Stage display(Stage stage, ApplicationProperties properties) {
		stage.setScene(scene);
		menubar.setBackground(getBackgroundFromColor(properties.getColorGenerator().getf(1)));
		try {
			Node physicalInput = input.lookup(".content");
			if (physicalInput instanceof Region)
				((Region) physicalInput).setBackground(getBackgroundFromColor(properties.getColorGenerator().getf(2)));
		} catch (Exception e) {
			Notesss.error(
					"Failed to apply some styling. Looking up TextArea's .content node returned a valid Region, but failed to execute. (PL-DP~10");
		}
		root.setBackground(getBackgroundFromColor(properties.getColorGenerator().getb(0)));
		input.setBackground(getBackgroundFromColor(properties.getColorGenerator().getf(2)));
//		input.setBorder(Utilities.getBorderFromColor(properties.getColorGenerator().getf(0), 5));

		this.stage = stage;
		return stage;
	}

}
