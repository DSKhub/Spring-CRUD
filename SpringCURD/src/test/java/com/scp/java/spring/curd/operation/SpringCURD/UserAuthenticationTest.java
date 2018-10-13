package com.scp.java.spring.curd.operation.SpringCURD;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserAuthenticationTest {
	
  @Test(dataProvider="loginData")
  public void userNameNullTest(String uname,String pwd,String emsg) {
	  System.out.println("Execution Test Case with Parameter---"+uname +","+pwd+","+emsg);
	  UserAuthentication authentication=new UserAuthentication();
	  String returnVal=authentication.authenticateUser(uname, pwd);
	  Assert.assertEquals(returnVal, emsg);
  }
  
  @DataProvider(name="loginData")
  public Object[][] testData() {
	   Object[][] testData=new Object[6][3];
	   
	   testData[0][0]=null;
	   testData[0][1]=null;
	   testData[0][2]=AppMessages.USERNAME_EMPTY;
	   
	   testData[1][0]=null;
	   testData[1][1]="DSK";
	   testData[1][2]=AppMessages.USERNAME_EMPTY;
	   
	   testData[2][0]="Deepali";
	   testData[2][1]=null;
	   testData[2][2]=AppMessages.PASSWORD_EMPTY;
	   
	   testData[3][0]="DSK";
	   testData[3][1]="DSK";
	   testData[3][2]=AppMessages.LOGIN_INVALID;
	   
	   testData[4][0]="Dsk@143";
	   testData[4][1]="Deepali";
	   testData[4][2]=AppMessages.LOGIN_INVALID;
	   
	   testData[5][0]="Deepali";
	   testData[5][1]="Dsk@143";
	   testData[5][2]=AppMessages.LOGIN_SUCCESS;
	   
	  return testData;
	
  }
  
  @BeforeClass
	public void beforeClass() {
		System.out.println("Before Class......!!...");
	}
  @AfterClass
  public void afterClass(){
	  System.out.println("After Class.........!!!...");
  }
  @BeforeGroups
  public void beforeGroup() {
		System.out.println("Before Group......!!...");
	}
  @AfterGroups
  public void afterGroup() {
		System.out.println("After Group......!!...");
	}
  @BeforeMethod
  public void beforeMethod() {
		System.out.println("Before Method......!!...");
	}
  @AfterMethod
  public void afterMethod() {
		System.out.println("After Method......!!...");
	}
  @BeforeSuite
  public void beforeSuite() {
		System.out.println("Before Suite......!!...");
	}
  
  @AfterSuite
  public void afterSuite() {
		System.out.println("After Suite......!!...");
	}
  @BeforeTest
  public void beforeTest() {
		System.out.println("Before Test......!!...");
	}
  @AfterTest
  public void afterTest() {
		System.out.println("After Test......!!...");
	}
}


