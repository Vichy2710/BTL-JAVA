package objects;
import java.util.*;
public interface GDS {

	public List<Person> statisticPerson();
	public List<Person> statisticPerson(Person similar);
	public List<Person> statisticPerson(String name);
	public List<Person> statisticPerson(Address addr);
	public List<Person> statisticPerson(byte age);
}
