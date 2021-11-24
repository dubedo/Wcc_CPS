package vid2.LinkedListvSetList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> implements List<T> {
	private Node header = new Node();
	private int totalSize = 0;

	public Iterator<T> iterator() {
		return new MyIterator();
	}

	private void addNode(T value, Node curr) {
		new Node(value, curr);
		totalSize += 1;
	}

	public boolean add(T value) {
		addNode(value, header);
		return true;
	}

	public void addFirst(T value) {
		addNode(value, header.next);
		totalSize += 1;
	}

	public T getFirst() {
		return header.next.value;
	}

	public T getlast() {
		return header.previous.value;
	}

	void addLast(T value) {
		add(value);
	}

	T removeFirst() {
		Node n = header.next;
		removeNode(n);
		return n.value;
	}

	T removeLast() {
		Node n = header.previous;
		removeNode(n);
		return n.value;
	}

	private void removeNode(Node n) {
		n.previous.next = n.next;
		n.next.previous = n.previous;
		totalSize -= 1;
	}

	public int size() {

		return totalSize;
	}

	public boolean isEmpty() {
		if (totalSize == 0)
			return true;
		else
			return false;
	}

	public void clear() {
		header = new Node();
		totalSize = 0;
	}

	public static void main(String[] args) {
		LinkedList<String> ml = new LinkedList<String>();

		ml.add("three");
		ml.add("four");
		ml.add("five");
		ml.addFirst("two");
		ml.addFirst("one");

		System.out.println("Front = " + ml.getFirst());
		System.out.println("Last = " + ml.getlast());

		Iterator<String> iter = ml.iterator();

		while (iter.hasNext()) {
			String s = iter.next();
			if (s.equals("three"))
				iter.remove();
			System.out.println(s);
		}
		System.out.println("After removing three");
		iter = ml.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}

		ml.removeFirst();
		System.out.println("After removeFirst");
		iter = ml.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}

		ml.removeLast();
		System.out.println("After removeLast");
		iter = ml.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= totalSize)
			throw new IndexOutOfBoundsException();
	}

	private Node gotoNode(int index) {
		checkIndex(index);
		Node n = header.next;
		for (int i = 0; i < index; i++)
			n = n.next;

		return n;
	}

	@Override
	public void add(int index, T value) {

		if (index == totalSize)
			addNode(value, header);
		else
			addNode(value, gotoNode(index));
	}

	@Override
	public boolean addAll(Collection<? extends T> otherCollection) {
		Iterator<? extends T> iter = otherCollection.iterator();
		boolean changesHappened = false;
		while (iter.hasNext()) {
			add(iter.next()); // added to the end
			changesHappened = true;
		}
		return changesHappened;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> otherCollection) {
		Iterator<? extends T> iter = otherCollection.iterator();
		boolean changesHappened = false;
		Node n;
		if (index == totalSize)
			n = header;
		else
			n = gotoNode(index);

		while (iter.hasNext()) {
			addNode(iter.next(), n);
			changesHappened = true;
		}
		return changesHappened;

	}

	@Override
	public boolean contains(Object obj) {
		if (indexOf(obj) >= 0)
			return true;
		else
			return false;

	}

	@Override
	public boolean containsAll(Collection<?> otherCollection) {
		@SuppressWarnings("rawtypes")
		Iterator iter = otherCollection.iterator();
		while (iter.hasNext()) {
			Object otherObj = iter.next();
			if (!contains(otherObj))
				return false;
		}
		return true;
	}

	@Override
	public T get(int index) {
		Node n = gotoNode(index);
		return n.value;
	}

	@Override
	public int indexOf(Object obj) {
		Iterator<T> iter = iterator();
		int index = 0;
		while (iter.hasNext()) {
			if (obj.equals(iter.next()))
				return index;
			index += 1;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		throw new UnsupportedOperationException("MyLinkedList unimplemented method");
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException("MyLinkedList unimplemented method");
	}

	@Override
	public ListIterator<T> listIterator(int arg0) {
		throw new UnsupportedOperationException("MyLinkedList unimplemented method");
	}

	@Override
	public boolean remove(Object obj) {
		Iterator<T> iter = iterator();
		while (iter.hasNext()) {
			if (obj.equals(iter.next())) {
				iter.remove();
				return true;
			}
		}
		return false;
	}

	@Override
	public T remove(int index) {
		Node n = gotoNode(index);
		T value = n.value;
		removeNode(n);
		return value;
	}

	@Override
	public boolean removeAll(Collection<?> otherCollection) {
		@SuppressWarnings("rawtypes")
		Iterator iter = otherCollection.iterator();
		boolean changesHappened = false;
		while (iter.hasNext()) {
			Object value = iter.next();
			if (remove(value))
				changesHappened = true;
		}
		return changesHappened;

	}

	@Override
	public boolean retainAll(Collection<?> otherCollection) {
		Iterator<T> iter = iterator();
		boolean changesHappened = false;
		while (iter.hasNext()) {
			T value = iter.next();
			if (!otherCollection.contains(value)) {
				iter.remove();
				changesHappened = true;
			}
		}
		return changesHappened;
	}

	@Override
	public T set(int index, T value) {
		Node n = gotoNode(index);
		T retValue = n.value;
		n.value = value;
		return retValue;
	}

	@Override
	public List<T> subList(int startIndex, int endIndex) {
		checkIndex(startIndex);
		checkIndex(endIndex - 1);
		Node n = gotoNode(startIndex);
		List<T> retList = new LinkedList<T>();
		for (int index = startIndex; index < endIndex; index++) {
			retList.add(n.value);
			n = n.next;
		}

		return retList;
	}

	@Override
	public Object[] toArray() {
		Object[] retArr = new Object[totalSize];
		Iterator<T> iter = iterator();
		int index = 0;
		while (iter.hasNext()) {
			retArr[index++] = iter.next();
		}
		return retArr;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] arg0) {
		// Not sure I know how to make an Array of T
		// The following doesn't work
		// T[] = new T();
		throw new UnsupportedOperationException("MyLinkedList unimplemented method");
	}

	/****** Inner Class *****/
	class Node {
		T value;
		Node next;
		Node previous;

		Node() {
			value = null;
			next = this;
			previous = this;
		}

		Node(T value, Node curr) {
			this.value = value;
			next = curr;
			previous = curr.previous;
			curr.previous.next = this;
			curr.previous = this;
		}

	}

	/******* Inner class Iterator *****/
	class MyIterator implements Iterator<T> {
		Node lastNode = header;
		Node nextNode = header;

		@Override
		public boolean hasNext() {
			if (nextNode.next == lastNode)
				return false;
			return true;
		}

		@Override
		public T next() {
			nextNode = nextNode.next;
			return nextNode.value;
		}

		@Override
		public void remove() {
			removeNode(nextNode);

		}

	}

}