package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;


public class HtmlPagesConverterTest {
    @Test
    public void foo() throws IOException {
        CustomReaderClass readerMock = mock(CustomReaderClass.class);
        HtmlPagesConverter converter = new HtmlPagesConverter("foo",readerMock);

        assertEquals("foo", converter.getFilename());
    }

    @Test
    public void getHTMLpage_loremIpsum() throws IOException {
        String line1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit,\n";
        String line2 = "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n";
        String breakline = "PAGE_BREAK";
        CustomReaderClass readerMock = mock(CustomReaderClass.class);
        when(readerMock.readLine()).thenReturn(line1).thenReturn(line2).thenReturn(breakline).thenReturn(null)
                .thenReturn(line1).thenReturn(line2).thenReturn(breakline).thenReturn(null);

        HtmlPagesConverter converter = new HtmlPagesConverter("Lorem", readerMock);

        String result = converter.getHtmlPage(1,readerMock);

        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit,\n" +
                "<br />sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
                "<br />", result);
    }
}
