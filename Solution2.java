package ericsson_test;

import java.util.Stack;

public class Solution2 {
	public static void main(String[] args) {
		// Correct strings.
		for (String testStr : new String[] { "()((()()))", "(()(())())", "()", "(())" }) {
			System.out.println(solution(testStr) ? "1" : "0");
		}
		
		// Incorrect strings.
		for (String testStr : new String[] { "()((())()))", "()))", "(()" }) {
			System.out.println(solution(testStr) ? "1" : "0");
		}
	}

	public static boolean solution(String str) {
		if (str == null || "".equals(str)) {
			return true;
		}
		
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			switch (ch) {
			case '(':
				stack.push(ch);
				break;
			
			case ')':
				if (stack.size() <= 0) {
					return false;
				}
				stack.pop();
				break;

			default:
				return false;
			}
		}
		
		if (stack.size() > 0) {
			return false;
		}
		
		return true;
	}
}
