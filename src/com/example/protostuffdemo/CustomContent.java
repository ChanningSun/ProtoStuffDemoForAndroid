package com.example.protostuffdemo;

import java.util.List;

public class CustomContent {
	private String type;
	private String act;
	private String eventid;
	private List<CustomMap> map;
	private String calc;

	public CustomContent() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public List<CustomMap> getMap() {
		return map;
	}

	public void setMap(List<CustomMap> map) {
		this.map = map;
	}

	public String getCalc() {
		return calc;
	}

	public void setCalc(String calc) {
		this.calc = calc;
	}

	public String showContent(String prefix) {
		StringBuilder b = new StringBuilder();
		b.append(prefix + "type=" + type + "\n");
		b.append(prefix + "act=" + act + "\n");
		b.append(prefix + "eventid=" + eventid + "\n");
		b.append(prefix + "map=" + "\n");
		for (CustomMap c : map) {
			b.append(prefix + c.showContent("\t"));
		}
		b.append(prefix + "calc=" + calc + "\n");
		return b.toString();
	}

}
