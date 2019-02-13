package zeale.applicationss.notesss.graphics.uis.pages;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.Notesss;
import zeale.applicationss.notesss.utilities.Utilities;
import zeale.applicationss.notesss.utilities.colors.ColorList;

public class AdvancedHomePage implements Page {

	private final static Object LAYOUT_ITEM_PANE_KEY = new Object();

	private final static StackPane getItemPaneForLayout(Pos position, Node... children) {
		StackPane pane = new StackPane(children);
		for (Node n : children)
			n.getProperties().put(LAYOUT_ITEM_PANE_KEY, pane);
		pane.setAlignment(position);
		return pane;
	}

	private final static StackPane getLayoutItemPane(Node node) {
		return (StackPane) node.getProperties().get(LAYOUT_ITEM_PANE_KEY);
	}

	private final Pane viewDummy = new Pane(), tabsDummy = new Pane(), historyDummy = new Pane(),
			settingsDummy = new Pane();

	private final Text title = new Text("Notesss");
	private final TextField searchBar = new TextField();

	private final VBox titleBox = new VBox(20, title, searchBar);
	private final VBox leftItemWrapping = new VBox(50, getItemPaneForLayout(Pos.BOTTOM_RIGHT, viewDummy),
			getItemPaneForLayout(Pos.TOP_RIGHT, tabsDummy)),
			rightItemWrapping = new VBox(50, getItemPaneForLayout(Pos.BOTTOM_LEFT, historyDummy),
					getItemPaneForLayout(Pos.TOP_LEFT, settingsDummy));
	private final HBox itemsWrapping = new HBox(50, leftItemWrapping, rightItemWrapping);

	private final VBox root = new VBox(75, titleBox, itemsWrapping);
	private final ScrollPane scrollWrapper = new ScrollPane(root);
	private final Scene scene = new Scene(scrollWrapper);

	{
		// DUMMY Dummy nodes.
		viewDummy.setPrefSize(350, 350);// TL
		tabsDummy.setPrefSize(400, 400);// BL
		historyDummy.setPrefSize(400, 400);// TR
		settingsDummy.setPrefSize(350, 350);// BR
		viewDummy.setMaxSize(350, 350);// TL
		tabsDummy.setMaxSize(400, 400);// BL
		historyDummy.setMaxSize(400, 400);// TR
		settingsDummy.setMaxSize(350, 350);// BR
		viewDummy.setMinSize(250, 250);
		tabsDummy.setMinSize(250, 250);
		historyDummy.setMinSize(250, 250);
		settingsDummy.setMinSize(250, 250);

		ColorList<?> colorGenerator = Notesss.getColorGenerator();
		Background firstForeground = Utilities.getBackgroundFromColor(colorGenerator.getf(0)),
				secondForeground = Utilities.getBackgroundFromColor(colorGenerator.getf(1));
		viewDummy.setBackground(firstForeground);
		tabsDummy.setBackground(secondForeground);
		historyDummy.setBackground(secondForeground);
		settingsDummy.setBackground(firstForeground);

//		VBox.setMargin(getLayoutItemPane(viewDummy), new Insets(0, 0, 0, 50));
//		VBox.setMargin(getLayoutItemPane(settingsDummy), new Insets(0, 50, 0, 0));

		// Shift left column down a little.
//		HBox.setMargin(leftItemWrapping, new Insets(20, 0, 0, 0));

		root.setBackground(Utilities.getBackgroundFromColor(colorGenerator.getb(0)));
		Utilities.setAllAnchors(0d, root);
		titleBox.setFillWidth(false);
		titleBox.setAlignment(Pos.CENTER);
		root.setFillWidth(false);
		root.setAlignment(Pos.CENTER);

		scrollWrapper.setFitToHeight(true);
		scrollWrapper.setFitToWidth(true);
		root.setPadding(new Insets(80));

		/////////////////////////////////////////////////////////////////////////////////////

		searchBar.setPrefWidth(600);
		searchBar.setBackground(Utilities.getBackgroundFromColor(colorGenerator.getf(2)));

	}

	@Override
	public Stage display(Stage stage, ApplicationProperties properties) {
		stage.setScene(scene);
		return stage;
	}

}
