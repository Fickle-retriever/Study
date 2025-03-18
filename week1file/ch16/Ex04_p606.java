package ch16;


/*스레드 동기화(p606)- synchronized
- 한 번에 하나의 쓰레드만 객체에 접근할 수 있도록 
  객체에 락(lock)을 걸어서 데이터의 일관성을 유지하는 것.
 
*동기화 메소드와 블록
- 스레드 작업이 끝날 때까지 객체에 잠금을 걸어 
  스레드가 사용 중인 객체를 다른 스레드가 변경할 수 없게 함

*동기화 메소드 및 블록 선언
- 인스턴스와 정적 메소드에  synchronized 키워드 붙임
- 동기화 메소드를 실행 즉시 객체는 잠금이 일어나고, 메소드 실행이 끝나면 잠금 풀림
- 메소드 일부 영역 실행 시 객체 잠금을 걸고 싶다면 동기화 블록을 만듦
*/
public class Ex04_p606 {
	public static void main(String args[]) {
		//RunnableEx41 객체를 생성하여 Runnable 인터페이스를 구현한 스레드
		Runnable r = new RunnableEx41();
		new Thread(r).start(); //첫 번째 스레드 시작
		new Thread(r).start(); // 두 번째 스레드 시작
	}
}

class Account {
	//계좌의 잔액
	private int balance = 1000; // private으로 해야 동기화가 의미가 있다.

	//잔액조회
	public  int getBalance() {
		return balance;
	}
	
//	//출금하기 
//	//synchronized 동기화하지 않는 메서드를 동기화한 경우와 비교해보자
//	public void withdraw(int money){ 
//		if(balance >= money) {
//			try { 
//				Thread.sleep(500); //1초 대기(출금 처리 시간 시뮬레이션)
//			} catch(InterruptedException e) {}
//			
//			//잔액에서 출금금액을 차감
//			balance -= money;
//		}
//	} // withdraw
	
	/*synchronized로 메서드를 동기화*/
	public synchronized void withdraw(int money){ 
		if(balance >= money) {
			try { Thread.sleep(1000);} catch(InterruptedException e) {}
			balance -= money;
		}
	} // withdraw
	
}

class RunnableEx41 implements Runnable {
	Account acc = new Account();

	public void run() {
		while(acc.getBalance() > 0) {
			// 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			// 출금하기
			acc.withdraw(money);
			// 현재 잔액 출력
			System.out.println("balance:"+acc.getBalance());
		}
	} //run()
}