package javatest;
/**
 * Util class used to convert the value.
 *
 */
public class ConverterUtil {
	
	public static double getUSDfromGBP(double gbp) {
		return gbp * ConversionConstants.GBP_TO_USD;
	}

	public static double getUSDfromCHF(double gbp) {
		return gbp * ConversionConstants.CHF_TO_USD;
	}

	public static double getUSDfromEUR(double gbp) {
		return gbp * ConversionConstants.EUR_TO_USD;
	}
	
}
