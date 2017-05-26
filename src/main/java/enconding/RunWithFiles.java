package enconding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class RunWithFiles {

	public static void main(String[] args) throws IOException {
		File file = new File("texto-internacional.txt");
		FileOutputStream outputStream = new FileOutputStream(file);

		OutputStreamWriter writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
		writer.append("קריאת");
		writer.append("\n\u05E7\u05E8\u05D9\u05D0\u05EA");
		
		writer.close();
		
		FileInputStream inputStream = new FileInputStream(file);
		
		InputStreamReader reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
		BufferedReader bufferedReader = new BufferedReader(reader);
		String linha;
		while ((linha = bufferedReader.readLine()) != null) {
			System.out.println(linha);
		}
		
		bufferedReader.close();
	}
}
