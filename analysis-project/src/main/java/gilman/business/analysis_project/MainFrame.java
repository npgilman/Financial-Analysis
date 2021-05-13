package gilman.business.analysis_project;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	final static private String HEADER = "Gilman Analysis";
	final static private int WIDTH = 960;
	final static private int HEIGHT = 540;
	
	private JPanel ActivePanel;
	
	public MainFrame() {
		super(HEADER);
		setBounds((250), (150), WIDTH, HEIGHT);
		setActivePanel(new LandingPage());
		add(ActivePanel);
		
	}
	
	public static void main(String[] args) {
		MainFrame testFrame = new MainFrame();
		testFrame.setVisible(true);
		
	}

	public JPanel getActivePanel() {
		return ActivePanel;
	}

	public void setActivePanel(JPanel activePanel) {
		ActivePanel = activePanel;
	}
}