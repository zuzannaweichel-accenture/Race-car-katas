package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlTextConverterTest {
    @Test
    public void whenCallingGetFileName_WithTestFileName_ReturnsTestFileName() {
        String testFileName = "foo";
        HtmlTextConverter converter = new HtmlTextConverter(testFileName);
        assertEquals(testFileName, converter.getFilename());
    }


}
