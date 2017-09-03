package com.geeks.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Node{
	
	private int nodeValue;
	private Set<Node> adjucentNodes = new HashSet<Node>();
	private boolean visited = false;
	private Map<Node, Integer> weightMap = new HashMap<Node, Integer>(); 

	public Node(int nodeValue) {
		setNodeValue(nodeValue);
	}
	public Node(int nodeValue,Set<Node> adjucentNodes) {
		this(nodeValue);
		setAdjucentNodes(adjucentNodes); 
	}
	
	public int getNodeValue() {
		return nodeValue;
	}
	public void setNodeValue(int nodeValue) {
		this.nodeValue = nodeValue;
	}
	public Set<Node> getAdjucentNodes() {
		return adjucentNodes;
	}
	public void setAdjucentNodes(Set<Node> adjucentNodes) {
		this.adjucentNodes = adjucentNodes;
	}
	public void addAdjucentNodes(Node ...nodes) {
		Set<Node> nodeSet = this.getAdjucentNodes();
		for (int i = 0; i < nodes.length; i++) 
			nodeSet.add(nodes[i]);
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public Node markVisited() {
		this.setVisited(true);
		return this;
	}
	@Override
	public String toString() {
		return "Node = " + nodeValue ;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nodeValue;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (nodeValue != other.nodeValue)
			return false;
		return true;
	}
	public Integer getWeight(Node node) {
		return weightMap.get(node);
	}
	public void setWeightMap(Map<Node, Integer> weightMap) {
		this.weightMap = weightMap;
	}
	public void setWeight(Node node, int weight) {
		this.weightMap.put(node, weight);
	}
}