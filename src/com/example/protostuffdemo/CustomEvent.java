package com.example.protostuffdemo;

public class CustomEvent {
	private CustomContent content;
	private CustomBase base;

	public CustomEvent() {
	}

	public CustomContent getContent() {
		return content;
	}

	public void setContent(CustomContent content) {
		this.content = content;
	}

	public CustomBase getBase() {
		return base;
	}

	public void setBase(CustomBase base) {
		this.base = base;
	}

	public String showContent() {
		StringBuilder b = new StringBuilder();

		b.append("content=" + "\n" + content.showContent("\t"));
		b.append("base=" + "\n" + base.showContent("\t"));

		return b.toString();
	}

}
