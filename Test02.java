package test;

public class Test02 {
	public static void main(String[] args) {
		int mod1 = 3;
		int mod2 = 4;
		int max_range = 20;
		int count = 0;
		System.out.println("mod1:"+mod1+" mod2:"+mod2+" max_range:"+max_range);
		for(int i=1; i<=max_range; i++) {
			if(i%mod1==0 & i%mod2!=0) {
				System.out.println(i);
				count++;
			}
			
		}
		System.out.println("return 값 : " + count);
		
	}
}
