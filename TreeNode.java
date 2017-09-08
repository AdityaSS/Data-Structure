package Datastructure;

public class TreeNode {

	Integer data;
	TreeNode leftchild;
	TreeNode rightchild;
	boolean isDeleted = false;

	public TreeNode(Integer a) {
		data = a;
	}

	public TreeNode find(Integer a) {
		if (data == a && isDeleted == false) {
			return this;
		} else if (a < data && leftchild != null) {
			return leftchild.find(a);
		} else if (a > data && rightchild != null) {
			return rightchild.find(a);
		}
		return null;
	}

	public Integer smallest() {
		if (leftchild == null) {
			return data;
		}
		return leftchild.smallest();
	}
	
	public void traverseInOrder() {
		if (this.leftchild != null)
			this.leftchild.traverseInOrder();
		System.out.print(this + " ");
		if (this.rightchild != null)
			this.rightchild.traverseInOrder();
	}
	
	public Integer largest() {
		if (rightchild == null) {
			return data;
		}
		return rightchild.largest();
	}
	
	public String toString() {
		return String.valueOf(this.data);
	}


	public void insert(Integer a) {
		if (a >= data) {
			if (rightchild == null) {
				rightchild = new TreeNode(a);
			} else {
				rightchild.insert(a);
			}

		} else {
			if (leftchild == null) {
				leftchild = new TreeNode(a);
			} else {
				leftchild.insert(a);
			}
		}
	}

	public Integer getData() {
		return data;
	}

	public void setLeftChild(TreeNode a) {
		leftchild = a;
	}

	public void setRightChild(TreeNode a) {
		rightchild = a;
	}

	public TreeNode getLeftChild() {
		return leftchild;
	}

	public TreeNode getRightChild() {
		return rightchild;
	}

	public void delete() {
		isDeleted = true;
	}

	public boolean isDeleted() {
		return isDeleted;
	}
}
