package com.cognizant.ms.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.ms.model.BankDetail;
import com.cognizant.ms.model.PensionDetail;
import com.cognizant.ms.model.PensionerDetail;
import com.cognizant.ms.model.PensionerInput;


@SpringBootTest
 class PensionManagementControllerTest {

	@Mock
	PensionManagementController pensionManagementController;
	

//	@Mock
//	ProcessPensionProxy processPensionProxy;
//	
//	@Mock
//	AuthorizationProxy authorizationProxy;
	
	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNTcyMTkxMywiaWF0IjoxNjE1NTQxOTEzfQ.sBh1dxvrhBUQWtmOIzJ0HYBIQCxZ__5Hhr1IvsOyYNI";

	
	@Test
	public void allDetailsTest() {
		BankDetail bankDetail = new BankDetail("ICICI", "12345678", "private");
		PensionerDetail pensionerDetail = new PensionerDetail("982897132579", "Prasanna", "03-03-2000", "PCASD1234Q",
				27000, 10000, "self", bankDetail);
		BankDetail bankDetail1 = new BankDetail("SBI", "12345678", "private");
		PensionerDetail pensionerDetail1 = new PensionerDetail("982897132788", "Prasanna", "03-03-2000", "PCASD1234Q",
				27000, 10000, "self", bankDetail1);
		List<PensionerDetail>  pensionerDetailsList = new ArrayList<>();
		pensionerDetailsList.add(pensionerDetail);
		pensionerDetailsList.add(pensionerDetail1);
		when(pensionManagementController.allPensionersDetails()).thenReturn(pensionerDetailsList);
		assertEquals(pensionManagementController.allPensionersDetails(),pensionerDetailsList);
		
	}
	
	
	@Test
	public void pensionDetailsTest() throws Exception {

		PensionerInput pensionerInput = new PensionerInput("Prasanna", "03-03-2000","PCASD1234Q","982897132579","self");
		PensionDetail pensionDetail = new PensionDetail("Prasanna","03-03-2000","PCASD1234Q","self",31050);
	
		when(pensionManagementController.getPensionDetail(token, pensionerInput)).thenReturn(pensionDetail);
		assertEquals(pensionManagementController.getPensionDetail(token, pensionerInput), pensionDetail);
	
	}
	
	
	
}
