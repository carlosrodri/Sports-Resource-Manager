package structures;

import java.util.ArrayList;

public class Tree<T> {

	private NodeTree<T> root;
	private int i = 0;
	
	public Tree() {
		root = new NodeTree<T>(null, null);
	}

	public void add(NodeTree<T> node) {
		if (root != null) {
			NodeTree<T> current = root;
			if(node.getFatherNode() != null && node.getFatherNode().equals(current)) {
				current.addToList(node);
//				root = node;
//				add(node, current);
			}else {
				System.out.println(current.getInfo().toString() + "  padreeeeee rooot");
				current.addToList(node);
			}
		}else {
			root = node;
		}
		i++;
	}

//	private void add(NodeTree<T> node, NodeTree<T> fatherNode) {
//		fatherNode.addToList(node);
//	}

	public void print(NodeTree<T> node) {
		if (node.getNodeList() != null) {
			System.out.println(node.getInfo() + "    padre");
			printList(node.getNodeList());
		}else {
			System.out.println(node.getInfo().toString());
		}
	}

	private void printList(ArrayList<NodeTree<T>> list) {
		for (NodeTree<T> node : list) {
			System.out.println(node.getInfo() + "    hijo");
//			print(node);
		}
	}
	
	public NodeTree<T> getRoot(){
		return root;
	}
	
}