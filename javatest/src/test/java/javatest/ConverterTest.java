package javatest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConverterTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final String fileLocation = "src/test/resources/test.txt";
	private Converter converter = new Converter();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
		converter.setFileLocation(fileLocation);
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

	@Test
	public void testConverter() throws IOException {
		assertEquals("", "");
		converter.convert();
		String[] output = outContent.toString().split(" ");
		double average = Double.parseDouble(output[output.length - 1]);
		assertEquals(127.60000000, average, 0.001);

	}
}
