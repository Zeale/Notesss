package zeale.applicationss.notesss.graphics.uis.pages;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zeale.application.notesss._resources.ResourceObtainer;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.Notesss;
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

	{
		data.addListener(new ListChangeListener<File>() {

			@Override
			public void onChanged(Change<? extends File> c) {
				synchronized (data) {
					while (c.next()) {
						if (c.wasAdded()) {
							List<? extends File> change = c.getAddedSubList();
							int i = 0;
							for (File f : change)
								layout.getChildren().add(c.getFrom() + i++,
										f.exists() ? makeNewItem(f.getName(), DEFAULT_NOTE_ICON)
												: makeNewItem(null, DEFAULT_LOAD_FAILED_ICON));
						} else if (c.wasRemoved()) {

						} else if (c.wasPermutated()) {

						} else if (c.wasReplaced()) {

						} else if (c.wasUpdated()) {

						}
					}
				}

			}
		});

		File[] children = Notesss.getRootDirectory().getFile().listFiles();
		if (children == null) {
			// TODO Write some code to display the error (and a refresh button).
		} else
			for (File f : children) {
				data.add(f);
			}
	}

	private final Map<File, StackPane> icons = new HashMap<>();

	private final static Image DEFAULT_NOTE_ICON = new Image(
			ResourceObtainer.resource("graphics/ui/pages/home/Notepad-v1-2.png")),
			// TODO Get a "load failed" icon
			DEFAULT_LOAD_FAILED_ICON = DEFAULT_NOTE_ICON;

	private StackPane makeNewItem(String text, Image icon) {
		StackPane pane = new StackPane();
		Text title = new Text(text == null ? "Unknown..." : text);
		title.setFill(text == null ? Color.FIREBRICK : Color.GREEN);
		StackPane.setAlignment(title, Pos.BOTTOM_CENTER);
		pane.getChildren().addAll(new ImageView(icon), title);

		return pane;
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

		stage.setHeight(800);
		stage.setWidth(1200);
		return stage;
	}

}
