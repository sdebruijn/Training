package nl.sijmen.htmlwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HTMLWriter {

	private StringBuilder html;

	public HTMLWriter() {

	}

	public void append(String str) {
		html.append(str);
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
			System.err.println(e.getStackTrace());
		}

	}

}
