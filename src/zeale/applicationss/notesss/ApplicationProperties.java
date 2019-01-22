package zeale.applicationss.notesss;

import zeale.applicationss.notesss.graphics.uis.pages.Page;

/**
 * <p>
 * This class stores properties and data about the
 * application<code style="display:none">PROV</code>, and is (<i>currently</i>
 * just) used by {@link Page} instances to perform setup based on these
 * "properties and data," of the application.
 * </p>
 * <p>
 * When a {@link Page} is initialized normally, it is given the
 * {@link ApplicationProperties} instance held by the {@link Notesss} class.
 * This instance of {@link ApplicationProperties} is the application's primary
 * set of properties.
 * </p>
 * <p>
 * If, however, the creation of a {@link Page} instance, that is initialized
 * based on custom/spoofed properties, is desired, an instance of this class can
 * be forged and passed to the constructor of a given {@link Page}.
 * </p>
 * 
 * @author Zeale
 *
 */
public class ApplicationProperties {

}
