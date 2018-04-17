package models.entities;

import java.util.Calendar;

public class Petition {
	private Student student;
	private Calendar date;
	private Element element;
	
	public Petition(Student student, Calendar date, Element element) {
		super();
		this.student = student;
		this.date = date;
		this.element = element;
	}
	public Student getStudent() {
		return student;
	}
	public Calendar getDate() {
		return date;
	}
	public Element getElement() {
		return element;
	}
	@Override
	public String toString() {
		return "Petition [student=" + student + ", date=" + date + ", element=" + element + "]";
	}
}