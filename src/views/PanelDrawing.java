package views;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import constants.ConstantsUI;
import models.entities.Element;
import structures.ElementStack;
import structures.Node;

public class PanelDrawing extends JPanel{

	private static final long serialVersionUID = 1L;
	private ElementStack<Element> volley, basket, football;
	public PanelDrawing() {
		basket = new ElementStack<>();
	}

	@Override 
	public void paint(Graphics g) {
		super.paint(g);
		paintBasket(g);
		paintVolley(g);
		paintFootball(g);
		paintStore(g);
	}

	public void paintBasket(Graphics g) {
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

	public void paintFootball(Graphics g) {
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

	public void paintVolley(Graphics g) {
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

	private void paintStore(Graphics g) {
		Image img = new ImageIcon(getClass().getResource(ConstantsUI.STORE)).getImage();
		g.drawImage(img, 100, 65, this);
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
}