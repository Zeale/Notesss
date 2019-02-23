package zeale.applicationss.notesss;

import zeale.applicationss.notesss.graphics.uis.pages.Page;
import zeale.applicationss.notesss.utilities.colors.ColorList;

/**
 * <p>
 * This class stores properties and data about the
 * application<code style="display:none">PROV</code>, and is (<i>currently</i>
 * just) used by {@link Page} instances to perform setup based on these
 * "properties and data," of the application.
 * </p>
 * <p>
 * <u>{@link ApplicationProperties} are immutable, apart from the .</u>
 * </p>
 *
 * @author Zeale
 *
 */
public class ApplicationProperties {

	public class PropertyEditor {
		private PropertyEditor() {
		}

		public ApplicationProperties properties() {
			return ApplicationProperties.this;
		}

		public void setColorGenerator(ColorList<?> colorGenerator) {
			properties().colorGenerator = colorGenerator;
		}
	}

	public static PropertyEditor instance() {
		return new ApplicationProperties().new PropertyEditor();
	}

	private ColorList<?> colorGenerator = ColorList.PURE;

	private ApplicationProperties() {
	}

	public ColorList<?> getColorGenerator() {
		return colorGenerator;
	}
}
