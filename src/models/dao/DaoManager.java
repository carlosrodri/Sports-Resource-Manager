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

	public DaoManager() {
		requestQueue = new Queue<>();
		studentQueue = new Queue<>();
		footballStack = new ElementStack<>();
		basketStcak = new ElementStack<>();
		voleyStack = new ElementStack<>();
	}

	public void generateAllStudents(){
		for (int i = 0; i < 20; i++) {
			studentQueue.enqueue(new Node<Student>(new Student(i, "Student n "+i)));
		}
	}

	public void generateAllBallFootball(){
		for (int i = 0; i < 20; i++) {
			footballStack.push(new Node<Element>(new Element(i, "footballBall")));
		}
	}

	public void generateAllBasketBall(int quantum){
		for (int i = 0; i < quantum; i++) {
			basketStcak.push(new Node<Element>(new Element(i, "basketBall")));
		}
	}

	public void generateAllBallVolley(){
		for (int i = 0; i < 20; i++) {
			voleyStack.push(new Node<Element>(new Element(i, "VolleyBall")));
		}
	}

	public void addPetition(String element) throws Exception {
		switch (element) {
		case "Volley":
			addVolley();
			break;
		case "Basket":
			addBasket();
			break;
		case "Football":
			addFootball();
			break;
		}
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
}