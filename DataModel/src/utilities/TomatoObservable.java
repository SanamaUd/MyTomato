package utilities;

/**
 * This interface provides a {@link TomatoObservableManager} for the observable object.
 * This is to avoid the observers to inherit and use composition over inheritance when observing.
 */
public interface TomatoObservable {

	/**
	 * Provides the {@link TomatoObservableManager} to add observers to.
	 * @return the {@link TomatoObservableManager}
	 */
	public TomatoObservableManager getObservableManager();
}
