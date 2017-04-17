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

        // NOTE: Remove this toString before submitting
        @Override
        public String toString() {
            return element.toString();
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
      * @return      The element at the given index
      */
    public E get(int index) {
        // NOTE: Remove this before submitting
        System.out.println("\nget(int)\n----------");
        printList();

        Node node = getNode(index);
        return (node != null) ? node.getElement() : null;
    }

    /**
      * [add description]
      * @param E data [description]
      */
    public void add(E data) {
        // NOTE: Remove this before submitting
        System.out.println("\nadd(E)\n----------");
        printList();

        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;

        // NOTE: Remove this before submitting
        System.out.println("\nPOST add(E)\n----------");
        printList();
    }

    /**
      * [add description]
      * @param  int index         [description]
      * @param  E   data          [description]
      * @return     [description]
      */
    public boolean add(int index, E data) {
        // NOTE: Remove this before submitting
        System.out.println("\nadd(int, E)\n----------");
        printList();

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

        // NOTE: Remove this before submitting
        System.out.println("\nPOST add(int, E)\n----------");
        printList();

        return true;
    }

    /**
      * [addAll description]
      * @param Collection<? extends E> c [description]
      */
    public void addAll(Collection<? extends E> c) {
        for (E element : c) {
            add(element);
        }
    }

    /**
      * [contains description]
      * @param  E data          [description]
      * @return   [description]
      */
    public boolean contains(E data) {
        // NOTE: Remove this before submitting
        System.out.println("\ncontains(E)\n----------");
        printList();

        Node currNode = head;

        // Keep looking through the list while there is something to look for
        while (currNode != null) {
            if (currNode.getElement() == data) {
                return true;
            }
            currNode = currNode.getNext();
        }

        return false;
    }

    /**
      * [containsAll description]
      * @param  Collection<? extends       E> c [description]
      * @return              [description]
      */
    public boolean containsAll(Collection<? extends E> c) {
        boolean containedAll = true;

        for (E element : c) {
            containedAll = containedAll && contains(element);
        }

        return containedAll;
    }

    /**
      * [remove description]
      * @param  E data          [description]
      * @return   [description]
      */
    public boolean remove(E data) {
        // NOTE: Remove this before submitting
        System.out.println("\nremove(E)\n----------");
        printList();

        Node prevNode = null;
        Node currNode = head;

        while (currNode != null) {
            if (currNode.getElement() == data) {
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

                // NOTE: Remove this before submitting
                System.out.println("\nPOST remove(E)\n----------");
                printList();

                return true;
            }
            prevNode = currNode;
            currNode = currNode.getNext();
        }

        return false;
    }

    /**
      * [remove description]
      * @param  int index         [description]
      * @return     [description]
      */
    public E remove(int index) {
        // NOTE: Remove this before submitting
        System.out.println("\nremove(int)\n----------");
        printList();

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

            // NOTE: Remove this before submitting
            System.out.println("\nPOST remove(int)\n----------");
            printList();

            return currNode.getElement();
        } else {
            return null;
        }
    }

    /**
      * [removeAll description]
      * @param  Collection<? extends       E> c [description]
      * @return              [description]
      */
    public boolean removeAll(Collection<? extends E> c) {
        boolean removedAll = true;

        for (E element : c) {
            removedAll = removedAll && remove(element);
        }

        return removedAll;
    }

    /**
      * [size description]
      * @return [description]
      */
    public int size() {
        return count;
    }

    /**
      * [isEmpty description]
      * @return [description]
      */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
      * [clear description]
      */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    // NOTE: Remove this method before submitting
    public void printList() {
        Node currNode = head;
        System.out.println("Count: " + count);
        for (int i = 0; i < count; i++) {
            System.out.println(i + ": " + currNode);
            currNode = currNode.getNext();
        }

        System.out.println("Head: " + head);
        System.out.println("Tail: " + tail);
    }
}
