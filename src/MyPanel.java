import javax.swing.JFrame;
import javax.swing.UIManager;

public class MyPanel {
	static JFrame frame = new JFrame();
	String lookAndFeel = null;
	
	MyPanel(){
		lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		frame.setSize(900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void setBackgraund(Backgraund backgraund) {
		backgraund.setLayout(null);
		backgraund.setSize(900, 600);
		frame.setContentPane(backgraund);
	}

	
	
}
