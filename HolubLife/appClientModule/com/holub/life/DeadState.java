package com.holub.life;

public class DeadState implements State {
	Cell contextCell;

	public DeadState(Cell contextCell) {
		this.contextCell = contextCell;
	}

	
	@Override
	public boolean getState() {
	return false;
	}

	
}
