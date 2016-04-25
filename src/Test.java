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
    	      
    	      //Scan each line
    	      while (lineScanner.hasNext()) {
                  String part = lineScanner.next();
                  characters.add(part);
    	      }
              
    	      // Define polynomial for each line
    	      Polynomial P1 = new Polynomial();
    	      
    	      // Get polynomial name from first string
    	      Name = characters.get(0);
    	      P1.Name(Name);
    	      
    	      //Iterate through list
    	      int i = 1, j = 2;
    	      while(j < characters.size()){
    	    	  // Read numbers for each term from file assuming correct input
    	    	  first = Integer.parseInt(characters.get(i));
	    		  last = Integer.parseInt(characters.get(j));
	    		  Term T7 = new Term();
	    		  T7.Initialize(first, last);
	    		  
	    		  //Insert new term into polynomial
	    		  P1.Insert(T7);
	    		  i = i+2;
	    		  j = j+2;
    	      }
    	      
    	      // Execute operations on each polynomial
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
    	      
    	      // Clear characters ArrayList
    	      characters.clear();
    	   }
    		Scan.close();
	}

}
