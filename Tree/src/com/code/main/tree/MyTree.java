package com.code.main.tree;

public class MyTree {

	class Node {

		private Node left;
		private Node right;
		private Integer data;

		public Node() {
		}

		private Node(int data) {
			this.data = data;

		}

		public void addNode(int value) {

			if (this.data <= value) {

				if (this.left == null) {
					this.left = new Node(value);
				} else {
					this.left.addNode(value);
				}
			} else {
				if (this.right == null)
					this.right = new Node(value);
				else
					this.right.addNode(value);
			}
		}

	}

	public void printNode(Node node) {

		if (node != null) {
			System.out.print(node.data + ",");
			printNode(node.left);
			printNode(node.right);
		}

	}

	public static void main(String[] args) {

		MyTree myTree = new MyTree();

		MyTree.Node node = myTree.new Node();
		node.addNode(1);
		node.addNode(3);
		node.addNode(2);
		node.addNode(4);
		node.addNode(5);

		myTree.printNode(node);
	}
}
