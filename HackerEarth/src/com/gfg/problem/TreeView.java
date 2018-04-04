package com.gfg.problem;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.tree.bst.BST.*;
import com.tree.bst.Node;

public class TreeView {

	public static void main(String[] args) {
		Node root = insertNode(null, 50);

		insertNode(root, 25);
		insertNode(root, 75);
		insertNode(root, 12);
		insertNode(root, 32);
		insertNode(root, 29);
		insertNode(root, 27);
		insertNode(root, 31);
		insertNode(root, 30);
//		insertNode(root, 76);
//		insertNode(root, 77);
//		insertNode(root, 78);
//		insertNode(root, 79);
//		insertNode(root, 80);
		
		traverseTree(root);

		ViewOfTree leftViewOfTree = new ViewOfTree(View.LEFT);
		leftViewOfTree.print(root);
		
		ViewOfTree rightViewOfTree = new ViewOfTree(View.RIGHT);
		rightViewOfTree.print(root);
	}

}
enum View{
	LEFT("Left"),RIGHT("Right");
	
	String value ;

	private View(String view) {
		this.value = view;
	}
	
}
class ViewOfTree{

	private Map<Integer,Node> hm;
	private View view ;
	
	public ViewOfTree (View view){
		this.hm = new LinkedHashMap<Integer, Node>();
		this.view = view;
	}
	
	public void print(Node root) {
		if(null == root)
			return ;
		
		print(root,0);
		System.out.printf("\n\n");
		System.out.println(this.view.value +" view of tree : ");
		for (Integer i : hm.keySet()) {
			System.out.printf(hm.get(i).data+" ");
		}
	}

	private void print(Node node, int i) {
		if(null == node)
			return ;
		
		if(!hm.containsKey(i)) {
			hm.put(i, node);
		}
		
		if(this.view == View.LEFT) {
			print(node.left, i+1);
			print(node.right, i+1);
		}else {
			print(node.right, i+1);
			print(node.left, i+1);
		}
		
	}
}