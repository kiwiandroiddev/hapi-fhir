
package ca.uhn.fhir.model.dstu.valueset;

/*
 * #%L
 * HAPI FHIR - Core Library
 * %%
 * Copyright (C) 2014 University Health Network
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import ca.uhn.fhir.model.api.*;
import java.util.HashMap;
import java.util.Map;

public enum RestfulOperationTypeEnum {

	/**
	 * Code Value: <b>read</b>
	 */
	READ("read", "http://hl7.org/fhir/restful-operation"),
	
	/**
	 * Code Value: <b>vread</b>
	 */
	VREAD("vread", "http://hl7.org/fhir/restful-operation"),
	
	/**
	 * Code Value: <b>update</b>
	 */
	UPDATE("update", "http://hl7.org/fhir/restful-operation"),
	
	/**
	 * Code Value: <b>delete</b>
	 */
	DELETE("delete", "http://hl7.org/fhir/restful-operation"),
	
	/**
	 * Code Value: <b>history-instance</b>
	 */
	HISTORY_INSTANCE("history-instance", "http://hl7.org/fhir/restful-operation"),
	
	/**
	 * Code Value: <b>validate</b>
	 */
	VALIDATE("validate", "http://hl7.org/fhir/restful-operation"),
	
	/**
	 * Code Value: <b>history-type</b>
	 */
	HISTORY_TYPE("history-type", "http://hl7.org/fhir/restful-operation"),
	
	/**
	 * Code Value: <b>create</b>
	 */
	CREATE("create", "http://hl7.org/fhir/restful-operation"),
	
	/**
	 * Code Value: <b>search-type</b>
	 */
	SEARCH_TYPE("search-type", "http://hl7.org/fhir/restful-operation"),
	
	;
	
	/**
	 * Identifier for this Value Set:
	 * http://hl7.org/fhir/vs/type-restful-operation
	 */
	public static final String VALUESET_IDENTIFIER = "http://hl7.org/fhir/vs/type-restful-operation";

	/**
	 * Name for this Value Set:
	 * RestfulOperationType
	 */
	public static final String VALUESET_NAME = "RestfulOperationType";

	private static Map<String, RestfulOperationTypeEnum> CODE_TO_ENUM = new HashMap<String, RestfulOperationTypeEnum>();
	private static Map<String, Map<String, RestfulOperationTypeEnum>> SYSTEM_TO_CODE_TO_ENUM = new HashMap<String, Map<String, RestfulOperationTypeEnum>>();
	
	private final String myCode;
	private final String mySystem;
	
	static {
		for (RestfulOperationTypeEnum next : RestfulOperationTypeEnum.values()) {
			CODE_TO_ENUM.put(next.getCode(), next);
			
			if (!SYSTEM_TO_CODE_TO_ENUM.containsKey(next.getSystem())) {
				SYSTEM_TO_CODE_TO_ENUM.put(next.getSystem(), new HashMap<String, RestfulOperationTypeEnum>());
			}
			SYSTEM_TO_CODE_TO_ENUM.get(next.getSystem()).put(next.getCode(), next);			
		}
	}
	
	/**
	 * Returns the code associated with this enumerated value
	 */
	public String getCode() {
		return myCode;
	}
	
	/**
	 * Returns the code system associated with this enumerated value
	 */
	public String getSystem() {
		return mySystem;
	}
	
	/**
	 * Returns the enumerated value associated with this code
	 */
	public RestfulOperationTypeEnum forCode(String theCode) {
		RestfulOperationTypeEnum retVal = CODE_TO_ENUM.get(theCode);
		return retVal;
	}

	/**
	 * Converts codes to their respective enumerated values
	 */
	public static final IValueSetEnumBinder<RestfulOperationTypeEnum> VALUESET_BINDER = new IValueSetEnumBinder<RestfulOperationTypeEnum>() {
		@Override
		public String toCodeString(RestfulOperationTypeEnum theEnum) {
			return theEnum.getCode();
		}

		@Override
		public String toSystemString(RestfulOperationTypeEnum theEnum) {
			return theEnum.getSystem();
		}
		
		@Override
		public RestfulOperationTypeEnum fromCodeString(String theCodeString) {
			return CODE_TO_ENUM.get(theCodeString);
		}
		
		@Override
		public RestfulOperationTypeEnum fromCodeString(String theCodeString, String theSystemString) {
			Map<String, RestfulOperationTypeEnum> map = SYSTEM_TO_CODE_TO_ENUM.get(theSystemString);
			if (map == null) {
				return null;
			}
			return map.get(theCodeString);
		}
		
	};
	
	/** 
	 * Constructor
	 */
	RestfulOperationTypeEnum(String theCode, String theSystem) {
		myCode = theCode;
		mySystem = theSystem;
	}

	
}
