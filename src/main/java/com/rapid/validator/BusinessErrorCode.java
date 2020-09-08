package com.rapid.validator;

public enum BusinessErrorCode {
	ERROR_ORIGIN_MISSING(5001), 
	ERROR_DESTINATION_MISSING(5002);
	
	
	 private int code;

	 private BusinessErrorCode(int c) {
	   code = c;
	 }

	 public int getCode() {
	   return code;
	 }
}
