package batcommsystem.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.JAXBException;

import org.primefaces.event.FlowEvent;

import batcommsystem.model.Endereco;
import batcommsystem.model.Person;
import batcommsystem.model.UserAccount;
import batcommsystem.resource.LogradouroResource;

@SessionScoped
@ManagedBean
public class NewUserMB extends AbstractMB {

	private Person person;
	private Endereco endereco;
	private UserAccount userAccount;

	private String password;
	private String confirmPassword;

	@PostConstruct
	public void init() {
		this.person = new Person();
		this.endereco = new Endereco();
		this.userAccount = new UserAccount();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public String save() {

		if (true) {

			return "Success";
		}

		return "Fail";

	}

	public String onFlowProcess(FlowEvent event) {

		return event.getNewStep();

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void findCEP() {
		LogradouroResource resource = new LogradouroResource();
		try {
			this.endereco.setLogradouro(resource.findCEP(this.getEndereco()
					.getLogradouro().getCep()));
			resource.findCEP(this.getEndereco().getLogradouro().getCep());
		} catch (JAXBException e) {
			this.endereco = null;

			displayErrorMessageToUser(e.getMessage());
			e.printStackTrace();
		}
	}
}