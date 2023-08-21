package co.yedam.stream;

import java.io.FileOutputStream;

public class FileOutputStreamExe {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = 
					new FileOutputStream("c:/Temp/out.data");
			fos.write(100);
			fos.write(200);
			fos.write(300); //248 16 32 64 128 256

			fos.flush(); // 버퍼의 캐시값을 비움.
			fos.close(); // 사용한 리소스 환원.			

		} catch (Exception e) {
			System.out.println("무슨 오류임?\n" + e);
		}

		System.out.println("end");
	}
}
