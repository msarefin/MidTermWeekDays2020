package datastructure;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */

		Queue q = new ArrayDeque();

		q.add("First");
		q.add("Second");
		q.add("Third");
		q.add("Fourth");

		System.out.println(q.toString());

		q.add("Alex");
		System.out.println(q.toString());

		q.offer("James");

		System.out.println(q.toString());

		q.poll();
		System.out.println(q.toString());

	}

}
