package models.entities;

public class Element {
	private int code;
	private String name;
	
	public Element(int code, String name) {
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
		return "Element [code=" + code + ", name=" + name + "]";
	}	
}