package objects;

import java.util.*;
public interface CTH {
	public ArrayList<Person> getPerson();
	public ArrayList<Person> getPerson(Person similar);
	public ArrayList<Person> getPerson(Person similar, byte min_age);
	public ArrayList<Person> getPerson(Person similar, Address addr);
} 
