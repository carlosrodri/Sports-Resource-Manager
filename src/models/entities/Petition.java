package models.entities;

public class Petition {
	private Student student;
	private Element element;
	private int seconds;
	public Petition(Student student, Element element) {
		super();
		this.student = student;
		this.element = element;
		seconds = 0;
	}
	public Student getStudent() {
		return student;
	}
	public Element getElement() {
		return element;
	}
	public int getSeconds() {
		return seconds;
	}
	public void incrementTime() {
		seconds ++;
	}
	@Override
	public String toString() {
		return "Petition [student=" + student + ", element=" + element + ", seconds=" + seconds
				+ "]";
	}
}