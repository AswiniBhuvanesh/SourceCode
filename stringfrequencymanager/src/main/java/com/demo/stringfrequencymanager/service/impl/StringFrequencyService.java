package com.demo.stringfrequencymanager.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.stringfrequencymanager.App;
import com.demo.stringfrequencymanager.pojo.StringFrequencyResult;
import com.demo.stringfrequencymanager.service.IStringFrquencyService;

@Service
public class StringFrequencyService implements IStringFrquencyService {

	@Override
	public StringFrequencyResult getResult(String inputStringValue) {
		StringFrequencyResult frequencyResult = new StringFrequencyResult();
		Map<String, Integer> logsDataListWithCount = App.logFilesContentList;
		if (logsDataListWithCount.get(inputStringValue) != null && logsDataListWithCount.get(inputStringValue) > 5) {
			frequencyResult.setResponse("false");
		} else if (inputStringValue.length() > 40) {
			frequencyResult.setResponse("Input string length should not be greater than 40");
		} else {
			frequencyResult.setResponse("true");
		}
		return frequencyResult;
	}

}
