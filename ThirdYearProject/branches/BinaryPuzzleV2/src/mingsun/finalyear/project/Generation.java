package mingsun.finalyear.project;

import java.util.Random;
/**
 * This class is for puzzle generating, which is to provide unique solutions puzzle grid.
 * @author Ming Sun
 *
 */
public class Generation {
	/**
	 * @param nbList NumberButtonList.
	 * @param size Integer, size of puzzle grid.
	 * @param sp SolvePuzzle object name.
	 * @param random Random number generator.
	 * @param difficulity Integer.
	 */
	private NumberButtonList nbList;
	private int size;
	private SolvePuzzle sp;
	private Random random;
	private int difficulity;
	/**
	 * Constructor of Generation class.
	 * @param nbList NumberButtonList.
	 * @param size Integer.
	 */
	public Generation(NumberButtonList nbList, int size, int difficulity) {
		this.nbList = nbList;
		this.size = size;
		this.difficulity = difficulity;
	}
	/**
	 * 
	 * @return
	 */
	public NumberButtonList generator() {
		for (int row = 0; row < size; row++) {
			int[] positions = new int[size / 2];
			for (int i = 0; i < positions.length; i++) {
				positions[i] = size;
			}
			boolean repeat = true;
			for (int index = 0; index < size / 2; index++) {
				while (repeat) {
					int number = random.nextInt(size);
					if (index == 0) {
						positions[index] = number;
						repeat = false;
					} else {
						for (int i = 0; i < positions.length; i++) {
							if (positions[i] != number || positions[i] != size) {
								positions[index] = number;
								repeat = false;
							}
						}
					}
				}
			}
			for(int index=0; index<positions.length; index ++) {
				int value = random.nextInt(2);
				nbList.getNumberButton(row*size+positions[index]).setValue(value);
			}
		}
		return nbList;
	}
	
	public NumberButtonList getGeneratedPuzzle() {
		sp = new SolvePuzzle(nbList, size);
		sp.solverIt();
		switch(difficulity) {
		case 1:
			for(int row=0; row<size; row++){
				int column = random.nextInt(4);
				nbList.getNumberButton(row*size + column).setValue(2);
			}
			break;
		case 2:
			for(int row=0; row<size; row++){
				if(row%2==0){
					int column = random.nextInt(4);
					nbList.getNumberButton(row*size + column).setValue(2);
				} else {
					int column1 = random.nextInt(4);
					int column2 = random.nextInt(4);
					while(column1==column2) {
						column2 = random.nextInt(4);
					}
					nbList.getNumberButton(row*size + column1).setValue(2);
					nbList.getNumberButton(row*size + column2).setValue(2);
				}
			}
			break;
		case 3:
			for(int row=0; row<size; row++){
				int column1 = random.nextInt(4);
				int column2 = random.nextInt(4);
				while(column1==column2) {
					column2 = random.nextInt(4);
				}
				nbList.getNumberButton(row*size + column1).setValue(2);
				nbList.getNumberButton(row*size + column2).setValue(2);
			}
			break;
		}
		return nbList;
	}
}
