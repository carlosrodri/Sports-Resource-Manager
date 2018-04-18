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

	}

	public void paintBasket(Graphics g) {
		int x = 25; int y = 20;
		if(basket != null) {
			Node<Element> current = basket.getHead();
			Image img = new ImageIcon(getClass().getResource(ConstantsUI.BASKET)).getImage();
			while (current != null) {
				g.drawImage(img, x, y, this);
				current = current.getNext();
				y += 40;
			}
		}
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