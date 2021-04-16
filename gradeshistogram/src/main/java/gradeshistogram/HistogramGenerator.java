package gradeshistogram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class HistogramGenerator {

	/***
	 * 
	 * @author @katerinadimatou The purpose of this assignment is to demonstrate a
	 *         simple scenario of a JFreeChart XYLine chart and make a Histogram of
	 *         frequencies.
	 */

	public static void main(String[] args) throws FileNotFoundException {
		// Reading the data from the file
		Scanner sc = new Scanner(new FileInputStream(args[0]));
		ArrayList<Integer> data = new ArrayList<Integer>();

		while (sc.hasNext()) {
			int x = sc.nextInt();
			data.add(x);
		}

		HistogramGenerator demo = new HistogramGenerator();
		int[] dataValues = demo.getData(data);

		demo.generateChart(dataValues);

	}

	/***
	 * Receives an Integer ArrayList and returns a single Integer array containing
	 * the values
	 * 
	 * @param input Integer ArrayList
	 */

	public int[] getData(ArrayList<Integer> input) {

		int[] dataValues = new int[input.size()];

		// Turning the ArrayList into a single Integer Array
		int y = 0;
		for (final Integer value : input) {
			dataValues[y++] = value;
		}

		return dataValues;
	}

	/***
	 * Receives a single dimension Integer array. From this array the dataset that
	 * will be used for the visualization is generated. Finally, The chart is
	 * generated with the use of the aforementioned dataset and then presented in
	 * the screen.
	 * 
	 * @param dataValues Single dimension integer array
	 */

	public void generateChart(int[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");
		/*
		 * Counting the different values in the array
		 */
		ArrayList<Integer> diffNum = new ArrayList<Integer>();
		for (int i = 0; i < dataValues.length; i++) {
			if (!diffNum.contains(dataValues[i])) {
				diffNum.add(dataValues[i]);
			}
		}
		
		//Sorting the ArrayList
		Collections.sort(diffNum);
			
		/*
		 * Counting the frequency of every value and adding series to the dataset 
		 */
		for (int j=0; j< diffNum.size(); j++) {
			int counter = 0;
			for (int w=0; w< dataValues.length; w++){
				if (diffNum.get(j)==dataValues[w]) {
					counter++;
					
				}
			}
			int num = diffNum.get(j);
			data.add(num, counter);
		}

		// add the series to the dataset
		dataset.addSeries(data);
		
		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
				JFreeChart chart = ChartFactory.createXYLineChart("Grades Histogram", "Grades", "Frequency", dataset,
						PlotOrientation.VERTICAL, legend, tooltips, urls);
		/*
		 * Initialize a frame for visualizing the chart and attach the previously
		 * created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

}