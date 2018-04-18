package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.entities.Element;
import structures.ElementStack;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelDrawing panelDrawing;
	
	public MainWindow() {
		setExtendedState(MAXIMIZED_BOTH);
		
		panelDrawing = new PanelDrawing();
		
		add(panelDrawing, BorderLayout.CENTER);
		setVisible(true);
	}

	public void setBasket(ElementStack<Element> basket) {
		panelDrawing.setBasket(basket);
		panelDrawing.repaint();
	}
	
	public int getQuantum() {
		return Integer.parseInt(JOptionPane.showInputDialog("input the quantum"));
	}
}
