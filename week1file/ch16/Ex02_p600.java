package ch16;

//p600
/*스레드 상태.쓰레드의 실행제어
-실행 대기 상태: 실행을 기다리고 있는 상태 
-실행 상태: CPU 스케쥴링에 따라 CPU를 점유하고 run() 메소드를 실행. 
		  스케줄링에 의해 다시 실행 대기 상태로 돌아갔다가 다른 스레드가 실행 상태 반복
-종료 상태: 실행 상태에서 run() 메소드가 종료되어 실행할 코드 없이 
		  스레드의 실행을 멈춘 상태
-일시 정지 상태
 스레드가 실행할 수 없는 상태
 스레드가 다시 실행 상태로 가기 위해서는 일시 정지 상태에서 실행 대기 상태로 가야야 함 
 Thread 클래스의 sleep() 메소드: 실행 중인 스레드를 일정 시간 멈추게 함
 매개값 단위는 밀리세컨드(1/1000)
- yield() 메소드: 
  실행되는 스레드는 실행 대기 상태로 돌아가고, 다른 스레드가 실행되도록 양보 
   무의미한 반복을 막아 프로그램 성능 향상 
*/
/*메인 스레드
- 메인 스레드는 main() 메소드의 첫 코드부터 순차적으로 실행
- main() 메소드의 마지막 코드를 실행하거나 
  return 문을 만나면 실행을 종료
- 메인 스레드는 추가 작업 스레드들을 만들어서 실행시킬 수 있음
- 메인 스레드가 작업 스레드보다 먼저 종료되더라도 
  작업 스레드가 계속 실행 중이라면 프로세스는 종료되지 않음
*/
public class Ex02_p600 {
	public static void main(String args[]) {
		//스레드 생성 및 시작
		Thread1 th1 = new Thread1(); //스레드 생성
		Thread2 th2 = new Thread2(); //스레드 생성
		th1.start(); //스레드를 시작
		th2.start(); //스레드를 시작

//		//스레드 일시 정지
//		try {
//			Thread.sleep(2000);	//메인 스레드가 2초 동안 일시 정지되 
//			//그 동안 th1과 th2 스레드는 계속 실행
//		} catch(InterruptedException e) {}

		System.out.print("<<main쓰레드>>");
	} //main쓰레드
}

class Thread1 extends Thread {
	public void run() {
		for(int i=0; i < 300; i++) {
			System.out.print("-");
			//스레드 일시 정지
			try {
				Thread.sleep(200);	//메인 스레드가 2초 동안 일시 정지되 
				//그 동안 th1과 th2 스레드는 계속 실행
			} catch(InterruptedException e) {}
		}
			
		System.out.print("<<th1쓰레드>>");
	}//run()
}

class Thread2 extends Thread {
	public void run() {
		for(int i=0; i < 300; i++) {
			//스레드 일시 정지
			try {
				Thread.sleep(200);	//메인 스레드가 2초 동안 일시 정지되 
				//그 동안 th1과 th2 스레드는 계속 실행
			} catch(InterruptedException e) {}
			System.out.print("|");
			}
		System.out.print("<<th2쓰레드>");
		
	}//run()
}