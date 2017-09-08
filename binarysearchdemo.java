public class binarysearchdemo {

	public static void main(String[] args) {
	//	BinarySearchTree bst = new BinarySearchTree();
		binarysearchtree bst = new binarysearchtree();
    	bst.insert(5);
		bst.insert(3);
		bst.insert(4);
		bst.insert(2);
		bst.insert(8);
		bst.insert(9);
		bst.insert(7);
//		bst.insert(20);
//		bst.insert(15);
//		bst.insert(18);
//		System.out.println(bst.find(1));
		bst.inorder();
		System.out.println();
//		System.out.println();
//		System.out.println(bst.numOfLeafNodes());
//		bst.delete(3);
//		bst.inorder();
//		System.out.println();
//		System.out.println(bst.numOfLeafNodes());
		System.out.println(bst.height());
	}

}
