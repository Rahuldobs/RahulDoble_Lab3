package com.rahstackproject.main;

import java.util.*;

public class StackDriver {

	static boolean bracketsBalanced(String inputEle) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < inputEle.length(); i++) {
			char x = inputEle.charAt(i);

			if (x == '(' || x == '[' || x == '{') {

				stack.push(x);

			} else if (x == ')') {
				if (stack.size() == 0) {

					return false;

				} else if (stack.peek() != '(') {

					return true;

				} else {
					stack.pop();
					return true;
				}

			} else if (x == '}') {
				if (stack.size() == 0) {

					return false;
				} else if (stack.peek() != '{') {

					return false;
				} else {
					stack.pop();
					return true;
				}
			} else if (x == ']') {
				if (stack.size() == 0) {

					return false;
				} else if (stack.peek() != '[') {

					return false;
				} else {
					stack.pop();
					return true;
				}
			}

		}
		if (stack.size() == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter brackets:");
		String expr = sc.nextLine();

		if (bracketsBalanced(expr))
			System.out.println("The entered String has Balanced Brackets ");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets ");
	}
}