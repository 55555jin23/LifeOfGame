package com.holub.life;

public class AliveState implements State{
	Cell contextCell;

	public AliveState(Cell contextCell) {
		this.contextCell = contextCell;
	}
	
	
	@Override
	public boolean getState() {
	return true;
	}
	

}
