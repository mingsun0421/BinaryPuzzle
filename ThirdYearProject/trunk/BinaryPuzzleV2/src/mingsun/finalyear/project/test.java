package mingsun.finalyear.project;

import java.io.FileNotFoundException;
import java.io.IOException;

public class test {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ReadPuzzleTxt rpt = new ReadPuzzleTxt("./resource/4x4Puzzle1.txt",4);
		rpt.getList();
	}
}
