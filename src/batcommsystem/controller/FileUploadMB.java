package batcommsystem.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "fileUploadMB")
@RequestScoped
public class FileUploadMB {
	
	private final static String destination = "C:\\TEMP\\";

	public FileUploadMB() {
	}

	public void doUpload(FileUploadEvent fileUploadEvent) {
		UploadedFile uploadedFile = fileUploadEvent.getFile();
		String fileNameUploaded = uploadedFile.getFileName();
		long fileSizeUploaded = uploadedFile.getSize();
		String infoAboutFile = "<br/> Arquivo recebido: <b>" + fileNameUploaded
				+ "</b><br/>" + "Tamanho do Arquivo: <b>" + fileSizeUploaded
				+ "</b>";
		try {
			copyFile(uploadedFile.getFileName(), uploadedFile.getInputstream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null,
				new FacesMessage("Sucesso", infoAboutFile));
	}
	
	 public void copyFile(String fileName, InputStream in) {
         try {
            
            
              // write the inputStream to a FileOutputStream
              OutputStream out = new FileOutputStream(new File(destination + fileName));
              System.out.println("O arquivo sera gravado no caminho: " + destination + fileName);
            
              int read = 0;
              byte[] bytes = new byte[1024];
            
              while ((read = in.read(bytes)) != -1) {
                  out.write(bytes, 0, read);
              }
            
              in.close();
              out.flush();
              out.close();
            
              System.out.println("New file created!");
              } catch (IOException e) {
              System.out.println(e.getMessage());
              }
  }
}
