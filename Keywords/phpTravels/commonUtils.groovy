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


class commonUtils {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}
	@Keyword
	def loginToPHPTravels(String userName,String password) {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://www.phptravels.net/admin')
		WebUI.maximizeWindow()
		WebUI.setText(findTestObject('Object Repository/common/super_admin/Page_Administator Login/input_email'), userName)
		WebUI.setText(findTestObject('Object Repository/common/super_admin/Page_Administator Login/input_password'), password)
		WebUI.click(findTestObject('Object Repository/common/super_admin/Page_Administator Login/button_Login'))
	}
	@Keyword
	def deleteSupplierData() {
		WebUI.click(findTestObject('user/create_new_supplier/Page_Dashboard/a_Accounts'))
		WebUI.click(findTestObject('user/create_new_supplier/Page_Dashboard/a_Suppliers'))
		if (WebUI.verifyElementPresent(findTestObject('user/create_new_supplier/Page_Suppliers Management/select_Supplier'),5,FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('user/create_new_supplier/Page_Suppliers Management/select_Supplier'))
			WebUI.click(findTestObject('common/button_Delete'))
			WebUI.acceptAlert()
			WebUI.waitForPageLoad(30, FailureHandling.STOP_ON_FAILURE)
			println("Supplier created has been deleted Successfully")
		}
	}
	@Keyword
	def deleteTourData() {
		WebUI.click(findTestObject('create_Tour/Page_Tours Management/a_Tours'))
		WebUI.waitForElementPresent(findTestObject('create_Tour/Page_Tours Management/a_TourSubTab'), 30)
		WebUI.click(findTestObject('create_Tour/Page_Tours Management/a_TourSubTab'))
		if (WebUI.verifyElementPresent(findTestObject('create_Tour/Page_Add Tour/select_Supplier'),5,FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('create_Tour/Page_Add Tour/select_Supplier'))
			WebUI.click(findTestObject('common/button_Delete'))
			WebUI.acceptAlert()
			WebUI.waitForPageLoad(30, FailureHandling.STOP_ON_FAILURE)
			println("Tour created has been deleted Successfully")
		}
	}
	@Keyword
	def deleteAdminData() {
		WebUI.click(findTestObject('user/create_new_admin/Page_Dashboard/a_Accounts'))
		WebUI.delay(10)
		WebUI.click(findTestObject('user/create_new_admin/Page_Dashboard/a_Admins'))
		if (WebUI.verifyElementPresent(findTestObject('user/create_new_admin/Page_Update Admin/select_Admin'),6,FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('user/create_new_admin/Page_Update Admin/select_Admin'))
			WebUI.delay(5)
			WebUI.click(findTestObject('common/button_Delete'))
			WebUI.acceptAlert()
			println("Admin created has been deleted Successfully")
		}
	}

	@Keyword
	def logoutPHPTravels() {
		WebUI.click(findTestObject('Object Repository/common/button_Logout'))
	}
}