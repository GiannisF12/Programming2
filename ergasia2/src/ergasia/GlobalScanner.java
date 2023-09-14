package ergasia;

import java.util.Scanner;


public class GlobalScanner {
    private static GlobalScanner instance;

    private Scanner scanner;

    
    private GlobalScanner() {
        scanner = new Scanner(System.in);
    }

    
    public static Scanner getScanner() {
		if (instance == null) {
			instance = new GlobalScanner();
		}
		
		return instance.scanner;
	}
}
