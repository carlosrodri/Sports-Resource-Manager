package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import constants.ConstantsUI;
import models.entities.Element;
import models.entities.Petition;
import models.entities.Student;
import structures.ElementStack;
import structures.Node;
import structures.Queue;

public class PanelDrawing extends JPanel{

	private static final long serialVersionUID = 1L;
	private ElementStack<Element> volley, basket, football;
	private Queue<Student> student;
	private Queue<Petition> petition;
	private int y;
	private Graphics gr;
	public PanelDrawing() {
		basket = new ElementStack<>();
		student = new Queue<>();
		petition = new Queue<>();
	}

	@Override 
	public void paint(Graphics g) {
		super.paint(g);
		gr = g;
		setPreferredSize(new Dimension(getWidth(), y));
		paintBasket(g);
		paintVolley(g);
		paintFootball(g);
		paintStudent(g);
		paintPetition(g);
		paintStore(g);
	}

	private void paintBasket(Graphics g) {
		int x = 250; int y = 20;
		if(basket != null) {
			Node<Element> current = basket.getHead();
			Image img = new ImageIcon(getClass().getResource(ConstantsUI.BASKET)).getImage();
			while (current != null) {
				g.drawImage(img, x, y, this);
				current = current.getNext();
				x += 40;
			}
		}
	}

	private void paintFootball(Graphics g) {
		int x = 250; int y = 70;
		if(football != null) {
			Node<Element> current = football.getHead();
			Image img = new ImageIcon(getClass().getResource(ConstantsUI.FOOTBALL)).getImage();
			while (current != null) {
				g.drawImage(img, x, y, this);
				current = current.getNext();
				x += 40;
			}
		}
	}

	private void paintVolley(Graphics g) {
		int x = 250; int y = 110;
		if(volley != null) {
			Node<Element> current = volley.getHead();
			Image img = new ImageIcon(getClass().getResource(ConstantsUI.VOLLEY)).getImage();
			while (current != null) {
				g.drawImage(img, x, y, this);
				current = current.getNext();
				x += 40;
			}
		}
	}

	private void paintStudent(Graphics g) {
		int x = 100; int y = 180;
		if(student != null) {
			Node<Student> current = student.getHead();
			Image img = new ImageIcon(getClass().getResource(ConstantsUI.PEOPLE)).getImage();
			while (current != null) {
				g.drawImage(img, x, y, this);
				current = current.getNext();
				y += 60;
				this.y = y;
			}
		}
	}
	
	private void paintPetition(Graphics g){
		int x = 1000; int y = 180;
		if(petition != null) {
			Node<Petition> current = petition.getHead();
			Image img = new ImageIcon(getClass().getResource(ConstantsUI.PLAY)).getImage();
			while (current != null) {
				g.drawImage(img, x, y, this);
				current = current.getNext();
				y += 60;
				this.y = y;
			}
		}
	}

	private void paintStore(Graphics g) {
		Image img = new ImageIcon(getClass().getResource(ConstantsUI.STORE)).getImage();
		g.drawImage(img, 100, 65, this);
	}

	public void showGif() {
		gr.drawImage(new ImageIcon(getClass().getResource(ConstantsUI.GIF)).getImage(), 100, 70, this);
	}
	public void setBasket(ElementStack<Element> basket) {
		this.basket = basket;
	}
	public void setVolley(ElementStack<Element> volley) {
		this.volley = volley;
	}
	public void setFootball(ElementStack<Element> football) {
		this.football = football;
	}

	public void setStudents(Queue<Student> studentQueue) {
		this.student = studentQueue;
	}

	public void setPetition(Queue<Petition> petition) {
		this.petition = petition;
	}

}