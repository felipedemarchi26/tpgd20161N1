package jogo;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class Jogo extends Game {

	private Player player;
	
	public Jogo() {
		addKeyListener(new KeyInputHandler());
	}
	
	@Override
	public void aposTermino() {
	}

	@Override
	public void gameLoop() {
		desenharRetangulo(0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight(), Color.BLACK);
		player.draw(getGraphics2D());
		player.update();
	}

	@Override
	public void init() {
		player = new Player();
	}
	
	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		jogo.startGame();
	}

	private class KeyInputHandler extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_D) {
				player.setRight(true);
				player.setWalking(true);
			} else if (e.getKeyCode() == KeyEvent.VK_A) {
				player.setRight(false);
				player.setWalking(true);
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_D) {
				player.setWalking(false);
			} else if (e.getKeyCode() == KeyEvent.VK_A) {
				player.setWalking(false);
			}
		}
	}
	
}
