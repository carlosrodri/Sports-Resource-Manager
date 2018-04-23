package views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import constants.ConstantsUI;
import controllers.Actions;
import controllers.Controller;
import models.entities.Element;
import models.entities.Petition;
import models.entities.Student;
import structures.ElementStack;
import structures.Queue;
import structures.Tree;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelDrawing panelDrawing;
	private JSpinner spinner, spinnerStudents;
	private SpinnerNumberModel numberModel, model;
	private JButton btnAccept, btnStop;
	private JScrollPane scrollPane;
	private ShowReport showReport;


	public MainWindow(Controller controller) {
		GridSystem gridSystem = new GridSystem(this);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource(ConstantsUI.ICON)).getImage());
		setTitle(ConstantsUI.TITLE);
		
		showReport = new ShowReport();
		
		numberModel = new SpinnerNumberModel(1, 1, 15, 1);
		model = new SpinnerNumberModel(1, 1, 15, 1);

		spinner = new JSpinner(numberModel);
		spinner.setBorder(new TitledBorder(ConstantsUI.NUMBER_OF_BALLS));

		spinnerStudents = new JSpinner(model);
		spinnerStudents.setBorder(new TitledBorder(ConstantsUI.NUMBER_OF_STUDENTS));

		btnAccept = new JButton(new ImageIcon(getClass().getResource(ConstantsUI.START_BUTTON)));
		btnAccept.setToolTipText(ConstantsUI.ACCEPT_TEXT);
		btnAccept.setActionCommand(Actions.ACCEPT.toString());
		btnAccept.addActionListener(controller);
		btnAccept.setBackground(Color.WHITE);
		btnAccept.setBorder(null);

		btnStop = new JButton(new ImageIcon(getClass().getResource(ConstantsUI.STOP_BUTTON)));
		btnStop.setToolTipText(ConstantsUI.STOP);
		btnStop.setActionCommand(Actions.STOP.toString());
		btnStop.setBackground(Color.WHITE);
		btnStop.addActionListener(controller);
		
		panelDrawing = new PanelDrawing();
		scrollPane = new JScrollPane(panelDrawing);

		add(scrollPane, gridSystem.insertComponent(0, 0, 12, 0.9));
		add(spinner, gridSystem.insertComponent(1, 0, 1, 0.01));
		add(spinnerStudents, gridSystem.insertComponent(2, 0, 1, 0.01));
		add(btnAccept, gridSystem.insertComponent(1, 1, 1, 0.01));
		add(btnStop, gridSystem.insertComponent(2, 1, 1, 0.01));
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

	public int getQuantumStudents() {
		return Integer.parseInt(spinnerStudents.getValue().toString());
	}

	public void setStudents(Queue<Student> studentQueue) {
		panelDrawing.setStudents(studentQueue);
		panelDrawing.repaint();
		scrollPane.setViewportView(panelDrawing);
	}

	public void setPetition(Queue<Petition> petition) {
		panelDrawing.setPetition(petition);
		panelDrawing.repaint();
		scrollPane.setViewportView(panelDrawing);
	}

	public void stopSimulation() {
		panelDrawing.repaint();
	}

	public void repaintPanel() {
		panelDrawing.repaint();
	}

	public void paintTime(int tIme) {
		panelDrawing.setTime(tIme);
		panelDrawing.repaint();
	}
	
	public void setDatas(Tree<Element> tree) {
		showReport.setDatas(tree.getRoot());
		showReport.setVisible(true);
	}
}
