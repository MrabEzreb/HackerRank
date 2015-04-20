package com.ezrebclan.practice.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import com.ezrebclan.practice.algorithms.SolveMeFirst;
import com.ezrebclan.practice.algorithms.SolveMeSecond;
import com.ezrebclan.practice.algorithms.UtopianTree;

public class AutomatedTester {
	
	public static void main(final String[] args) {
		utopianTree();
	}
	
	@SuppressWarnings("unused")
	private static void solveMeFirst() {
		String[] args = {
				"2",
				"3"
		};
		writeToSysin(args[0]);
		writeToSysin(args[1]);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SolveMeFirst s = new SolveMeFirst();
		s.main(null);
	}
	
	@SuppressWarnings("unused")
	private static void solveMeSecond() {
		String[] args = {
				"2",
				"2 3",
				"3 7"
		};
		writeToSysin(args[0]);
		writeToSysin(args[1]);
		writeToSysin(args[2]);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SolveMeSecond s = new SolveMeSecond();
		s.main(null);
	}
	
	private static void utopianTree() {
		String[] args = {
				"3",
				"0",
				"1",
				"4"
		};
		writeToSysin(args[0]);
		writeToSysin(args[1]);
		writeToSysin(args[2]);
		writeToSysin(args[3]);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UtopianTree ut = new UtopianTree();
		ut.main(null);
	}
	
	public static void writeToSysin(String string) {
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.mouseMove(400, 725);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
		String[] characters = string.split("");
		for (int i = 1; i < characters.length; i++) {
			r.keyPress(KeyEvent.getExtendedKeyCodeForChar(characters[i].charAt(0)));
			r.keyRelease(KeyEvent.getExtendedKeyCodeForChar(characters[i].charAt(0)));
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}
