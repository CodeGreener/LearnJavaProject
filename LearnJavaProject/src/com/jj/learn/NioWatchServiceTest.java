package com.jj.learn;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class NioWatchServiceTest {

	public static void main(String[] args) {
		NioWatchServiceTest t = new NioWatchServiceTest();
		t.actualMonitor();
	}
	private WatchService setupWatch(Path dir) {
		try {
			WatchService ws = FileSystems.getDefault().newWatchService();
			dir.register(ws, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
			return ws;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private void actualMonitor() {
		WatchService ws = setupWatch(Paths.get("c:/", "temp"));
		if (ws != null) {
			WatchKey key = null;
			while (true) {
				try {
					key = ws.take();
					
					//each key can have multiple events associated
					for (WatchEvent<?> e : key.pollEvents()) {
						System.out.println(e.kind() + " " + e.context().toString());
					}
					
					boolean reset = key.reset();
					if (!reset) {
						break;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
