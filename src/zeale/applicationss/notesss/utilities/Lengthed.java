package zeale.applicationss.notesss.utilities;

public interface Lengthed {
	default int len() {
		return length();
	}

	int length();
}
