package batcommsystem.test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import batcommsystem.data.dao.EnderecoDAO;
import batcommsystem.data.dao.LogradouroDAO;
import batcommsystem.model.Endereco;
import batcommsystem.model.Logradouro;
import batcommsystem.resource.LogradouroResource;
import junit.framework.TestCase;

public class EnderecoTestCase extends TestCase {

	@Test
	public void testPersistence() {
		Logradouro logradouro = null;
		LogradouroResource resource = new LogradouroResource();
		
		String cep = "13506-563";
		
		Endereco endereco = new Endereco();
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		try {
			logradouro = resource.findCEP(cep);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(logradouro.getCidade());
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		assertNotNull("CEP não encontrado ou invalido", logradouro);
		
		endereco.setLogradouro(logradouro);//1
		endereco.setComplemento("Casa com Luz Vermelha");
		endereco.setNumero("6969");
		
		enderecos.add(endereco);
		
		logradouro.setEnderecos(enderecos);//2
		
		//relações 1 e 2 satisfeitas
		
		LogradouroDAO dao = new LogradouroDAO();
		EnderecoDAO daoEnd = new EnderecoDAO();
		
		
		//Salvando logradouro
		dao.beginTransaction();
		dao.save(logradouro);
		dao.commitAndCloseTransaction();
		
		//Persistindo Endereco
		/*daoEnd.beginTransaction();
		daoEnd.save(endereco);
		daoEnd.commitAndCloseTransaction();*/
		
		
		Endereco persisted = null;
		daoEnd.beginTransaction();
		persisted = daoEnd.find(1);
		daoEnd.closeTransaction();
		
		assertEquals(cep, persisted.getLogradouro().getCep());
		
		
		
	}
	
	
	
}
