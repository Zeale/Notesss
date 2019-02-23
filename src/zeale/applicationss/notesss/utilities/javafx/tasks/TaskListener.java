package zeale.applicationss.notesss.utilities.javafx.tasks;

import javafx.concurrent.Task;
import javafx.concurrent.Worker.State;

public interface TaskListener<TT, T extends Task<TT>> {
	default void onComplete(Task<TT> task, State workerState) {
	}

	void onProgress(Task<TT> task, double progress);
}
