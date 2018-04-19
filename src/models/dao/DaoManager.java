package models.dao;

import java.util.GregorianCalendar;
import models.entities.Element;
import models.entities.Petition;
import models.entities.Student;
import structures.ElementStack;
import structures.Node;
import structures.Queue;

public class DaoManager {
	private Queue<Student> studentQueue;
	private Queue<Petition> requestQueue;
	private ElementStack<Element> footballStack, basketStcak, voleyStack;
	private String list;

	public DaoManager() {
		requestQueue = new Queue<>();
		studentQueue = new Queue<>();
		footballStack = new ElementStack<>();
		basketStcak = new ElementStack<>();
		voleyStack = new ElementStack<>();
	}

	private void generateAllStudents(int quantumStudents){
		studentQueue.clear();
		for (int i = 0; i < quantumStudents; i++) {
			studentQueue.enqueue(new Node<Student>(new Student(i, "Student n "+i)));
		}
	}

	private void generateAllBallFootball(int quantum){
		footballStack.clear();
		for (int i = 0; i < quantum; i++) {
			footballStack.push(new Node<Element>(new Element(i, "footballBall")));
		}
	}

	private void generateAllBasketBall(int quantum){
		basketStcak.clear();
		for (int i = 0; i < quantum; i++) {
			basketStcak.push(new Node<Element>(new Element(i, "basketBall")));
		}
	}

	private void generateAllBallVolley(int quantum){
		voleyStack.clear();
		for (int i = 0; i < quantum; i++) {
			voleyStack.push(new Node<Element>(new Element(i, "VolleyBall")));
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

	private void addFootball() throws Exception {
		requestQueue.enqueue(new Node<Petition>(new Petition(studentQueue.dequeue().getInformation(),new GregorianCalendar(),
				footballStack.pop().getInformation())));
	}

	private void addBasket() throws Exception {
		requestQueue.enqueue(new Node<Petition>(new Petition(studentQueue.dequeue().getInformation(),new GregorianCalendar(),
				basketStcak.pop().getInformation())));
	}

	private void addVolley() throws Exception {
		requestQueue.enqueue(new Node<Petition>(new Petition(studentQueue.dequeue().getInformation(),new GregorianCalendar(),
				voleyStack.pop().getInformation())));
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
}