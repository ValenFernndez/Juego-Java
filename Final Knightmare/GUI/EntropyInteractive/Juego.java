package EntropyInteractive;

import java.awt.Graphics2D;

public abstract class Juego extends JGame {
	public Juego(String name, int x, int y){super(name, x, y);}
	abstract public void gameUpdate(double delta);
	abstract public void gameStartup();
	abstract public void gameDraw(Graphics2D g);
	abstract public void gameShutdown();
}