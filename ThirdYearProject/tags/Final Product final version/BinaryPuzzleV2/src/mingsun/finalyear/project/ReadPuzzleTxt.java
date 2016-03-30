package mingsun.finalyear.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * the class is designed to support save grid option.
 * 
 * @author Ming Sun
 * @param nbList
 *            NumberButtonList, list of number buttons.
 * @param fileName
 *            string name of file.
 * @param size
 *            integer, size of grid.
 */
public class ReadPuzzleTxt {
	private NumberButtonList nbList;
	private String fileName;
	private int size;

	/**
	 * Constructor.
	 * 
	 * @param fileName
	 *            String
	 * @param size
	 *            integer
	 */
	public ReadPuzzleTxt(String fileName, int size) {
		this.fileName = fileName;
		this.size = size;
		nbList = new NumberButtonList();
	}

	/**
	 * This method can read txt and return a number button list of all content
	 * in that file.
	 * 
	 * @return NumberButtonList, list of number buttons.
	 * @throws FileNotFoundException
	 *             Exception
	 * @throws IOException
	 *             Exception
	 */
	public NumberButtonList getList() throws FileNotFoundException, IOException {
		int index = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				// process the line.
				String[] splited = line.split("\\s+");
				for (int i = 0; i < size; i++) {
					NumberButton nb = new NumberButton(index);
					nb.setValue(Integer.parseInt(splited[i]));
					nb.setIcon();
					if (Integer.parseInt(splited[i]) != 2) {
						nb.setEditable(false);
					}
					nbList.add(nb);
					index++;
				}
			}
		}
		return nbList;
	}
}
