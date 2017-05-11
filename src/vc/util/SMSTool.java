package vc.util;



public class SMSTool {
    //check the valid destination mobile
    
	
	public static boolean isValidMobileNumber(String mobileNumber) {
        if (mobileNumber == null || "".equals(mobileNumber)) {
            return false;
        }
        else
		{
			return (
						(mobileNumber.length() == 10 && mobileNumber.startsWith("09")) || 
						(mobileNumber.length() == 11 && mobileNumber.startsWith("01")) ||	
						(mobileNumber.length() == 11 && mobileNumber.startsWith("849")) ||	
						(mobileNumber.length() == 11 && mobileNumber.startsWith("848")) ||
						(mobileNumber.length() == 10 && mobileNumber.startsWith("08")) ||
						(mobileNumber.length() == 12 && mobileNumber.startsWith("841")
					)
			);			
		}
	}   

	/**
	 * Truonglx;
	 * return UNKNOWN if not a valid mobile operator
	 * @param mobileNumber
	 * @return
	 */
    public static String buildMobileOperator(String mobileNumber) {
        String mobileOperator = null;
        
        if (mobileNumber.startsWith("+8492") || mobileNumber.startsWith("8492") || 
        		mobileNumber.startsWith("092") || mobileNumber.startsWith("92") ||
        	mobileNumber.startsWith("+84188") || mobileNumber.startsWith("84188") || 
        		mobileNumber.startsWith("0188") || mobileNumber.startsWith("188") ||
        	mobileNumber.startsWith("+84186") || mobileNumber.startsWith("84186") || 
        		mobileNumber.startsWith("0186") || mobileNumber.startsWith("186")
        	) 
        {
            mobileOperator = "VNM";
        } else //cool
        if (mobileNumber.startsWith("+8491") || mobileNumber.startsWith("8491") || 
        		mobileNumber.startsWith("091") || mobileNumber.startsWith("91") ||
        	mobileNumber.startsWith("+8494") || mobileNumber.startsWith("8494") || 
        		mobileNumber.startsWith("094") || mobileNumber.startsWith("94") ||	
        	mobileNumber.startsWith("+84123") || mobileNumber.startsWith("84123") || 
        		mobileNumber.startsWith("0123") || mobileNumber.startsWith("123") ||	
        	mobileNumber.startsWith("+84125") || mobileNumber.startsWith("84125") || 
        		mobileNumber.startsWith("0125") || mobileNumber.startsWith("125") ||	
        	mobileNumber.startsWith("+84127") || mobileNumber.startsWith("84127") || 
        		mobileNumber.startsWith("0127") || mobileNumber.startsWith("127") ||
        	mobileNumber.startsWith("+84124") || mobileNumber.startsWith("84124") || 
    			mobileNumber.startsWith("0124") || mobileNumber.startsWith("124") ||
        	mobileNumber.startsWith("+84129") || mobileNumber.startsWith("84129") || 
        		mobileNumber.startsWith("0129") || mobileNumber.startsWith("129") ||
            mobileNumber.startsWith("+8488") || mobileNumber.startsWith("8488") || 
        		mobileNumber.startsWith("088") || mobileNumber.startsWith("88")
        		) {
            mobileOperator = "GPC";
        } else 
        	if (mobileNumber.startsWith("+8493") || mobileNumber.startsWith("8493") || 
        			mobileNumber.startsWith("093")||mobileNumber.startsWith("93") ||   
        		mobileNumber.startsWith("+8490") || mobileNumber.startsWith("8490") || 
        			mobileNumber.startsWith("090") || mobileNumber.startsWith("90") ||
        		mobileNumber.startsWith("+84121") || mobileNumber.startsWith("84121") || 
        			mobileNumber.startsWith("0121") || mobileNumber.startsWith("121") ||
        		mobileNumber.startsWith("+84122") || mobileNumber.startsWith("84122") || 
        			mobileNumber.startsWith("0122") || mobileNumber.startsWith("122") ||
        		mobileNumber.startsWith("+84126") || mobileNumber.startsWith("84126") || 
        			mobileNumber.startsWith("0126") || mobileNumber.startsWith("126") ||
        		mobileNumber.startsWith("+84120") || mobileNumber.startsWith("84120") || 
        			mobileNumber.startsWith("0120") || mobileNumber.startsWith("120") ||        		
        		mobileNumber.startsWith("+84128") || mobileNumber.startsWith("84128") || 
        			mobileNumber.startsWith("0128") || mobileNumber.startsWith("128") ||
            	mobileNumber.startsWith("+8489") || mobileNumber.startsWith("8489") || 
        			mobileNumber.startsWith("089") || mobileNumber.startsWith("89")
        			){
            mobileOperator = "VMS";
            
        } else 
        	if (mobileNumber.startsWith("+8498") || mobileNumber.startsWith("8498") || 
        			mobileNumber.startsWith("098") || mobileNumber.startsWith("98") ||
        		mobileNumber.startsWith("+8497") || mobileNumber.startsWith("8497") || 
        			mobileNumber.startsWith("097") || mobileNumber.startsWith("97") ||
        		mobileNumber.startsWith("+84168") || mobileNumber.startsWith("84168") || 
        			mobileNumber.startsWith("0168") || mobileNumber.startsWith("168") ||
        		mobileNumber.startsWith("+84169") || mobileNumber.startsWith("84169") || 
        			mobileNumber.startsWith("0169") || mobileNumber.startsWith("169") ||
        		mobileNumber.startsWith("+84166") || mobileNumber.startsWith("84166") || 
        			mobileNumber.startsWith("0166") || mobileNumber.startsWith("166")||
        		mobileNumber.startsWith("+84167") || mobileNumber.startsWith("84167") || 
        			mobileNumber.startsWith("0167") || mobileNumber.startsWith("167")||
        		mobileNumber.startsWith("+84164") || mobileNumber.startsWith("84164") || 
        			mobileNumber.startsWith("0164") || mobileNumber.startsWith("164")||
        		mobileNumber.startsWith("+84165") || mobileNumber.startsWith("84165") || 
        			mobileNumber.startsWith("0165") || mobileNumber.startsWith("165") ||
        		mobileNumber.startsWith("+84162") || mobileNumber.startsWith("84162") || 
        			mobileNumber.startsWith("0162") || mobileNumber.startsWith("162") ||
        		mobileNumber.startsWith("+84163") || mobileNumber.startsWith("84163") || 
        			mobileNumber.startsWith("0163") || mobileNumber.startsWith("163") ||
        			
        	    mobileNumber.startsWith("+8496") || mobileNumber.startsWith("8496") || 
        	    	mobileNumber.startsWith("096") || mobileNumber.startsWith("96") ||
        	    mobileNumber.startsWith("+8486") || mobileNumber.startsWith("8486") || 
        	    	mobileNumber.startsWith("086") || mobileNumber.startsWith("86")
        		) {
            mobileOperator = "VIETEL";
        } else if (mobileNumber.startsWith("+8495") || mobileNumber.startsWith("8495") || 
        		mobileNumber.startsWith("095") || mobileNumber.startsWith("95")) {
            mobileOperator = "SFONE";
        }  else if (mobileNumber.startsWith("+8449") || mobileNumber.startsWith("8449") || 
        		mobileNumber.startsWith("049")) { //e.g: 8449130003 / 049130003
            mobileOperator = "CITYFONE";
            
        }  else if (mobileNumber.startsWith("+84199") || mobileNumber.startsWith("84199") || mobileNumber.startsWith("0199") || mobileNumber.startsWith("199")||
      			mobileNumber.startsWith("+8499") || mobileNumber.startsWith("8499") || mobileNumber.startsWith("099") || mobileNumber.startsWith("99")){ 
            mobileOperator = "BEE";
        } else {
            mobileOperator = "UNKNOWN";
        }
       //  System.out.println("buildMobileOperator mobileNumber="+mobileNumber+":"+mobileOperator);
        return mobileOperator;
    }

    // Call this method before storing or sending info (short message) to mobile
    public static String filterInfo(String info) {
        //1) Remove '\r' (0x0D) character
        if (info == null) return null;
        info = StringTool.removeChar(info, '\r');

        //2) max = 160 chars
        if (info.length() > 160) {
            info = info.substring(0, 160);// 0 -> 159
        }
        return info;
    }

    static char NINE = (char) 0x39;
    static final char ZERO = (char) 0x30;

    //extract 091xx or 090xxx (10 ky tu)
    //[0] --> mobile number
    //[1] --> info without mobile number
    public static String[] extractMobileNumber(String info) {
        if (info == null || info.length() <= 10) return null;

        String mobile = null;
        int index = info.indexOf("09");
        String tempMobile = null;

        while(index > 0 && info.length() >= (index + 10)) {
            tempMobile = info.substring(index, index + 10);
            if (StringTool.isNumberic(tempMobile)) {
                mobile = tempMobile;
                info = info.substring(0, index) + " " + info.substring(index + 10);
                break;
            }
            index = info.indexOf("09", index + 2);
        }
        String[] result = null;
        if (mobile != null) {
            result = new String[2];
            result[0] = mobile;
            result[1] = info;
        }
        return result;
    }


}
