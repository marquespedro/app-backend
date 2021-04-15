package br.com.app.service;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;


@Stateless
public class ArquivoService {

	
	public void criarArquivos(List<InputPart> inputParts) {
	
		for (InputPart inputPart : inputParts) {
		
			try {

				MultivaluedMap<String, String> header = inputPart.getHeaders();
				
				String nomeArquivo = extrairNomeArquivo(header);

				// realiza conversao do arquivo de upload para  inputstream
				InputStream inputStream = inputPart.getBody(InputStream.class, null);

				byte[] bytes = IOUtils.toByteArray(inputStream);

				String pastaHomeUploads = System.getProperty("user.home") + File.separator + "uploads";
				File customDir = new File(pastaHomeUploads);

				if (!customDir.exists()) {
					customDir.mkdir();
				}
				
				String filePath = customDir.getCanonicalPath() + File.separator + nomeArquivo + UUID.randomUUID();
				
				FileUtils.writeByteArrayToFile(new File(filePath), bytes);
				
//				writeFile(bytes, fileName);


			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private String extrairNomeArquivo(MultivaluedMap<String, String> header) {

		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {
				String[] name = filename.split("=");
				String finalFileName = name[1].trim().replaceAll("\"", "");
				return finalFileName;
			}
		}
		return "unknown";
	}

	public Integer operacaoDemorada(Integer numero) {
		
		List<Integer> numeros = new ArrayList<>();
		
		for(int i = 1; i <= numero ; i++) {
			numeros.add(i);	
		}
		
		Predicate<Integer> somentePares = n -> n % 2 == 0 ;	
		
		List<Integer> numerosPares = numeros.stream().filter(somentePares).collect(Collectors.toList());
		
		BinaryOperator<Integer> somador = (acc, element) -> acc + element;
		
		Integer resultado =  numerosPares.stream().reduce(somador).orElse(null);
		
		return resultado;
	}
}
