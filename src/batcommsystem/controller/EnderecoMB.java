package batcommsystem.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.xml.bind.JAXBException;

import batcommsystem.model.Endereco;
import batcommsystem.resource.LogradouroResource;

@ManagedBean
@SessionScoped
public class EnderecoMB {
	
	@PostConstruct
	public void init() {
		this.endereco = new Endereco();
	}
	
	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String pesquisaCEP() {
		
		LogradouroResource resource = new LogradouroResource();
		try {
			this.endereco.setLogradouro(resource.findCEP(this.getEndereco().getLogradouro().getCep()));
			resource.findCEP(this.getEndereco().getLogradouro().getCep());
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
		
		return "show_cep";
	}
	
	public void pesquisaAjaxCEP(ActionEvent event) {
		
		LogradouroResource resource = new LogradouroResource();
		try {
			this.endereco.setLogradouro(resource.findCEP(this.getEndereco().getLogradouro().getCep()));
			resource.findCEP(this.getEndereco().getLogradouro().getCep());
		} catch (JAXBException e) {
			e.printStackTrace();
			
		}
		
		
	}

	
	

}
