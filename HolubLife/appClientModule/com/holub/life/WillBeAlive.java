package com.holub.life;

public class WillBeAlive implements State {
	Cell contextCell;

	public WillBeAlive(Cell contextCell) {
		this.contextCell = contextCell;
	}
	
	@Override
	public boolean getState() {
	return true;
	}
	
}
