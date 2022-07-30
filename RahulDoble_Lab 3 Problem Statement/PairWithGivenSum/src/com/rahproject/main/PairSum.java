package com.rahproject.main;

import java.util.HashSet;
import java.util.Scanner;

public class PairSum {
	public static class Node {
		int nodeData;
		Node leftNode;
		Node rightNode;
	};

	public static Node NewNode(int nodeData) {
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}

	public Node insert(Node root, int key) {
		if (root == null)
			return NewNode(key);
		if (key < root.nodeData)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}

	public boolean findPair(Node root, int sum, HashSet<Integer> set) {
		// TODO Auto-generated method stub
		if (root == null) {
			return false;
		}
		if (findPair(root.leftNode, sum, set)) {
			return true;
		}
		if (set.contains(sum - root.nodeData)) {
			System.out.println("Pair is found (" + (sum - root.nodeData) + "," + " " + root.nodeData + ") ");
			return true;
		} else
			set.add(root.nodeData);

		return findPair(root.rightNode, sum, set);
	}

	public void findPairWithGivenSum(Node root, int sum) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<>();
		if (!findPair(root, sum, set))
			System.out.println("Pairs do not exit" + "\n");
	}

	public static void main(String[] args) {
		Node root = null;
		Scanner sc = new Scanner(System.in);

		PairSum findSP = new PairSum();
		root = findSP.insert(root, 40);
		root = findSP.insert(root, 20);
		root = findSP.insert(root, 60);
		root = findSP.insert(root, 10);
		root = findSP.insert(root, 30);
		root = findSP.insert(root, 50);
		root = findSP.insert(root, 70);

		System.out.println("Enter the sum you want to search:");
		int sum = sc.nextInt();
		findSP.findPairWithGivenSum(root, sum);
	}

}
