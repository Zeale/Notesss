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
	private final VBox leftItemWrapping = new VBox(30, getItemPaneForLayout(Pos.TOP_LEFT, viewDummy),
			getItemPaneForLayout(Pos.BOTTOM_LEFT, tabsDummy)),
			rightItemWrapping = new VBox(25, getItemPaneForLayout(Pos.TOP_RIGHT, historyDummy),
					getItemPaneForLayout(Pos.BOTTOM_RIGHT, settingsDummy));
	private final HBox itemsWrapping = new HBox(250, leftItemWrapping, rightItemWrapping);

	private final VBox root = new VBox(75, titleBox, itemsWrapping);
	private final ScrollPane scrollWrapper = new ScrollPane(root);
	private final Scene scene = new Scene(scrollWrapper);

	{
		// DUMMY Dummy nodes.
		viewDummy.setPrefSize(400, 450);
		tabsDummy.setPrefSize(400, 300);
		historyDummy.setPrefSize(300, 300);
		settingsDummy.setPrefSize(300, 450);
		viewDummy.setMinSize(400, 450);
		tabsDummy.setMinSize(400, 300);
		historyDummy.setMinSize(300, 300);
		settingsDummy.setMinSize(300, 450);

		ColorList<?> colorGenerator = Notesss.getColorGenerator();
		Background firstForeground = Utilities.getBackgroundFromColor(colorGenerator.getf(0)),
				secondForeground = Utilities.getBackgroundFromColor(colorGenerator.getf(1));
		viewDummy.setBackground(firstForeground);
		tabsDummy.setBackground(secondForeground);
		historyDummy.setBackground(secondForeground);
		settingsDummy.setBackground(firstForeground);

		VBox.setMargin(getLayoutItemPane(viewDummy), new Insets(0, 0, 0, 10));
		VBox.setMargin(getLayoutItemPane(settingsDummy), new Insets(0, 15, 0, 0));

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
		root.setPadding(new Insets(50));

		/////////////////////////////////////////////////////////////////////////////////////

		searchBar.setPrefWidth(600);

	}

	@Override
	public Stage display(Stage stage, ApplicationProperties properties) {
		stage.setScene(scene);
		return stage;
	}

}
