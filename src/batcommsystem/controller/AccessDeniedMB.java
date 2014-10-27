package batcommsystem.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class AccessDeniedMB extends AbstractMB {
	
	@PostConstruct
	public void init(){
		
		this.personMB = (PersonMB) FacesContext
			    .getCurrentInstance().getExternalContext().getSessionMap().get("personMB");
	}
	
	private PersonMB personMB;

	public PersonMB getPersonMB() {
		return personMB;
	}

	public void setPersonMB(PersonMB personMB) {
		this.personMB = personMB;
	}
	
	

}
