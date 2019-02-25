package zeale.applicationss.notesss.utilities.generators;

public interface Generator<R> {
	@SafeVarargs
	static <R, T extends R> Generator<R> arrayLoop(T... array) {
		if (array.length == 0)
			throw new IllegalArgumentException("Cannot create a Generator using an array of size 0.");
		return new Generator<R>() {

			private int pos = -1;

			@Override
			public T next() {
				return array[++pos >= array.length ? (pos = 0) : pos];
			}
		};
	}

	@SafeVarargs
	static <R, T extends R> Generator<R> random(T... array) {
		return () -> array[(int) (Math.random() * array.length)];
	}

	R next();

}
