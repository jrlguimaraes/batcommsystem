package batcommsystem.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import batcommsystem.facade.IntraMessageFacade;
import batcommsystem.model.IntraMessage;

@ManagedBean
@ViewScoped
public class IntraCommMB extends AbstractMB {

	@PostConstruct
	public void init() {

		this.intraMessage = new IntraMessage();
		System.out.print("EXECUTOU INIT DO INTRAMESSAGE");

		this.personMB = (PersonMB) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("personMB");
		//this.intraMessage.setPerson(this.personMB.getPerson());
	}

	private PersonMB personMB;
	private IntraMessage intraMessage;
	private List<IntraMessage> intraComms;
	private IntraMessageFacade intraMessageFacade = new IntraMessageFacade();

	public List<IntraMessage> getIntraComms() {
		if (this.intraComms == null)
			this.intraComms = this.intraMessageFacade.listAll();
		return intraComms;
	}

	public PersonMB getPersonMB() {
		return personMB;
	}

	public void setPersonMB(PersonMB personMB) {
		this.personMB = personMB;
	}

	public void setIntraComms(List<IntraMessage> intraComms) {
		this.intraComms = intraComms;
	}

	public IntraMessage getIntraMessage() {
		return intraMessage;
	}

	public void setIntraMessage(IntraMessage intraMessage) {
		this.intraMessage = intraMessage;
	}

	public void updateCI() {

		try {
			this.getIntraMessageFacade().updateIntraMessage(this.intraMessage);
		} catch (Exception exception) {
			keepDialogOpen();
			displayErrorMessageToUser("Ops, we could not create. Sorry, try again later.");
			exception.printStackTrace();
		}
		this.resetCI();
	}

	public void resetCI() {
		System.out.println("RESETOU CI!");
		this.intraMessage = new IntraMessage();
	}

	public IntraMessageFacade getIntraMessageFacade() {
		return intraMessageFacade;
	}

	public void setIntraMessageFacade(IntraMessageFacade intraMessageFacade) {
		this.intraMessageFacade = intraMessageFacade;
	}

	public void addIntraMessage() {
		try {
			this.intraMessage.setPerson(this.personMB.getPerson());
			this.intraMessageFacade.addIntraMessage(this.intraMessage);
			displayInfoMessageToUser("Done!");
			
		} catch (Exception exception) {
			keepDialogOpen();
			displayErrorMessageToUser("Ops, we could not update. Sorry, try again later");
			exception.printStackTrace();
		}
		this.resetCI();
	}
	
	/*=====================================*/
	public void updateTime() {
		this.myTime = new Date();
	}
	private Date myTime;
	public Date getMyTime() {
		return myTime;
	}
	public void setMyTime(Date myTime) {
		this.myTime = myTime;
	}
}
