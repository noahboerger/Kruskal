import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UserInterface extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	// JFrame Variablen
	private JButton matrix_loesen;
	private JButton graph_anzeigen;
	private JButton datei_auswaehlen;
	private JLabel top_label;

	// Pfad in welchem der Graph liegen soll
	private String path;

	// Konstruktor (initialisiert JFrame)
	public UserInterface() {
		matrix_loesen = new JButton("Matrix l�sen");
		graph_anzeigen = new JButton("Graph anzeigen");
		datei_auswaehlen = new JButton("Matrixdatei laden");
		top_label = new JLabel("Matrix per Kruskal l�sen", JLabel.CENTER);
		top_label.setFont(new Font(top_label.getFont().getName(), top_label.getFont().getStyle(), 18));

		matrix_loesen.addActionListener((ActionListener) this);
		graph_anzeigen.addActionListener((ActionListener) this);
		datei_auswaehlen.addActionListener((ActionListener) this);

		setBounds(10, 10, 375, 100);
		setLayout(new BorderLayout());

		add(matrix_loesen, BorderLayout.EAST);
		add(graph_anzeigen, BorderLayout.CENTER);
		add(datei_auswaehlen, BorderLayout.WEST);
		add(top_label, BorderLayout.NORTH);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// ActionEvent f�r JFramekomponenten
	@Override
	public void actionPerformed(ActionEvent event) {
		// Datei ausw�hlen Button �ffnet FileChooser um Pfad f�r zu lesende csv
		// festzulegen
		if (event.getSource() == datei_auswaehlen) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Dateien", "csv");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				path = chooser.getSelectedFile().getPath();
			}

		} else if (event.getSource() == graph_anzeigen) {
			// Graph anzeigen Button l�d den Graphen (insofern m�glich) und gibt dessen
			// Adjazenslisten auf neuem JFrame aus
			if (path == null) {
				JOptionPane.showMessageDialog(this, "Bitte w�hlen Sie einen Pfad aus", "Pfad w�hlen",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				Graph graph = GraphReader.readGraph(path);

				String ausgabetext = graph.toString();

				int ausgabegroese = 0;
				char tempArray[] = ausgabetext.toCharArray();
				for (char c : tempArray) {
					if (c == '<') {
						ausgabegroese++;
					}
				}

				JFrame ausgabe = new JFrame("Berechneter Spannbaum:");
				ausgabe.setBounds(10, 10, 400, 40 + (ausgabegroese - 3) * 20);
				ausgabe.add(new JLabel(ausgabetext), JLabel.CENTER);
				ausgabe.setResizable(false);
				ausgabe.setVisible(true);

			} catch (Exception e) {
				// Hier ist Exception Handling sinnvoll, da der User auf seine Fehlauswahl
				// aufmerksam gemacht werden kann und das Programm so problemlos weiterl�uft
				JOptionPane.showMessageDialog(this,
						"Ausgew�hlte Datei kann nicht gelesen werden \nNur CSV Dateien im richtigen Format k�nnen gelesen werden",
						"Anderen Pfad w�hlen", JOptionPane.ERROR_MESSAGE);
				return;
			}

		} else if (event.getSource() == matrix_loesen) {
			// Matrix L�sen Button l�d den Graphen aus dem angegebenen Pfad (insofern
			// m�glich), ruft mit ihm die Kruskal-Methode auf und gibt die L�sung auf einem
			// neuen JFrame aus
			if (path == null) {
				JOptionPane.showMessageDialog(this, "Bitte w�hlen Sie einen Pfad aus", "Pfad w�hlen",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				Graph graph = GraphReader.readGraph(path);

				Kruskal.kruskal(graph);

				String ausgabetext = "<html><body><center>Spannbaum: <br><br>";
				int gesamtkosten = 0;
				int ausgabegroese = 0;
				for (Edge e : graph.edges()) {
					if (e.isStatus()) {
						ausgabetext += "(" + e.getLeft().getName() + "," + e.getRight().getName() + ")  " + e.getCost()
								+ "<br>";
						gesamtkosten += e.getCost();
						ausgabegroese++;
					}
				}
				ausgabetext += "<br>Gesamstkosten: " + gesamtkosten + "</center></body></html>";

				JFrame ausgabe = new JFrame("Berechneter Spannbaum:");
				ausgabe.setBounds(10, 10, 180, 100 + ausgabegroese * 20);
				ausgabe.add(new JLabel(ausgabetext), JLabel.CENTER);
				ausgabe.setResizable(false);
				ausgabe.setVisible(true);

			} catch (NullPointerException e) {
				// Hier ist Exception Handling sinnvoll, da der User auf seine fehlerhaften
				// Graphen aufmerksam gemacht werden kann und das Programm so problemlos
				// weiterl�uft
				JOptionPane.showMessageDialog(this,
						"Kein Zusammenh�ngender Graph\nBitte w�hlen Sie eine CSV Datei mit zusammenh�ngendem Graphen",
						"Andere CSV Datei w�hlen", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (Exception e) {
				// Hier ist Exception Handling sinnvoll, da der User auf seine Fehlauswahl
				// aufmerksam gemacht werden kann und das Programm so problemlos weiterl�uft
				JOptionPane.showMessageDialog(this,
						"Ausgew�hlte Datei kann nicht gelesen werden \nNur CSV Dateien im richtigen Format k�nnen gelesen werden",
						"Anderen Pfad w�hlen", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}
}
