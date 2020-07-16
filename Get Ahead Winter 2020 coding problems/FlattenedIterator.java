import java.util.*;
import java.lang.*;

/**
* Flattened Iterator for integers
* Example usage:
*	//Instantiate FlattenedIterator
*	FlattenedIterator fi =
*			new FlattenedIterator(				
*				[1, 2, 3],
*				[4, 5],
*				[6, 7, 8]);
*
*	while(fi.hasNext()) {
*		System.out.print(fi.next() + " ");
*	}
*
*	//Output
*	1 4 6 2 5 7 3 8
*	
* Time complexity:
*	O(m) to instantiate FlattenedIterator, where m = number of Iterators given
*	O(1) to determine if FlattenedIterator has more elements
*	O(n) to iterate over all the elements
*	Total time complexity to instantiate and iterate over all the elements: O(m + n)
*/
public class FlattenedIterator {

	/**
	* A queue is used to cycle through Iterators that still have elements in their iteration. 
	*/
	private Queue<Iterator> queue;

	/**
	* Arguments taken: variable number of Iterators, arguments must not be null (not sure if a null Iterator is possible, though).
	* 				   input Iterators can be empty (they'll just get dropped).
	* Assumption: The Iterators are given in the desired order to be interleaved.
	*/
	public FlattenedIterator(Iterator ... iterators) {
		this.queue = new LinkedList<>();
		for(Iterator it : iterators) {
			if(it.hasNext()) {
				this.queue.add(it);
			}
		}
	}

	public boolean hasNext() {
		return this.queue.size() > 0;
	}

	public int next() {
		Iterator it = this.queue.remove();
		int n = (Integer)it.next();
		if(it.hasNext()) {
			this.queue.add(it);
		}
		return n;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(6, 7));
		ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(10, 11, 12));

		Iterator<Integer> it1 = list1.iterator();
		Iterator<Integer> it2 = list2.iterator();
		Iterator<Integer> it3 = list3.iterator();

		FlattenedIterator fi = new FlattenedIterator(it1, it2, it3);

		while(fi.hasNext()) {
			System.out.print(fi.next() + " ");
		}
	}
}