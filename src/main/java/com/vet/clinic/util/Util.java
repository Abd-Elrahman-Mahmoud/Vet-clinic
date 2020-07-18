package com.vet.clinic.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Util {

	private static final ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
	}

	public static String toJson(Object instance) {
		try {
			return mapper.writeValueAsString(instance);
		} catch (Exception e) {
			return "";
		}
	}

}
