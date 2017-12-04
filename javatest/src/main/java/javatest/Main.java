package javatest;

import java.io.IOException;
/**
 * Main class to start the flow.
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		Converter converter = new Converter();
		converter.convert();
	}

}
