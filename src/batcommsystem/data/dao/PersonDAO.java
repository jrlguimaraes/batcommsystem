package batcommsystem.data.dao;

import java.util.HashMap;
import java.util.Map;

import batcommsystem.model.Person;

public class PersonDAO extends GenericDAO<Person> {

	private static final long serialVersionUID = 1L;
	
	public PersonDAO() {
		super(Person.class);
	}
	
	public Person findPersonByLogin(String login) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("login", login);

		return super.findOneResult(Person.FIND_PERSON_BY_LOGIN, parameters);
	}
	
}
