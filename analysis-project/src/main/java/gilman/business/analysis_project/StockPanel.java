package gilman.business.analysis_project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import yahoofinance.Stock;
import yahoofinance.histquotes.HistoricalQuote;

public class StockPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Stock currentStock;
	private Label activeTicker;
	private StockGraph stockGraph;
	
	public StockPanel(String tickerSymbol) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		currentStock = new Stock(tickerSymbol);
		activeTicker = new Label(tickerSymbol);
		stockGraph = new StockGraph();
		add(activeTicker);
		add(stockGraph);
		//Temporary Border
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		drawChart();

	}
	
	
	public void drawChart() {
		List<HistoricalQuote> prices;
		try {
			prices = currentStock.getHistory();
		} catch (IOException e) {
			e.printStackTrace();
			prices = null;
		}
		for (HistoricalQuote hq : prices) {
			System.out.println(hq.getClose());
		}
		
		stockGraph.setPrices(prices);
		stockGraph.repaint();
	}
	
	public void updateStock(String newTicker) {
		currentStock = new Stock(newTicker);
		activeTicker.setText(newTicker);
		drawChart();
		
	}
	
}

class StockGraph extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private List<HistoricalQuote> prices;
	private int maximumQuote;
	private int minimumQuote;
	
	public StockGraph() {
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public List<HistoricalQuote> getPrices() {
		return prices;
	}

	public void setPrices(List<HistoricalQuote> prices) {
		this.prices = prices;
		
		int currentMax = prices.get(0).getClose().intValue();
		int currentMin = prices.get(0).getClose().intValue();
		for (HistoricalQuote hq : prices) {
			int val = hq.getClose().intValue();
			if (val < currentMin) currentMin = val;
			if (val > currentMax) currentMax = val;
		}
		this.setMaximumQuote(currentMax);
		this.setMinimumQuote(currentMin);
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		List<Point> points = new ArrayList<Point>();
		for (int i = 0; i < prices.size(); i++) {
			int x = (i*getWidth()/prices.size());
			int y = (prices.get(i).getClose().intValue()) / getMaximumQuote() * getHeight();
			points.add(new Point(x,y));
		}
		
		for (int i = 0; i < points.size() - 1; i++) {
			int x1 = points.get(i).x;
			int y1 = points.get(i).y;
			int x2 = points.get(i+1).x;
			int y2 = points.get(i+1).y;
			g.drawLine(x1, y1, x2, y2);
		}
		
	}

	public int getMinimumQuote() {
		return minimumQuote;
	}

	public void setMinimumQuote(int minimumQuote) {
		this.minimumQuote = minimumQuote;
	}

	public int getMaximumQuote() {
		return maximumQuote;
	}

	public void setMaximumQuote(int maximumQuote) {
		this.maximumQuote = maximumQuote;
	}
	   
}
