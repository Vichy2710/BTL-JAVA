package objects;
import java.util.*;
public interface BTTU extends CTX, CTH, GDS{

	public HashMap<Person, String> searchPerson();
	public HashMap<Person, String> searchPerson(Person similar);
	public HashMap<Person, String> searchPerson(Person similar, byte max_age);
	public HashMap<Person, String> searchPerson(Person similar, Address addr);
	public HashMap<Person, String> searchPerson(Person similar, String name_similar);
	public HashMap<Person, String> searchPerson(Person similar, Address addr, byte age);
}
