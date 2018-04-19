package views;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import constants.ConstantsUI;
import controllers.Actions;
import controllers.Controller;
import models.entities.Element;
import structures.ElementStack;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelDrawing panelDrawing;
	private JSpinner spinner;
	private SpinnerNumberModel numberModel;
	private JButton btnAccept;
	
	public MainWindow(Controller controller) {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		numberModel = new SpinnerNumberModel(1, 1, 15, 1);
		spinner = new JSpinner(numberModel);
		
		btnAccept = new JButton(ConstantsUI.ACCEPT_TEXT);
		btnAccept.setActionCommand(Actions.ACCEPT.toString());
		btnAccept.addActionListener(controller);
		add(btnAccept, BorderLayout.SOUTH);
		
		panelDrawing = new PanelDrawing();
		
		add(panelDrawing, BorderLayout.CENTER);
		add(spinner, BorderLayout.PAGE_START);
		setVisible(true);
	}

	public void setBasket(ElementStack<Element> basket) {
		panelDrawing.setBasket(basket);
		panelDrawing.repaint();
	}
	
	public void setVolley(ElementStack<Element> volleyStack) {
		panelDrawing.setVolley(volleyStack);
		panelDrawing.repaint();
	}

	public void setFootball(ElementStack<Element> footballStack) {
		panelDrawing.setFootball(footballStack);
		panelDrawing.repaint();
	}
	
	public int getQuantum() {
		return Integer.parseInt(spinner.getValue().toString());
	}
}
