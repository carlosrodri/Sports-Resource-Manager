package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.dao.DaoManager;
import views.MainWindow;

public class Controller implements ActionListener{
	private DaoManager daoManager;
	private MainWindow mainWindow;
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
			break;
		}
	}

	private void acceptSimulation() {
		daoManager.generateAllBalls(mainWindow.getQuantum());
		mainWindow.setBasket(daoManager.getBasketStcak());
		mainWindow.setVolley(daoManager.getVoleyStack());
		mainWindow.setFootball(daoManager.getFootballStack());
	}
}
