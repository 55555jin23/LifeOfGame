package com.holub.life.create;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.holub.io.FileDo;
import com.holub.life.Cell;
import com.holub.life.Clock;
import com.holub.life.Universe;

public class ActionCreate implements Create{
	@Override
	public Object create(final Cell outermostCell,String fuc) {
		// TODO Auto-generated method stub
		if(fuc=="Store"){
			return new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{	FileDo.doStore(outermostCell);
				}
			};
		}
		else if(fuc=="Clear"){
			return new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{	outermostCell.clear();
					Universe.instance().repaint();
				};
			};
		}
		else if(fuc=="Load"){
			return new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{	FileDo.doLoad(outermostCell);
				}
			};
		}
		else if(fuc=="Exit"){
			
			return new ActionListener()
			{	public void actionPerformed(ActionEvent e)
	        	{	System.exit(0);
	        	}
			};
		}
		else if(fuc=="Modifier"){
			return new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{
					String name = ((JMenuItem)e.getSource()).getName();
					char toDo = name.charAt(0);

					if( toDo=='T' )
						Clock.instance().tick();				      // single tick
					else
						Clock.instance().startTicking(   toDo=='A' ? 500:	  // agonizing
										toDo=='S' ? 150:	  // slow
										toDo=='M' ? 70 :	  // medium
										toDo=='F' ? 30 : 0 ); // fast
				}
			};
			
		}
		return null;
	}

}
