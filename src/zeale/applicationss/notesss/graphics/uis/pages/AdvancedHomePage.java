package zeale.applicationss.notesss.graphics.uis.pages;

import javafx.animation.Transition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import zeale.applicationss.notesss.ApplicationProperties;
import zeale.applicationss.notesss.Notesss;
import zeale.applicationss.notesss.graphics.uis.pages.templates.CoverLayout;

public class AdvancedHomePage extends CoverLayout {
	private final DropShadow cardShadow = new DropShadow();

	private final ImageView notesssIcon = new ImageView(
			"/zeale/application/notesss/_resources/graphics/ui/pages/home/Notepad-v1-2.png");
	private final Text notesssButtonLabel = new Text("My Notesss");
	{
		notesssIcon.setFitHeight(66);
		notesssIcon.setFitWidth(50);
		notesssIcon.setEffect(cardShadow);
	}

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
		topLeftSquare.setEffect(cardShadow);
		topRightSquare.setEffect(cardShadow);
		bottomRightSquare.setEffect(cardShadow);
		bottomLeftSquare.setEffect(cardShadow);

		title.setEffect(cardShadow);
		searchBar.setEffect(cardShadow);

		notesssButtonLabel.setFill(Notesss.getColorGenerator().getf(1));
		notesssButtonLabel.setFont(Font.font(null, 28));
		notesssButtonLabel.setStrokeWidth(0.5);
		notesssButtonLabel.setStroke(Notesss.getColorGenerator().getf(1));
		notesssButtonLabel.setEffect(cardShadow);

		topLeftSquare.getChildren().addAll(notesssIcon, notesssButtonLabel);
		topLeftSquare.setSpacing(5);
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
		return super.display(stage, properties);
	}
}
