package batcommsystem.test;

import java.util.Date;

import batcommsystem.data.dao.IntraMessageDAO;
import batcommsystem.data.dao.PersonDAO;
import batcommsystem.model.IntraMessage;
import batcommsystem.model.Person;
import batcommsystem.model.UserAccount;

public class Tester2 {

	public static void main(String[] args) {

		
		UserAccount batman = new UserAccount();
		
		batman.setLogin("bwayne");
		batman.setPassword("b4tc4v3");
		batman.setAdministrator(true);
		
		Person secretIdentity = new Person();
		secretIdentity.setEmail("batman@gotham.com");
		secretIdentity.setName("Bruce Wayne");
		secretIdentity.setUserAccount(batman);

		
		PersonDAO dao = new PersonDAO();
		dao.beginTransaction();
		dao.save(secretIdentity);
		
		dao.commit();
		dao.closeTransaction();
		
		IntraMessage ci = new IntraMessage();
		ci.setMessage("Go back to the cave Robin!!!!");
		ci.setDate(new Date(System.currentTimeMillis()));
		ci.setPerson(secretIdentity);
		
		IntraMessageDAO d = new  IntraMessageDAO();
		d.beginTransaction();
		d.save(ci);
		d.commitAndCloseTransaction();
		

	}

}
