package ca.uqtr.gl.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Utils {
	public static String obtenirChaineAleatoire(int longueur) {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid.substring(0, longueur);
	}
	
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidDate(String dateText) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateText);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public static Date stringToDate(String dateText) {
		try {
			if (isValidDate(dateText)) {
				return new SimpleDateFormat("dd/MM/yyyy").parse(dateText);
			}
		}
		catch (Exception e) {
		}
		
		return null;
	}
	
}
