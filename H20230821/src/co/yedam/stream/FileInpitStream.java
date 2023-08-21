package co.yedam.stream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInpitStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileInputStream fis = new FileInputStream("c:/temp/data.out");
			
			while (true) {
				int val = fis.read();

				if (val == -1) {
					break;
				}			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
