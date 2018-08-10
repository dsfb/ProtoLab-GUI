package com.google.sites.danieltcc1.view;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PlotGraph extends JFrame {
	/**
   * 
   */
	private static final long serialVersionUID = 1L;

	public PlotGraph(final String title, final String TitleGraph,
			final String Xaxis, final String Yaxis, double value1, double value2) {
		super(title);
		final XYSeries series = new XYSeries(TitleGraph);
		double[] xArr;
		double[] yArr;

		xArr = new double[40];
		yArr = new double[40];

		for (int i = 0; i < 40; i++) {
			xArr[i] = i / 20.0;
			yArr[i] = value1 + (value2 - value1)
					* (1.0 - Math.exp(-(i - 20) / (0.143 * 10))) * (i / 20);
			series.add(xArr[i], yArr[i]);
		}
		final XYSeriesCollection data = new XYSeriesCollection(series);
		final JFreeChart chart = ChartFactory
				.createXYLineChart(TitleGraph, Xaxis, Yaxis, data,
						PlotOrientation.VERTICAL, true, true, false);

		if (value1 != 0 && value2 != 0) {
			chart.getXYPlot().getRangeAxis()
					.setRange(value1 * 0.95, value2 * 1.05);
		} else if (value1 == 0 && value2 != 0) {
			if (value2 >= 15.0)
				chart.getXYPlot().getRangeAxis().setRange(-10.0, value2 * 1.05);
			else if (value2 >= 10.0)
				chart.getXYPlot().getRangeAxis().setRange(-5.0, value2 * 1.05);
			else
				chart.getXYPlot().getRangeAxis().setRange(-1.0, value2 * 1.05);
		} else if (value1 != 0 && value2 == 0) {
			if (value1 < 0) {
				if (value1 <= -15.0)
					chart.getXYPlot().getRangeAxis()
							.setRange(value1 * 0.95, 10.0);
				else if (value1 <= -10.0)
					chart.getXYPlot().getRangeAxis()
							.setRange(value1 * 0.95, 5.0);
				else
					chart.getXYPlot().getRangeAxis()
							.setRange(value1 * 0.95, 1.0);
			} else {
				if (value1 >= 15.0)
					chart.getXYPlot().getRangeAxis()
							.setRange(-10.0, value1 * 1.05);
				else if (value1 >= 10.0)
					chart.getXYPlot().getRangeAxis()
							.setRange(-5.0, value1 * 1.05);
				else
					chart.getXYPlot().getRangeAxis()
							.setRange(-1.0, value1 * 1.05);
			}
		} else if (value1 == 0 && value2 == 0) {
			chart.getXYPlot().getRangeAxis().setRange(-10.0, 10.0);
		}
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(650, 300));
		setContentPane(chartPanel);
	};
}