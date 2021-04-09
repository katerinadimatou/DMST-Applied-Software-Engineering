package gradeshistogram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;

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
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that can be
		 * visualized in the same chart
		 */
		HistogramDataset dataset = new HistogramDataset();

		/*
		 * Counting the different values in the array
		 */
		ArrayList<Integer> diffNum = new ArrayList<Integer>();
		for (int i = 0; i < dataValues.length; i++) {
			if (!diffNum.contains(dataValues[i])) {
				diffNum.add(dataValues[i]);
			}
		}
		int num = diffNum.size();

		// converting the integer array to a double one
		double[] values = new double[dataValues.length];
		for (int i = 0; i < dataValues.length; i++) {
			values[i] = dataValues[i];
		}

		// adding data to dataset
		dataset.addSeries("key", values, num);

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createHistogram("Grades Histogram", "Grades", "Frequency", dataset);

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