package net.pqno.engine;

public class NumberToSuffixConverter {

	/**
	 * Caracteres aceitáveis para uma URL
	 * */
	public final static String WEB_URL_VAlID_CHARS[] = new String[] { "0", "1",
			"2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
			"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E",
			"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
			"S", "T", "U", "V", "W", "X", "Y", "Z" };

	/**
	 * Converte o número para o algarismo passado no vetor em
	 * */
	public String convert(long number, String[] base) {
		long temp = number;
		StringBuffer buf = new StringBuffer();
		int baseLength = base.length;
		while (temp > (baseLength - 1)) {
			int mod = (int) (temp % baseLength);
			buf.insert(0, base[mod]);
			temp = temp / baseLength;
		}
		buf.insert(0, base[(int) temp]);
		return buf.toString();
	}

	/**
	 * Converte o número para o algarismo passado no vetor em
	 * */
	public String convert(long number) {
		return convert(number, WEB_URL_VAlID_CHARS);
	}

}
