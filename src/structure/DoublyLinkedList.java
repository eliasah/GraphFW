/**
 * @author: ABOUHAYDAR Elias - LIAFA Departement of Distributed Algorithms and Graphs
 * 
 */

package structure;

import exceptions.InvalidIndexException;

public class DoublyLinkedList<E> implements List {

	private int len;
	private Node2 head, tail;

	/**
	 * Instanciate a new DoublyLinkedList of type E
	 * 
	 */
	public DoublyLinkedList() {
		super();
	}

	@Override
	/**
	 * Adds object o to the List at index i 
	 * @param o
	 * @param i
	 * @throws InvalidIndexException
	 */
	public void add(Object e, int i) throws InvalidIndexException {

		if (i < 0 || i > len + 1)
			throw new InvalidIndexException();
		Node2 n = new Node2(e);
		if (len == 0) {
			head = tail = n;
		} else if (i == 1) {
			head.setPrev(n);
			n.setNext(head);
			head = n;
		} else if (i == len + 1) {
			tail.setNext(n);
			n.setPrev(n);
			tail = n;
		} else {
			Node2 p = null, q = head;
			for (int j = 1; j < i; j++) {
				p = q;
				q = q.getNextNode2();
			}
			p.setNext(n);
			n.setPrev(p);
			n.setNext(q);
			q.setPrev(n);

		}
		len++;
	}

	@Override
	public Object atIndex(int i) {
		if (i < 1 || i > len)
			try {
				throw new InvalidIndexException();
			} catch (InvalidIndexException e) {
				System.err
						.println("the index must be between 1 and the size of the list");
				e.printStackTrace();
			}
		Node2 n = head;
		for (int j = 1; j < i; j++) {
			n = n.getNextNode2();
		}
		return n.getData();
	}

	@Override
	public void delete(int i) throws InvalidIndexException {
		if (len == 1)
			head = tail = null;
		if (i < 1 || i > len)
			throw new InvalidIndexException();
		else {
			if (i == 1)
				head = head.getNextNode2();
			else if (i == len) {
				tail = tail.getPrevNode2();
				tail.setNext(null);
			} else {
				Node2 q = head, p = null;
				for (int j = 1; j < i; j++) {
					p = q;
					q = q.getNextNode2();
				}
				q.getNextNode2().getPrev();
				p.setNext(q.getNext());
			}
		}
		len--;
	}

	/**
	 * Returns the head node of the list
	 * 
	 * @return the head node of the list
	 */
	public Node2 getHead() {
		return head;
	}

	/**
	 * Returns the tail node of the list
	 * 
	 * @return the head node of the list
	 */
	public Node2 getTail() {
		return tail;
	}

	/**
	 * Returns the index of a node from the list
	 * 
	 * @param n
	 *            a node
	 * @return the index of the node given in argument
	 * @throws InvalidIndexException
	 */
	public int indexOf(Node2 n) throws InvalidIndexException {
		for (int i = 1; i <= len; i++) {
			if (atIndex(i) == n)
				return i;
		}
		return 0;
	}

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list.
	 */
	public int length() {
		return len;
	}

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list.
	 */
	public int size() {
		return len;
	}

	/**
	 * Returns a string representation of this collection. The string
	 * representation consists of a list of the collection's elements in the
	 * order they are returned by its iterator, enclosed in square brackets
	 * ("[]"). Adjacent elements are separated by the characters ", " (comma and
	 * space). Elements are converted to strings as by String.valueOf(Object).
	 * This implementation creates an empty string buffer, appends a left square
	 * bracket, and iterates over the collection appending the string
	 * representation of each element in turn. After appending each element
	 * except the last, the string ", " is appended. Finally a right bracket is
	 * appended. A string is obtained from the string buffer, and returned.
	 * 
	 * Override : toString in class Object
	 * 
	 * @return a string representation of this collection
	 * 
	 * 
	 */
	@Override
	public String toString() {
		if (len == 0)
			return "Empty List";
		String str = /** "length = " + len + ", C = " **/
		"{";
		for (int i = 1; i <= len; i++) {
			str += atIndex(i);
		}
		str += "} ";
		return str;
	}

}
