import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
			
		ArrayList<String> characters = new ArrayList<String>();
	    String Name;
	    int first, last;
	    File file = new File("Terms");
	    Scanner Scan = new Scanner(file);
	    
		//Until end of file read line by line
    	while (Scan.hasNextLine()) {
    	      String line = Scan.nextLine();

    	      @SuppressWarnings("resource")
			Scanner lineScanner = new Scanner(line);
    	      lineScanner.useDelimiter(";");
    
    	      while (lineScanner.hasNext()) {
                  String part = lineScanner.next();
                  characters.add(part);
    	      }
              
    	      Polynomial P1 = new Polynomial();
    	      Name = characters.get(0);
    	      P1.Name(Name);
    	      
    	      int i = 1, j = 2;
    	      while(j < characters.size()){
    	    	  first = Integer.parseInt(characters.get(i));
	    		  last = Integer.parseInt(characters.get(j));
	    		  Term T7 = new Term();
	    		  T7.Initialize(first, last);
	    		  P1.Insert(T7);
	    		  i = i+2;
	    		  j = j+2;
    	      }
    	      System.out.println("Initial Polynomial");
    	      P1.Print();
    	      System.out.println("After Deletion");
    	      P1.Delete(5,3);
    	      P1.Print();
    	      
    	      System.out.println("After Reverse");
    	      P1.Reverse();
    	      P1.Print();
    	      
    	      System.out.println("Final Return");
    	      P1.Reverse();
    	      P1.Product();
    	      P1.Print();
    	      System.out.println("New Polynomial");
    	      characters.clear();
    	   }
    		Scan.close();
    	
	}

}
