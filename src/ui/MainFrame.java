package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.PHome;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static int dimX = 1280,dimY = 720;
	JPanel pMain;
	private JPanel pCardHolder;
	public CardLayout cardLayout;
	public static PHome pHome;

	public MainFrame() {
		super("Phone Book App");

		setLayout(new BorderLayout());

		pMain = new JPanel();
		add(pMain, BorderLayout.CENTER);

		setLayout(new BorderLayout());

		// CARD HOLDER PANEL STARTS

		pCardHolder = new JPanel();
		add(pCardHolder, BorderLayout.CENTER);

		CardLayout layout = new CardLayout();
		layout.setHgap(0);
		layout.setVgap(0);
		pCardHolder.setLayout(layout);

		pHome = new PHome();
		pHome.setBackground(new Color(0, 153, 255));
		pCardHolder.add("pHome", pHome);

		setSize(dimX, dimY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
}
