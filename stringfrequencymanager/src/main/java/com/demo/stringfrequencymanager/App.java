package com.demo.stringfrequencymanager;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 *
 */
@SpringBootApplication
public class App {
	public static Map<String, Integer> logFilesContentList = new HashMap<String, Integer>();

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(App.class);

		logFilesContentList = loadFile();
		app.run(args);

	}

	private static Map<String, Integer> loadFile() throws Exception {

		Map<String, Integer> dataWithCount = new HashMap<String, Integer>();
		int count = 1;
		List<String> logContentList = new ArrayList<String>();
		URL url = Thread.currentThread().getContextClassLoader().getResource("logFiles/");
		if (url != null) {
			if (url.getProtocol().equals("file")) {
				File file = Paths.get(url.toURI()).toFile();
				if (file != null) {
					File[] files = file.listFiles();
					if (files != null) {
						for (File filename : files) {

							logContentList = Files.readAllLines(filename.toPath(), Charset.defaultCharset());

							for (String line : logContentList) {
								if (!line.isEmpty()) {
									String[] splitedContent = line.split(",");
									if (splitedContent.length != 0) {
										String content = splitedContent[1].toUpperCase();
										if (dataWithCount.get(content) == null) {
											dataWithCount.put(content, 1);
										} else {
											dataWithCount.put(content, (dataWithCount.get(content) + count));

										}
									}
								}
							}

						}
					}
				}
			}

		}

		return dataWithCount;
	}
}
