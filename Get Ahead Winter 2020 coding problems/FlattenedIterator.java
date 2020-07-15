import java.util.*;
import java.lang.*;

public class FlattenedIterator {
	private int len;
	private Iterator[] iterators;

	public FlattenedIterator(Iterator ... it) {
		this.len = it.length;
		this.iterators = it;
	}

	public List<Integer> flatten() {
		List<Integer> flattened = new ArrayList<>();
		if(this.len == 0) {
			return flattened; 
		}
		
		HashSet<Integer> finished = new HashSet<>();

		int pos = 0;
		while(true) {
			if(!finished.contains(pos)) {
				Iterator itr = this.iterators[pos];
				if(itr.hasNext()) {
					int n = (Integer)itr.next();
					flattened.add(n);
					itr.remove();
				} else {
					finished.add(pos);
				}
			}
			if(finished.size() == this.len) {
				break;
			}
			pos = (pos + 1) % this.len;
		}
		return flattened; //return or print here?
	}

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(6, 7, 8, 9));
		ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(10, 11, 12, 13, 14, 15));

		Iterator<Integer> it1 = list1.iterator();
		Iterator<Integer> it2 = list2.iterator();
		Iterator<Integer> it3 = list3.iterator();

		FlattenedIterator fi = new FlattenedIterator(it1, it2, it3);
		List<Integer> combinedList = fi.flatten();

		for(int i : combinedList) {
			System.out.print(i + " ");
		}
	}

}