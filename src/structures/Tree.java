package structures;

import java.util.ArrayList;

public class Tree<T> {

	private NodeTree<T> root;
	private int i = 0;

	public Tree() {
		root = new NodeTree<T>(null, null);
	}

	public void add(NodeTree<T> node, T info) {
		if (root.getNodeList() != null && root.getNodeList().size() > 3) {
			search(info).addToList(node);
			System.out.println(search(info).
					getInfo().toString() 
					+ "nide + ---" + info.toString());
		}else {
			root.addToList(new NodeTree<T>(info, root));
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

	public NodeTree<T> search(T info){
		if(root != null) {
			if(root.getInfo() == null) {
				return root;
			}else {
				return search(info, root.getNodeList().get(0));
			}
		}
		System.out.println("retorna nuloooooo");
		return root;
	}

	private NodeTree<T> search(T info, NodeTree<T> nodeTree) {
		if(nodeTree.getNodeList() != null) {
			for (NodeTree<T> node : nodeTree.getNodeList()) {
				if(node.getInfo().equals(info)) {
					return node;
				}else {
					return search(info, node);
				}
			}
		}
		System.out.println("retorna nuloooooo en profundidad");
		return nodeTree;
	}

	public NodeTree<T> getRoot(){
		return root;
	}

}