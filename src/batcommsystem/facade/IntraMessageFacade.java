package batcommsystem.facade;

import java.util.List;

import batcommsystem.data.dao.IntraMessageDAO;
import batcommsystem.model.IntraMessage;

public class IntraMessageFacade {
	
	private IntraMessageDAO intraMessageDAO = new IntraMessageDAO();

	public List<IntraMessage> listAll() {
		this.intraMessageDAO.beginTransaction();
		List<IntraMessage> result = this.intraMessageDAO.findAll();
		this.intraMessageDAO.closeTransaction();
		return result;
	}

	public void updateIntraMessage(IntraMessage intraMessage) {	
		
		this.intraMessageDAO.beginTransaction();
		IntraMessage persistedIM = this.intraMessageDAO.find(intraMessage.getId());
		// Atualizar todos os campos pertinentes:
		persistedIM.setDate(intraMessage.getDate());
		
		persistedIM.setMessage(intraMessage.getMessage());
		persistedIM.setPerson(intraMessage.getPerson());
		
		this.intraMessageDAO.update(persistedIM);
		this.intraMessageDAO.commitAndCloseTransaction();
	}
	
	public void addIntraMessage(IntraMessage intraMessage) {
		this.intraMessageDAO.beginTransaction();
		this.intraMessageDAO.save(intraMessage);
		this.intraMessageDAO.commitAndCloseTransaction();
	}
	
	public IntraMessage findById(Integer id) {
		IntraMessage result = null;
		
		this.intraMessageDAO.beginTransaction();
		result = this.intraMessageDAO.find(id);
		this.intraMessageDAO.closeTransaction();
		
		return result;
	}
	 
	
	
	

}
