package com.hagaisapir.dropbox.dropboxclient;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hagaisapir.dropbox.dropboxclient.beans.FileBean;

public class RunnableApp {

	public static void main(String[] args) {
		AllFiles("C:/sapir");
	}

	private static void AllFiles(String directoryName) {

		File file = new File(directoryName);

		File[] files = file.listFiles();
		String currentFileBeanAsJson = null;

		for (File currentFile : files) {
			String AbsoluteFileName = currentFile.getAbsolutePath();
			if (currentFile.isDirectory()) {
				AllFiles(AbsoluteFileName);
			} else if (currentFile.getName().endsWith(".txt")) {

				// extracting the file name and the file data
				String RelativeFileName = AbsoluteFileName.substring(2);
				Path path = Paths.get(RelativeFileName);
				String fileData = "";
				try (Scanner scanner = new Scanner(path)) {
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine();
						fileData += line;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				FileBean currentFileBean = new FileBean(RelativeFileName, fileData);
				ObjectMapper mapper = new ObjectMapper();
				try {
					currentFileBeanAsJson = mapper.writeValueAsString(currentFileBean);
				} catch (JsonProcessingException e1) {
					e1.printStackTrace();
				}
				// uploading the data to server

				URL url;
				HttpURLConnection connection;
				try {
					url = new URL("http://localhost:8080/dropboxserver/rest/file");
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("POST");
					connection.setDoOutput(true);
					connection.setFixedLengthStreamingMode(currentFileBeanAsJson.length());
					connection.setRequestProperty("Content-Type", "application/json");
					connection.connect();
					try(DataOutputStream out = new DataOutputStream(connection.getOutputStream())){
					out.writeBytes(currentFileBeanAsJson);
					}catch (Exception e) {
						e.printStackTrace();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
	}
}
