package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class HtmlTextConverter
{
	private String filePath;
    private CustomReaderClass reader;

    public HtmlTextConverter(String filePath) throws IOException {
    	this.reader = new CustomReaderClass(filePath);
    	this.filePath = filePath;
	}

    public HtmlTextConverter(String filePath, CustomReaderClass reader) {
    	this.filePath = filePath;
    	this.reader = reader;
    }

    public String convertToHtml() throws IOException{

	    String line = reader.readLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += StringEscapeUtils.escapeHtml(line);
	        html += "<br />";
	        line = reader.readLine();
	    }
	    return html;

    }

	public String getFilename() {
		return this.filePath;
	}
}
