package assignment8;

public class Student {
	private String id;
	private String name;
	
	public Student() {

	}
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "[Name,Id] = [" + getName() + "," + getId() + "]";
	}

}
