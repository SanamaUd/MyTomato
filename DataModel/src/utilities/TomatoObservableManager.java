package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This handles the observers.
 */
public class TomatoObservableManager {

	private Map<TomatoObservation<?>, List<TomatoActionListener<?>>> observers;

	/**
	 * Constructor of {@link TomatoObservableManager}.
	 */
	public TomatoObservableManager() {
		this(new HashMap<>());
	}

	/**
	 * Constructor of {@link TomatoObservableManager} specifying
	 * the mapping of observers. For Testing.
	 * @param observers the map of {@link TomatoObservation} to their listeners to use
	 */
	TomatoObservableManager(Map<TomatoObservation<?>, List<TomatoActionListener<?>>> observers) {
		this.observers = observers;
	}
	
	public <T> TomatoActionListener<T> addObservers(TomatoObservation<T> type, TomatoActionListener<T> action) {
		List<TomatoActionListener<?>> listeners = observers.get(type);
		if (listeners == null) {
		   listeners = new ArrayList<>();
		}
		listeners.add(action);
		observers.put(type, listeners);
		return action;
	}

	public <T> void removeObservers(TomatoObservation<T> type, TomatoActionListener<T> action) {
		List<TomatoActionListener<?>> listeners = observers.get(type);
		if(listeners != null && listeners.contains(action)) {
			listeners.remove(action);
			observers.put(type, listeners);
		}
	}

	public <T> void notifyObservers(TomatoObservation<T> type, T updatedValue) {
        List<TomatoActionListener<?>> listeners = observers.get(type);
        if(listeners != null) {
        	for(TomatoActionListener<?> listener : listeners) {
        		@SuppressWarnings("unchecked") // safe since the mapping populated with same type
				TomatoActionListener<T> typedListener = (TomatoActionListener<T>) listener;
        		typedListener.update(updatedValue);
        	}
        }
	}
}
