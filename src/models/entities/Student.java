package models.entities;

public class Student {
	private int code;
	private String name;
	
	public Student(int code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Student [code=" + code + ", name=" + name + "]";
	}
}