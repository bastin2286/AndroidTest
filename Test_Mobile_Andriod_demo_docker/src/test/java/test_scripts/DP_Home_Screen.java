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
	  								enabled = true)  //dependsOnMethods = {"DP_Home_Screen_TC_4", "DP_Home_Screen_TC_5"}
	  public void DP_Home_Screen_TC_5()
    	  {
		  count_1++;
		  MobileElement el50 = (MobileElement) driver.findElementById
									(dbUtils.dbGetElement(document, "AddPatientScreen", "Button" , "el50"));
		  el50.click();
		  MobileElement el51 = (MobileElement) driver.findElementById
					(dbUtils.dbGetElement(document, "AddPatientScreen", "Button" , "el51"));
		  el51.click();
		  MobileElement el52 = (MobileElement) driver.findElementById
					(dbUtils.dbGetElement(document, "AddPatientScreen", "Button" , "el52"));
		  el52.sendKeys("Test");
		  MobileElement el53 = (MobileElement) driver.findElementById
								(dbUtils.dbGetElement(document, "AddPatientScreen", "Button" , "el53"));		  
		  String L_name = String.valueOf(count_1);
		  el53.sendKeys(L_name);
		
		  MobileElement el54 = (MobileElement) driver.findElementById
							(dbUtils.dbGetElement(document, "AddPatientScreen", "Button" , "el54"));
		  el54.click();

		  MobileElement el55 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "AddPatientScreen", "Button" , "el55"));
		  el55.click();
		  el55.click();
		  MobileElement el56 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "AddPatientScreen", "Button" , "el56"));
		  el56.click();
		  
		  MobileElement el57 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "AddPatientScreen", "Button" , "el57"));
		  el57.click();
		  MobileElement el58 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "AddPatientScreen", "Button" , "el58"));
		  el58.click();
		  String search_test = "Test"+" "+L_name;
		  el58.sendKeys(search_test);
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
		  MobileElement el24 = (MobileElement) driver.findElementById
					(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el24"));
		  el24.click();
		  MobileElement el25 = (MobileElement) driver.findElementById
	  				(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el25"));
		  el25.click();
		  MobileElement el26 = (MobileElement) driver.findElementById
					(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el26"));
		  el26.sendKeys("Test");
		  MobileElement el27 = (MobileElement) driver.findElementById
								(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el27"));		  
		  String L_name = String.valueOf(count_1);
		  el27.sendKeys(L_name);
		
		  MobileElement el28 = (MobileElement) driver.findElementById
							(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el28"));
		  el28.click();

		  MobileElement el29 = (MobileElement) driver.findElementById
				  				(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el29"));
		  el29.click();
		  MobileElement el30 = (MobileElement) driver.findElementById
				  				(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el30"));
		  el30.sendKeys(sDOB);
		  System.out.println("sDOB: "+sDOB);
		  if(sGender.equalsIgnoreCase("Male"))
		  {
			  MobileElement el31 = (MobileElement) driver.findElementById
					  					(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el31"));
			  el31.click();
		  }
		  else
		  {
			  MobileElement el32 = (MobileElement) driver.findElementById
					  				(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el32"));
			  el32.click();
		  }

		  MobileElement el33 = (MobileElement) driver.findElementById
				  				(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el33"));
		  el33.sendKeys(sFather_Name);
		  MobileElement el34 = (MobileElement) driver.findElementById
				  			(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el34"));
		  el34.sendKeys(sMother_Name);
		  MobileElement el35 = (MobileElement) driver.findElementById
					(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el35"));
		  el35.click();

		  System.out.println("Contains:..... "+ driver.getPageSource().contains(sFather_Name));
		  assertEquals(true, driver.getPageSource().contains(sFather_Name));
		  
		  MobileElement el36 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el36"));
		  el36.click();
		  MobileElement el37 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el37"));
		  el37.click();
		  el37.sendKeys(sAddr);
		  MobileElement el38 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el38"));
		  el38.sendKeys(sPh);
		  MobileElement el39 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el39"));
		  el39.sendKeys(sAPh);
		  MobileElement el40 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el40"));
		  el40.sendKeys(sEmail);
		  MobileElement el41 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el41"));
		  el41.click();
		  MobileElement el42 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el42"));
		  el42.click();
		  MobileElement el43 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el43"));
		  el43.sendKeys(sBT);
		  MobileElement el44 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el44"));
		  el44.clear();
		  MobileElement el45 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el45"));
		  el45.sendKeys(sWT);
		  MobileElement el46 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el46"));
		  el46.sendKeys(sHT);
		  MobileElement el47 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el47"));
		  el47.sendKeys(sCom);
		  MobileElement el48 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el48"));
		  el48.sendKeys(sOccu);
		  driver.hideKeyboard();
		  MobileElement el49 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "PatientMetaData", "Button" , "el49"));
		  el49.click();
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
								+ "with dataProvider", enabled = true)
	  public void DP_Home_Screen_TC_3(String sDOB, String sGender, 
			  			String sFather_Name, String sMother_Name) 
	  {
		  count_1++;
		  MobileElement el12 = (MobileElement) driver.findElementById
					(dbUtils.dbGetElement(document, "PatientDataScreen", "Button" , "el12"));
		  el12.click();
		  MobileElement el13 = (MobileElement) driver.findElementById
	  				(dbUtils.dbGetElement(document, "PatientDataScreen", "Button" , "el13"));
		  el13.click();

		  MobileElement el14 = (MobileElement) driver.findElementById
					(dbUtils.dbGetElement(document, "PatientDataScreen", "Button" , "el14"));
		  el14.sendKeys("Test");
		  MobileElement el15 = (MobileElement) driver.findElementById
								(dbUtils.dbGetElement(document, "PatientDataScreen", "Button" , "el15"));
		  String L_name = String.valueOf(count_1);
		  el15.sendKeys(L_name);
		
		  MobileElement el16 = (MobileElement) driver.findElementById
							(dbUtils.dbGetElement(document, "PatientDataScreen", "Button" , "el16"));
		  el16.click();
		  MobileElement el17 = (MobileElement) driver.findElementById
				  				(dbUtils.dbGetElement(document, "PatientDataScreen", "Button" , "el17"));
				  el17.click();

		  MobileElement el18 = (MobileElement) driver.findElementById
				  				(dbUtils.dbGetElement(document, "PatientDataScreen", "Button" , "el18"));
		  el18.sendKeys(sDOB);
		  System.out.println("sDOB: "+sDOB);
		  if(sGender.equalsIgnoreCase("Male"))
		  {
			  MobileElement el19 = (MobileElement) driver.findElementById
					  					(dbUtils.dbGetElement(document, "PatientDataScreen", "Button" , "el19"));
			  el19.click();
		  }
		  else
		  {
			  MobileElement el20 = (MobileElement) driver.findElementById
					  				(dbUtils.dbGetElement(document, "PatientDataScreen", "Button" , "el20"));
			  el20.click();
		  }

		  MobileElement el21 = (MobileElement) driver.findElementById
				  				(dbUtils.dbGetElement(document, "PatientDataScreen", "Button" , "el21"));
		  el21.sendKeys(sFather_Name);
		  MobileElement el22 = (MobileElement) driver.findElementById
				  			(dbUtils.dbGetElement(document, "PatientDataScreen", "Button" , "el22"));
		  el22.sendKeys(sMother_Name);
			  
		  MobileElement el23 = (MobileElement) driver.findElementById
				  					(dbUtils.dbGetElement(document, "PatientDataScreen", "Button" , "el23"));
		  el23.click();
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
  				dependsOnMethods = {"DP_Home_Screen_TC_1"}, enabled = true)
  public void DP_Home_Screen_TC_2(String F_name, String L_name) 
  {
	  MobileElement el06 = (MobileElement) driver.findElementById
			  					(dbUtils.dbGetElement(document, "AddPatientScreenTest", "Button" , "el06"));
	  el06.click();
	  MobileElement el07 = (MobileElement) driver.findElementById
			  					(dbUtils.dbGetElement(document, "AddPatientScreenTest", "Button" , "el07"));
	  el07.sendKeys(F_name);
	  MobileElement el08 = (MobileElement) driver.findElementById
			  						(dbUtils.dbGetElement(document, "AddPatientScreenTest", "Button" , "el08"));
	  el08.sendKeys(L_name);

	  MobileElement el09 = (MobileElement) driver.findElementById
			  					(dbUtils.dbGetElement(document, "AddPatientScreenTest", "Button" , "el09"));
	  el09.click();
	  
	  MobileElement el10 = (MobileElement) driver.findElementById
							(dbUtils.dbGetElement(document, "AddPatientScreenTest", "Button" , "el10"));
	  el10.click();
	  
	  assertEquals(true, driver.getPageSource().contains(F_name));
	  assertEquals(true, driver.getPageSource().contains(L_name));

	  el10.click();
	  MobileElement el11 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "AddPatientScreenTest", "Button" , "el11"));
	  el11.click();
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
  		+ "description facility", enabled = true)
  public void DP_Home_Screen_TC_1() 
  {

	  MobileElement el01 = (MobileElement) driver.findElementById
			  			(dbUtils.dbGetElement(document, "HomeScreen", "Button" , "el01"));
	  el01.click();
	  MobileElement el02 = (MobileElement) driver.findElementById
			  				(dbUtils.dbGetElement(document, "HomeScreen", "Button" , "el02"));
	  el02.click();
	  MobileElement el03 = (MobileElement) driver.findElementById
			  				(dbUtils.dbGetElement(document, "HomeScreen", "Button" , "el03"));
	  el03.sendKeys("Test");
	  MobileElement el04 = (MobileElement) driver.findElementById
			  				(dbUtils.dbGetElement(document, "HomeScreen", "Button" , "el04"));
	  el04.sendKeys("01");

	  MobileElement el05 = (MobileElement) driver.findElementById
			  					(dbUtils.dbGetElement(document, "HomeScreen", "Button" , "el05"));
	  el05.click();
	  
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
		  String e14_element = dbUtils.dbGetElement(document, "HomeScreen", "Button" , "el01");
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
		  MobileElement el59 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "CloseTC4", "Button" , "el59"));
		  el59.click();
		  el59.click();
		  MobileElement el60 = (MobileElement) driver.findElementById(dbUtils.dbGetElement(document, "CloseTC4", "Button" , "el60"));
		  el60.click();
  	}
}
