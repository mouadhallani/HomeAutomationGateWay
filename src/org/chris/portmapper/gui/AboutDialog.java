package org.chris.portmapper.gui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.chris.portmapper.PortMapperApp;
import org.chris.portmapper.util.URLLabel;
import org.jdesktop.application.Action;

@SuppressWarnings("serial")
public class AboutDialog extends JDialog {

	private final static String DIALOG_NAME = "about_dialog";
	private final static String ACTION_CLOSE = "about_dialog.close";

	public AboutDialog() throws HeadlessException {
		super(PortMapperApp.getInstance().getMainFrame(), true);

		this.setName(DIALOG_NAME);
		ActionMap actionMap = PortMapperApp.getInstance().getContext()
				.getActionMap(this.getClass(), this);

		JPanel pane = new JPanel(new MigLayout("", "[center,grow]", "")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		this.add(pane);

		pane.add(createLabel("about_dialog.label1"), "wrap");
		pane.add(createLabel("about_dialog.label2"), "wrap");
		pane.add(createLabel("about_dialog.label3"), "wrap");
		pane.add(createLabel("about_dialog.label4"), "wrap");
		pane.add(createLabel("about_dialog.label5"), "wrap");
		pane
				.add(
						new URLLabel(
								"http://sourceforge.net/projects/upnp-portmapper/", "http://sourceforge.net/projects/upnp-portmapper/"), //$NON-NLS-1$
						"wrap unrelated"); //$NON-NLS-1$
		JButton closeButton = new JButton(actionMap.get(ACTION_CLOSE)); //$NON-NLS-1$
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		pane.add(closeButton);
		this.pack();
	}

	@Action(name = ACTION_CLOSE)
	public void close() {
		this.dispose();
	}

	private JLabel createLabel(String name) {
		JLabel newLabel = new JLabel(name);
		newLabel.setName(name);
		return newLabel;
	}
}
