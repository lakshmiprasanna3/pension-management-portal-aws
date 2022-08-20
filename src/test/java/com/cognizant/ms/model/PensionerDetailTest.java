package com.cognizant.ms.model;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

@SpringBootTest
 class PensionerDetailTest {

	@Test
	void NoArgsPensionDetailTest()
	{
		assertThat(new PensionerDetail()).isNotNull();
		assertThat(new BankDetail()).isNotNull();
		
	}
	
	@Test
	void AllArgsPensionDetailTest()
	{
		BankDetail bankDetail = new BankDetail("SBI", "1930232384", "public");
		PensionerDetail pensionDetail=new PensionerDetail("19183857573", "Professor","06-11-1999" , "PIYTH7890L",40000,12000, "family",bankDetail);
	
		//assertThat(assertThat(pensionDetail).isNotNull());
		assertNotNull(pensionDetail);
		assertNotNull(bankDetail);
	}

	@Test
	void AllsetterPensionDetailTest()
	{
		BankDetail bankDetail = new BankDetail();
		bankDetail.setBankName("HDFC");
		bankDetail.setAccountNumber("35346356456457");
		bankDetail.setBankType("private");
		PensionerDetail pensionerDetail=new PensionerDetail() ;
		pensionerDetail.setAadhaarNumber("32535245425452");
		pensionerDetail.setName("Nairobi");
		pensionerDetail.setDateOfBirth("11-5-1990");
		pensionerDetail.setPanNumber("ILUPWS2341C");
		pensionerDetail.setPensionType("family");
		pensionerDetail.setSalary(500000);
		pensionerDetail.setAllowance(12000);
		pensionerDetail.setBankDetail(bankDetail);
		//assertThat(assertThat(pensionerDetail).isNotNull());
		assertNotNull(pensionerDetail);
		assertNotNull(bankDetail);
		
	}
	
	@Test
	void getterPensionDetailTest()
	{
		BankDetail bankDetail = new BankDetail("SBI", "1930232384", "public");
		PensionerDetail pensionDetail=new PensionerDetail("19183857573", "Professor","06-11-1999" , "PIYTH7890L",40000,12000, "family",bankDetail);
		String adhaar = pensionDetail.getAadhaarNumber() ;
		assertEquals("19183857573", adhaar) ;
		assertEquals("Professor", pensionDetail.getName() ) ;
		assertEquals("06-11-1999", pensionDetail.getDateOfBirth() ) ;
		assertEquals("PIYTH7890L", pensionDetail.getPanNumber() ) ;
		assertEquals(40000, pensionDetail.getSalary()) ;
		assertEquals(12000, pensionDetail.getAllowance()) ;
		assertEquals("family", pensionDetail.getPensionType()) ;
		assertEquals("SBI", bankDetail.getBankName());
		assertEquals("1930232384", bankDetail.getAccountNumber());
		assertEquals("public", bankDetail.getBankType());
		

	}
}
