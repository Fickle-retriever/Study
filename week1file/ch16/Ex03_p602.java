package ch16;

import javax.swing.JOptionPane;

/*메인 스레드
- 메인 스레드는 main() 메소드의 첫 코드부터 순차적으로 실행
- main() 메소드의 마지막 코드를 실행하거나 
  return 문을 만나면 실행을 종료
- 메인 스레드는 추가 작업 스레드들을 만들어서 실행시킬 수 있음
- 메인 스레드가 작업 스레드보다 먼저 종료되더라도 
  작업 스레드가 계속 실행 중이라면 프로세스는 종료되지 않음
  
*인터럽트-interrupt() 메서드(p602)
- 한 스레드가 다른 스레드의 실행을 중단하거나, 특정 작업을 수행하도록 요청 
- 스레드에 인터럽트를 발생시키는 방법은 Thread 클래스의 interrupt() 메서드를 사용 
- 이 메서드를 호출하면, 해당 스레드의 인터럽트 상태가 설정됨. 
  스레드가 sleep(), wait(), 또는 join()과 같은 블로킹 상태에 있을 때, 
  인터럽트가 발생하면 InterruptedException이 발생
*/
public class Ex03_p602 {
	public static void main(String[] args) throws Exception {
		Thread31 th1 = new Thread31(); //작업 스레드 생성
		th1.start(); //작업 스레드 시작

		// 사용자로부터 입력을 받는 대화상자 표시
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요."); 
		System.out.println("입력하신 값은 " + input + "입니다.");
		
		// 작업 스레드에 인터럽트 신호 전송
		th1.interrupt();  // interrupt()를 호출하면, interrupted상태가 true가 된다.
		System.out.println("isInterrupted():"+ th1.isInterrupted()); // true
	}
}

class Thread31 extends Thread {
	public void run() {
		int i = 10; //카운트 시작 값
		
		//i가 0이 아니고, 스레드가 인터럽트되지 않은 동안 반복
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			//여기에서의 for문은 시간 지연을 위해 사용
			for(long x=0;x<2500000000L;x++); 
		}
		System.out.println("카운트가 종료되었습니다.");
	} 
}