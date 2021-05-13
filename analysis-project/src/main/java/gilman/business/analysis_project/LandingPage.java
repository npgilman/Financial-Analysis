package gilman.business.analysis_project;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class LandingPage extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public StockPanel stockChart;
	
	public StockComboBox stockSelector;
	
	public LandingPage() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.stockSelector = new StockComboBox();
		this.stockChart = new StockPanel((String) stockSelector.getSelectedItem());
		add(stockSelector);
		add(stockChart);
		
		stockSelector.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> jb = (JComboBox<String>)e.getSource();
				String activeTicker = (String)jb.getSelectedItem();
				stockChart.updateStock(activeTicker);
			}
			
		});
		
		
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

