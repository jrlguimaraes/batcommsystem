package batcommsystem.test;

import batcommsystem.data.dao.PersonDAO;
import batcommsystem.model.Person;
import batcommsystem.model.UserAccount;

public class Tester1 {

	public static void main(String[] args) {


		UserAccount batman = new UserAccount();
		
		batman.setLogin("bwayne");
		batman.setPassword("b4tc4v3");
		
		Person secretIdentity = new Person();
		secretIdentity.setEmail("batman@gotham.com");
		secretIdentity.setName("Bruce Wayne");
		secretIdentity.setUserAccount(batman);

		
		PersonDAO dao = new PersonDAO();
		dao.beginTransaction();
		dao.save(secretIdentity);
		
		dao.commit();
		dao.closeTransaction();
		
		

	}

}
