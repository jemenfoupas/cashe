import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CacheTest {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		try {
			
			if(args.length == 2) {
				int size1 = Integer.parseInt(args[0]);
				int size2 = 0;
				String fileName = "test-files/" + args[1];
				
				reader(size1, size2, fileName);
			} else if(args.length == 3) {
				int size1 = Integer.parseInt(args[0]);
				int size2 = Integer.parseInt(args[1]);
				String fileName = "test-files/" + args[2];
				
				reader(size1, size2, fileName);
			}
			
//			String fileName = "test-files/small.txt";
//			reader(5, 15, fileName);
			
		} catch(NumberFormatException e) {
			System.out.println("wrong inpute");
		}
		
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println("Time elapsed: " + time + " milliseconds");
	}
	
	public static void reader (int size1, int size2, String string) {
		
		File file = new File(string);
		Cache cache;
		
		if(size2 == 0) {
			cache = new Cache (size1);
		} else {
			cache = new Cache (size1, size2);
		}
		
		try {
			Scanner scan = new Scanner(file);
			
			while (scan.hasNext()) {
				Scanner scan2 = new Scanner(scan.next());
				scan2.useDelimiter("\t");
		        
				String data = scan2.next();
		        cache.getObject(data);
		        
			    scan2.close();
		      }
			
			System.out.println(cache.toString());
			scan.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
			
		}
	}
}
