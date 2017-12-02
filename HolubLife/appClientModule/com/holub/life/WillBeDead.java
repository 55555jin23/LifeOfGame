package com.holub.life;

public class WillBeDead implements State {
	Cell contextCell;

	public WillBeDead(Cell contextCell) {
		this.contextCell = contextCell;
	}
	
	@Override
	public boolean getState() {
	return false;
	}

}
