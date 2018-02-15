
package Strings;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {

	class Node {
		int data;
		Node leftchild;
		Node rightchild;

		public Node(int n) {
			data = n;
		}

		public int getdata() {
			return data;
		}

		public Node getleftchild() {
			return leftchild;
		}

		public Node getrightchild() {
			return rightchild;
		}

		public void setleftchild(Node a) {
			leftchild = a;

		}

		public void setrightchild(Node a) {
			rightchild = a;
		}

		public Node setdata(int a) {
			return new Node(data = a);
		}

		public String toString() {
			return data + "";
		}

		public void inorder() {
			if (leftchild != null) {
				leftchild.inorder();
			}

			System.out.print(this + " ");

			if (rightchild != null) {
				rightchild.inorder();
			}
		}

		public void insert(int i) {
			if (i <= this.getdata()) {
				if (leftchild == null) {
					leftchild = new Node(i);
				} else {
					leftchild.insert(i);
				}
			} else {
				if (rightchild == null) {
					rightchild = new Node(i);
				} else {
					rightchild.insert(i);
				}
			}

		}

		public LinkedList<Node>[] linkedlist(LinkedList<Node>[] list, int count) {

			if (this.isLeaf()) {
				list[count].add(this);
				return list;
			}
			list[count].add(this);

			if (leftchild != null) {
				leftchild.linkedlist(list, count + 1);
			}

			if (rightchild != null) {
				rightchild.linkedlist(list, count + 1);
			}

			return list;
		}

		public int height() {
			if (isLeaf()) {
				return 1;
			}

			int left = 0;
			int right = 0;
			if (leftchild != null) {
				left = 1 + leftchild.height();
			}

			if (rightchild != null) {
				right = 1 + rightchild.height();
			}
			if (left > right) {
				return left;
			} else {
				return right;
			}

		}

		private boolean isLeaf() {
			return leftchild == null && rightchild == null;
		}

		public void zigzag(Stack<Node> s1, Stack<Node> s2) {
			s1.add(this);
			while (!s1.isEmpty()) {
				while (!s1.isEmpty()) {
					Node current = s1.pop();
					System.out.print(current + " ");
					if (current.rightchild != null) {
						s2.push(current.getrightchild());
					}
					if (current.leftchild != null) {
						s2.push(current.getleftchild());
					}

				}

				while (!s2.isEmpty()) {
					Node current = s2.pop();
					System.out.print(current + " ");
					if (current.leftchild != null) {
						s1.push(current.getleftchild());
					}
					if (current.rightchild != null) {
						s1.push(current.getrightchild());
					}
				}

			}

		}

		public int balancecheck() {
			if (this.isLeaf()) {
				return 1;
			}

			int left = 0;
			int right = 0;

			if (leftchild != null) {
				left = leftchild.balancecheck();
			}

			if (rightchild != null) {
				right = rightchild.balancecheck();
			}

			System.out.println(this + " " + left + " " + right);

			if (Math.abs(left - right) >= 0 && Math.abs(left - right) <= 1) {
				return (left > right) ? left + 1 : right + 1;
			} else {
				return Integer.MIN_VALUE;
			}

		}

		public boolean BSTCheck(int minValue, int maxValue) {
			if (this.isLeaf()) {
				if (this.getdata() > minValue && this.getdata() < maxValue) {
					return true;
				} else {
					return false;
				}
			}

			boolean left = true;
			boolean right = true;

			if (leftchild != null) {
				left = leftchild.BSTCheck(minValue, this.getdata());
			}

			if (rightchild != null) {
				right = rightchild.BSTCheck(this.getdata(), maxValue);
			}

			if (this.getdata() > minValue && this.getdata() < maxValue && left == true && right == true) {
				return true;
			} else {
				return false;
			}

		}

		public Node successor(int i, Node parent) {
			if (this.getdata() == i) {
				if (this.isLeaf()) {
					return parent;
				} else {
					if (this.rightchild != null) {
						Node a = this.getrightchild();
						while (a.leftchild != null) {
							a = a.getleftchild();
						}
						return a;
					} else {
						return parent;
					}

				}
			}
			Node a = this;
			if (leftchild != null && i <= this.getdata()) {
				parent = this;
				a = leftchild.successor(i, parent);
			} else {
				if (rightchild != null && i > this.getdata()) {
					a = rightchild.successor(i, parent);
				}
			}

			return a;
		}

		public Node comancestor(int i, int j) {

			if (this.getdata() == i || this.getdata() == j) {
				return this;
			}

			Node left = null;
			Node right = null;

			if (leftchild != null) {
				left = leftchild.comancestor(i, j);
			}

			if (rightchild != null) {
				right = rightchild.comancestor(i, j);
			}

			if (left != null && right != null) {
				return this;
			} else {
				if (left != null && right == null) {
					return left;
				} else {
					return right;
				}
			}

		}

		public boolean subtreecheck(Node root1, Node root2) {

			if (root1.getdata() != root2.getdata()) {
				return false;
			}

			boolean left = true;
			boolean right = true;

			if (root1.leftchild != null && root2.leftchild != null) {
				left = subtreecheck(root1.getleftchild(), root2.getleftchild());
			}

			if (root1.rightchild != null && root2.rightchild != null) {
				right = subtreecheck(root1.getrightchild(), root2.getrightchild());
			}

			if (left == true && right == true) {
				return true;
			} else {
				return false;
			}
		}

		public void pathsum(int i, Stack<Node> stack, int sum) {

			sum += this.getdata();
			stack.push(this);

			if (sum == i) {
				System.out.println(stack);
			}

			if (sum < i) {
				if (leftchild != null) {
					leftchild.pathsum(i, stack, sum);
				}

				if (rightchild != null) {
					rightchild.pathsum(i, stack, sum);
				}
			}

			sum = sum - stack.pop().getdata();
		}

		public void preorder(Queue<Node> queue) {
			queue.add(this);
			if (this.leftchild != null) {
				leftchild.preorder(queue);
			}

			if (this.rightchild != null) {
				rightchild.preorder(queue);
			}

		}

		public void inverse(Stack<Node> stack, Queue<Node> queue) {
			queue.offer(this);
			while (!queue.isEmpty()) {
				Node current = queue.poll();
				if (current.rightchild != null) {
					queue.offer(current.rightchild);
				}

				if (current.leftchild != null) {
					queue.offer(current.leftchild);
				}

				stack.push(current);

			}

			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
		}

		public void predecessor(int i, Node parent) {
			if (this.getdata() == i) {
				if (this.leftchild == null) {
					System.out.println(parent);
				} else {
					Node a = this.getleftchild();
					while (a.rightchild != null) {
						a = a.rightchild;
					}
					System.out.println(a);
				}
			}

			else if (leftchild != null && i < this.getdata()) {
				leftchild.predecessor(i, parent);
			}

			else if (rightchild != null && i > this.getdata()) {
				parent = this;
				rightchild.predecessor(i, parent);
			}
		}

		public void levelprint(Queue<Node> queue) {
			queue.add(this);
			while (!queue.isEmpty()) {
				Node current = queue.poll();
				if (current.leftchild != null) {
					queue.add(current.getleftchild());
				}

				if (current.rightchild != null) {
					queue.add(current.getrightchild());
				}

				System.out.print(current + " ");
			}

		}

		public void ancestor(int i, Stack<Node> stack) {
			if (this.getdata() == i) {
				while (!stack.isEmpty()) {
					System.out.print(stack.pop() + " ");
				}

			}

			else if (leftchild != null && i < this.getdata()) {
				stack.push(this);
				leftchild.ancestor(i, stack);
			}

			else if (rightchild != null && i > this.getdata()) {
				stack.push(this);
				rightchild.ancestor(i, stack);
			}

		}

		public int sumtree(int sum) {
			if (this.isLeaf()) {
				return this.getdata();
			}

			int left = 0;
			int right = 0;
			if (leftchild != null) {
				left = leftchild.sumtree(sum);
			}

			if (rightchild != null) {
				right = rightchild.sumtree(sum);
			}

			return left + right + this.getdata();

		}

		public int leafcount(int i) {
			if (this.isLeaf()) {
				return 1;
			}

			int left = 0;
			int right = 0;
			if (leftchild != null) {
				left = leftchild.leafcount(i);
			}

			if (rightchild != null) {
				right = rightchild.leafcount(i);
			}

			return left + right;

		}

		public int leafsum() {
			if (this.isLeaf()) {
				return this.getdata();
			}

			int left = 0;
			int right = 0;

			if (leftchild != null) {
				left = leftchild.leafsum();
			}

			if (rightchild != null) {
				right = rightchild.leafsum();
			}
			return left + right;
		}

		public void allpath(Stack<Node> stack) {

			stack.push(this);

			if (this.isLeaf()) {
				System.out.println(stack);
			}

			if (leftchild != null) {
				leftchild.allpath(stack);
			}

			if (rightchild != null) {
				rightchild.allpath(stack);
			}

			stack.pop();

		}

		public int kleaf(int i) {
			if (this.isLeaf()) {
				return 1;
			}

			int left = 0;
			int right = 0;

			if (leftchild != null) {
				left = leftchild.kleaf(i);
			}

			if (rightchild != null) {
				right = rightchild.kleaf(i);
			}

			if (left == 1 && right == 1) {
				System.out.print(this + " ");
			}
			return left + right;

		}

		public void BFS(Queue<Node> queue) {

			queue.add(this);
			while (!queue.isEmpty()) {

				Node current = queue.poll();
				System.out.print(current + " ");

				if (current.leftchild != null) {
					queue.add(current.leftchild);
				}

				if (current.rightchild != null) {
					queue.add(current.rightchild);
				}

			}
		}

		public int csequence(Node parent, int count, int maxlength) {

			int n = 0;
			count = this.getdata() == parent.getdata() + 1 ? count + 1 : 1;
			maxlength = Math.max(count, maxlength);
			
			System.out.println(this + " " + count + " " + maxlength);

			if (leftchild != null) {
				n = leftchild.csequence(this, count, maxlength);
			}

			if (rightchild != null) {
				n = rightchild.csequence(this, count, maxlength);
			}

			return n;

		}

		public void delete(int i) {
			Node current = this;
			Node parent = this;
			boolean left = true;
			while (current.getdata() != i) {
				if (i <= current.getdata()) {
					parent = current;
					left = true;
					current = current.getleftchild();
				} else {
					parent = current;
					left = false;
					current = current.getrightchild();
				}
			}

			if (current.isLeaf()) {
				if (left == true) {
					parent.setleftchild(null);
				} else {
					parent.setrightchild(null);
				}

			}

			if (current.leftchild != null && current.rightchild != null) {
				Node current2 = current.getrightchild();
				Node parent2 = current.getrightchild();

				while (current2.getleftchild() != null) {
					parent2 = current2;
					current2 = current2.getleftchild();
				}

				current = current.setdata(current2.getdata());
				parent2.setleftchild(null);

			}

			if (current.leftchild == null) {
				parent.setrightchild(current.getrightchild());
			}

			if (current.rightchild == null) {
				parent.setleftchild(current.getleftchild());
			}

		}

		public int diameter(Node parent, int maxlength) {
			if (this.isLeaf()) {
				return 0;
			}

			int left = 0;
			int right = 0;

			if (leftchild != null) {
				left = 1 + leftchild.diameter(this, maxlength);
			}

			if (rightchild != null) {
				right = 1 + rightchild.diameter(this, maxlength);
			}

			if (left + right > maxlength) {
				maxlength = left + right;
			}

			// int sum = Math.max(left + right + 1, maxlength);

			System.out.println(this + " " + "left " + left + " right " + right + " maxlength " + maxlength);

			if (parent == null) {
				System.out.println(maxlength);
			}

			if (left > right) {
				return left;
			} else {
				return right;
			}
		}

	}

	public class tree {

		Node root = null;

		public void inorder() {
			if (root == null) {
				return;
			} else {
				root.inorder();
			}

		}

		public void insert(int i) {
			if (root == null) {
				root = new Node(i);
			} else {
				root.insert(i);
			}
		}

		public void linkedlist() {
			if (root == null) {
				return;
			} else {
				@SuppressWarnings("unchecked")

				LinkedList<Node>[] list = new LinkedList[height()];
				for (int i = 0; i < list.length; i++) {
					list[i] = new LinkedList<Node>();
				}
				root.linkedlist(list, 0);
				for (int i = 0; i < list.length; i++) {
					System.out.println(list[i]);
				}
			}

		}

		private int height() {
			int n = 0;
			if (root == null) {
				return n;
			} else {
				n = root.height();
			}
			return n;
		}

		public void zigzag() {
			if (root == null) {
				return;
			}
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			root.zigzag(s1, s2);

		}

		public void balancecheck() {
			if (root == null) {
				return;
			} else {
				int n = root.balancecheck();
				System.out.println(n);
				if (n > 0) {
					System.out.println("Balanced");
				} else {
					System.out.println("Not Balanced");
				}
			}

		}

		public void BSTCheck() {
			if (root == null) {
				return;
			} else {
				boolean a = root.BSTCheck(Integer.MIN_VALUE, Integer.MAX_VALUE);
				if (a) {
					System.out.println("BST");
				} else {
					System.out.println("Not BST");
				}
			}

		}

		public void successor(int i) {
			if (root == null) {
				return;
			} else {
				Node parent = null;
				System.out.println(root.successor(i, parent));
			}

		}

		public void comancestor(int i, int j) {
			if (root == null) {
				return;
			} else {
				System.out.println(root.comancestor(i, j));
			}

		}

		public void subtreecheck(tree t, tree t2) {
			if (root == null) {
				return;
			} else {
				Node t1 = find(t.root, t2.root);
				System.out.println(root.subtreecheck(t1, t2.root));
			}

		}

		private Node find(Node root1, Node root2) {
			while (root1.getdata() != root2.getdata()) {
				if (root2.getdata() < root1.getdata()) {
					root1 = root1.getleftchild();
				} else {
					root1 = root1.getrightchild();
				}
			}

			return root1;
		}

		public void pathsum(int i) {
			if (root == null) {
				return;
			} else {
				Stack<Node> stack = new Stack<Node>();
				int sum = 0;
				Queue<Node> queue = new LinkedList<BST.Node>();
				root.preorder(queue);
				System.out.println(queue);
				while (!queue.isEmpty()) {
					queue.poll().pathsum(i, stack, sum);
				}

			}

		}

		public void inverse() {
			if (root == null) {
				return;
			} else {
				Stack<Node> stack = new Stack<Node>();
				Queue<Node> queue = new LinkedList<Node>();
				root.inverse(stack, queue);
			}
		}

		public void predecessor(int i) {
			if (root == null) {
				return;
			} else {
				Node parent = null;
				root.predecessor(i, parent);
			}

		}

		public void levelprint() {
			if (root == null) {
				return;
			} else {
				Queue<Node> queue = new LinkedList<>();
				root.levelprint(queue);
			}

		}

		public void ancestor(int i) {
			if (root == null) {
				return;
			} else {
				Stack<Node> stack = new Stack<Node>();
				root.ancestor(i, stack);
			}

		}

		public void sumtree() {
			if (root == null) {
				return;
			} else {
				int sum = 0;
				System.out.println(root.sumtree(sum));
			}

		}

		public void leafcount() {
			if (root == null) {
				return;
			} else {
				System.out.println(root.leafcount(0));
			}

		}

		public void leafsum() {
			if (root == null) {
				return;
			} else {
				System.out.println(root.leafsum());
			}

		}

		public void allpath() {
			if (root == null) {
				return;
			} else {
				Stack<Node> stack = new Stack<Node>();
				root.allpath(stack);
			}

		}

		public void kleaf(int i) {
			if (root == null) {
				return;
			} else {
				root.kleaf(i);
			}

		}

		public void BFS() {
			if (root == null) {
				return;
			} else {
				Queue<Node> queue = new LinkedList<>();
				root.BFS(queue);
			}

		}

		public void csequenece() {
			if (root == null) {
				return;
			} else {
				int count = 0;
				int maxlength = 0;
				System.out.println(root.csequence(root, count, maxlength));
			}

		}

		public void delete(int i) {
			if (root == null) {
				return;
			} else {
				root.delete(i);
			}

		}

		public void diameter() {
			if (root == null) {
				return;
			} else {
				root.diameter(null, 0);
			}

		}
	}

	public static void main(String[] args) {
		tree t = new BST().new tree();
	//	tree t2 = new BST().new tree();
		t.insert(5);
		t.insert(3);
		t.insert(4);
		t.insert(2);
		// t.insert(8);

		t.insert(8);
		t.insert(7);
		t.insert(9);
		 t.insert(10);
		 t.insert(12);
		 t.insert(13);
		 t.insert(14);

		// t.insert(6);
		// t.insert(10);
		// t.insert(20);
		// t.insert(11);
		// t.insert(12);

//		t.insert(200);
//		t.insert(250);
//		t.insert(150);
//		t.insert(120);
//		t.insert(170);
//		t.insert(160);
//		t.insert(190);
//		t2.insert(200);
//		t2.insert(250);
//		t2.insert(150);
//		t2.insert(120);
//		t2.insert(170);
//		t2.insert(160);
//		t2.insert(190);

		// t.linkedlist(); // creates a linked list of nodes at same height.
		// t.inorder();
		// t.zigzag(); // prints nodes in zigzag order
		// t.balancecheck(); // checks if tree is balanced or not
		// t.BSTCheck(); // checks if tree is BST
		// t.successor(5); // gives the successor node of the given node.
		// t.comancestor(2, 9); // finds common ancestor of 2 nodes.
		// t.subtreecheck(t, t2); // checks if t2 is subtree of t.
		// t.pathsum(7); // gives all paths having the sum
		// t.inverse(); // prints the tree in inverse order, leaves to root
		// t.predecessor(7); // here a predecessor of a node is printed.
		// t.levelprint(); // prints the tree level by level.
		// t.ancestor(5); // print all ancestor of given node.
		// t.sumtree(); // gives the sum of the whole tree.
		// t.leafcount(); // count number of leaf nodes.
		// t.leafsum(); // gives sum of leaf.
		// t.allpath(); // print all path from root.
		// t.kleaf(2); // prints only that node which has 2 leaf.
		// t.BFS();
		// t.csequenece(); // gives the length of maximum continuous sequence.
		// t.delete(9); // deletes a node from the tree.
		// t.inorder();
		 t.diameter(); // finds the longest path in a tree.

	}

}

