package batcommsystem.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import batcommsystem.model.UserAccount;

@ViewScoped
@ManagedBean(name="userMB")
public class UserAccountMB extends AbstractMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public static final String INJECTION_NAME = "#{userMB}";
	
	private UserAccount userAccount;
	
	private boolean logged;

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	public boolean isAdmin() {
		return userAccount.isAdministrator();
	}

	public boolean isDefaultUser() {
		return !userAccount.isAdministrator();
	}
	
	public String logout() {
		getRequest().getSession().invalidate();
		return "/pages/public/login.xhtml";
	}
	
	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

}
