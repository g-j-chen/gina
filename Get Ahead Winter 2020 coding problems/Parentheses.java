import java.util.*;

public class Parentheses {

	//Assuming the given string will only contain parentheses.
	public static int longestBalancedParentheses(String input) {
		if(input == null || input.isEmpty()) {
			return 0;
		}
		//The stack keeps track of indices of opening parentheses that we have
		//not yet come across a closing parentheses for.
		Stack<Integer> stack = new Stack<>();
		//Initially, push value of -1 as a sort of bookend -
		//this indicates the longest contiguous substring of balanced parentheses starts at index 0
		stack.push(-1);
		int max = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
			}

			//Check if the stack is empty
			//If it is empty, this means there were more ')' than '(',
			//and would not be a valid substring if the character at i is included.
			//So we set i to be the new bookend.
			if(!stack.empty()) {
				max = Math.max(max, i - stack.peek());
			} else {
				stack.push(i);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println("longest for '())(())' should be 4: " + longestBalancedParentheses("())(())"));
		System.out.println("longest for ')(()))))(((()' should be 4: " + longestBalancedParentheses(")(()))))(((()"));
		System.out.println("longest for '))))(((()' should be 2: " + longestBalancedParentheses("))))(((()"));
		System.out.println("longest for '' should be 0: " + longestBalancedParentheses(""));
		System.out.println("longest for 'null' should be 0: " + longestBalancedParentheses(null));
		System.out.println("longest for '    ' should be 0: " + longestBalancedParentheses("    "));
		System.out.println("longest for '()())' should be 4: " + longestBalancedParentheses("()())"));
		System.out.println("longest for ')()()(()))' should be 8: " + longestBalancedParentheses(")()()(()))"));
		System.out.println("longest for '()((())' should be 4: " + longestBalancedParentheses("()((())"));
	}
}