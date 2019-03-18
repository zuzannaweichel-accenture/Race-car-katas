package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlPagesConverter {

    private String filename;
    private List<Integer> breaks;
    private CustomReaderClass reader;

    public HtmlPagesConverter (String filename, CustomReaderClass reader) throws IOException {
        this.filename = filename;
        this.reader = reader;
        this.breaks = new ArrayList<Integer>();
        calculatePageBreak();
    }
    public HtmlPagesConverter (String filename) throws IOException {
        this.filename = filename;
        this.reader = new CustomReaderClass(filename);
        this.breaks = new ArrayList<Integer>();
        calculatePageBreak();
    }

    private void calculatePageBreak() throws IOException {
        this.breaks.add(0);
        int cumulativeCharCount = 0;
        String line = reader.readLine();
        //System.out.println(line);
        while (line != null) {
            cumulativeCharCount += line.length() + 1; // add one for the newline
            if (line.contains("PAGE_BREAK")) {
                int page_break_position = cumulativeCharCount;
                breaks.add(page_break_position);
            }
            line = reader.readLine();
        }
        reader.close();
    }

    public String getHtmlPage(int page) throws IOException {
        CustomReaderClass reader = new CustomReaderClass(filename);
        return getHtmlPage(page, reader);
    }

    public String getHtmlPage(int page, CustomReaderClass reader) throws IOException {
        reader.skip(breaks.get(page));
        StringBuffer htmlPage = new StringBuffer();
        String line = reader.readLine();
        System.out.println(line);
        while (line != null)
        {
            if (line.contains("PAGE_BREAK")) {
                break;
            }
            htmlPage.append(StringEscapeUtils.escapeHtml(line));
            htmlPage.append("<br />");

            line = reader.readLine();
        }
        reader.close();
        return htmlPage.toString();
    }

    public String getFilename() {
        return this.filename;
    }
    
}
