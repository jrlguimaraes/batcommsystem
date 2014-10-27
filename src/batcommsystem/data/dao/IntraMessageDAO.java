package batcommsystem.data.dao;

import batcommsystem.model.IntraMessage;

public class IntraMessageDAO extends GenericDAO<IntraMessage> {

	private static final long serialVersionUID = 1L;
	
	public IntraMessageDAO() {
		super(IntraMessage.class);
	}

}
