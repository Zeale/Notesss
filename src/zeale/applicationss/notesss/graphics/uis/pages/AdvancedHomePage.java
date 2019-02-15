package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.animation.Transition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.Notesss;
import zeale.applicationss.notesss.utilities.Utilities;
import zeale.applicationss.notesss.utilities.colors.ColorList;

public class AdvancedHomePage implements Page {

	private final DropShadow cardShadow = new DropShadow();

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

	private final ImageView notesssIcon = new ImageView(
			"/zeale/application/notesss/_resources/graphics/ui/pages/home/Notepad-v1-2.png");
	private final Text notesssButtonLabel = new Text("My Notesss");
	{
		notesssIcon.setFitHeight(66);
		notesssIcon.setFitWidth(50);
		notesssIcon.setEffect(cardShadow);
	}

	private final VBox notesssBox = new VBox(5, notesssIcon, notesssButtonLabel);
	private final Pane tabsDummy = new Pane(), historyDummy = new Pane(), settingsDummy = new Pane();

	private final Text title = new Text("Notesss");
	private final TextField searchBar = new TextField();

	private final VBox titleBox = new VBox(20, title, searchBar);
	private final VBox leftItemWrapping = new VBox(50, getItemPaneForLayout(Pos.BOTTOM_RIGHT, notesssBox),
			getItemPaneForLayout(Pos.TOP_RIGHT, tabsDummy)),
			rightItemWrapping = new VBox(50, getItemPaneForLayout(Pos.BOTTOM_LEFT, historyDummy),
					getItemPaneForLayout(Pos.TOP_LEFT, settingsDummy));
	private final HBox itemsWrapping = new HBox(50, leftItemWrapping, rightItemWrapping);

	private final VBox root = new VBox(75, titleBox, itemsWrapping);
	private final ScrollPane scrollWrapper = new ScrollPane(root);
	private final Scene scene = new Scene(scrollWrapper);

	private final BooleanProperty shadowed = new SimpleBooleanProperty(),
			shadowOnFocus = new SimpleBooleanProperty(false);
	{

		cardShadow.setOffsetX(5);
		cardShadow.setOffsetY(5);
		cardShadow.setWidth(10);
		cardShadow.setHeight(10);
		Transition cardShadowTransition = new Transition() {

			{
				setCycleDuration(Duration.millis(250));
			}

			@Override
			protected void interpolate(double frac) {
				cardShadow.setColor(new Color(0, 0, 0, frac));
			}
		};
		shadowed.addListener((observable, oldValue, newValue) -> {

			if (newValue) {
				cardShadowTransition.pause();
				cardShadowTransition.setRate(1);
				cardShadowTransition.play();
			} else {
				cardShadowTransition.pause();
				cardShadowTransition.setRate(-1);
				cardShadowTransition.play();
			}

		});

		// PROV Effects may wanna be removed when they're invisible.
		notesssBox.setEffect(cardShadow);
		tabsDummy.setEffect(cardShadow);
		historyDummy.setEffect(cardShadow);
		settingsDummy.setEffect(cardShadow);

		title.setEffect(cardShadow);
		searchBar.setEffect(cardShadow);

	}

	{

		final double bigBoxSize = 300, lilBoxSize = 250, boxMinSize = 200;

		final double bigBoxPrefWidth = bigBoxSize, bigBoxPrefHeight = bigBoxSize, lilBoxPrefWidth = lilBoxSize,
				lilBoxPrefHeight = lilBoxSize;
		final double boxMinWidth = boxMinSize, boxMinHeight = boxMinSize;

		// DUMMY Dummy nodes.
		notesssBox.setPrefSize(lilBoxPrefWidth, lilBoxPrefHeight);// TL
		tabsDummy.setPrefSize(bigBoxPrefWidth, bigBoxPrefHeight);// BL
		historyDummy.setPrefSize(bigBoxPrefWidth, bigBoxPrefHeight);// TR
		settingsDummy.setPrefSize(lilBoxPrefWidth, lilBoxPrefHeight);// BR
		notesssBox.setMaxSize(lilBoxPrefWidth, lilBoxPrefHeight);// TL
		tabsDummy.setMaxSize(bigBoxPrefWidth, bigBoxPrefHeight);// BL
		historyDummy.setMaxSize(bigBoxPrefWidth, bigBoxPrefHeight);// TR
		settingsDummy.setMaxSize(lilBoxPrefWidth, lilBoxPrefHeight);// BR
		notesssBox.setMinSize(boxMinWidth, boxMinHeight);
		tabsDummy.setMinSize(boxMinWidth, boxMinHeight);
		historyDummy.setMinSize(boxMinWidth, boxMinHeight);
		settingsDummy.setMinSize(boxMinWidth, boxMinHeight);

		ColorList<?> colorGenerator = Notesss.getColorGenerator();
		Background firstForeground = Utilities.getBackgroundFromColor(colorGenerator.getf(0)),
				secondForeground = Utilities.getBackgroundFromColor(colorGenerator.getf(1));

		notesssBox.setBackground(firstForeground);
		notesssButtonLabel.setFill(colorGenerator.getf(1));
		notesssButtonLabel.setFont(Font.font(null, FontPosture.ITALIC, 28));
		notesssButtonLabel.setEffect(cardShadow);
		notesssBox.setAlignment(Pos.CENTER);

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
		root.setPadding(new Insets(40, 80, 100, 80));

		/////////////////////////////////////////////////////////////////////////////////////

		searchBar.setPrefWidth(600);
		searchBar.setBackground(Utilities.getBackgroundFromColor(colorGenerator.getf(2)));

		title.setFont(Font.font(60));
		title.setFill(colorGenerator.getf(2));
		title.setStroke(colorGenerator.getf(2));
		title.setStrokeWidth(1.4);

	}

	@Override
	public synchronized Stage display(Stage stage, ApplicationProperties properties) {
		stage.setScene(scene);
		shadowOnFocus.addListener((observable, oldValue, newValue) -> {
			if (newValue)
				shadowed.bind(stage.focusedProperty());
			else
				shadowed.unbind();
		});
		shadowOnFocus.set(true);
		return stage;
	}

}
