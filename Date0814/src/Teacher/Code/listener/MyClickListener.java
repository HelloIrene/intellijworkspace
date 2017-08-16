package Teacher.Code.listener;

import Teacher.Code.ui.DialogFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;


public class MyClickListener implements ActionListener {

	private DialogFrame frame;

	public MyClickListener(DialogFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color c = JColorChooser.showDialog(frame, "Ñ¡ÔñÑÕÉ«", Color.BLACK);
		frame.getPnlMain().setBackground(c);
	}

}
