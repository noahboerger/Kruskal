import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UserInterface extends JFrame implements ActionListener {

	JButton matrix_loesen;
	JButton datei_auswaehlen;
	JLabel top_label;

	String path;

	public static void main(String[] args) {
		new UserInterface();
	}

	public UserInterface() {
		matrix_loesen = new JButton("Matrix lösen");
		matrix_loesen.setPreferredSize(new Dimension(140, 0));
		datei_auswaehlen = new JButton("Matrixdatei laden");
		datei_auswaehlen.setPreferredSize(new Dimension(140, 0));
		top_label = new JLabel("Kruskal lösen", JLabel.CENTER);
		top_label.setFont(new Font(top_label.getFont().getName(), top_label.getFont().getStyle(), 18));

		matrix_loesen.addActionListener((ActionListener) this);
		datei_auswaehlen.addActionListener((ActionListener) this);

		setBounds(10, 10, 280, 100);
		setLayout(new BorderLayout());

		add(matrix_loesen, BorderLayout.EAST);
		add(datei_auswaehlen, BorderLayout.WEST);
		add(top_label, BorderLayout.NORTH);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event)  {
		if (event.getSource() == datei_auswaehlen) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Dateien", "csv");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				path = chooser.getSelectedFile().getPath();
			}
		} else if (event.getSource() == matrix_loesen) {
			if (path == null) {
				JOptionPane.showMessageDialog(this, "Bitte wählen Sie den Pfad vorher aus", "Pfad wählen",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
				try {
					Graph graph = GraphIO.readGraph(path);
					graph.printGraph();
					
					Kruskal.kruskal(graph);
					
					System.out.println("Blah Blah Spannbaum: ");
					int gesamtkosten = 0;
					for(Edge e: graph.edges()) {
						if(e.isStatus()) {
							System.out.println("(" + e.getLeft().getName() + "," + e.getRight().getName() + ")  " + e.getCost());
							gesamtkosten += e.getCost();
						}
					}
					System.out.println("Gesamstkosten: " + gesamtkosten);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "Ausgewählte Datei kann nicht gelesen werden \nNur CSV Dateien im richtigen Format können gelesen werden", "Anderen Pfad wählen",
							JOptionPane.ERROR_MESSAGE);
				}
		}
	}
}
