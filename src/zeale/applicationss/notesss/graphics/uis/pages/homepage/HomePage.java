package zeale.applicationss.notesss.graphics.uis.pages.homepage;

import javafx.animation.Transition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.graphics.uis.pages.NoteEditorPage;
import zeale.applicationss.notesss.graphics.uis.pages.templates.CoverLayout;

public class HomePage extends CoverLayout {
	private final DropShadow cardShadow = new DropShadow();

	private final ImageView notesssIcon = new ImageView(
			"/zeale/application/notesss/_resources/graphics/ui/pages/home/Notepad-v1-2.png");
	private final Text notesssButtonLabel = new Text("My Notes");
	{
		notesssIcon.setFitHeight(66);
		notesssIcon.setFitWidth(50);
		notesssIcon.setEffect(cardShadow);
	}

	private Stage stage;
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

		topLeftSquare.setEffect(cardShadow);
		topRightSquare.setEffect(cardShadow);
		bottomRightSquare.setEffect(cardShadow);
		bottomLeftSquare.setEffect(cardShadow);

		title.setEffect(cardShadow);
		searchBar.setEffect(cardShadow);

		notesssButtonLabel.setFont(Font.font(null, 28));
		notesssButtonLabel.setStrokeWidth(0.8);
		notesssButtonLabel.setEffect(cardShadow);

		topLeftSquare.getChildren().addAll(notesssIcon, notesssButtonLabel);
		topLeftSquare.setSpacing(5);

		applyMouseEffects(cardShadow, topLeftSquare, topRightSquare, bottomLeftSquare, bottomRightSquare);
		topLeftSquare.setOnMouseClicked(event -> new NoteEditorPage().display(stage));

	}

	private static final void applyMouseEffects(Effect defaultShadow, Node... nodes) {

		Transform clickShadowShift = new Translate(5, 5);
		InnerShadow clickShadow = new InnerShadow();

		Glow glow = new Glow();
		glow.setInput(defaultShadow);
		clickShadow.setOffsetX(5);
		clickShadow.setOffsetY(5);
		clickShadow.setWidth(10);
		clickShadow.setHeight(10);

		for (Node n : nodes)
			new Object() {
				boolean clicking;
				{
					n.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
						glow.setInput(clickShadow);
						n.setEffect(glow);
						if (n instanceof Parent)
							for (Node n : ((Parent) n).getChildrenUnmodifiable())
								if (!n.getTransforms().contains(clickShadowShift))
									n.getTransforms().add(clickShadowShift);
						clicking = true;
					});
					n.addEventFilter(MouseEvent.MOUSE_RELEASED, event -> {
						glow.setInput(defaultShadow);
						if (n instanceof Parent)
							for (Node n : ((Parent) n).getChildrenUnmodifiable())
								n.getTransforms().remove(clickShadowShift);
						clicking = false;
					});

					n.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> {
						n.setEffect(glow);
						if (clicking)
							if (n instanceof Parent)
								for (Node n : ((Parent) n).getChildrenUnmodifiable())
									if (!n.getTransforms().contains(clickShadowShift))
										n.getTransforms().add(clickShadowShift);
					});
					n.addEventFilter(MouseEvent.MOUSE_EXITED, event -> {
						n.setEffect(defaultShadow);
						if (n instanceof Parent)
							for (Node n : ((Parent) n).getChildrenUnmodifiable())
								n.getTransforms().remove(clickShadowShift);
					});
				}
			};
	}

	@Override
	public synchronized Stage display(Stage stage, ApplicationProperties properties) {
		shadowOnFocus.addListener((observable, oldValue, newValue) -> {
			if (newValue)
				shadowed.bind(stage.focusedProperty());
			else
				shadowed.unbind();
		});
		shadowOnFocus.set(true);
		this.stage = stage;

		// Styling using ApplicationProperties instance.
		Paint color = properties.getColorGenerator().getf(2);
		notesssButtonLabel.setFill(color);
		notesssButtonLabel.setStroke(color);

		return super.display(stage, properties);
	}
}
