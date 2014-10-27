package batcommsystem.facade;

import batcommsystem.data.dao.UserAccountDAO;
import batcommsystem.model.UserAccount;

public class UserAccountFacade {
	
	private UserAccountDAO userAccountDAO = new UserAccountDAO();
	
	
	public UserAccount findUserAccountByLogin(String login) {
		this.userAccountDAO.beginTransaction();
		UserAccount ua = this.userAccountDAO.findUserAccountByLogin(login);
		this.userAccountDAO.closeTransaction();
		return ua;
	}

}
