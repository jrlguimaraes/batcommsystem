package batcommsystem.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import batcommsystem.model.Person;

@ViewScoped
@ManagedBean(name="personMB")
public class PersonMB extends AbstractMB  implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String INJECTION_NAME = "#{personMB}";
	
	private UserAccountMB userAccountMB;
	private Person person;
		
	
	public UserAccountMB getUserAccountMB() {
		return userAccountMB;
	}
	public void setUserAccountMB(UserAccountMB userAccountMB) {
		this.userAccountMB = userAccountMB;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
