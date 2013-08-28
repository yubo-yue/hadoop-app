package org.hey.HadoopInAction.ch301;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class Edge implements WritableComparable<Edge> {

	private String departureNode;
	private String arrivalNode;

	public String getDepartureNode() {
		return departureNode;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(departureNode);
		out.writeUTF(arrivalNode);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		departureNode = in.readUTF();
		arrivalNode = in.readUTF();
	}

	@Override
	public int compareTo(Edge arg0) {
		return (departureNode.compareTo(arg0.departureNode) != 0) ? departureNode
				.compareTo(arg0.departureNode) : arrivalNode
				.compareTo(arg0.arrivalNode);
	}

}
