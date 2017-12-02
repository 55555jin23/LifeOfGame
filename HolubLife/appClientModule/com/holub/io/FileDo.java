package com.holub.io;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.holub.life.Cell;
import com.holub.life.Clock;
import com.holub.life.Storable;
import com.holub.life.Universe;

public class FileDo {
	public static void doLoad(Cell outermostCell) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream in = new FileInputStream(
			   Files.userSelected(".",".life","Life File","Load"));

			Clock.instance().stop();		// stop the game and
			outermostCell.clear();			// clear the board.

			Storable memento = outermostCell.createMemento();
			memento.load( in );
			outermostCell.transfer( memento, new Point(0,0), Cell.LOAD );

			in.close();
		}
		catch( IOException theException )
		{	JOptionPane.showMessageDialog( null, "Read Failed!",
					"The Game of Life", JOptionPane.ERROR_MESSAGE);
		}
		Universe.instance().repaint();
	}
	
	public static void doStore(Cell outermostCell) {
		// TODO Auto-generated method stub
		try
			{
				FileOutputStream out = new FileOutputStream(
					  Files.userSelected(".",".life","Life File","Write"));
				Clock.instance().stop();		// stop the game

				Storable memento = outermostCell.createMemento();
				outermostCell.transfer( memento, new Point(0,0), Cell.STORE );
				memento.flush(out);

				out.close();
			}
			catch( IOException theException )
			{	JOptionPane.showMessageDialog( null, "Write Failed!",
						"The Game of Life", JOptionPane.ERROR_MESSAGE);
			}
		
	}
}
