package batcommsystem.model;

import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames="login")})
@NamedQuery(name = "User.findByLogin", query = "select u from UserAccount u where u.login like :login")
public class UserAccount {
	
	public static final String FIND_BY_LOGIN = "User.findByLogin";

	@Id
	private String login;
	private String password;
	private boolean administrator;
	
	
	
	public boolean isAdministrator() {
		return administrator;
	}
	
	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}
	
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
	
	public String logout() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().getSessionMap().remove("user");
		facesContext.getExternalContext().invalidateSession();
		return "login";
	}
	
}
