package jogo;

import java.awt.Graphics2D;
import java.awt.Image;

import br.senai.sc.engine.Utils;

public class Player {

	private int posX;
	private int posY;
	private int velX;
	private int velY;
	private int width;
	private int height;
	private int frameX;
	private int frameY;
	private boolean right;
	private boolean walking;
	private Image image;

	public Player() {
		image = Utils.getInstance().loadImage("imagens/sonic.png");
		posX = 50;
		posY = Utils.getInstance().getHeight() - 200;
		width = 120;
		height = 115;
		velX = 5;
		velY = 0;
		frameX = 0;
		frameY = 0;
	}

	public int getPosX() {
		if (posX > 0) {
			System.out.println("Get Pos X");
		}
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		if (right && velX < 0) {
			this.velX *= -1;
		} else if (!right && velX > 0) {
			this.velX *= -1;
		}
		this.right = right;
	}

	public boolean isWalking() {
		return walking;
	}

	public void setWalking(boolean walking) {
		if (!walking) {
			this.frameY = 0;
			if (right) {
				this.frameX = 0;
			} else {
				this.frameX = 1;
			}
		} else {
			if (right) {
				this.frameY = 1;
			} else {
				this.frameY = 2;
			}
		}
		this.walking = walking;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getFrameX() {
		return frameX;
	}

	public void setFrameX(int frameX) {
		this.frameX = frameX;
	}

	public int getFrameY() {
		return frameY;
	}

	public void setFrameY(int frameY) {
		this.frameY = frameY;
	}
	
	public void update() {
		if (walking) {
			System.out.println(frameX);
			this.frameX++;
			if (this.frameX == 8) {
				this.frameX = 0;
			}
			System.out.println("PosX: (" + getPosX() + " + " + getVelX() + ")");
			setPosX(getPosX() + getVelX());
		}
	}

	public void draw(Graphics2D g) {
		// 1º - Imagem
		// 2º - Posição X da tela onde irá iniciar o desenho da imagem
		// 3º - Posição Y da tela onde irá iniciar o desenho da imagem
		// 4º - Largura da imagem que será desenhada na tela
		// 5º - Altura da imagem que será desenada na tela
		// 6º - Posição X do Sprite onde irá iniciar o recorte da imagem
		// 7º - Posição Y do Sprite onde irá iniciar o recore da imagem
		// 8º - Posição X do Sprite onde irá terminar o recorte da imagem
		// 9º - Posição Y do Sprite onde irá terminar o recorte da imagem
		// 10º - ImageObserver sempre será null.
		g.drawImage(getImage(), getPosX(), getPosY(), width + getPosX(), height + getPosY(), 
				(frameX * width), (frameY * height), (frameX * width) + width, (frameY * height) + height, null);
	}

}
