package co.yedam.api;

public class SystemExe {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
//		long start = System.nanoTime();
				
		for(int i =0; i < 1000000; i++) {
			System.out.println(i);
		}
		long end = System.currentTimeMillis();
//		long end = System.nanoTime();
		
		System.out.println(end - start + " ms");
//		System.out.println(end - start + " ns");
		
		
	}
}
