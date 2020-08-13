import java.util.Stack;

public class HistogramArea {

	//Class to store the start and end index of largest area
	public static class HistogramRange {
		public static int start;
		public static int end;

		public static HistogramRange(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public static String toString() {
			System.out.printf("(%d, %d)\n", this.start, this.end);
		}
	}

	public static String getLargestArea(int[] array) {
		//Stack holds indices of array. Indices are added if they are greater than top of stack
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		int startInd = 0;
		int endInd = 0;
		int indexAtTopOfStack;
		int tempArea;
		int tempAreaStart;
		int tempAreaEnd;
		int i = 0;

		while(i < array.length) {
			if(stack.empty() || array[i] >= array[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				//Come across a value less than top of stack, which limits area
				indexAtTopOfStack = stack.pop();

				//Calculates area that includes the popped bar
				int width = (stack.empty() ? i : i - stack.peek() - 1);
				tempArea = array[indexAtTopOfStack] * width;

				tempAreaEnd = i - 1;
				tempAreaStart = tempAreaEnd - width + 1;

				//Compare area just calculated to stored maxArea, and set new range if needed
				if(tempArea > maxArea) {
					maxArea = tempArea;
					startInd = tempAreaStart;
					endInd = tempAreaEnd;
				}
				//i is not incremented so we can calculate a new area  that extends backwards
				//using a equal or shorter bar with increasing width, if stack is not empty
			}
		}

		//Keep popping from stack and calculating new area using same logic as above
		while(!stack.empty()) {
			indexAtTopOfStack = stack.pop();
			int width = (stack.empty() ? i : i - stack.peek() - 1);
			tempArea = array[indexAtTopOfStack] * width;
			tempAreaEnd = i - 1;
			tempAreaStart = tempAreaEnd - width + 1;
			if(tempArea > maxArea) {
				maxArea = tempArea;
				startInd = tempAreaStart;
				endInd = tempAreaEnd;
			}
		}

		return new HistogramRange(startInd, endInd);
	}

	public static void main(String args[]) {
		int[] a = {2, 4, 2, 1};
		System.out.println("Should be max area = 6, start = 0, end = 2");
		HistogramRange ra = getLargestArea(a);
		ra.toString();
		System.out.println();

		int[] b = {2, 4, 2, 1, 10, 6, 10};
		System.out.println("Should be max area = 18, start = 4, end = 6");
		HistogramRange rb = getLargestArea(b);
		rb.toString();
		System.out.println();

		int[] c = {1, 1, 6, 1, 1};
		System.out.println("Should be max area = 6, start = 2, end = 2");
		HistogramRange rc = getLargestArea(c);
		rc.toString();
		System.out.println();
	}
}