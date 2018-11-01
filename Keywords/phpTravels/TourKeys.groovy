package phpTravels
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.InternalData
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class TourKeys {

	@Keyword
	def navigateToNewTour(){
		WebUI.click(findTestObject('create_Tour/Page_Tours Management/a_Tours'))
		WebUI.click(findTestObject('create_Tour/Page_Tours Management/a_Add New'))
	}

	@Keyword
	def provideTourDetails(){

		InternalData inData= findTestData('generalTourDetails')
		String status=inData.internallyGetValue(14, 0)
		WebUI.selectOptionByValue(findTestObject('create_Tour/Page_Add Tour/select_TourStatus'), status, true)
		String tourName=inData.internallyGetValue(0, 0)
		WebUI.setText(findTestObject('create_Tour/Page_Add Tour/input_tourname'), tourName)
		WebUI.switchToFrame(findTestObject('create_Tour/Page_Add Tour/iframeObject'), 30)
		WebUI.click(findTestObject('create_Tour/Page_Add Tour/iframeBody'))
		String tourDescription=inData.internallyGetValue(1, 0)
		WebUI.setText(findTestObject('create_Tour/Page_Add Tour/iframeBody'), tourDescription)
		WebUI.switchToDefaultContent()
		String maxAdult=inData.internallyGetValue(2, 0)
		WebUI.setText(findTestObject('create_Tour/Page_Add Tour/input_maxadult'), maxAdult)
		String adultPrice=inData.internallyGetValue(3, 0)
		WebUI.setText(findTestObject('create_Tour/Page_Add Tour/input_adultprice'), adultPrice)
		WebUI.scrollToPosition(9999999, 9999999)
		WebUI.click(findTestObject('create_Tour/Page_Add Tour/span_EnableChild'))
		String maxChild=inData.internallyGetValue(4, 0)
		WebUI.setText(findTestObject('create_Tour/Page_Add Tour/input_maxchild'), maxChild)
		String childPrice=inData.internallyGetValue(5, 0)
		WebUI.setText(findTestObject('create_Tour/Page_Add Tour/input_childprice'), childPrice)
		WebUI.click(findTestObject('create_Tour/Page_Add Tour/span_EnableInfant'))
		String maxInfant=inData.internallyGetValue(6, 0)
		WebUI.setText(findTestObject('create_Tour/Page_Add Tour/input_maxinfant'), maxInfant)
		String infantPrice=inData.internallyGetValue(7, 0)
		WebUI.setText(findTestObject('create_Tour/Page_Add Tour/input_infantprice'), infantPrice)
		String star=inData.internallyGetValue(8, 0)
		WebUI.selectOptionByValue(findTestObject('create_Tour/Page_Add Tour/select_Select'), star, true)
		String tourDays=inData.internallyGetValue(9, 0)
		WebUI.setText(findTestObject('create_Tour/Page_Add Tour/input_tourdays'), tourDays)
		String tourNights=inData.internallyGetValue(10, 0)
		WebUI.setText(findTestObject('create_Tour/Page_Add Tour/input_tournights'), tourNights)
		String tourType=inData.internallyGetValue(11, 0)
		WebUI.click(findTestObject('create_Tour/Page_Add Tour/select_TourType'))
		WebUI.click(findTestObject('create_Tour/Page_Add Tour/select_TourTypeOption',[('type') : tourType]))
		String featured=inData.internallyGetValue(12, 0)
		WebUI.selectOptionByValue(findTestObject('create_Tour/Page_Add Tour/select_Featured'), featured, true)
		WebUI.click(findTestObject('create_Tour/Page_Add Tour/autocomplete_Location1'))
		String location=inData.internallyGetValue(13, 0)
		WebUI.setText(findTestObject('create_Tour/Page_Add Tour/autocomplete_Location2'), location)
		WebUI.click(findTestObject('create_Tour/Page_Add Tour/autocomplete_Location3'))
	}

	@Keyword
	def provideTourInclusions(){

		InternalData inData= findTestData('tourInclusions')
		WebUI.click(findTestObject('create_Tour/Page_Add Tour/a_Inclusions'))
		WebUI.waitForPageLoad(20, FailureHandling.STOP_ON_FAILURE)
		int i=0;
		for (int k=4; k<=45;k++) {
			String selectTrigger=inData.internallyGetValue(1, i)
			if(selectTrigger.intern()=='0'){
				WebUI.click(findTestObject('create_Tour/Page_Add Tour/checkbox_Inclusions', [('value') : k ]))
			}
			i=i+1
		}
	}

	@Keyword
	def provideTourExclusions(){
		InternalData inData= findTestData('tourExclusions')
		WebUI.click(findTestObject('create_Tour/Page_Add Tour/a_Exclusions'))
		WebUI.waitForPageLoad(20, FailureHandling.STOP_ON_FAILURE)
		int i=0;
		for (int k=4; k<=17;k++) {
			String selectTrigger=inData.internallyGetValue(1, i)
			if(selectTrigger.intern()=='0'){
				WebUI.click(findTestObject('create_Tour/Page_Add Tour/checkbox_Exclusions', [('value') : k ]))
			}

			i=i+1
		}
	}

	@Keyword
	def SaveTour(){
		WebUI.click(findTestObject('common/button_Submit'))
		WebUI.verifyElementPresent(findTestObject('create_Tour/Page_Add Tour/table_Tour'), 30)
		println("Tour has been saved Successfully")
	}
}