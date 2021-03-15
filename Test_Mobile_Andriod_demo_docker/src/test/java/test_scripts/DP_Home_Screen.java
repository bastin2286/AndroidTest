/*****************************************************************************
 * File Name 	: DP_Home_Screen.java
 * 
 * Version		: 0.1
 * 
 * Author		: Bastin
 * 
 * Type			:(Test Scripts/Libraries) Test Scripts
 * 
 * Description	: This .java file is written to test the Home_Screen
 * 				  as part of the scripting. 
 * 
 * Test cases	: DP_Home_Screen_TC_1, DP_Home_Screen_TC_2, DP_Home_Screen_TC_3
 *****************************************************************************/
package test_scripts;
import org.testng.annotations.Test;
/*Inclusion of required libraries*/
import org.testng.asserts.Assertion;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import tcsLib.applicationLaunchLib;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import tcsLib.screenshotLib;
import tcsLib.yamlLib;
import utility.ExcelUtils;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import tcsLib.dbUtils;
import org.json.simple.JSONObject;
import com.mongodb.DB;

/*Below class contains the test scripts for the Home screen*/
/*TestNG settings for run all the defined test cases*/
public class DP_Home_Screen  
{
	static int count_1 = 0;
	public AppiumDriver<MobileElement> driver;
	JSONObject document;
	/*Data provider with excel settings in the name of PatientData*/
	@DataProvider
	public Object[][] PatientData() 
	{
	  try
		{
		  	
			ExcelUtils.setExcelFile("/src/AndroidTest/Test_Mobile_Andriod_demo_docker/src/test/java/test_data/Test.xlsx","Sheet3");			
			Object[][] testObjArray = ExcelUtils.getTableArray("/src/AndroidTest/Test_Mobile_Andriod_demo_docker/src/test/java/test_data/Test.xlsx","Sheet3");		
			return (testObjArray);	
		}
		
		catch(Exception e)
		{
			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}	
	
	/*Data provider with excel settings in the name of PatientData*/
	@DataProvider
	public Object[][] PatientMetaData() 
	{
	  try
		{
		  	
			ExcelUtils.setExcelFile("/src/AndroidTest/Test_Mobile_Andriod_demo_docker/src/test/java/test_data/Test.xlsx","PatientMetaData test");			
			Object[][] testObjArray = ExcelUtils.getTableArray("/src/AndroidTest/Test_Mobile_Andriod_demo_docker/src/test/java/test_data/Test.xlsx","PatientMetaData test");		
			return (testObjArray);	
		}
		
		catch(Exception e)
		{
			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/**************************************************************************
	 * Test Name  : DP_Home_Screen_TC_5
	 * 
	 * Test ID	  : TC_5
	 * 
	 * Type		  :(Parameterized/Data Driven/other) other
	 * 
	 * Group	  :(Smoke/Sanity/Regression) Regression
	 * 
	 * Description: This test case will verify the screen functions are working 
	 * 				as per the SRS document
	 *************************************************************************/

	  @Test(priority = 5, description = "Add Patient screen testing "
	  								+ "with parameterized testing",
	  								enabled = false)  //dependsOnMethods = {"DP_Home_Screen_TC_4", "DP_Home_Screen_TC_5"}
	  public void DP_Home_Screen_TC_5()
    {
		  count_1++;
		  MobileElement el5 = (MobileElement) driver.findElementById
									("us.drpad.drpadapp:id/lv_patient");
		  el5.click();
		  MobileElement el15 = (MobileElement) driver.findElementById
					("us.drpad.drpadapp:id/imgAddPatient");
		  el15.click();
		  MobileElement el26 = (MobileElement) driver.findElementById
					("us.drpad.drpadapp:id/edt_first_name");
		  el26.sendKeys("Test");
		  MobileElement el27 = (MobileElement) driver.findElementById
								("us.drpad.drpadapp:id/edt_lastname");		  
		  String L_name = String.valueOf(count_1);
		  el27.sendKeys(L_name);
		
		  MobileElement el8 = (MobileElement) driver.findElementById
							("us.drpad.drpadapp:id/btn_done");
		  el8.click();

		  MobileElement el04 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/ic_clinic");
		  el04.click();
		  el04.click();
		  MobileElement el2 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/txt_home");
		  el2.click();
		  
		  MobileElement el1 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/lv_addappoinment");
		  el1.click();
		  MobileElement el12 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/edt_search");
		  el12.click();
		  String search_test = "Test"+" "+L_name;
		  el12.sendKeys(search_test);
		  assertEquals(true, true);
    }

	/**************************************************************************
	 * Test Name  : DP_Home_Screen_TC_4
	 * 
	 * Test ID	  : TC_4
	 * 
	 * Type		  :(Parameterized/Data Driven/other) other
	 * 
	 * Group	  :(Smoke/Sanity/Regression) Regression
	 * 
	 * Description: This test case will verify the screen functions are working 
	 * 				as per the SRS document
	 *************************************************************************/
	  @Test(priority = 4, dataProvider = "PatientMetaData", description = "Home screen testing with priority and "
  		+ "description facility", enabled = true)
    public void DP_Home_Screen_TC_4(String sDOB, String sGender, 
  						String sFather_Name, String sMother_Name,
  						String sAddr, String sPh, String sAPh, String sEmail,
  						String sBT, String sHT, String sWT, String sOccu,
  						String sCom)
    {
		  count_1++;
		  MobileElement el5 = (MobileElement) driver.findElementById
					(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el5"));
		  el5.click();
		  MobileElement el15 = (MobileElement) driver.findElementById
	  				(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el15"));
		  el15.click();
		  MobileElement el26 = (MobileElement) driver.findElementById
					(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el26"));
		  el26.sendKeys("Test");
		  MobileElement el27 = (MobileElement) driver.findElementById
								(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el27"));		  
		  String L_name = String.valueOf(count_1);
		  el27.sendKeys(L_name);
		
		  MobileElement el8 = (MobileElement) driver.findElementById
							(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el8"));
		  el8.click();

		  MobileElement el1 = (MobileElement) driver.findElementById
				  				(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el1"));
		  el1.click();
		  MobileElement el12 = (MobileElement) driver.findElementById
				  				(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el12"));
		  el12.sendKeys(sDOB);
		  System.out.println("sDOB: "+sDOB);
		  if(sGender.equalsIgnoreCase("Male"))
		  {
			  MobileElement el18 = (MobileElement) driver.findElementById
					  					(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el18"));
			  el18.click();
		  }
		  else
		  {
			  MobileElement el19 = (MobileElement) driver.findElementById
					  				(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el19"));
			  el19.click();
		  }

		  MobileElement el119 = (MobileElement) driver.findElementById
				  				(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el119"));
		  el119.sendKeys(sFather_Name);
		  MobileElement el120 = (MobileElement) driver.findElementById
				  			(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el120"));
		  el120.sendKeys(sMother_Name);
		  MobileElement el121 = (MobileElement) driver.findElementById
					(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el121"));
		  el121.click();

		  System.out.println("Contains:..... "+ driver.getPageSource().contains(sFather_Name));
		  assertEquals(true, driver.getPageSource().contains(sFather_Name));
		  
		  MobileElement el01 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el01"));
		  el01.click();
		  MobileElement el02 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el02"));
		  el02.click();
		  el02.sendKeys(sAddr);
		  MobileElement el113 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el113"));
		  el113.sendKeys(sPh);
		  MobileElement el4 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el4"));
		  el4.sendKeys(sAPh);
		  MobileElement el115 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el115"));
		  el115.sendKeys(sEmail);
		  MobileElement el6 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el14"));
		  el6.click();
		  MobileElement el7 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el7"));
		  el7.click();
		  MobileElement el18 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el18"));
		  el18.sendKeys(sBT);
		  MobileElement el9 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el9"));
		  el9.clear();
		  MobileElement el10 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el10"));
		  el10.sendKeys(sWT);
		  MobileElement el11 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el11"));
		  el11.sendKeys(sHT);
		  MobileElement el112 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el112"));
		  el112.sendKeys(sCom);
		  MobileElement el13 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el13"));
		  el13.sendKeys(sOccu);
		  driver.hideKeyboard();
		  MobileElement el14 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el14"));
		  el14.click();
		  try
		  {
			  System.out.println("sFather_Name: "+sFather_Name);
			  System.out.println("Contains: "+ driver.getPageSource().contains(sFather_Name));

			  screenshotLib.captureScreenshot("DP_Home_Screen_TC_4_"
					  				+ "b4_Err", driver);
			  if(driver.getPageSource().contains(sFather_Name))
			  {
				  assertEquals(true,true);
			  }
			  else
			  {
				  close_TC4();
			  }
			  if(driver.getPageSource().contains(sMother_Name))
			  {
				  assertEquals(true,true);
			  }
			  else
			  {
				  
				  close_TC4();
			  }

			  if(driver.getPageSource().contains(sAddr))
			  {
				  assertEquals(true,true);
			  }
			  else
			  {
				  close_TC4();
			  }
			  
			  if(driver.getPageSource().contains(sAPh))
			  {
				  assertEquals(true,true);
			  }
			  else
			  {
				  close_TC4();
			  }
			  
			  if(driver.getPageSource().contains(sBT))
			  {
				  assertEquals(true,true);
			  }
			  else
			  {
				  close_TC4();
			  }
			  
			  if(driver.getPageSource().contains(sWT))
			  {
				  assertEquals(true,true);
			  }
			  else
			  {
				  close_TC4();
			  }
			  
			  if(driver.getPageSource().contains(sHT))
			  {
				  assertEquals(true,true);
			  }
			  else
			  {
				  close_TC4();
			  }
			  
			  if(driver.getPageSource().contains(sCom))
			  {
				  assertEquals(true,true);
			  }
			  else
			  {
				  close_TC4();
			  }
			  
			  if(driver.getPageSource().contains(sOccu))
			  {
				  assertEquals(true,true);
			  }
			  else
			  {
				  close_TC4();
			  }
			  /*
			  assertEquals(true, driver.getPageSource().contains(sFather_Name));
			  assertEquals(true, driver.getPageSource().contains(sMother_Name));
			  assertEquals(true, driver.getPageSource().contains(sAddr));
			  assertEquals(true, driver.getPageSource().contains(sPh));
			  assertEquals(true, driver.getPageSource().contains(sAPh));
			  assertEquals(true, driver.getPageSource().contains(sBT));
			  assertEquals(true, driver.getPageSource().contains(sWT));
			  assertEquals(true, driver.getPageSource().contains(sHT));
			  assertEquals(true, driver.getPageSource().contains(sCom));
			  assertEquals(true, driver.getPageSource().contains(sOccu));
			  */
		  }
		  catch(Exception e)
			{
				System.out.println("Error Cause is:- "+e.getCause());
				System.out.println("Error Message is:- "+e.getMessage());
				e.printStackTrace();
			}
		  close_TC4();
    }

	/**************************************************************************
	 * Test Name  : DP_Home_Screen_TC_3
	 * 
	 * Test ID	  : TC_3
	 * 
	 * Type		  :(Parameterized/Data Driven/other) Data Driven
	 * 
	 * Group	  :(Smoke/Sanity/Regression) Regression
	 * 
	 * Description: This test case will input the patient data from the
	 * 				excel and verify the screen functions are working 
	 * 				as per the SRS document
	 *************************************************************************/
	  @Test(priority = 3, dataProvider = "PatientData", 
			description = "Add Patient details screen testing "
								+ "with dataProvider", enabled = false)
	  public void DP_Home_Screen_TC_3(String sDOB, String sGender, 
			  			String sFather_Name, String sMother_Name) 
	  {
		  count_1++;
		  MobileElement el5 = (MobileElement) driver.findElementById
					("us.drpad.drpadapp:id/lv_patient");
		  el5.click();
		  MobileElement el15 = (MobileElement) driver.findElementById
	  				("us.drpad.drpadapp:id/imgAddPatient");
		  el15.click();

		  MobileElement el126 = (MobileElement) driver.findElementById
					("us.drpad.drpadapp:id/edt_first_name");
		  el126.sendKeys("Test");
		  MobileElement el127 = (MobileElement) driver.findElementById
								("us.drpad.drpadapp:id/edt_lastname");
		  String L_name = String.valueOf(count_1);
		  el127.sendKeys(L_name);
		
		  MobileElement el118 = (MobileElement) driver.findElementById
							("us.drpad.drpadapp:id/btn_done");
		  el118.click();
		  MobileElement el1 = (MobileElement) driver.findElementById
				  				("us.drpad.drpadapp:id/txt_title_age");
				  el1.click();

		  MobileElement el112 = (MobileElement) driver.findElementById
				  				("us.drpad.drpadapp:id/edt_dob");
		  el112.sendKeys(sDOB);
		  System.out.println("sDOB: "+sDOB);
		  if(sGender.equalsIgnoreCase("Male"))
		  {
			  MobileElement el1118 = (MobileElement) driver.findElementById
					  					("us.drpad.drpadapp:id/rd_male");
			  el1118.click();
		  }
		  else
		  {
			  MobileElement el19 = (MobileElement) driver.findElementById
					  				("us.drpad.drpadapp:id/rd_female");
			  el19.click();
		  }

		  MobileElement el19 = (MobileElement) driver.findElementById
				  				("us.drpad.drpadapp:id/edt_father_name");
		  el19.sendKeys(sFather_Name);
		  MobileElement el20 = (MobileElement) driver.findElementById
				  			("us.drpad.drpadapp:id/edt_mother_name");
		  el20.sendKeys(sMother_Name);
			  
		  MobileElement el21 = (MobileElement) driver.findElementById
				  					("us.drpad.drpadapp:id/btn_save");
		  el21.click();
		  try
		  {
			  //assertEquals(true, driver.getPageSource().contains(sDOB));
			  assertEquals(true, driver.getPageSource().contains(sFather_Name));
			  assertEquals(true, driver.getPageSource().contains(sMother_Name));
		  }
		  catch(Exception e)
			{
				System.out.println("Error Cause is:- "+e.getCause());
				System.out.println("Error Message is:- "+e.getMessage());
				e.printStackTrace();
			}
		  close_TC4();
			  
	  }

	/**************************************************************************
	 * Test Name  : DP_Home_Screen_TC_2
	 * 
	 * Test ID	  : TC_2
	 * 
	 * Type		  :(Parameterized/Data Driven/other) Parameterized
	 * 
	 * Group	  :(Smoke/Sanity/Regression) Regression
	 * 
	 * Description: This test case will input the patient data from the
	 * 				xml and verify the screen functions are working 
	 * 				as per the SRS document. And also verifies the 
	 * 				dependsOnMethods.
	 *************************************************************************/
  @Parameters({"F_name","L_name"})
  @Test(priority = 2, description = "Add Patient screen testing "
  								+ "with parameterized testing",
  				dependsOnMethods = {"DP_Home_Screen_TC_1"}, enabled = false)
  public void DP_Home_Screen_TC_2(String F_name, String L_name) 
  {
	  MobileElement el5 = (MobileElement) driver.findElementById
			  					("us.drpad.drpadapp:id/imgAddPatient");
	  el5.click();
	  MobileElement el26 = (MobileElement) driver.findElementById
			  					("us.drpad.drpadapp:id/edt_first_name");
	  el26.sendKeys(F_name);
	  MobileElement el27 = (MobileElement) driver.findElementById
			  						("us.drpad.drpadapp:id/edt_lastname");
	  el27.sendKeys(L_name);

	  MobileElement el8 = (MobileElement) driver.findElementById
			  					("us.drpad.drpadapp:id/btn_done");
	  el8.click();
	  
	  MobileElement el9 = (MobileElement) driver.findElementById
							("us.drpad.drpadapp:id/ic_clinic");
	  el9.click();
	  
	  assertEquals(true, driver.getPageSource().contains(F_name));
	  assertEquals(true, driver.getPageSource().contains(L_name));

	  el9.click();
	  MobileElement el2 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/txt_home");
	  el2.click();
  }	

/**************************************************************************
 * Test Name  : DP_Home_Screen_TC_1
 * 
 * Test ID	  : TC_1
 * 
 * Type		  :(Parameterized/Data Driven/other) other
 * 
 * Group	  :(Smoke/Sanity/Regression) Regression
 * 
 * Description: This test case will verify the screen functions are working 
 * 				as per the SRS document
 *************************************************************************/
  @Test(priority = 1, description = "Home screen testing with priority and "
  		+ "description facility", enabled = false)
  public void DP_Home_Screen_TC_1() 
  {

	  MobileElement el4 = (MobileElement) driver.findElementById
			  			(dbUtils.dbGetElement(document, "HomeScreen", "Button" , "el4"));
	  el4.click();
	  MobileElement el5 = (MobileElement) driver.findElementById
			  				(dbUtils.dbGetElement(document, "HomeScreen", "Button" , "el5"));
	  el5.click();
	  MobileElement el6 = (MobileElement) driver.findElementById
			  				(dbUtils.dbGetElement(document, "HomeScreen", "Button" , "el6"));
	  el6.sendKeys("Test");
	  MobileElement el7 = (MobileElement) driver.findElementById
			  				(dbUtils.dbGetElement(document, "HomeScreen", "Button" , "el7"));
	  el7.sendKeys("01");

	  MobileElement el8 = (MobileElement) driver.findElementById
			  					(dbUtils.dbGetElement(document, "HomeScreen", "Button" , "el8"));
	  el8.click();
	  
	  //Need to check the screen verification call
	  assertEquals(true,true);
  }
  

/**************************************************************************
 * Test Name  : DP_Home_Screen_TC_0
 * 
 * Test ID	  : TC_0
 * 
 * Type		  :(Parameterized/Data Driven/other) other
 * 
 * Group	  :(Smoke/Sanity/Regression) Regression
 * 
 * Description: This test case will verify the screen functions are working 
 * 				as per the SRS document
 *************************************************************************/
  @Test(priority = 0, description = "Home screen testing with priority and "
  		+ "description facility",enabled = true)
  public void DP_Home_Screen_TC0() 
  {
	  //Need to check the screen verification call
	  assertEquals(true,true);
  }
  /**************************************************************************
   * Function Name  : beforeTest
   * 
   * Description: As per test NG this is the function which will call before the test
	    			automatically
   *************************************************************************/
  @BeforeTest
  public void beforeTest() 
  {
	  try
		{
		  Map<String, String> map;
		  String path = "/src/AndroidTest/Test_Mobile_Andriod_demo_docker/src/test/java/utility/test.yaml";
		  DB db = dbUtils.dbGetDatabase("10.10.196.130", 27017,"MobileAppElementsRepo");
		  System.out.println("DB:"+ db);
		  
		  document = dbUtils.dbGetDoument(db,"App1",1, "/src/AndroidTest/Test_Mobile_Andriod_demo_docker/src/test/java/utility/json_array_output.json");
		  System.out.println("document:"+ document);
		  String e14_element = dbUtils.dbGetElement(document, "HomeScreen", "Button" , "el4");
		  System.out.println("element id :"+ e14_element);
		  
		  map = yamlLib.yamlRead(path);
		  driver = applicationLaunchLib.appLaunch(map.get("path_config"),map.get("app_id"));	
		  System.out.println("B4 Test");
		}
		catch(Exception e)
		{
			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
  }
  /**************************************************************************
   * Function Name  : afterTest
   * 
   * Description: As per test NG this is the function which will call after 
   * 				the test automatically
   *************************************************************************/
  @AfterTest
  public void afterTest() 
  {
	  try
		{	
			driver.quit();			
			 System.out.println("After Tetst");
		}
		catch(Exception e)
		{
			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
  }

  /**************************************************************************
   * Function Name  : close_TC4
   * 
   * Description: If the assert is not equal test case should close the window
   * 				to run the next test case successfully
   *************************************************************************/
  	public void close_TC4() 
  	{
		  MobileElement el04 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/ic_clinic");
		  el04.click();
		  el04.click();
		  MobileElement el2 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/txt_home");
		  el2.click();
  	}
}
