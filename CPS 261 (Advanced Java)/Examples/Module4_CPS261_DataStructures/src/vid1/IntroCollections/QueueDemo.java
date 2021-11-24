package vid1.IntroCollections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<>();

		// add is dangerous. offer is better.
		queue.add(3);
		queue.offer(1);
		queue.offer(2);
		System.out.println(queue);

		// remove is dangerous. poll is better.
		// remember null pointer exceptions.
		queue.remove();
		queue.poll();
		System.out.println(queue);

		System.out.println(queue.peek());
	}

}
