package ch16;

//p594
/*프로세스와 쓰레드(process & thread)
-프로세스 : 실행 중인 프로그램, 자원(resources)과 쓰레드로 구성
-쓰레드  : 프로세스 내에서 실제 작업을 수행. 
 		 모든 프로세스는 최소한 하나의 쓰레드를 가지고 있다.
==> 프로세스 : 쓰레드 = 공장 : 일꾼
-싱글 쓰레드 프로세스  = 자원+쓰레드
-멀티 쓰레드 프로세스  = 자원+쓰레드+쓰레드+…+쓰레드

-멀티 태스킹(멀티 프로세싱) : 동시에 여러 프로세스를 실행시키는 것
-멀티 쓰레딩 : 하나의 프로세스 내에 동시에 여러 쓰레드를 실행시키는 것
			- 프로세스를 생성하는 것보다 쓰레드를 생성하는 비용이 적다.
			- 같은 프로세스 내의 쓰레드들은 서로 자원을 공유한다.

*멀티쓰레드의 장점
- 시스템 자원을 보다 효율적으로 사용할 수 있다.
- 사용자에 대한 응답성(responseness)이 향상된다.
- 작업이 분리되어 코드가 간결해 진다.
*멀티쓰레드의 단점
- 동기화(synchronization)에 주의해야 한다.
- 교착상태(dead-lock)가 발생하지 않도록 주의해야 한다.
- 각 쓰레드가 효율적으로 고르게 실행될 수 있게 해야 한다.

*쓰레드의 구현과 실행
① Thread클래스를 상속
② Runnable인터페이스를 구현

*/
public class Ex01_p594 {

	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1(); // Thread 클래스를 상속한 쓰레드 생성

//		for(int i=0; i < 50; i++) {
//			System.out.print("r"); 
//		}
//		for(int i=0; i < 50; i++) {
//			System.out.print("t"); 
//		}
		
		//병렬 처리를 하려면, 각각의 루프를 별도의 쓰레드에서 실행해야 gka
//		Runnable r = new ThreadEx1_2(); // Runnable 인터페이스를 구현한 객체 생성
//		Thread t2 = new Thread(r);	    // 생성자 Thread(Runnable target)
//
//		t1.start();// t1 쓰레드 시작
//		t2.start();// t2 쓰레드 시작
	}
}

//① Thread클래스를 상속하는 방법
class ThreadEx1_1 extends Thread {
	public void run() {
		for(int i=0; i < 5; i++) {
			System.out.println(getName()); // 조상인 Thread의 getName()을 호출
		}
	}
}

//② Runnable인터페이스를 구현
class ThreadEx1_2 implements Runnable {
	public void run() {
		for(int i=0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
			//어떤 스레드가 실행하고 있는지 확인하려면 
			//정적 메소드인 currentThread()로 스레드 객체의 참조를 얻은 다음 
			//getName() 메소드로 이름을 출력
		}
	}
}

