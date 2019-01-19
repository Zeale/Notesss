package zeale.applicationss.notesss.utilities;

public class FrozenBox<I> {

	public FrozenBox(I item) {
		this.item = item;
	}

	public final I item;
}
