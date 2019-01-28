package zeale.applicationss.notesss.graphics.uis.pages;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.Notesss;

// Fullscreen will have a side menu, window mode will have a regular menu bar.
public class HomePage implements Page {

	private final Text title = new Text("Notesss");
	private final TextArea input = new TextArea();

	private final AnchorPane root = new AnchorPane();
	{
		VBox wrapper = new VBox(30d, title, input);
		wrapper.setAlignment(Pos.CENTER);

		root.getChildren().add(wrapper);

		title.setFont(Font.font(72));
		title.setFill(Color.LIGHTGRAY);

		input.setPrefSize(800, 600);

		AnchorPane.setLeftAnchor(wrapper, 50d);
		AnchorPane.setRightAnchor(wrapper, 50d);
		AnchorPane.setTopAnchor(wrapper, 25d);
		AnchorPane.setBottomAnchor(wrapper, 25d);
	}
	private final ScrollPane rootScroll = new ScrollPane(root);
	{
		rootScroll.setFitToHeight(false);
		rootScroll.setFitToWidth(true);
		rootScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
	}

	private final MenuItem save = new MenuItem("Save"), load = new MenuItem("Load");
	private final Menu fileMenu = new Menu("File", null, save, load);
	private final MenuItem copy = new MenuItem("Copy"), cut = new MenuItem("Cut"), paste = new MenuItem("Paste"),
			selectAll = new MenuItem("Select All"), delete = new MenuItem("Delete"), clear = new MenuItem("Clear");
	{
		copy.setOnAction(event -> {
			String text = input.getSelectedText();
			if (text == null || text.isEmpty())
				return;

			Clipboard clipboard = Clipboard.getSystemClipboard();
			ClipboardContent content = new ClipboardContent();
			content.putString(text);
			clipboard.setContent(content);

		});
		cut.setOnAction(event -> {
			String text = input.getSelectedText();
			if (text == null || text.isEmpty())
				return;

			Clipboard clipboard = Clipboard.getSystemClipboard();
			ClipboardContent content = new ClipboardContent();
			content.putString(text);
			clipboard.setContent(content);

			input.replaceSelection("");
		});
	}
	private final Menu editMenu = new Menu("Edit", null, copy, cut, paste, selectAll, delete, clear);
	private final MenuBar menubar = new MenuBar(fileMenu, editMenu);
	private final BorderPane wrapper = new BorderPane(rootScroll);
	private Stage stage;
	{
		save.setOnAction(event -> {
			File out = new FileChooser().showSaveDialog(stage);
			if (out == null)
				return;
			try (PrintWriter writer = new PrintWriter(new FileOutputStream(out))) {
				writer.print(input.getText());
			} catch (FileNotFoundException e) {
				PrintWriter errOut = Notesss.CONSOLE.getWriter();
				e.printStackTrace(errOut);
				errOut.close();
			}
		});

		load.setOnAction(event -> {
			File in = new FileChooser().showOpenDialog(stage);
			if (in == null)
				return;
			StringBuilder builder = new StringBuilder();
			try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(in))) {
				int c;
				while ((c = reader.read()) != -1)
					builder.append((char) c);
			} catch (IOException e) {
				PrintWriter errOut = Notesss.CONSOLE.getWriter();
				e.printStackTrace(errOut);
				errOut.close();
			}

			input.setText(builder.toString());
		});
		wrapper.setTop(menubar);
	}
	private final Scene scene = new Scene(wrapper);

	@Override
	public Stage display(Stage stage, ApplicationProperties properties) {
		this.stage = stage;
		stage.setScene(scene);
		return stage;
	}

}
