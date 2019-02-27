package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;

public class NoteManagementPage implements Page {

	
	
	private final BorderPane leftMenu = new BorderPane();
	private final Accordion rightAccordion = new Accordion();
	private final StackPane center = new StackPane();

	private final BorderPane root = new BorderPane(center);
	{
		root.setRight(rightAccordion);
		root.setLeft(leftMenu);
	}

	@Override
	public Stage display(Stage stage, ApplicationProperties properties) {
		stage.setScene(new Scene(root));
		return stage;
	}

}
