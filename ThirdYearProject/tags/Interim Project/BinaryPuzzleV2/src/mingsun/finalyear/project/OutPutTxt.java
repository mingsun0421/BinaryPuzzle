package mingsun.finalyear.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * the class is designed to support save grid option.
 * @author Ming Sun
 * @param nbList NumberButtonList list of number buttons.
 * @param size integer, size of puzzle.
 */
public class OutPutTxt {
	private NumberButtonList nbList;
	private int size;
	/**
	 * Constructor
	 * @param nbList NumberButtonList list of all number buttons.
	 * @param size integer, size of puzzle.
	 */
	public OutPutTxt(NumberButtonList nbList, int size) {
		this.nbList = nbList;
		this.size = size;
	}
	/**
	 * This method will output elements in the list to txt file
	 */
	public void output() {
		try {
			FileWriter fw = new FileWriter("./output/output.txt");
			BufferedWriter out = new BufferedWriter(fw);
			for(int Rindex=0; Rindex<size; Rindex++){
				for(int Cindex=0; Cindex<size; Cindex++) {
					out.write(String.valueOf(nbList.getNumberButton(Rindex*size + Cindex).getValue())+" ");
				}
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
