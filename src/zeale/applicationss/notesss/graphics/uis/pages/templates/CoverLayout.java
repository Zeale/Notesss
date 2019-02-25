package zeale.applicationss.notesss.graphics.uis.pages.templates;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.graphics.uis.pages.Page;
import zeale.applicationss.notesss.utilities.Utilities;
import zeale.applicationss.notesss.utilities.colors.ColorList;

public class CoverLayout implements Page {

	private final static Object LAYOUT_ITEM_PANE_KEY = new Object();

	private final static StackPane getItemPaneForLayout(Pos position, Node... children) {
		StackPane pane = new StackPane(children);
		for (Node n : children)
			n.getProperties().put(LAYOUT_ITEM_PANE_KEY, pane);
		pane.setAlignment(position);
		return pane;
	}

	protected final VBox topLeftSquare = new VBox();
	protected final Pane bottomLeftSquare = new Pane(), topRightSquare = new Pane(), bottomRightSquare = new Pane();

	protected final Text title = new Text("Notesss");
	protected final TextField searchBar = new TextField();

	protected final VBox titleBox = new VBox(20, title, searchBar);
	private final VBox leftItemWrapping = new VBox(50, getItemPaneForLayout(Pos.BOTTOM_RIGHT, topLeftSquare),
			getItemPaneForLayout(Pos.TOP_RIGHT, bottomLeftSquare)),
			rightItemWrapping = new VBox(50, getItemPaneForLayout(Pos.BOTTOM_LEFT, topRightSquare),
					getItemPaneForLayout(Pos.TOP_LEFT, bottomRightSquare));
	private final HBox itemsWrapping = new HBox(50, leftItemWrapping, rightItemWrapping);

	private final VBox root = new VBox(75, titleBox, itemsWrapping);
	private final ScrollPane scrollWrapper = new ScrollPane(root);
	private final Scene scene = new Scene(scrollWrapper);

	{

		final double bigBoxSize = 300, lilBoxSize = 250, boxMinSize = 200;

		final double bigBoxPrefWidth = bigBoxSize, bigBoxPrefHeight = bigBoxSize, lilBoxPrefWidth = lilBoxSize,
				lilBoxPrefHeight = lilBoxSize;
		final double boxMinWidth = boxMinSize, boxMinHeight = boxMinSize;

		// DUMMY Dummy nodes.
		topLeftSquare.setPrefSize(lilBoxPrefWidth, lilBoxPrefHeight);// TL
		bottomLeftSquare.setPrefSize(bigBoxPrefWidth, bigBoxPrefHeight);// BL
		topRightSquare.setPrefSize(bigBoxPrefWidth, bigBoxPrefHeight);// TR
		bottomRightSquare.setPrefSize(lilBoxPrefWidth, lilBoxPrefHeight);// BR
		topLeftSquare.setMaxSize(lilBoxPrefWidth, lilBoxPrefHeight);// TL
		bottomLeftSquare.setMaxSize(bigBoxPrefWidth, bigBoxPrefHeight);// BL
		topRightSquare.setMaxSize(bigBoxPrefWidth, bigBoxPrefHeight);// TR
		bottomRightSquare.setMaxSize(lilBoxPrefWidth, lilBoxPrefHeight);// BR
		topLeftSquare.setMinSize(boxMinWidth, boxMinHeight);
		bottomLeftSquare.setMinSize(boxMinWidth, boxMinHeight);
		topRightSquare.setMinSize(boxMinWidth, boxMinHeight);
		bottomRightSquare.setMinSize(boxMinWidth, boxMinHeight);

		topLeftSquare.setAlignment(Pos.CENTER);

//		VBox.setMargin(getLayoutItemPane(viewDummy), new Insets(0, 0, 0, 50));
//		VBox.setMargin(getLayoutItemPane(settingsDummy), new Insets(0, 50, 0, 0));

		// Shift left column down a little.
//		HBox.setMargin(leftItemWrapping, new Insets(20, 0, 0, 0));

		Utilities.setAllAnchors(0d, root);
		titleBox.setFillWidth(false);
		titleBox.setAlignment(Pos.CENTER);
		root.setFillWidth(false);
		root.setAlignment(Pos.CENTER);

		scrollWrapper.setFitToHeight(true);
		scrollWrapper.setFitToWidth(true);
		root.setPadding(new Insets(40, 80, 100, 80));

		/////////////////////////////////////////////////////////////////////////////////////

		searchBar.setPrefWidth(600);

		title.setFont(Font.font(60));
		title.setStrokeWidth(1.4);

	}

	@Override
	public synchronized Stage display(Stage stage, ApplicationProperties properties) {
		stage.setScene(scene);

		//////////////////////////////////////
		// Styling using ApplicationProperties
		ColorList<?> colorGenerator = properties.getColorGenerator();
		Background firstForeground = Utilities.getBackgroundFromColor(colorGenerator.getf(0)),
				secondForeground = Utilities.getBackgroundFromColor(colorGenerator.getf(1));

		topLeftSquare.setBackground(firstForeground);
		bottomLeftSquare.setBackground(secondForeground);
		topRightSquare.setBackground(secondForeground);
		bottomRightSquare.setBackground(firstForeground);

		root.setBackground(Utilities.getBackgroundFromColor(colorGenerator.getb(0)));
		scrollWrapper.setBackground(Utilities.getBackgroundFromColor(colorGenerator.getb(0)));

		searchBar.setBackground(Utilities.getBackgroundFromColor(colorGenerator.getf(2)));

		title.setFill(colorGenerator.getf(2));
		title.setStroke(colorGenerator.getf(2));
		// Styling using ApplicationProperties
		//////////////////////////////////////
		return stage;
	}

}
