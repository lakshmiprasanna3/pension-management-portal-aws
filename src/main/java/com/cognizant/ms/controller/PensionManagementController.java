package com.cognizant.ms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ms.model.PensionDetail;
import com.cognizant.ms.model.PensionerDetail;
import com.cognizant.ms.model.PensionerInput;
import com.cognizant.ms.restClient.AuthorizationProxy;
import com.cognizant.ms.restClient.ProcessPensionProxy;

@RestController
@CrossOrigin("*")
public class PensionManagementController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionManagementController.class);
	
	@Autowired
	private AuthorizationProxy authorizationProxy;
	@Autowired
	private ProcessPensionProxy processPensionProxy;
	

	
	// pensionerDetailms
	
	@GetMapping("/details")
	public List<PensionerDetail> allPensionersDetails(){
		LOGGER.info("Started");
		return processPensionProxy.allPensionersDetails();
	}
	
	@GetMapping("/pensionerDetail")
	public PensionerDetail getPensionerDetail(@RequestHeader(name = "Authorization") String token,
			  @PathVariable String aadhaarNumber) {
		LOGGER.info("Started");
		return processPensionProxy.getPensionerDetail(token, aadhaarNumber);
	}
	
	//processPensionms
	
	@PostMapping("/pensionerInput")
	public PensionDetail getPensionDetail(@RequestHeader(name = "Authorization") String token,
			@RequestBody PensionerInput pensionerInput) throws Exception{
		
		if(authorizationProxy.authorization(token)) {
			LOGGER.info("Token Validated");
			return processPensionProxy.getPensionDetail(token, pensionerInput);
		}else {
			LOGGER.error("Token Invalid Exception");
			throw new Exception("token is not valid");
		}
		
	}
	
	
	
	
}
