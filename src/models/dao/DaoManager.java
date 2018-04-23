package models.dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import constants.ConstantsUI;
import models.entities.Element;
import models.entities.Petition;
import models.entities.Student;
import structures.ElementStack;
import structures.NodeList;
import structures.Queue;
import structures.Tree;

public class DaoManager {
	private Queue<Student> studentQueue;
	private Queue<Petition> requestQueue;
	private ElementStack<Element> footballStack, basketStcak, voleyStack;
	private String list;
	private Timer timer;
	private Tree<Element> tree;
	private Queue<Petition> report;
	private int seconds;

	public DaoManager() {
		requestQueue = new Queue<>();
		studentQueue = new Queue<>();
		footballStack = new ElementStack<>();
		basketStcak = new ElementStack<>();
		voleyStack = new ElementStack<>();
		report = new Queue<>();
		tree = new Tree<>();
	}

	private void generateAllStudents(int quantumStudents){
		studentQueue.clear();
		for (int i = 0; i < quantumStudents; i++) {
			studentQueue.enqueue(new NodeList<Student>(new Student(generateCode(), getName())));
		}
	}

	private void generateAllBallFootball(int quantum){
		footballStack.clear();
		for (int i = 0; i < quantum; i++) {
			footballStack.push(new NodeList<Element>(new Element(i, "footballBall")));
		}
	}

	private void generateAllBasketBall(int quantum){
		basketStcak.clear();
		for (int i = 0; i < quantum; i++) {
			basketStcak.push(new NodeList<Element>(new Element(i, "basketBall")));
		}
	}

	private void generateAllBallVolley(int quantum){
		voleyStack.clear();
		for (int i = 0; i < quantum; i++) {
			voleyStack.push(new NodeList<Element>(new Element(i, "VolleyBall")));
		}
	}

	public void addPetition(String element) throws Exception {
		switch (element) {
		case "volley":
			addVolley();
			break;
		case "Basket":
			addBasket();
			break;
		case "football":
			addFootball();
			break;
		}
	}

	public void generateAllElements(int quantum, int quantumStudents) {
		generateAllBasketBall(quantum);
		generateAllBallVolley(quantum);
		generateAllBallFootball(quantum);
		generateAllStudents(quantumStudents);
	}

	private int generateRandomTime() {
		return (int) (Math.random() * 10000) + 1000;
	}

	private String getName() {
		return ConstantsUI.names[(int)(Math.random()*ConstantsUI.names.length-1)];
	}

	private void addFootball() throws Exception {
		Petition petition = new Petition(studentQueue.dequeue().getInformation(),footballStack.pop().getInformation(), getTIme());
		requestQueue.enqueue(new NodeList<Petition>(petition));
	}

	private void addBasket() throws Exception {
		Petition petition = new Petition(studentQueue.dequeue().getInformation(),basketStcak.pop().getInformation(), getTIme());
		requestQueue.enqueue(new NodeList<Petition>(petition));
	}

	private void addVolley() throws Exception {
		Petition petition = new Petition(studentQueue.dequeue().getInformation(),voleyStack.pop().getInformation(), getTIme());
		requestQueue.enqueue(new NodeList<Petition>(petition));
	}

	public ElementStack<Element> getVoleyStack() {
		return voleyStack;
	}

	public ElementStack<Element> getBasketStcak() {
		return basketStcak;
	}

	public ElementStack<Element> getFootballStack() {
		return footballStack;
	}

	public Queue<Student> getStudentQueue() {
		return studentQueue;
	}

	public Queue<Petition> getRequestQueue() {
		return requestQueue;
	}

	public boolean validate() {
		if(studentQueue.isEmpty()) {
			list = "student";
			return true;
		}else if (footballStack.isEmpty()) {
			list = "football";
			return true;
		}else if(basketStcak.isEmpty()) {
			list = "basket";
			return true;
		}else if(voleyStack.isEmpty()) {
			list = "volley";
			return true;
		}else {
			return false;
		}
	}

	public String randomBalls() {
		int num = (int) (Math.random() * 3);
		String [] names={"Basket", "volley", "football"};
		return names[num];
	}

	public void restartLists() {
		switch (list) {
		case "volley":
			pushVolley();
			break;
		case "basket":
			pushBasket();
			break;
		case "football":
			pushFootball();
			break;
		case "student":
			addStudent();
			break;
		}
	}

	private void addStudent() {
		studentQueue.enqueue(new NodeList<Student>(new Student(generateCode(), getName())));
	}

	private int generateCode() {
		return (int)(Math.random()*500);
	}

	private void pushFootball() {
		Petition request = requestQueue.dequeue().getInformation();
		request.setSeconds(getTIme()-request.getSeconds());
		report.enqueue(new NodeList<Petition>(request));
		footballStack.push(new NodeList<Element>(request.getElement()));
	}

	private void pushBasket() {
		Petition request = requestQueue.dequeue().getInformation();
		request.setSeconds(getTIme()-request.getSeconds());
		report.enqueue(new NodeList<Petition>(request));
		basketStcak.push(new NodeList<Element>(request.getElement()));
	}

	private void pushVolley() {
		Petition request = requestQueue.dequeue().getInformation();
		request.setSeconds(getTIme()-request.getSeconds());
		report.enqueue(new NodeList<Petition>(request));
		voleyStack.push(new NodeList<Element>(request.getElement()));
	}

	public void ballsBack() {
		timer = new Timer(generateRandomTime(), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(requestQueue != null) {
					restartLists();
				}else {
					timer.stop();
				}
			}
		});
		timer.start();
	}

	public Tree<Element> getTree(){
		return tree;
	}

	public void incrementTime() {
		seconds++;
	}

	public int getTIme() {
		return seconds;
	}

	public Queue<Petition> getreport(){
		return report;
	}

	public void report() {
		if(!requestQueue.isEmpty()) {
			NodeList<Petition> current = requestQueue.getHead();
			while (current != null) {
				report.enqueue(current);
				current = current.getNext();
			}
		}
	}
}