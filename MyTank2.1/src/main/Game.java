package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game {
	public static void main(String...args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new TankFrame().lunch();;
            }
        });
	}
}
@SuppressWarnings("serial")
class TankFrame extends JFrame {
	public TankFrame() {
		setIconImage(new ImageIcon("D:\\WorkSpaces\\MyData\\Icon\\TankWorld.PNG").getImage());
		setTitle("ÃπøÀ ¿ΩÁ Ver 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	public void lunch() {
		setContentPane(new TankPanel().lunch());
		setJMenuBar(new TankMenuBar());
		pack();
		setVisible(true);
	}
}
