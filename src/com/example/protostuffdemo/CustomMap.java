package com.example.protostuffdemo;

public class CustomMap {

	private String key;
	private String value;

	public CustomMap() {
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String showContent(String prefix) {
		StringBuilder b = new StringBuilder();
		b.append(prefix + "key=" + key + "\n");
		b.append(prefix + "value=" + value + "\n");
		return b.toString();
	}
}
