package zeale.applicationss.notesss.utilities.generators;

import java.util.Iterator;

public abstract class NullstopGenerator<R> implements Generator<R>, Iterator<R> {

	private R element;
	private boolean cached;

	private void cacheNext() {
		cached = true;
		element = next();
	}

	@Override
	public boolean hasNext() {
		if (!cached)
			cacheNext();
		return element != null;
	}

	protected abstract R nextItem();

	@Override
	public R next() {
		if (cached) {
			cached = false;
			return element;
		}
		return nextItem();
	}

}
