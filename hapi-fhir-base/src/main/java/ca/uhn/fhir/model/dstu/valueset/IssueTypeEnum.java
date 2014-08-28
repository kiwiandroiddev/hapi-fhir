
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

public enum IssueTypeEnum {

	/**
	 * Code Value: <b>invalid</b>
	 *
	 * Content invalid against Specification or Profile.
	 */
	INVALID("invalid", "http://hl7.org/fhir/issue-type"),
	
	/**
	 * Code Value: <b>security</b>
	 *
	 * authorization/permissions issue.
	 */
	SECURITY("security", "http://hl7.org/fhir/issue-type"),
	
	/**
	 * Code Value: <b>processing</b>
	 *
	 * processing issues.
	 */
	PROCESSING("processing", "http://hl7.org/fhir/issue-type"),
	
	/**
	 * Code Value: <b>transient</b>
	 *
	 * transient processing issues.
	 */
	TRANSIENT("transient", "http://hl7.org/fhir/issue-type"),
	
	;
	
	/**
	 * Identifier for this Value Set:
	 * http://hl7.org/fhir/vs/issue-type
	 */
	public static final String VALUESET_IDENTIFIER = "http://hl7.org/fhir/vs/issue-type";

	/**
	 * Name for this Value Set:
	 * IssueType
	 */
	public static final String VALUESET_NAME = "IssueType";

	private static Map<String, IssueTypeEnum> CODE_TO_ENUM = new HashMap<String, IssueTypeEnum>();
	private static Map<String, Map<String, IssueTypeEnum>> SYSTEM_TO_CODE_TO_ENUM = new HashMap<String, Map<String, IssueTypeEnum>>();
	
	private final String myCode;
	private final String mySystem;
	
	static {
		for (IssueTypeEnum next : IssueTypeEnum.values()) {
			CODE_TO_ENUM.put(next.getCode(), next);
			
			if (!SYSTEM_TO_CODE_TO_ENUM.containsKey(next.getSystem())) {
				SYSTEM_TO_CODE_TO_ENUM.put(next.getSystem(), new HashMap<String, IssueTypeEnum>());
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
	public IssueTypeEnum forCode(String theCode) {
		IssueTypeEnum retVal = CODE_TO_ENUM.get(theCode);
		return retVal;
	}

	/**
	 * Converts codes to their respective enumerated values
	 */
	public static final IValueSetEnumBinder<IssueTypeEnum> VALUESET_BINDER = new IValueSetEnumBinder<IssueTypeEnum>() {
		@Override
		public String toCodeString(IssueTypeEnum theEnum) {
			return theEnum.getCode();
		}

		@Override
		public String toSystemString(IssueTypeEnum theEnum) {
			return theEnum.getSystem();
		}
		
		@Override
		public IssueTypeEnum fromCodeString(String theCodeString) {
			return CODE_TO_ENUM.get(theCodeString);
		}
		
		@Override
		public IssueTypeEnum fromCodeString(String theCodeString, String theSystemString) {
			Map<String, IssueTypeEnum> map = SYSTEM_TO_CODE_TO_ENUM.get(theSystemString);
			if (map == null) {
				return null;
			}
			return map.get(theCodeString);
		}
		
	};
	
	/** 
	 * Constructor
	 */
	IssueTypeEnum(String theCode, String theSystem) {
		myCode = theCode;
		mySystem = theSystem;
	}

	
}
