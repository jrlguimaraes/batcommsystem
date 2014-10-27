package batcommsystem.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import batcommsystem.model.Logradouro;

public class LogradouroResource {
	private static int HTTP_COD_SUCESSO = 200;

	public Logradouro findCEP(String cep) throws JAXBException {
		Logradouro logradouro = null;
		
		try {
			
			URL url = new URL("http://viacep.com.br/ws/" + cep + "/xml");
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
				throw new RuntimeException("HTTP error code : "
						+ con.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(con.getInputStream())));
			JAXBContext jaxbContext = JAXBContext.newInstance(RESTcep.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			
			RESTcep banda = (RESTcep) jaxbUnmarshaller.unmarshal(br);
			
			logradouro = new Logradouro();
			
			logradouro.setCep(banda.getCep());
			logradouro.setLogradouro(banda.getLogradouro());
			logradouro.setBairro(banda.getBairro());
			logradouro.setUf(banda.getUf());
			logradouro.setIbge(banda.getIbge());
			logradouro.setCidade(banda.getLocalidade());
			
			
	
			
			con.disconnect();
			
			return logradouro;
		} catch (MalformedURLException e) {
			logradouro = null;
			e.printStackTrace();
		} catch (IOException e) {
			logradouro = null;
			e.printStackTrace();
		}
		
		return logradouro;
	}
}

// Leia mais em: Consumindo um Web Service Rest com Java
// http://www.devmedia.com.br/consumindo-um-web-service-rest-com-java/27286#ixzz3CHMJqeCF