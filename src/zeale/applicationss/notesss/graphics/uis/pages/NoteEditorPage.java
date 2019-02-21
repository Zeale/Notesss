package zeale.applicationss.notesss.graphics.uis.pages;

import static zeale.applicationss.notesss.utilities.Utilities.getBackgroundFromColor;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.utilities.Utilities;

public class NoteEditorPage implements Page {

	private final Menu fileMenu = new Menu("File");
	private final MenuBar menubar = new MenuBar(fileMenu);
	private final TextArea input = new TextArea();
	private final AnchorPane center = new AnchorPane(input);
	private final BorderPane root = new BorderPane(center);
	{
		Utilities.setAllAnchors(80d, input);
		root.setTop(menubar);
		center.setFocusTraversable(true);
		center.setOnMouseClicked(event -> center.requestFocus());

		DropShadow shadow = new DropShadow();
		input.setEffect(shadow);
		menubar.setEffect(shadow);
	}
	private final Scene scene = new Scene(root);

	@Override
	public Stage display(Stage stage, ApplicationProperties properties) {
		stage.setScene(scene);
		menubar.setBackground(getBackgroundFromColor(properties.getColorGenerator().getf(1)));
		Node physicalInput = input.lookup(".content");
		if (physicalInput instanceof Region)
			((Region) physicalInput).setBackground(getBackgroundFromColor(properties.getColorGenerator().getf(2)));
		root.setBackground(getBackgroundFromColor(properties.getColorGenerator().getb(0)));
		input.setBackground(getBackgroundFromColor(properties.getColorGenerator().getf(2)));
//		input.setBorder(Utilities.getBorderFromColor(properties.getColorGenerator().getf(0), 5));

		return stage;
	}

}
