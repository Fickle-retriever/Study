package ch12;

public class Member01 {
	//필드
	private int 	mNo; //회원번호
	private String	name;//회원명
	private int 	age; //나이
	
	//생성자
	public Member01() {}

	public Member01(int mNo, String name, int age) {
		this.mNo = mNo;
		this.name = name;
		this.age = age;
	}

	//getter & setter
	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

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

	@Override
	public String toString() {
		return "Member01 [mNo=" + mNo + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
