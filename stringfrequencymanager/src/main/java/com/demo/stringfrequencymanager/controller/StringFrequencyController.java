package com.demo.stringfrequencymanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.stringfrequencymanager.pojo.StringFrequencyResult;
import com.demo.stringfrequencymanager.service.IStringFrquencyService;

@RestController
public class StringFrequencyController {

	@Autowired
	private IStringFrquencyService stringFrequency;

	@RequestMapping("/isStringValid")
	@ResponseBody
	public StringFrequencyResult isStringValid(
			@RequestParam(value = "inputString", required = true) String inputStringValue) {

		return stringFrequency.getResult(inputStringValue.toUpperCase());
	}
}
