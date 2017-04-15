import java.util.Collection;

/**
 * The LinkedList interface defines a set of standard operations that are
 * typically associated with linked list, such as adding, removing, and checking
 * to see if the list contains an item.
 *
 * Note that while your linked list implementation should make use of a Node
 * class, the methods below take in and return instances of the generic type,
 * not the nodes themselves.
 *
 * @author Justin Nieto
 * @version 1.1
 * @param <E> the type of the elements to store in the linked list
 */
public interface LinkedList<E> {

    /**
     * Returns the element in the linked list at the specified index.
     * Does not change the contents of the list in any way. If the given
     * index is negative or greater than the maximum possible index, returns
     * null.
     *
     * @param index of element to be retrieved
     * @return the element at the given index or null if index out of bounds
     */
    E get(int index);

    /**
     * Adds the specified piece of data to the end of the linked list.
     * This method should execute in O(1) (constant) time. This means that
     * you should not iterate over the whole list to add the item to the end
     * (we will check for this).
     *
     * @param data the object to be added to the linked list
     */
    void add(E data);

    /**
     * Adds given piece of data to the linked list at the given index.
     * All items that were originally at the index or after the index should
     * be shifted down by one. If the index specified is not valid, returns
     * false. Otherwise, returns true.
     *
     * If the index specified is 0 or if it is one larger than the maximum
     * current index (ie if index is equal to the size of the linked list),
     * then this method should execute in O(1) (constant) time. This means that
     * you should not iterate over the entire list to add the element, as it
     * is unnecessary to do so.
     *
     * @param index the index at which to add the item
     * @param data the item to be added to te linked list
     * @return true if the data could be added at the given index
     */
    boolean add(int index, E data);

    /**
     * Adds each element in the Collection to the end of the linked list.
     *
     * @param c the collection of items to add to the end of the linked list
     */
    void addAll(Collection<? extends E> c);

    /**
     * Determines whether or not the given piece of data is in the linked list.
     *
     * @param data the item to check
     * @return true if the linked list contains the item, false otherwise
     */
    boolean contains(E data);

    /**
     * Determines whether or not every element of the given Collection is
     * in the linked list.
     *
     * @param c the Collection of elements to check
     * @return true if list contains every element in the Collection
     */
    boolean containsAll(Collection<? extends E> c);

    /**
     * Finds the first element of the list equal to the given piece of data
     * and removes it from the list. Returns false if the given piece of data
     * is not in the list and therefore cannot be removed.
     *
     * @param data the piece of data to be removed from the list
     * @return true if the item was removed, false if list does not contain it
     */
    boolean remove(E data);

    /**
     * Removes and returns the item in the list at the given index.
     * All items at indices after the given index are shifted down by one.
     *
     * @param index the index of the item to remove from the linked list
     * @return the removed item
     */
    E remove(int index);

    /**
     * Removes all elements in the given collection from the linked list.
     *
     * @param c the Collection of items to remove
     * @return true if all elements in the Collection were removed.
     */
    boolean removeAll(Collection<? extends E> c);

    /**
     * Returns the number of elements in the linked list. This method
     * should execute in O(1) (constant) time. This means that you should not
     * iterate over the entire list to count the number of items, but rather
     * you should maintain a size variable that you can just return here.
     *
     * @return the number of elements in the linked list
     */
    int size();

    /**
     * Returns true if the linked list has no elements.
     *
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Removes all elements from the list. After calling this method,
     * the isEmpty method should return true.
     */
    void clear();

}

