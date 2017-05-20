package interfaces;

import java.awt.event.KeyEvent;

public interface Listenable {
	public void keyPress(KeyEvent e);
	public void keyReleased(KeyEvent e);
}
