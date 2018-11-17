package utilities;

/**
 * This holds the action to perform with the new value.
 * @param <T> the type of value to listen to
 */
public interface TomatoActionListener<T> {

	/**
	 * Provides the action to perform with the updated value.
	 * @param updatedValue the value to update with
	 */
	public void update(T updatedValue);
}
