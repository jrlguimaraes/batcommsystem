package batcommsystem.test;

import batcommsystem.data.dao.PersonDAO;
import batcommsystem.model.Person;

public class Tester4 {

	public static void main(String[] args) {

		Person p;
		
		PersonDAO dao = new PersonDAO();
		
		dao.beginTransaction();
		p = dao.findPersonByLogin("joker");
		dao.closeTransaction();
		
	
		
		
		if(p != null) {
			System.out.println(p.getName());
		} else
			System.out.println("NULO");
		

	}

}
