package in.javahome;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
	Calculator cal = new Calculator();

	public void testAddition() {
		Assert.assertEquals(cal.add(10, 20), 30);
	}
	public void testMultiplication() {
		Assert.assertEquals(cal.multiply(10, 2), 20);
	}
	public void testSubtraction() {
		Assert.assertEquals(cal.subtract(15, 20), -5);
	}
	public void testDivision() {
		Assert.assertEquals(cal.divide(100, 20), 5);
	}
}
