package batcommsystem.test;

import java.util.Date;

import org.junit.Test;

import batcommsystem.facade.IntraMessageFacade;
import batcommsystem.facade.PersonFacade;
import batcommsystem.facade.UserAccountFacade;
import batcommsystem.model.IntraMessage;
import batcommsystem.model.Person;
import batcommsystem.model.UserAccount;
import junit.framework.TestCase;


public class IntramessageFacadeTestCase extends TestCase {
	
	 @Test
	 public void testFacades() {
		 Person p = null;
		 UserAccount ua = null;
		 
		 PersonFacade personF = new PersonFacade();
		 UserAccountFacade uaF = new UserAccountFacade();
		 IntraMessageFacade mF = new IntraMessageFacade();
		 
		 //Encontrar UserAccount
		 ua = uaF.findUserAccountByLogin("bwayne");
		 
		 
		 System.out.println("Procurando UserAccount:");
		 System.out.println(ua.getLogin());
		 
		 //Confirma se o valor esperado NÃO É NULL
		 assertNotNull("Objeto UserAcount Nulo!", ua);
		
		 p = personF.findPersonByUserAccount(ua);
		 
		 //CONFIRMA se o valor esperado NÃO É NULL
		 assertNotNull("Pessoa é null", p);
		 
		 p.setUserAccount(ua);
		 
		 IntraMessage message = new IntraMessage();
		 
		 
		 Date d = new Date();
		 
		 message.setDate(d);
		 message.setMessage("Esta é uma mensagem gerada automaticamente por um método de teste automatizado.");
		 message.setPerson(p);
		 //message.setTime(d);
		 
		 mF.addIntraMessage(message);
		 
		 IntraMessage persistedIM = null;
		 
		 persistedIM = mF.findById(2);
		 
		 assertNotNull(persistedIM);
		 
		 
		 
	 }
	 
	 @Test
	 public void testSavePerson() {
		 
		 Person p = new Person();
		 UserAccount ua = new UserAccount();
		 
		 PersonFacade personF = new PersonFacade();
		 //UserAccountFacade uaF = new UserAccountFacade();
		 
		 ua.setLogin("twofaces");
		 ua.setPassword("flipacoin");		 
		 ua.setAdministrator(false);
		 
		 p.setName("Harley Dent");
		 p.setEmail("twoplustwo@gotham.com");
		 p.setUserAccount(ua);
		 
		 personF.save(p);
		 
		 Person persisted = null;
		 
		 persisted = personF.findPersonByUserAccount(ua);
		 
		 assertNotNull(persisted);
		 
		 
		 
	 }

}
