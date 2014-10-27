package batcommsystem.controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import batcommsystem.facade.PersonFacade;
import batcommsystem.facade.UserAccountFacade;
import batcommsystem.model.Person;
import batcommsystem.model.UserAccount;
import batcommsystem.controller.UserAccountMB;;

@ManagedBean
@ViewScoped
public class LoginMB extends AbstractMB {
	
	private PersonMB personMB;
	
	private String login;
	private String password;

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PersonMB getPersonMB() {
		return personMB;
	}

	public void setPersonMB(PersonMB personMB) {
		this.personMB = personMB;
	}

	public String makeLoginCheck() {
		boolean isValidUser = false;

		UserAccount ua = new UserAccountFacade().findUserAccountByLogin(this.login);	

		if ((ua != null) && (ua.getPassword().equals(this.password)) ){
			isValidUser = true;
		}

		if (isValidUser) {
			
			this.personMB = new PersonMB();
			
			Person p = new PersonFacade().findPersonByUserAccount(ua);
			
			/* *********************TESTE******************************* 
			Person p  = new Person();
			p.setName("Bruce Wayne");
			p.setEmail("jbond@mi7.org");
			p.setUserAccount(ua);
			/* *********************TESTE******************************* */
			
			UserAccountMB uaMB = new UserAccountMB();
			uaMB.setUserAccount(ua);
			uaMB.setLogged(true);
			
			this.personMB.setPerson(p);
			this.personMB.getPerson().setUserAccount(ua);
			this.personMB.setUserAccountMB(uaMB);
			

			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("personMB", this.personMB);
			return "default";

		} else {
			this.displayInfoMessageToUser("Usuario ou Senha Invalidos!");
			return null;
		}
	}

	

}
