package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import models.dao.DaoManager;
import views.MainWindow;

public class Controller implements ActionListener{
	private DaoManager daoManager;
	private MainWindow mainWindow;
	private Timer timer;

	public Controller() {
		daoManager = new DaoManager();
		mainWindow  =  new MainWindow(this);
	}

	public static void main(String[] args) {
		new Controller();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand())) {
		case ACCEPT:
			acceptSimulation();
			try {
				addPetition();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		}
	}

	private void addPetition() throws Exception {
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!daoManager.validate()) {
					try {
						daoManager.addPetition(randomBalls());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					mainWindow.setPetition(daoManager.getRequestQueue());
				}else {
					timer.stop();
					mainWindow.stopSimulation();
				}
			}
		});
		timer.start();
	}

	private String randomBalls() {
		int num = (int) (Math.random() * 3);
		String [] names={"Basket", "volley", "football"};
		System.out.println(num + "balones");

		return names[num];
	}

	private void acceptSimulation() {
		daoManager.generateAllElements(mainWindow.getQuantum(), mainWindow.getQuantumStudents());
		mainWindow.setBasket(daoManager.getBasketStcak());
		mainWindow.setVolley(daoManager.getVoleyStack());
		mainWindow.setFootball(daoManager.getFootballStack());
		mainWindow.setStudents(daoManager.getStudentQueue());
	}
}
