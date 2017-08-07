package printstream;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteToProcess {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Process p = Runtime
				.getRuntime()
				.exec("java ReadStandard");
		System.out.println(p.toString());
//		PrintStream ps = new PrintStream(p.getOutputStream());
//		ps.println("output");
//		ps.println(new WriteToProcess());
		BufferedOutputStream bos = new BufferedOutputStream(p.getOutputStream());
		bos.write(102);
	}

}

class ReadStandard {
	public static void main(String[] args) {
		PrintStream ps = null;
		Scanner sc = new Scanner(System.in);
		try {
			ps = new PrintStream(new FileOutputStream("D:/test3.txt"));
			
			sc.useDelimiter("\n");
			ps.println("键盘输入的内容是：");
			while (sc.hasNext()) {
				ps.println(sc.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();

	}
}
