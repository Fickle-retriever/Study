package testPack;
class Person{
	String name;
	int age;
	static int personCount = 0;
	public void introduce(){
		System.out.println("이름:" + name);
		System.out.println("나이:" + age);
	}
	public static void printPersonCount(){ // static을 붙여 클래스 메소드
		System.out.println(personCount);
	}
	public void setName(String name){ // this로 Person클래스의 name을 가져옴
		this.name = name;
	}
	Person(String name,int age){ // 초기화후 메인에서 바로 객체 생성하면서 활용
		this.name = name;
		this.age = age;
	}
}
public class Ctest {


   public static void main(String[] args){
       Person person = new Person("준영" , 24); // Person 생성자
       person.age = 20; // 인스턴스 변수 객체 필
       person.name = "망망"; // 인스턴스 변수 객체 필
       Person.personCount = 10; // 클래스 변수 객체 필X
       person.introduce(); // 인스턴스 매소드 진짜 void 받는거처럼
       Person.printPersonCount(); // 이것도 객체 필 x 바로 출력
       person.setName("왕왕");
       System.out.println(person.name);
   }


}
