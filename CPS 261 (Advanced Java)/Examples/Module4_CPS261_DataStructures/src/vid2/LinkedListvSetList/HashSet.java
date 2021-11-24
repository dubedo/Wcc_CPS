package vid2.LinkedListvSetList;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class HashSet<T> implements Set<T> {

	int tableSize = 879;
	float loadFactor;
	int totalSize = 0;
	Object[] hashTable;

	HashSet() {
		this(16, 0.75f);
	}

	HashSet(int initialCapacity) {
		this(initialCapacity, 075f);
	}

	HashSet(int initialCapacity, float loadFactor) {
		tableSize = initialCapacity;
		this.loadFactor = loadFactor;
		clear();
	}

	private int getHashBucketIndex(Object e) {
		return Math.abs(e.hashCode() % tableSize);
	}

	@SuppressWarnings("unchecked")
	private boolean isPresent(int index, Object e) {

		Node n = (Node) hashTable[index];

		while (n != null) {
			if (e.equals(n.value)) {
				return true;
			}
			n = n.next;
		}
		return false;
	}

	private void rehash() {
		int newTableSize = tableSize * 2;
		System.out.println("Rehash: " + newTableSize);

		HashSet<T> bigger = new HashSet<T>(newTableSize, loadFactor);

		Iterator<T> iteration = iterator();

		while (iteration.hasNext()) {
			bigger.add(iteration.next());
		}

		hashTable = bigger.hashTable;
		tableSize = newTableSize;
		totalSize = bigger.totalSize;

	}

	@Override
	public int size() {
		return totalSize;
	}

	@Override
	public boolean isEmpty() {
		if (totalSize == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(Object o) {
		int index = getHashBucketIndex(o);

		if (isPresent(index, o)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(T e) {
		int index = getHashBucketIndex(e);
		if (isPresent(index, e)) {
			return false;
		}

		Node toAdd = new Node(e);
		toAdd.next = (Node) hashTable[index];
		hashTable[index] = toAdd;
		totalSize += 1;

		if (totalSize > (int) tableSize * loadFactor) {
			rehash();
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		if (o == null) {
			return false;
		}

		int index = getHashBucketIndex(o);
		Node n = (Node) hashTable[index];

		if (n != null && o.equals(n.value)) {
			hashTable[index] = n.next;
			totalSize -= 1;
			return true;
		}

		Node previous = n;

		while (previous != null) {
			Node nextNode = previous.next;

			if (nextNode == null) {
				return false;
			}

			if (o.equals(nextNode.value)) {
				previous.next = nextNode.next;
				totalSize -= 1;
				return true;
			}

			previous = nextNode.next;

		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
		totalSize = 0;
		hashTable = new Object[tableSize];
		for (int i = 0; i < tableSize; i++) {
			hashTable[i] = null;
		}
	}

	class Node {
		T value;
		Node next;

		Node(T v) {
			value = v;
			next = null;
		}
	}

	class MyIterator implements Iterator<T> {

		int nextIndex = 0;
		Node nextNode = null;

		@SuppressWarnings("unchecked")
		public boolean hasNext() {

			if (nextNode != null) {
				return true;
			}

			while (nextIndex < tableSize) {
				nextNode = (Node) hashTable[nextIndex++];
				if (nextNode != null) {
					return true;
				}

			}

			return false;

		}

		public T next() {
			Node temp = nextNode;
			nextNode = temp.next;
			return temp.value;
		}

		public void remove() {
			System.out.println("Removed");
		}

	}

	public static void main(String[] args) {

		HashSet<String> mhs = new HashSet<String>(3, .75f);

		mhs.add("Fido");
		mhs.add("Spike");
		mhs.add("Spike");
		mhs.add("Izzy");
		mhs.add("Spot");
		mhs.add("Lassy");
		mhs.add("Rintintin");
		mhs.add("Rusty");
		mhs.add("Rastro");
		mhs.add("Silver");
		mhs.add("Spasky");

		if (mhs.contains("Fido")) {
			System.out.println("Fido Is In Here.");
		} else {
			System.out.println("Fido Is Not In Here.");
		}

		if (mhs.remove("Silver")) {
			System.out.println("We've Removed Silver.");
		}

		Iterator<String> iteration = mhs.iterator();
		while (iteration.hasNext()) {
			System.out.println(iteration.next());
		}

	}

}