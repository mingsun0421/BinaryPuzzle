package com.mingsun.cs2800;

import java.awt.EventQueue;

public class CalcController {
	private static CalcView view;
	
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view = new CalcView();
					view.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
