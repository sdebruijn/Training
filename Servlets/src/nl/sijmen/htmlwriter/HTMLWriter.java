package nl.sijmen.htmlwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class HTMLWriter {

	private StringBuilder html;

	public HTMLWriter() {
		html = new StringBuilder();
	}

	public void append(String str) {
		html.append(str +"\n");
	}

	public String toString() {
		return this.getHtml();
	}
	
	public String getHtml() {
		return html.toString();
	}

	public void append(File f) {
		Scanner sc;
		try {
			sc = new Scanner(f);
			try {
				while (sc.hasNextLine()) {
					String str = sc.nextLine();
					html.append(str + "\n");
				}
			} finally {
				sc.close();
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found > BALEN");
			System.err.println(e.getStackTrace());
		}

	}

	public void appendFile(String path) {
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(path));
			html.append(new String(encoded, StandardCharsets.UTF_8));
		} catch (IOException e) {
			return;
		}
	}
}
