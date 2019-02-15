package zeale.application.notesss._resources;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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

	public static String string(String path, byte[] arr, Charset encoding) {
		StringBuilder builder = new StringBuilder();
		int amount;
		try (InputStream in = resource(path)) {
			while ((amount = in.read(arr)) != -1)
				builder.append(new String(arr, 0, amount, encoding));
		} catch (IOException e) {
			return null;
		}
		return builder.toString();
	}

	public static String string(String path, byte[] arr) {
		return string(path, arr, StandardCharsets.US_ASCII);
	}

	public static String string(String path, int bufferSize) {
		return string(path, new byte[bufferSize]);
	}

	public static String string(String path, int bufferSize, Charset charset) {
		return string(path, new byte[bufferSize], charset);
	}

	public static String string(String path) {
		return string(path, 2048);
	}

}
