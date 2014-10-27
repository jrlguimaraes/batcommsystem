package batcommsystem.facade;

import batcommsystem.data.dao.PersonDAO;
import batcommsystem.model.Person;
import batcommsystem.model.UserAccount;

public class PersonFacade {
	
	private PersonDAO personDAO = new PersonDAO();
	
	public Person findPersonByUserAccount(UserAccount userAccount) {
		Person person;
		
		this.personDAO.beginTransaction();	
		person = this.personDAO.findPersonByLogin(userAccount.getLogin());
		this.personDAO.closeTransaction();

		return person;
	}
	
	public void save(Person person) {
		this.personDAO.beginTransaction();
		this.personDAO.save(person);
		this.personDAO.commitAndCloseTransaction();
	}

}
