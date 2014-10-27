package batcommsystem.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import batcommsystem.facade.PersonFacade;
import batcommsystem.model.Person;
import batcommsystem.model.UserAccount;

public class MockitoTest {

	@Test
	public void test() {
		PersonFacade facade = mock(PersonFacade.class);
		Person p;
		UserAccount ua = null;
		UserAccount ua2 = null;
		
		Person simula = new Person();
		simula.setEmail("email@teste.com");
		simula.setName("Teste da Silva");
		simula.setEndereco(null);
		simula.setId(1);
		
		
		
		when(facade.findPersonByUserAccount(ua)).thenReturn(simula);
		
		
		
		p = facade.findPersonByUserAccount(ua);
		assertEquals(Integer.toString(1), Integer.toString(p.getId()));
		assertEquals(simula.getEmail(), p.getEmail());
		
		System.out.print("Nome encontrado: ");
		System.out.print(p.getName());
		
		when(facade.findPersonByUserAccount(ua2)).thenReturn(null);
		
		
		p = facade.findPersonByUserAccount(ua2);
		assertNull(p);
		
		
		
		
		
		//http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html#stubbing

						
	}

}
