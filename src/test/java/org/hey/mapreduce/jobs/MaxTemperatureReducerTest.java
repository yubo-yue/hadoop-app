package org.hey.mapreduce.jobs;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.junit.Test;

public class MaxTemperatureReducerTest {

	@Test
	public void returnsMaximumIntegerInValues() throws IOException {
		MaxTemperatureReducer reducer = new MaxTemperatureReducer();
		Text key = new Text("1950");
		Iterator<IntWritable> values = Arrays.asList(new IntWritable(10),
				new IntWritable(5)).iterator();
		OutputCollector<Text, IntWritable> output = mock(OutputCollector.class);
		reducer.reduce(key, values, output, null);
		verify(output).collect(key, new IntWritable(10));
	}

}
