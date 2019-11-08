package com.demo.stringfrequencymanager.service;

import com.demo.stringfrequencymanager.pojo.StringFrequencyResult;

public abstract interface IStringFrquencyService {

	public abstract StringFrequencyResult getResult(String inputStringValue);
	
}
