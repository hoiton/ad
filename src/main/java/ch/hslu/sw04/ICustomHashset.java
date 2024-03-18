package ch.hslu.sw04;

/*
* Custom hashset interface
* @param <T> Type of the value
 */
public interface ICustomHashset<T> {
    /**
     * Add a value to the hashset
     * @param value Value to add
     */
    void add(T value);

    /**
     * Check if the hashset contains a value
     * @param value Value to check
     * @return True if the value is in the hashset
     */
    boolean contains(T value);

    /**
     * Remove a value from the hashset
     * @param value Value to remove
     */
    void remove(T value);

    /**
     * Get the size of the hashset
     * @return Size of the hashset
     */
    int size();

    /**
     * Check if the hashset is full
     * @return True if the hashset is full
     */
    boolean isFull();
}
