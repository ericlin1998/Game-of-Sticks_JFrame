import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TEst extends JFrame implements ActionListener {
	JTextField textField;
	JTextField jtfInput;
	JTextArea jtAreaOutput;
	String newline = "\n";
	public TEst() {
		createGui();
	}
	public void createGui() {
		textFeild = new JTextField(20);
		textField.setEditable(false);
		
		jtfInput = new JTextField(20);
		jtfInput.addActionListener(this);
		jtAreaOutput = new JTextArea(5, 20);
		jtAreaOutput.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(jtAreaOutput,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagLayout gridBag = new GridBagLayout();
		Container contentPane = getContentPane();
		contentPane.setLayout(gridBag);
		GridBagConstraints gridCons1 = new GridBagConstraints();
		gridCons1.gridwidth = GridBagConstraints.REMAINDER;
		gridCons1.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints gridCons2 = new GridBagConstraints();
		gridCons2.gridwidth = GridBagConstraints.REMAINDER;
		gridCons2.weightx = 1.0;
		gridCons2.weighty = 1.0;
		gridCons2.fill = GridBagConstraints.BOTH;
		GridBagConstraints gridCons3 = new GridBagConstraints();
		gridCons3.gridwidth = GridBagConstraints.REMAINDER;
		gridCons3.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(scrollPane, gridCons2);
		contentPane.add(textField, gridCons3);
		contentPane.add(jtfInput, gridCons1);
	}
	public void actionPerformed(ActionEvent evt) {
		String text = jtfInput.getText();
		jtAreaOutput.append(text + newline);
		jtfInput.selectAll();
	}
	public static void main(String[] args) {
		TEst jtfTfDemo = new TEst();
		jtfTfDemo.pack();
		jtfTfDemo.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		jtfTfDemo.setVisible(true);
	}
}