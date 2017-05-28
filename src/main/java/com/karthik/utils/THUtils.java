package com.karthik.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.IteratorUtils;

import com.karthik.constants.THConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class THUtils {
	@SuppressWarnings("unchecked")
	public static HashMap<String, Object> convertPojoToHashMap(Object input) {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(input, HashMap.class);

	}

	public static String convertPojoToString(Object input) {
		String result = "";
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			result = objectMapper.writeValueAsString(input);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Map<String, Object> appendingBaseResponse(Map<String, Object> input, int id) {

		switch (id) {
		case 0:
			input.put(THConstants.STATUSKEY, THConstants.STATUS200);
			input.put(THConstants.MSG, THConstants.INSERTION_SUCCESS);
			break;
		case 1:
			input.put(THConstants.STATUSKEY, THConstants.STATUS201);
			input.put(THConstants.MSG, THConstants.UPDATE_SUCCESS);
			break;

		case 2:
			input.put(THConstants.STATUSKEY, THConstants.STATUS405);
			input.put(THConstants.MSG, THConstants.FAILS);
			break;
		default:
			break;
		}

		return input;
	}
	@SuppressWarnings("rawtypes")
	public static List iteratorToList(Iterator itr) {
		List list = new ArrayList<>();

		if (itr != null) {
			list = IteratorUtils.toList(itr);

		}
		return list;
	}



}
