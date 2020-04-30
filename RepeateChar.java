package FindString;
/*Write a method that can take an uncompressed version of a string and return a compressed version.
Eg:
1. input aaaabbcc
   output a4b2c2
2. input abcababc
   output a3b3c2 
3. input "" or null
   output IllegalArgumentException    
*/

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RepeateChar {
	private static final Logger log = LogManager.getLogger(RepeateChar.class);

	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();
		String output = "";

		log.info("Example1: input aaaabbcc");
		output = countRepeatChar("aaaabbcc");
		log.info("Output - " + output);
	}

	public static String countRepeatChar(String strRep) {
		log.info("Input string is ---->"+strRep);
		String revOutput = "";
		try {

			if (strRep.length() == 0 || strRep == null) {
				revOutput = null;
				log.info("IllegalArgumentException");
			} else {
				int len = strRep.length();
				while (len > 0) {
					int count = 1;
					for (int j = 1; j < len; j++) {
						if (strRep.charAt(0) == strRep.charAt(j)) {
							count++;
						}
					}
					if (count >= 1) {
						revOutput = revOutput + " " + strRep.charAt(0) + "" + count;
					}

					String character = String.valueOf(strRep.charAt(0)).trim();
					strRep = strRep.replaceAll(character, "");
					len -= count;
				}
			}
		} catch (NullPointerException e) {
			revOutput = null;
			log.error("Null pointer exception. Please provide valid string." + e.getMessage());
		}
		return revOutput.trim();
	}
}
