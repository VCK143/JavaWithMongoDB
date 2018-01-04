package vck.pojo;

public class MyDetails {
	public String name;
	public int age;
	public String qual;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getQual() {
		return qual;
	}

	public void setQual(String qual) {
		this.qual = qual;
	}

	@Override
	public String toString() {
		return "MyDetails [Name=" + name + ", Age=" + age + ", Qualification=" + qual + "]";
	}
}
