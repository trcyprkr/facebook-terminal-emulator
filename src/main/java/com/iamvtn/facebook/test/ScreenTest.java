package com.iamvtn.facebook.test;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

public class ScreenTest {
	public static void main(String[] args) throws InterruptedException {
		Screen screen = TerminalFacade.createScreen();
		screen.startScreen();
		screen.putString(10, 2, "Hello World", Terminal.Color.WHITE, Terminal.Color.BLACK);
		screen.refresh();

		screen.readInput();
		
		boolean keepRunning = true;
		StringBuffer sb = new StringBuffer();
		while (keepRunning) {
			Key key = screen.readInput();

			while (key == null) {
				key = screen.readInput();
			}

			System.out.println("Key pressed: " + key.getKind().toString());

			switch (key.getKind()) {
				case Escape:
					screen.stopScreen();
					System.exit(0);
					break;
				case ArrowRight:
					screen.putString(20, 15, "Width of the window: " + screen.getTerminalSize().getColumns(),
							Terminal.Color.WHITE, Terminal.Color.BLACK);
					screen.putString(20, 16, "Height of the window: " + screen.getTerminalSize().getRows(),
							Terminal.Color.WHITE, Terminal.Color.BLACK);
					screen.refresh();
					break;
				case NormalKey:
					sb.append(key.getCharacter());
					System.out.println(key.getCharacter());
					break;
				case Enter:
					screen.clear();
					screen.putString(10, 10, sb.toString() + screen.getTerminalSize().getRows(),
							Terminal.Color.YELLOW, Terminal.Color.BLACK);
					screen.refresh();
					System.out.println(sb.toString());
					break;
				case ArrowUp:
					for (int i = 20; i < 80; i++) {
						screen.putString(i, 25, "X", Terminal.Color.CYAN, Terminal.Color.CYAN);
						Thread.sleep(25);
						screen.refresh();
					}
					break;
				default:
					System.out.println("Another key press: " + key.getKind().toString());

			}

		}
	}
}
