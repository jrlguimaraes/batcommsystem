package batcommsystem.test;

import batcommsystem.data.dao.PersonDAO;
import batcommsystem.facade.UserAccountFacade;
import batcommsystem.model.Person;
import batcommsystem.model.UserAccount;

public class Tester3 {

	public static void main(String[] args) {

		
		UserAccount joker = new UserAccount();
		
		joker.setLogin("joker");
		joker.setPassword("joker");
		joker.setAdministrator(false);
		
		Person secretIdentity = new Person();
		secretIdentity.setEmail("joker@gotham.com");
		secretIdentity.setName("The Joker");
		secretIdentity.setUserAccount(joker);
		
		PersonDAO dao = new PersonDAO();
		dao.beginTransaction();
		dao.save(secretIdentity);
		
		dao.commit();
		dao.closeTransaction();
		
		UserAccountFacade fac = new UserAccountFacade();
		UserAccount ua = new UserAccount();
		
		//ua = fac.findUserAccountByLogin(batman.getLogin());
		ua = fac.findUserAccountByLogin("joker");
		
		
		if(ua != null) {
			System.out.println(ua.getLogin());
		} else
			System.out.println("NULO");
		

	}

}
