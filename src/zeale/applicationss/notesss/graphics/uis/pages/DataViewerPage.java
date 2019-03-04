package zeale.applicationss.notesss.graphics.uis.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zeale.application.notesss._resources.ResourceObtainer;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.api.Note;
import zeale.applicationss.notesss.utilities.Utilities;

public class DataViewerPage implements Page {

	private final TilePane layout = new TilePane();
	private final TextField search = new TextField();
	private final VBox topVBox = new VBox(search);
	private final StackPane topLayout = new StackPane(topVBox);
	private final AnchorPane center = new AnchorPane(layout), top = new AnchorPane(topLayout);
	private final BorderPane root = new BorderPane(center);

	private final ObservableList<File> data = FXCollections
			.synchronizedObservableList(FXCollections.observableList(new LinkedList<>()));
	private final Map<File, StackPane> icons = new HashMap<>();
	{
		data.addListener(new ListChangeListener<File>() {

			@Override
			public void onChanged(Change<? extends File> c) {
				synchronized (data) {
					while (c.next()) {
						if (c.wasAdded()) {
							List<? extends File> change = c.getAddedSubList();
							for (int i = 0; i < change.size(); i++) {

								Note note;
								Node layout;
								try {
									note = Note.note(change.get(i));
									ImageView icon = new ImageView(note.icon());
									Text title = new Text(note.title());

									StackPane.setAlignment(title, Pos.BOTTOM_CENTER);
									layout = new StackPane(icon, title);
								} catch (FileNotFoundException e) {
									e.printStackTrace();
									layout = new ImageView(
											new Image(ResourceObtainer.resource("graphics/icons/error1.png")));
								}

								DataViewerPage.this.layout.getChildren().add(c.getFrom() + i, layout);
							}
						} else if (c.wasRemoved()) {

						} else if (c.wasPermutated()) {

						} else if (c.wasReplaced()) {

						} else if (c.wasUpdated()) {

						}
					}
				}

			}
		});
	}

	{
		root.setTop(top);
		Utilities.setAllAnchors(0d, topLayout);
	}

	@Override
	public Stage display(Stage stage, ApplicationProperties properties) {
		boolean fullscreen = stage.isFullScreen();
		stage.setScene(new Scene(root));
		if (fullscreen)
			stage.setFullScreen(true);

		stage.setHeight(600);
		stage.setWidth(800);
		return stage;
	}

}
