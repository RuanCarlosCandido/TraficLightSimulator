package org.models;

public enum TrafficLightColor {
	GREEN(1000), YELLOW(300), RED(2000);

	int standBy;

	private TrafficLightColor(int standBy) {
		this.standBy = standBy;
	}

	public int getStandBy() {
		return standBy;
	}

}
