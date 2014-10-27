package batcommsystem.data.dao;

import java.util.HashMap;
import java.util.Map;

import batcommsystem.model.UserAccount;

public class UserAccountDAO extends GenericDAO<UserAccount> {

	private static final long serialVersionUID = 1L;

	public UserAccountDAO() {
		super(UserAccount.class);
	}
	
	public UserAccount findUserAccountByLogin(String login) {
		Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("login", login);
		return super.findOneResult(UserAccount.FIND_BY_LOGIN, parameters);
	}

}
