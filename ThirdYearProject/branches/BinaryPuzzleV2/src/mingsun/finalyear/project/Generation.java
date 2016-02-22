package mingsun.finalyear.project;

import java.util.Random;

public class Generation {
	private NumberButtonList nbList;
	private int size;
	private SolvePuzzle sp;
	private Random random;

	public Generation(NumberButtonList nbList, int size) {
		this.nbList = nbList;
		this.size = size;
	}

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
}
