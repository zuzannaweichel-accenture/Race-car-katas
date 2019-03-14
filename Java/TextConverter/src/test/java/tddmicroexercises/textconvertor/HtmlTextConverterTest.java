package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.io.IOException;

public class HtmlTextConverterTest {
    @Test
    public void whenCallingGetFileName_WithTestFileName_ReturnsTestFileName() {
        String testFileName = "foo";
        CustomReaderClass readerMock = mock(CustomReaderClass.class);
        HtmlTextConverter converter = new HtmlTextConverter(testFileName, readerMock);

        assertEquals(testFileName, converter.getFilename());
    }

    @Test
    public void whenConvertingToHtml_WithTestFile_ReturnsFileAsHtml() throws IOException {
        String testFileName = "foo";
        CustomReaderClass readerMock = mock(CustomReaderClass.class);
        HtmlTextConverter converter = new HtmlTextConverter(testFileName, readerMock);

        when(readerMock.readLine()).thenReturn("foo").thenReturn(null);
        String result = converter.convertToHtml();

        assertEquals("foo<br />", result);
    }
}
