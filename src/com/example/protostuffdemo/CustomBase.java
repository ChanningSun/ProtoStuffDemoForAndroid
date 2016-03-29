package com.example.protostuffdemo;

public class CustomBase {

	private String model;
	private String imei;
	private String androidid;
	private String net;
	private String mac;
	private String display;
	private String ipaddr;
	private String install;
	private String ver;
	private String timestamp;
	private String child;
	private String manufacturer;
	private String vcode;
	private String androidsdk;

	public CustomBase() {
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getAndroidid() {
		return androidid;
	}

	public void setAndroidid(String androidid) {
		this.androidid = androidid;
	}

	public String getNet() {
		return net;
	}

	public void setNet(String net) {
		this.net = net;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public String getInstall() {
		return install;
	}

	public void setInstall(String install) {
		this.install = install;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public String getAndroidsdk() {
		return androidsdk;
	}

	public void setAndroidsdk(String androidsdk) {
		this.androidsdk = androidsdk;
	}

	public String showContent(String prefix) {
		StringBuilder b = new StringBuilder();

		b.append(prefix + "model=" + model + "\n");
		b.append(prefix + "imei=" + imei + "\n");
		b.append(prefix + "androidid=" + androidid + "\n");
		b.append(prefix + "net=" + net + "\n");
		b.append(prefix + "mac=" + mac + "\n");
		b.append(prefix + "display=" + display + "\n");
		b.append(prefix + "ipaddr=" + ipaddr + "\n");
		b.append(prefix + "install=" + install + "\n");
		b.append(prefix + "ver=" + ver + "\n");
		b.append(prefix + "timestamp=" + timestamp + "\n");
		b.append(prefix + "child=" + child + "\n");
		b.append(prefix + "manufacturer=" + manufacturer + "\n");
		b.append(prefix + "vcode=" + vcode + "\n");
		b.append(prefix + "androidsdk=" + androidsdk + "\n");

		return b.toString();
	}

}
