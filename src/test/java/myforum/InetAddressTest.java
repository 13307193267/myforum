package myforum;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.*;

import javax.faces.event.*;

public class InetAddressTest {

	static TextField f1 = new TextField(40);
	static List list = new List(6);

	public static void main(String[] are) {
		Frame f = new Frame();
		f.add(list);
		f.setSize(400, 400);
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		f1.addActionListener(null);
		p.add("West", f1);
		f.add("South", p);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setVisible(true);
	}

}

class MyListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		String s = InetAddressTest.f1.getText();
		InetAddress[] addr;

		try {
			InetAddressTest.list.removeAll();
			addr = InetAddress.getAllByName(s);
			for (int i = 0; i < addr.length; i++) {
				InetAddressTest.list.add(addr[i].toString());
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		((TextField) e.getSource()).setText(null);
	}

	@Override
	public void processAction(ActionEvent arg0) throws AbortProcessingException {
		// TODO Auto-generated method stub

	}
}
