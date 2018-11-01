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
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

public class PhpKeys {
	/*Initialisation*/
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	/*Initialisation*/

	@Keyword
	def navigateToCreateAdminPage(){
		WebUI.click(findTestObject('user/create_new_admin/Page_Dashboard/a_Accounts'))
		WebUI.click(findTestObject('user/create_new_admin/Page_Dashboard/a_Admins'))
		WebUI.click(findTestObject('user/create_new_admin/Page_Admins Management/button_Add'))
	}

	@Keyword
	def provideAdminDetails(){
		def dbdata= findTestData('adminDetails')
		String firstName= dbdata.getValue(3,1)
		WebUI.setText(findTestObject('user/create_new_admin/Page_Add Admin/input_fname'), firstName)
		String lastName= dbdata.getValue(4,1)
		WebUI.setText(findTestObject('user/create_new_admin/Page_Add Admin/input_lname'), lastName)
		String eMail= dbdata.getValue(5,1)
		WebUI.setText(findTestObject('user/create_new_admin/Page_Add Admin/input_email'), eMail)
		String password= dbdata.getValue(2,1)
		WebUI.setText(findTestObject('user/create_new_admin/Page_Add Admin/input_password'), password)
		String mobileNumber= dbdata.getValue(6,1)
		WebUI.setText(findTestObject('user/create_new_admin/Page_Add Admin/input_mobile'), mobileNumber)
		String country= dbdata.getValue(7,1)
		WebUI.click(findTestObject('user/create_new_admin/Page_Add Admin/autocomplete_country1'))
		WebUI.click(findTestObject('user/create_new_admin/Page_Add Admin/autocomplete_country2'))
		WebUI.setText(findTestObject('user/create_new_admin/Page_Add Admin/autocomplete_country2'), country)
		WebUI.click(findTestObject('user/create_new_admin/Page_Add Admin/autocomplete_country3'))
		String address1= dbdata.getValue(8,1)
		WebUI.setText(findTestObject('user/create_new_admin/Page_Add Admin/input_address1'), address1)
		String address2= dbdata.getValue(9,1)
		WebUI.setText(findTestObject('user/create_new_admin/Page_Add Admin/input_address2'), address2)
		String statusIndex= dbdata.getValue(10,1)
		WebUI.selectOptionByIndex(findTestObject('user/create_new_admin/Page_Add Admin/select_status'),statusIndex)
	}

	@Keyword
	def provideAccessDetailsForAdd () {
		def dbdata= findTestData('admin_AccessDetails')
		for(int j=1;j<=5;j++) {
			String addAccess= dbdata.getValue(4,j)
			if(addAccess.intern()=='1'){
				WebUI.check(findTestObject('common/Access/add/Page_Add Admin/checkbox_all',[('value') : j]))
			}
		}
	}

	@Keyword
	def provideAccessDetailsForEdit(){
		def dbdata= findTestData('admin_AccessDetails')
		for(int j=1;j<=5;j++) {
			String editAccess= dbdata.getValue(5,j)
			if(editAccess.intern()=='1'){
				WebUI.check(findTestObject('common/Access/edit/Page_Add Admin/checkbox_all',[('value') : j]))
			}
		}
	}

	@Keyword
	def provideAccessDetailsForRemove(){
		WebUI.scrollToPosition(9999999, 9999999)
		def dbdata= findTestData('admin_AccessDetails')
		for(int j=1;j<=5;j++) {
			String removeAccess= dbdata.getValue(6,j)
			if(removeAccess.intern()=='1'){
				WebUI.check(findTestObject('common/Access/remove/Page_Add Admin/checkbox_all',[('value') : j]))
			}
		}
	}

	@Keyword
	def saveAdmin(){
		WebUI.click(findTestObject('user/create_new_admin/Page_Update Admin/button_Submit'))
		WebUI.waitForPageLoad(30, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('user/create_new_admin/Page_Update Admin/table_Admin'), 30)
		println("Saved Successfully")
	}
}
