package com.rapid.validator;





public class ParamValidator  {
	
	public ParamValidator() {
		
	}
	public Error validateRequestParams(String origin, String destination) {
		Error error = null;
		
		if(origin == null || origin.equals("")) {
			error = new Error();
        	error.setCode(BusinessErrorCode.ERROR_ORIGIN_MISSING.getCode());
        	error.setDescription(BusinessErrorCode.ERROR_ORIGIN_MISSING.toString());
		} else if (destination == null || destination.equals("")) {
			error = new Error();
        	error.setCode(BusinessErrorCode.ERROR_DESTINATION_MISSING.getCode());
        	error.setDescription(BusinessErrorCode.ERROR_DESTINATION_MISSING.toString());
		}
		
		return error;
	}
	
	
	
	
}
