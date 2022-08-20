package com.cognizant.ms.restClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.ms.model.PensionDetail;
import com.cognizant.ms.model.PensionerDetail;
import com.cognizant.ms.model.PensionerInput;

@FeignClient(name="process-pension-microservice",url="${PROCESSPENSION_VAR:http://localhost:8011/processpension}")
public interface ProcessPensionProxy {

	@GetMapping("/details")
	public List<PensionerDetail> allPensionersDetails();
	
	
	@GetMapping("/pensionerDetail")
	public PensionerDetail getPensionerDetail(@RequestHeader(name = "Authorization") String token,
			  @PathVariable String aadhaarNumber);
	
	@PostMapping("/pensionerInput")
	public PensionDetail getPensionDetail(@RequestHeader(name = "Authorization") String token,
			@RequestBody PensionerInput pensionerInput);
}
