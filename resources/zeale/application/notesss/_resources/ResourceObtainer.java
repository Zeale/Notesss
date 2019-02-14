package zeale.application.notesss._resources;

import java.io.InputStream;

public class ResourceObtainer {
	/**
	 * Returns an input stream based on the given path which is either absolute, or
	 * relative to this class.
	 * 
	 * @param path The path.
	 * @return
	 * 
	 *         <pre>
	 * <code>ResourceObtainer.class.getResourceAsStream(path.startsWith("int://") && path.length() > 6 ? path.substring(6) : path)</code>
	 *         </pre>
	 */
	public static InputStream resource(String path) {
		return ResourceObtainer.class
				.getResourceAsStream(path.startsWith("int:") && path.length() > 4 ? path.substring(4) : path);
	}
}
