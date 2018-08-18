package notDefault;

import java.io.File;
import java.util.*;

public class Main {
	public static int choiceCount;
	public static boolean even;
	public static ArrayList<Person> people;
	public static ArrayList<Assignment> potential;
	public static Person[] current;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        people = new ArrayList<Person>();
        potential = new ArrayList<Assignment>();
        Scanner input = new Scanner(new File("input.txt"));
        choiceCount = Integer.parseInt(input.nextLine());
        
        while(input.hasNext()) {
        	people.add(new Person(input.nextLine()));
        }
        
        current = new Person[people.size()];
        even = people.size() % 2 == 0;
        
        for(int x = 0; x < people.size(); x ++) {
        	for(int y = 0; y < choiceCount; y ++) {
        		for(int z = 0; z < people.size(); z ++) {
        			if(people.get(x).choices[y].equals(people.get(z).name)){
        				break;
        			}
        			
        			if(z == people.size() - 1) {
        				System.out.println(people.get(x).name + "'s choice " + people.get(x).choices[y] + " does not exist!");
        				return;
        			}
        		}
        	}
        }
        
        cur(0);
        int max;
        
        for(int x = 0; x < choiceCount; x ++) {
        	max = 0;
        	
        	for(int y = 0; y < potential.size(); y ++) {
        		if(potential.get(y).choices[x] > max) {
        			max = potential.get(y).choices[x];
        		}else if(potential.get(y).choices[x] < max){
        			potential.remove(y);
        			y --;
        		}
        	}
        }
        
        System.out.println(potential.get((int)(Math.random() * potential.size())).toString());
	}

	public static void cur(int layer) {
		if(current[people.size() - 1] == null) {
			for(int i = 0; i < countFalse(people); i ++) {
				current[layer] = getFalse(people, i);
				current[layer].flip();
				cur(layer + 1);
				current[layer].flip();
				current[layer] = null;
			}
		}else {
			String input = "";
			
			for(int i = 0; i < people.size() - 1; i ++) {
				input = input + current[i].name + ',';
			}
			
			//System.out.println(input + current[people.size() - 1].name);
			potential.add(new Assignment(input + current[people.size() - 1].name));
		}
	}
	
	public static Person getPerson(String name) {
		for(int i = 0; i < people.size(); i ++) {
			if(people.get(i).name.equals(name)) {
				return(people.get(i));
			}
		}
		
		System.out.println("The person" + name + " does not exist!");
		return(null);
	}
	
	public static int countFalse(ArrayList<Person> people) {
		int out = 0;
		
		for(int i = 0; i < people.size(); i ++) {
			if(!people.get(i).taken) {
				out ++;
			}
		}
		
		return(out);
	}
	
	public static Person getFalse(ArrayList<Person> people, int index) {
		for(int i = 0; i < people.size(); i ++) {
			if(!people.get(i).taken) {
				if(index == 0) {
					return(people.get(i));
				}
				
				index --;
			}
		}
		
		System.out.println("You just called getFalse with " + index + ", and it was out of bounds!");
		return(null);
	}
}
