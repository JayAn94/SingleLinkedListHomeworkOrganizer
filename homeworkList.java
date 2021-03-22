
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.Date;

public class homeworkList<E> extends AbstractList<E> {

	private Node<E> head;

	// Node Constructor
	private static class Node<E> {

		public Node<E> next;
		public E element;
		public E duedate;

		public Node(E element, E duedate) {

			this(element, duedate, null);
		}

		public Node(E element, E duedate, Node next) {

			this.element = element;
			this.duedate = duedate;
			this.next = next;
		}
	}

	// Constructs an empty list.
	public homeworkList() {

		head = null;
	}

	// Adds new node to the front of the list
	public boolean add(E element, E duedate) {

		head = new Node(element, duedate, head);
		return true;
	}

	// Cycles through the list to remove an element passed from removeRequested
	public void removeAssignment(E removeRequested) {

		Node<E> current = head;
		Node<E> temp = null;

		if (current != null && current.element.equals(removeRequested)) {
			head = current.next;
			return;
		}

		while (current != null && !current.element.equals(removeRequested)) {
			temp = current;
			current = current.next;

			if (current == null) {
				break;
			}
		}
		temp.next = current.next;
	}

	// Prints Current Linked List
	public void print() {

		Node<E> temp = head;
		while (temp != null) {
			System.out.println(temp.element + " " + temp.duedate);
			temp = temp.next;
		}
	}

	// Returns the earliest due date by parsing all dates and comparing them to each
	// other
	public void earliestDate() throws ParseException {

		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		Date date;
		Node<E> current = head;
		Node<E> earliest = head;

		if (current == null) {
			System.out.println("List is currently Empty");
		}

		// Returns the first item in the list if it is the only item in the list
		if (current.next == null) {
			System.out.println(current.element + " " + current.duedate);
		}

		while (current != null) {

			// Parses the dueDate and cast to String and compares them to each other then
			// returns the smallest number
			// Sets earliest to the current if the first in the node is earliest set current
			// to next.
			if (df.parse((String) current.duedate).compareTo(df.parse((String) earliest.duedate)) <= 0) {
				earliest = current;
			}

			current = current.next;
		}

		System.out.println(earliest.element + " " + earliest.duedate);
	}

	@Override
	public E get(int index) {
		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.element;
	}

	@Override
	public int size() {
		int count = 0;
		Node<E> current = head;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}
}