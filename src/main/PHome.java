package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PHome extends JPanel {
	private static final long serialVersionUID = 4025631048750619547L;
	
	private OntologyHelper oh;

	private JButton howto;
	private JButton credits;
	private JButton contact;
	private JButton exit;
	private JButton runQuery;
	private JLabel lOntUrl, lOntQuery;
	private JTextField ontUrl;
	private JTextArea ontQuery;
	public static JTextArea textFinal;
	
	public PHome() {
		setLayout(null);
		setBackground(new Color(0, 153, 102));

		lOntUrl = new JLabel("Type your URL");
		add(lOntUrl);
		lOntUrl.setBounds(50, 60, 110, 20);
		
		ontUrl = new JTextField();
		add(ontUrl);	
		ontUrl.setBounds(50, 80, 400, 20);
		
		lOntQuery = new JLabel("Type your Query");
		add(lOntQuery);
		lOntQuery.setBounds(50, 130, 110, 20);
		
		ontQuery = new JTextArea();
		add(ontQuery);	
		ontQuery.setBounds(50, 150, 500, 200);
		
		textFinal = new JTextArea();
		add(textFinal);
		textFinal.setBounds(600, 200, 300, 100);
		
		runQuery = new JButton("Run Query");
		add(runQuery);	
		runQuery.setBounds(50, 380, 110, 20);
		
		runQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchUrl = ontUrl.getText();
				String searchQuery = ontQuery.getText();
				System.out.println(searchUrl);
				System.out.println(searchQuery);
				
				oh = new OntologyHelper();
				oh.populateFoafFriends(searchUrl);	
				oh.runQuery(searchQuery, OntologyHelper.friends);
			}
		});
		
		
		// MENU OPTIONS

		howto = new JButton("How To Use");
		add(howto);
		howto.setBounds(1100, 550, 110, 20);

		howto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"Home Panel : " + "There are information about dev team in home page.\n"
								+ "Smart Search Panel : "
								+ "You can search for a contact both with name or his/her phone with the help of Smart Search.\n"
								+ "Create Contact : " + "You can add new contacts to the phonebook.\n" + "List All : "
								+ "Lists all contacts in an alphabetical order.");
			}
		});

		credits = new JButton("Credits");
		add(credits);
		credits.setBounds(1100, 575, 110, 20);

		credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Ahmet KASIF\nAbdullah OGUK");
			}
		});

		contact = new JButton("Contact");
		add(contact);
		contact.setBounds(1100, 600, 110, 20);

		contact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						" Ahmet KASIF\n e - mail: ahmetkasif1995@gmail.com\n Abdullah OGUK\n e - mail: abdullahoguk@outlook.com");
			}
		});

		exit = new JButton("Exit");
		add(exit);
		exit.setBounds(1100, 625, 110, 20);

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null, "Thanks For Using Us...");
				System.exit(0);
			}
		});

	}
}
