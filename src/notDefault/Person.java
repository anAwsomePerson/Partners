package notDefault;

public class Person {
	String name;
	String[] choices;
	boolean taken;
	
    public Person(String input) {
    	taken = false;
    	choices = new String[Main.choiceCount];
    	name = input.substring(0, input.indexOf(",")).trim();
    	input = input.substring(input.indexOf(",") + 1);
    	
    	for(int i = 0; i < Main.choiceCount - 1; i ++) {
    		//System.out.println(i + " " + input);
    		choices[i] = input.substring(0, input.indexOf(","));
    		input = input.substring(input.indexOf(",") + 1);
    		
    		if(name.equals(choices[i])) {
        		System.out.println(name + " and " + choices[i] + " are the same! Can't partner with yourself!");
        	}
    	}
    	
    	choices[Main.choiceCount - 1] = input;
		
		if(name.equals(choices[Main.choiceCount - 1])) {
    		System.out.println(name + " and " + choices[Main.choiceCount - 1] + " are the same! Can't partner with yourself!");
    	}
    	
    	for(int x = 0; x < Main.choiceCount; x ++) {
    		for(int y = x + 1; y < Main.choiceCount; y ++) {
    			if(choices[x].equals(choices[y])) {
    	    		System.out.println(choices[x] + " and " + choices[y] + " are the same! Pick different choices!");
    	    	}
    		}
    	}
    }
    
    public void flip() {
    	taken = !taken;
    }
}
