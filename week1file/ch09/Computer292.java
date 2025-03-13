package ch09;

/*
 -클래스가 설계도라면 추상클래스는 미완성 설계도
 -추상메서드 : 선언부만 있고 구현부가 없는 메서드
 -일반메서드가 추상메서드를 호출할 수 있다.
 -완성된 설계도가 아니므로 인스턴스를 생성할수없다.
 -필요하지만 상속받는 곳 마다 다르게 구현될거같을때 사용
 -상속받는곧에서 추상메서드의 구현부를 완성한다
 */

//이 클래스는 부모클래스
public abstract class Computer292 {
	
		void turnOn() {System.out.println("computer 전원키기");}
		abstract void camera();
	
	
}

//상속
class Desktop293 extends Computer292{
	
	@Override
	void camera() {
		System.out.println("desktop 카메라기능");
		
	}
	
	
}


//상속
class Notebook296 extends Computer292{
	
	@Override
	void camera() {System.out.println("notebook 카메라기능");}
	
}