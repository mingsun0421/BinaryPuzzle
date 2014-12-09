package com.mingsun.cs2800;

import java.awt.EventQueue;
/**
 * This is main class for the calculator program.
 * @author Ming Sun email<zaac003@live.rhul.ac.uk>
 * @since 06/12/2014
 */
 public final class CalcController {
	/**
	 * @param view CalcView
	 */
	private static CalcView view;
	/**
	 * This is main method.
	 * @param args String[] Stirng array
	 */
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
