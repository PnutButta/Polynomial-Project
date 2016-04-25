import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.*;

public class Polynomial {
	private ArrayList<Term> list = new ArrayList<Term>();
    private int length;
    private String name;
    
    public void Name(String a_name){
    	this.name = a_name;
    }
    
    //Insert term into polynomial ArrayList
    public void Insert(Term a_term){
       length = list.size();
       Term curr, next;
        
        //add term to list
        if(list.isEmpty()){
        	list.add(a_term);
        }
        
        else{
        	for(int i=0; i<length; i++){
        		curr = list.get(i);
        		if(a_term.getExp() > curr.getExp()){
        			
        			//open space for new term by moving all term down in list
        			for(int j = length-1; j>list.indexOf(curr); j--){
        				next = list.get(j);
        				list.add(next);
        				list.remove(j);
        			}
        			//add new term
        			list.add(i, a_term);
        			break;
        		}
        		
        		else if(a_term.getExp() < curr.getExp() || a_term.getExp() == curr.getExp()){
        			if(i == length-1){
            			list.add(a_term);
            			break;
            		}
        			
        			
        		}
        	}
        }
    }
    
    //Print polynomial of Terms in Arraylist
    public StringBuilder Product(){
        length = list.size();
        String curr_term;
        Term curr;
        StringBuilder polynomial = new StringBuilder("");
        
        //Iterate through Arraylist
        for (int i = 0; i < length; i++){
            curr = list.get(i);
            curr_term = curr.ToString();
            
            if(curr.getCoeff() == 0 || curr == null){
                //checks if element in the Arraylist is empty
            }
            
            //adds Terms from list to polynomial string
            else{
                if(polynomial.length() == 0){
                    polynomial.append(curr_term);
                }
            
                else{
                    polynomial.append(" + ");
                    polynomial.append(curr_term);
                }
            }
        }
        
        return polynomial;
    }
    
    public void Print(){
    	System.out.print(name + "(X) = ");
    	System.out.print(Product());
        System.out.println("\n");
    }
    
    //Deletes a specific term from the ArrayList
    public void Delete(int coeff, int exp){
    	Term a_term = new Term();
    	a_term.Initialize(coeff, exp);
    	int found = 0;
    	
    	for(int i =0; i < length; i++){
    		// Compares given parameters w/ Terms in polynomial
    		if(a_term.getCoeff() == list.get(i).getCoeff()){
    			if(a_term.getExp() == list.get(i).getExp()){
    				list.remove(list.get(i));
    				found = 1;
    				break;
    			}
    		}
    	}
    	
    	// if term not found
    	if (found == 0){
    		System.out.println("Term is not in polynomial");
    	}
    }
    	
    //Reverses order of terms in polynomial
    public void Reverse(){
    	length = list.size();
    	int size;
    	Term curr;
    	//Initializes Stack
		Stack<Term> s1 = new Stack<Term>();
		
		//Iterates through current polynomial
    	for(int i=0; i < length; i++){
    		curr = list.get(i);
    		
    		//pushes current term onto STack
    		s1.push(curr);
    	}
    	
    	//Clears current polynomial
    	list.clear();
    	size = s1.size();
    	
    	//Adds terms from Stack to achieve Reverse order 
    	for(int i=0; i < size; i++){
    		list.add(s1.pop());
    	}
    }

}
