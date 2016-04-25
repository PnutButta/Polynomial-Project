public class Term {
	private int coefficient;
	private int exponent;
	private String term;
    
    public void Initialize(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    
    public int getCoeff() {
        return coefficient;
    }
    
    public int getExp() {
        return exponent;
    }
    
    //Formats Term as string
    public String ToString() {
    	
        if (exponent > 1){
        	term = (Integer.toString(coefficient) + "x^" + Integer.toString(exponent));
        }
        
        else if (exponent == 1){
        	term = Integer.toString(coefficient) + "x" + Integer.toString(exponent);
        }
        
        else if (exponent == 0){
        	term =Integer.toString(coefficient);
        }
        
        return term;
    }

}
