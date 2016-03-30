package mingsun.finalyear.project;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class is a simple test class, which is used to test the new
 * functionalities or debugging.
 * 
 * @author Ming Sun
 *
 */
public class test {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ReadPuzzleTxt rpt = new ReadPuzzleTxt("./resource/4x4Puzzle1.txt", 4);
		rpt.getList();
	}
}
