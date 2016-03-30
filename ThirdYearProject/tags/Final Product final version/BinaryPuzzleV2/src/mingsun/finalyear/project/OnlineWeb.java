package mingsun.finalyear.project;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

/**
 * This class is designed to generate puzzle from online web pages.
 * 
 * @author Ming Sun
 *
 */
public class OnlineWeb {
	private String urlAddress;
	private String file;

	/**
	 * 
	 * @param urlAddress
	 *            String, address of url link.
	 * @param file
	 *            String, name of file.
	 */
	public OnlineWeb(String urlAddress, String file) {
		this.urlAddress = urlAddress;
		this.file = file;
	}

	/**
	 * This method will get the text fields from the web to the txt files.
	 * 
	 * @throws IOException
	 *             if url address, file cannot be found.
	 */
	public void getText() throws IOException {
		URL url = null;
		try {
			url = new URL(urlAddress);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Cannot find URL address.");
			e.printStackTrace();
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Cannot find file name.");
			e.printStackTrace();
		}
		String inputLine;
		try {
			while ((inputLine = in.readLine()) != null)
				fileWriter.write(inputLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
	}

}
