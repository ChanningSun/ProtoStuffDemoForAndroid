package com.example.protostuffdemo;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String FILE_PATH = Environment.getExternalStorageDirectory() + "/protostuff.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_main);

		Button encodeBtn = (Button) findViewById(R.id.encode);
		encodeBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					encode();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		Button decodeBtn = (Button) findViewById(R.id.decode);
		decodeBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					decode();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 序列化
	 */
	private void encode() throws IOException {
		CustomEvent event = getEvent();
		byte[] bytes = null;
		Schema<CustomEvent> schema = RuntimeSchema.getSchema(CustomEvent.class);
		LinkedBuffer buffer = LinkedBuffer.allocate(4096);
		try {
			bytes = ProtostuffIOUtil.toByteArray(event, schema, buffer);
		} finally {
			buffer.clear();
		}
		File f = new File(FILE_PATH);
		FileOutputStream os = new FileOutputStream(f);
		os.write(bytes);
		os.flush();
		os.close();
		Toast.makeText(this, "序列化完成，请查看sd卡下的文件", Toast.LENGTH_SHORT).show();
	}

	/**
	 * 反序列化
	 */
	private void decode() throws IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(FILE_PATH));
		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
		byte[] temp = new byte[1024];
		int size = 0;
		while ((size = in.read(temp)) != -1) {
			out.write(temp, 0, size);
		}
		in.close();

		CustomEvent event = new CustomEvent();
		byte[] bytes = out.toByteArray();

		Schema<CustomEvent> schema = RuntimeSchema.getSchema(CustomEvent.class);
		ProtostuffIOUtil.mergeFrom(bytes, event, schema);
		System.out.print("sunqiang:\n" + event.showContent());
		Toast.makeText(this, "反序列化完成，请查看log", Toast.LENGTH_SHORT).show();
	}

	/**
	 * 编造数据
	 */
	private CustomEvent getEvent() {
		List<CustomMap> mapList = new LinkedList<CustomMap>();

		CustomMap map1 = new CustomMap();
		map1.setKey("key1");
		map1.setValue("value1");
		mapList.add(map1);

		CustomMap map2 = new CustomMap();
		map2.setKey("key2");
		map2.setValue("value2");
		mapList.add(map2);

		CustomContent content = new CustomContent();
		content.setType("type");
		content.setAct("act");
		content.setEventid("eventId");
		content.setMap(mapList);
		content.setCalc("calc");

		CustomBase base = new CustomBase();
		base.setModel("model");
		base.setImei("imei");
		base.setAndroidid("androidid");
		base.setNet("net");
		base.setMac("mac");
		base.setDisplay("display");
		base.setIpaddr("ipaddr");
		base.setInstall("install");
		base.setVer("ver");
		base.setTimestamp("timestamp");
		base.setChild("child");
		base.setManufacturer("manufacturer");
		base.setVcode("vcode");
		base.setAndroidsdk("androidsdk");

		CustomEvent event = new CustomEvent();
		event.setBase(base);
		event.setContent(content);

		return event;
	}

}
