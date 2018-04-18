package controllers;

import models.dao.DaoManager;
import views.MainWindow;

public class Controller {
	private DaoManager daoManager;
	private MainWindow mainWindow;
	
	public Controller() {
		daoManager = new DaoManager();
		mainWindow  =  new MainWindow();
		
		daoManager.generateAllBasketBall(mainWindow.getQuantum());
		mainWindow.setBasket(daoManager.getBasketStcak());
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
