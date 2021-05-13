package gilman.business.analysis_project;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class LandingPage extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	
	public LandingPage() {
		super();
		add(new TempButton("Temporary Button"));
		add(new StockComboBox());
		
		
	}
	
	
	
	
}

class TempButton extends Button {

	private static final long serialVersionUID = 1L;
	private int counter;
	private final String originalText;
	
	public TempButton(String text) {
		super(text);
		originalText = text;
		setCounter(0);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				counter++;
				setLabel(getOriginalText() + ": " + counter);
			}
			
		});
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getOriginalText() {
		return originalText;
	}
}

class StockComboBox extends JComboBox<String> {
	
	private static final long serialVersionUID = 1L;
	
	final private static String[] tickerSymbols = {"F", "LMT", "TSLA"};
	
	public StockComboBox() {
		super(tickerSymbols);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: CHANGE THE DISPLAYED PANEL TO THE ASSOCIATED STOCKS
				JComboBox<String> jb = (JComboBox<String>)e.getSource();
				String activeTicker = (String)jb.getSelectedItem();
				System.out.println("Active Ticker: " + activeTicker);
			}
			
		});
		
	}
	
}

