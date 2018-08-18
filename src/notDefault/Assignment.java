package notDefault;

public class Assignment {
	String string;
	int[] choices;
	
    public Assignment(String input) {
    	string = input;
    	choices = new int[Main.choiceCount];
    	
    	for(int x = 0; x < Main.people.size() / 2; x ++) {
    		if(!Main.even && x == Main.people.size() / 2 - 1) {
    			for(int y = 0; y < Main.choiceCount; y ++) {
    				if(Main.getPerson(getFromString(string, 2 * x)).choices[y].equals(getFromString(string, 2 * x + 1))){
    					choices[y] ++;
    				}
    				
    				if(Main.getPerson(getFromString(string, 2 * x)).choices[y].equals(getFromString(string, 2 * x + 2))){
    					choices[y] ++;
    				}
    				
    				if(Main.getPerson(getFromString(string, 2 * x + 1)).choices[y].equals(getFromString(string, 2 * x))){
    					choices[y] ++;
    				}
    				
    				if(Main.getPerson(getFromString(string, 2 * x + 1)).choices[y].equals(getFromString(string, 2 * x + 2))){
    					choices[y] ++;
    				}
    				
    				if(Main.getPerson(getFromString(string, 2 * x + 2)).choices[y].equals(getFromString(string, 2 * x))){
    					choices[y] ++;
    				}
    				
    				if(Main.getPerson(getFromString(string, 2 * x + 2)).choices[y].equals(getFromString(string, 2 * x + 1))){
    					choices[y] ++;
    				}
    			}
    		}else {
    			for(int y = 0; y < Main.choiceCount; y ++) {
    				if(Main.getPerson(getFromString(string, 2 * x)).choices[y].equals(getFromString(string, 2 * x + 1))){
    					choices[y] ++;
    				}
    				
    				if(Main.getPerson(getFromString(string, 2 * x + 1)).choices[y].equals(getFromString(string, 2 * x))){
    					choices[y] ++;
    				}
    			}
    		}
    	}
    }
    
    public String toString() {
    	String out = "";
    	
    	for(int x = 0; x < Main.people.size() / 2; x ++) {
    		if(!Main.even && x == Main.people.size() / 2 - 1) {
    			out = out + getFromString(string, 2 * x) + " and " + getFromString(string, 2 * x + 1) + " and " + getFromString(string, 2 * x + 1);
    		}else {
    			out = out + getFromString(string, 2 * x) + " and " + getFromString(string, 2 * x + 1) + ", ";
    		}
    	}
    	
    	return(out);
    }
    
    public static String getFromString(String string, int index) {
    	while(true) {
    		if(string.contains(",")){
    			if(index == 0) {
    				return(string.substring(0, string.indexOf(",")));
    			}
    			
    			string = string.substring(string.indexOf(",") + 1);
    			index --;
    		}else {
    			if(index == 0) {
    				return(string);
    			}
    			
    			break;
    		}
    	}
    	
    	System.out.println("You just called getFromString with " + index + ", and it was out of bounds!");
		return(null);
    }
}
