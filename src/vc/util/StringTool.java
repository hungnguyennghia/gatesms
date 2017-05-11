package vc.util;

import java.util.Random;
import java.util.Vector;
import java.util.Iterator;
import java.util.Collection;

/**
 * Replace/remove character in a String
 */
public class StringTool {
    static final char NINE = (char) 0x39;
    static final char ZERO = (char) 0x30;
    static final char CH_a = (char) 'a';
    static final char CH_z = (char) 'z';
    static final char CH_A = (char) 'A';
    static final char CH_Z = (char) 'Z';


    public static String appendString(String oldS, int pos, String s) {
        return (oldS.substring(0, pos) + s + oldS.substring(pos));
    }

    //To replace a character at a specified position
    public static String replaceCharAt(String s, int pos, char c) {
        //return s.substring(0, pos) + c + s.substring(pos + 1);
        StringBuffer buf = new StringBuffer( s );
        buf.setCharAt( pos, c );
        return buf.toString( );
    }

    // replace char with string
    public static String replaceChar(String s, char a, String b) {
        if (s == null) return null;

        StringBuffer newString = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == a) {
                newString.append(b);
            } else {
                newString.append(cur);
            }
        }
        return newString.toString();
    }


    //To remove a character
    public static String removeChar(String s, char c) {
        if (s == null) return null;

        StringBuffer newString = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur != c)
                newString.append(cur);
        }
        return newString.toString();
    }

    //To remove a character at a specified position
    public static String removeCharAt(String s, int pos) {
        if (s == null) return null;

        //return s.substring(0, pos) + s.substring(pos + 1);
        StringBuffer buf = new StringBuffer( s.length() - 1 );
        buf.append( s.substring(0,pos) ).append( s.substring(pos+1) );
        return buf.toString();
    }

    //abcdef --> bdf
    public static String removeCharsAtEvenPosition(String s) {
        if (s == null) return null;

        StringBuffer newString = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 1) {
                newString.append(s.charAt(i));
            }
        }
        return newString.toString();

    }


    // .,*/abc --> abc
    public static String removeSpecialCharsInFront(String s) {
        if (s == null) return null;
        String result = "";
        char currChar;
        for (int i = 0; i<s.length(); i++) {
            currChar = s.charAt(i);
            if ((currChar >= ZERO && currChar <= NINE) ||
                (currChar >= CH_a && currChar <= CH_z) ||
                (currChar >= CH_A && currChar <= CH_Z) ) {
                result = s.substring(i);
                break;
            }
        }
        return result;
    }

     public static String only2SpaceBetweenWords(String text) {
         if (text == null) return null;

         StringBuffer buffer = new StringBuffer();
         boolean lastCharIsSpace = false;
         for (int i=0; i<text.length(); i++) {
             char ch = text.charAt(i);
             if (ch == 0x20) {
                 if (lastCharIsSpace) {
                     continue;
                 } else {
                     lastCharIsSpace = true;
                 }
             } else if (lastCharIsSpace) {
                 lastCharIsSpace = false;
             }
             buffer.append(ch);
         }
         return buffer.toString();
     }

     public static String removeNULL(String s)
     {
         if(s == null)
             return null;
         StringBuffer newString = new StringBuffer();
         char ch = '\0';
         for(int i = 0; i < s.length(); i++)
         {
             ch = s.charAt(i);
             if(ch > '\003')
                 newString.append(s.charAt(i));
         }

         return newString.toString();
     }

     public static String removeSPACE(String s, int numOfChars)
     {
         if(s == null)
             return null;
         if(numOfChars < 0 || numOfChars > s.length())
             numOfChars = s.length();
         StringBuffer newString = new StringBuffer();
         char ch = '\0';
         for(int i = 0; i < numOfChars; i++)
         {
             ch = s.charAt(i);
             if(ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
                 newString.append(s.charAt(i));
         }

         newString.append(s.substring(numOfChars));
         return newString.toString();
     }
    /*
     * In
     *   text: a string having some seperator(s)
     * Out
     *   a collection of elements without (between) seperator
     */
    public static Collection parseString(String text, String seperator) {
        Vector vResult = new Vector();
        if (text == null || "".equals(text))
            return vResult;

        String tempStr = text.trim();
        String currentLabel = null;

        int index = tempStr.indexOf(seperator);
        while (index != -1) {
            currentLabel = tempStr.substring(0, index).trim();
            //Only accept not null element
            if (!"".equals(currentLabel))
                vResult.addElement(currentLabel);
            tempStr = tempStr.substring(index + 1);
            index = tempStr.indexOf(seperator);
        }
        //Last label
        currentLabel = tempStr.trim();
        if (!"".equals(currentLabel))
            vResult.addElement(currentLabel);
        return vResult;
    }

    final static String[] seperators = {" ", ".", ",", "-", "_", "="};
    public static Collection parseString(String text) {
        Vector vResult = new Vector();
        if (text == null || "".equals(text))
            return vResult;

        String tempStr = text.trim();
        String currentLabel = null;

        int index = getNextIndex(tempStr);
        while (index != -1) {
            currentLabel = tempStr.substring(0, index).trim();
            //Only accept not null element
            if (!"".equals(currentLabel))
                vResult.addElement(currentLabel);
            tempStr = tempStr.substring(index + 1);
            index = getNextIndex(tempStr);
        }
        //Last label
        currentLabel = tempStr.trim();
        if (!"".equals(currentLabel))
            vResult.addElement(currentLabel);
        return vResult;
    }
    private static int getNextIndex(String text) {
        int index = 0;
        int newIdx = 0;
        boolean hasOne = false;
        for (int i = 0; i < seperators.length; i++) {
            newIdx = text.indexOf(seperators[i]);
            if (!hasOne) {
                if (newIdx != -1) {
                    index = newIdx;
                    hasOne = true;
                }
            } else if (newIdx != -1) {
                if (newIdx < index) {
                    index = newIdx;
                }
            }
        }
        if (!hasOne)
            index = -1;
        return index;
    }

    /* Seperator is any charactor not in rage of (0-9), (a-z), (A-Z) */
    public static Collection parseStringEx(String text) {
        Vector vResult = new Vector();
        if (text == null || "".equals(text))
            return vResult;

        String tempStr = text.trim();
        String currLabel = "";
        char currChar = 0;
        for (int i=0; i < tempStr.length(); i++) {
            currChar = tempStr.charAt(i);
            if ( (currChar >= ZERO && currChar <= NINE) ||
                 (currChar >= CH_a && currChar <= CH_z) ||
                 (currChar >= CH_A && currChar <= CH_Z) ) {
                currLabel = currLabel + currChar;
            } else if (currLabel.length() > 0) {
                vResult.add(currLabel);
                currLabel = new String("");
            }
        }
        //last label
        if (currLabel.length() > 0) {
            vResult.add(currLabel);
        }
        return vResult;
    }
    public static boolean isNumberic(String sNumber) {
        if (sNumber == null || "".equals(sNumber)) {
            return false;
        }
        char ch_max = (char) 0x39;
        char ch_min = (char) 0x30;

        for (int i = 0; i < sNumber.length(); i++) {
            char ch = sNumber.charAt(i);
            if ( (ch < ch_min) || (ch > ch_max)) {
                return false;
            }
        }
        return true;
    }

    /**************************************************************************/
    /*                  GENERATE RANDOM STRING OF CHARACTERS                  */
    /**************************************************************************/
    private static char[] charArray = null; //Holds an array of character (used to get the random character for the random string)
    private static Random random = null; //random object
    // Create an arrays of characters (A--Z, 0--9)
    static {
        int numOfChars = 'Z' - 'A' + 1;
        int numOfDigits = '9' - '0' + 1;

        random = new Random(); // create a random object

        charArray = new char[numOfChars + numOfDigits];
        for (int i = 0; i < numOfChars; i++) {
            charArray[i] = (char) ('A' + i);
        }
        for (int i = 0; i < numOfDigits; i++) {
            charArray[numOfChars + i] = (char) ('0' + i);
        }
        //System.out.println(charArray);
    }
    //returns a random string of chars: A--Z, 0--9
    public static String generateRandomString(int length) {
        char[] ch = new char[length];
        for (int i = 0; i < length; i++)
            ch[i] = charArray[random.nextInt(charArray.length)];
        return new String(ch);
    }

    //Generate a hexa string from a long number
    public static String generateHexString(long number, int length) {
        String hex = Long.toHexString(number).toUpperCase();
        int hexLength = hex.length();
        if (hexLength > length) {
            hex = hex.substring(hexLength - length);
        } else if (hexLength < length) {
            for (int i=0; i < (length - hexLength); i++) {
                hex = "0" + hex;
            }
        }
        return hex;
    }

	public static String[] SplitByWidth(String s, int width) throws Exception
	{
		try{
	
			if (width==0){
				String[] ret = new String[1];
				ret[0]=s;
			return ret;
			}else{
		
				if (s.isEmpty()) return new String[0];
				else{
			
					if (s.length() <= width){
						String[] ret = new String[1];
						ret[0]=s;
					return ret;
					}else{
						int NumSeg = s.length() / width + 1;
						String[] ret = new String[NumSeg];
						int startPos = 0;
				
						for (int i = 0; i < NumSeg - 1; i++){
							ret[i] = s.substring(startPos,((width*(i+1))));
							startPos = (i+1)*width;
				//		logger.alert(ret[i]);
					
						}
						ret[NumSeg-1] = s.substring(startPos,s.length());
						return ret;
					}
				}
			}
	
		}catch (Exception e){
//			logger.alert(String.valueOf(e.fillInStackTrace()));
		return new String[0];
		}
	}
	
    public static void main(String args[]) {
        // To replace all occurences of a given character
//        String myString = "Replace ' by * ";
//        //String tmpString = myString.replace('\u0020', '*');
//        String tmpString = myString.replace('\'', '*');
//        System.out.println("Original = " + myString);
//        System.out.println("Result   = " + tmpString);

//        Collection coll = StringTool.parseString("A.B C,D-E.");
//        System.out.println("Size: " + coll.size());
//        for (Iterator it = coll.iterator(); it.hasNext(); ) {
//            System.out.println( (String) it.next());
//        }

//        Collection coll = StringTool.parseStringEx("DA.2130444 4455 55595");
//        System.out.println("Size: " + coll.size());
//        for (Iterator it = coll.iterator(); it.hasNext(); ) {
//            System.out.println( (String) it.next());
//        }


//        String hello = "" + '\00' + 'H' + '\00' + 'E' + '\00' + 'L' + '\00' + 'L' + '\00' + 'O';
//        System.out.println( hello );
//        System.out.println( StringTool.removeChar(hello, '\00'));


        //String s = "line1 " + '\n' + "line2 " + '\n';
        //System.out.println(StringTool.replaceChar(s, '\n', "<br>"));
        //System.out.println(StringTool.removeSpecialCharsInFront(""));

        //System.out.println(StringTool.appendString("0123456", "0123".length(), " "));

//        System.out.println(generateHexString(1, 10));
//        System.out.println(generateHexString(1000, 4));

        System.out.println(StringTool.removeCharsAtEvenPosition("\u0044"));
    }
}
