package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEConstants.EEditMenuItems;
import frames.GEDrawingPanel;
import shapes.GEGroup;
import shapes.GEShape;

public class GEMenuEdit extends JMenu {

	private GEDrawingPanel drawingPanel;

	public GEMenuEdit(String s) {
		super(s);
		for (EEditMenuItems btn : EEditMenuItems.values()) {
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(new EditMenuHandler());
			menuItem.setActionCommand(btn.toString());
			this.add(menuItem);
		}
	}

	public void init(GEDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	private class EditMenuHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switch (EEditMenuItems.valueOf(e.getActionCommand())) {
			case Group:
				drawingPanel.group(new GEGroup());
				break;
			case Ungroup:
				drawingPanel.unGroup();
				break;
			case Redo:
				drawingPanel.redo();
				break;
			case Undo:
				drawingPanel.undo();
				break;
			case ����:
				drawingPanel.copy();
				break;
			case ���̱�:
				drawingPanel.paste();
				break;
			case ����:
				drawingPanel.delete();
				break;
			case �߶󳻱�:
				drawingPanel.cut();
				break;
			}
		}
	}
}
