package views;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import models.entities.Element;
import structures.NodeTree;

public class ShowReport extends JDialog{

	private static final long serialVersionUID = 1L;
	private JTree jtree;
	private DefaultMutableTreeNode father, basket, volley, football;

	public ShowReport() {
		setLayout(new BorderLayout());
		setSize(400, 600);
		setTitle("Files Tree V 1.0");

		jtree = new JTree();
		jtree.setModel(null);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.add(jtree);

		father = new DefaultMutableTreeNode("Elements");

		football = new DefaultMutableTreeNode("football");
		volley = new DefaultMutableTreeNode("Volley");
		basket = new DefaultMutableTreeNode("basket");
		
		jtree.setModel(null);

		add(scrollPane, BorderLayout.CENTER);
	}

	public void setDatas(NodeTree<Element> node) {
		DefaultMutableTreeNode father = new DefaultMutableTreeNode("Elements");
		DefaultTreeModel model = new DefaultTreeModel(father);
		jtree.setModel(model);
		model.insertNodeInto(football, father, 0);
		model.insertNodeInto(volley, father, 1);
		model.insertNodeInto(basket, father, 2);
		
		for (NodeTree<Element> element : node.getNodeList()) {
			System.out.println(element.getNodeList().size()+ "     nombreeeeeeeeeeeeee");
			if(element.getInfo().getName().equals("basketBall")) {
				setChild(element, basket);
			}else if (element.getInfo().getName().equals("VolleyBall")) {
				setChild(element, volley);
			}else {
				setChild(element, football);
			}
		}
	}

	public void setChild(NodeTree<Element> node, DefaultMutableTreeNode UiNode) {
		for (NodeTree<Element> element : node.getNodeList()) {
			UiNode.add(new DefaultMutableTreeNode(element.getInfo().getName()));
//			model.insertNodeInto(, UiNode, i);
		}
		repaint();
	}
}