// I worked on the homework assignment alone, using only course materials.

import java.util.Collection;

/**
  * This class defines the SinglyLinkedList implementation of the LinkedList
  * data structure.
  *
  * @author iwebb6
  * @version 1.0
  * @param <E> The type of the elements to store in the SinglyLinkedList
  */
public class SinglyLinkedList<E> implements LinkedList<E> {
    // Keep track of the number of elements in the SinglyLinkedList
    private int count;

    // Keep track of the beginning and end of the SinglyLinkedList
    private Node head;
    private Node tail;

    // Define an inner class to store each Node of the SinglyLinkedList
    private class Node {
        // Store a reference to this element and the next
        private E element;
        private Node next;

        /**
          * A no-args constructor that creates a Node with no element or next
          * Node.
          */
        public Node() {
            this(null, null);
        }

        /**
          * Creates a Node with the given element and no next Node.
          *
          * @param element The element to give this Node
          */
        public Node(E element) {
            this(element, null);
        }

        /**
          * Creates a Node with the given element and next Node.
          *
          * @param element The element to give this Node
          * @param next    The next Node in the LinkedList
          */
        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        // Getters and setters for private instance data

        /**
          * Returns the Node's element
          *
          * @return This Node's element
          */
        public E getElement() {
            return element;
        }

        /**
          * Sets this Node's element.
          *
          * @param element This Node's new element
          */
        public void setElement(E element) {
            this.element = element;
        }

        /**
          * Returns this Node's next Node.
          *
          * @return This Node's next Node
          */
        public Node getNext() {
            return next;
        }

        /**
          * Sets this Node's next Node.
          *
          * @param next This Node's new next Node
          */
        public void setNext(Node next) {
            this.next = next;
        }
    }

    /**
      * A no-args constructor that initializes an empty SinglyLinkedList.
      */
    public SinglyLinkedList() {
        count = 0;
        head = null;
        tail = null;
    }

    // Returns the Node in the SinglyLinkedList at the given index
    private Node getNode(int index) {
        // Make sure the index is a valid one based on the size
        if (!isEmpty() && index > -1 && index < count) {
            Node currNode = head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.getNext();
            }

            return currNode;
        }

        return null;
    }

    /**
      * Returns the element at the given index.
      *
      * @param index The index of the desired element
      * @return      The element at the given index if the index is valid, null
      *              otherwise
      */
    public E get(int index) {
        Node node = getNode(index);
        return (node != null) ? node.getElement() : null;
    }

    /**
      * Adds the given element to the end of the SinglyLinkedList.
      *
      * @param data The element to add
      */
    public void add(E data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;
    }

    /**
      * Adds the given element to the specified index in the SinglyLinkedList.
      *
      * @param index The index to put the element at
      * @param data  The element to add
      * @return      true if the addition was successful, false if the index was
      *              invalid
      */
    public boolean add(int index, E data) {
        if (index == 0) {
            // Make a new head with the input data and a next of the old head
            Node oldHead = head;
            head = new Node(data, oldHead);
            count++;
        } else if (index == count) {
            add(data);
        } else {
            // Get the Node that will be right before the inserted one
            Node precedingNode = getNode(index - 1);
            if (precedingNode != null) {
                // Set the new Node's next to the preceding's next, and make the
                // preceding's next the new Node
                Node newNode = new Node(data, precedingNode.getNext());
                precedingNode.setNext(newNode);
                count++;
            } else {
                return false;
            }
        }

        // Account for the possibility of an originally empty SinglyLinkedList
        if (count == 1) {
            tail = head;
        }
        return true;
    }

    /**
      * Adds all of the elements in the Collection to the end of the
      * SinglyLinkedList.
      *
      * @param c The Collection of elements to add
      */
    public void addAll(Collection<? extends E> c) {
        for (E element : c) {
            add(element);
        }
    }

    /**
      * Returns whether or not the SinglyLinkedList contains the given element.
      *
      * @param data The element to check for
      * @return     true if the element is in the SinglyLinkedList, false
      *             otherwise
      */
    public boolean contains(E data) {
        Node currNode = head;

        // Keep looking through the list while there is something to look for
        while (currNode != null) {
            if (currNode.getElement().equals(data)) {
                return true;
            }
            currNode = currNode.getNext();
        }

        return false;
    }

    /**
      * Returns whether or not all elements in the given Collection are in the
      * SinglyLinkedList.
      *
      * @param c The Collection containing all of the elements to check
      * @return  true if all the elements are in the SinglyLinkedList, false
      *          otherwise
      */
    public boolean containsAll(Collection<? extends E> c) {
        for (E element : c) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    /**
      * Removes the first occurrence of the given element if it exists in the
      * SinglyLinkedList.
      *
      * @param data The element to remove
      * @return     true if the element was successfully removed, false
      *             otherwise
      */
    public boolean remove(E data) {
        Node prevNode = null;
        Node currNode = head;

        while (currNode != null) {
            if (currNode.getElement().equals(data)) {
                // Account for any head/tail deletions
                if (currNode != head && currNode != tail) {
                    prevNode.setNext(currNode.getNext());
                } else {
                    if (currNode == head) {
                        head = currNode.getNext();
                    }
                    if (currNode == tail) {
                        if (prevNode != null) {
                            prevNode.setNext(null);
                        }
                        tail = prevNode;
                    }
                }
                count--;
                return true;
            }
            prevNode = currNode;
            currNode = currNode.getNext();
        }

        return false;
    }

    /**
      * Removes the element at the given index and returns it if it was removed
      * successfully.
      *
      * @param index The index of the element to remove
      * @return      The removed object if successful, null otherwise
      */
    public E remove(int index) {
        Node prevNode = null;
        Node currNode = head;

        // Make sure the index is a valid one based on the size
        if (!isEmpty() && index > -1 && index < count) {
            for (int i = 0; i < index; i++) {
                prevNode = currNode;
                currNode = currNode.getNext();
            }

            // Account for any head/tail deletions
            if (currNode != head && currNode != tail) {
                prevNode.setNext(currNode.getNext());
            } else {
                if (currNode == head) {
                    head = currNode.getNext();
                }
                if (currNode == tail) {
                    if (prevNode != null) {
                        prevNode.setNext(null);
                    }
                    tail = prevNode;
                }
            }
            count--;
            return currNode.getElement();
        } else {
            return null;
        }
    }

    /**
      * Removes all elements in the given Collection from the SinglyLinkedList,
      * returning whether or not all elements were removed successfully.
      *
      * @param c The Collection containing the elements to remove
      * @return  Whether or not all of the elements were removed successfully
      */
    public boolean removeAll(Collection<? extends E> c) {
        boolean removedAll = true;

        for (E element : c) {
            removedAll = removedAll && remove(element);
        }

        return removedAll;
    }

    /**
      * Returns the size (number of elements) in the SinglyLinkedList.
      *
      * @return The size of the SinglyLinkedList
      */
    public int size() {
        return count;
    }

    /**
      * Returns whether or not the SinglyLinkedList is empty.
      *
      * @return true if the size of the SinglyLinkedList is 0, false otherwise
      */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
      * Deletes all elements from the SinglyLinkedList and sets the size to 0.
      */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }
}
