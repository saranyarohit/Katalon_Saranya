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
import com.kms.katalon.core.testdata.ExcelData

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class SupplierKeys {

	@Keyword
	def navigateToCreateSupplierPage(){
		WebUI.click(findTestObject('user/create_new_supplier/Page_Dashboard/a_Accounts'))
		WebUI.click(findTestObject('user/create_new_supplier/Page_Dashboard/a_Suppliers'))
		WebUI.click(findTestObject('user/create_new_supplier/Page_Suppliers Management/button_Add'))
	}

	@Keyword
	def provideSupplierDetails(){
		def xl_data= TestDataFactory.findTestData('supplierDetails')
		String firstName= xl_data.getValue(1,1)
		println(firstName)
		WebUI.setText(findTestObject('user/create_new_supplier/Page_Add Supplier/input_fname'), firstName)
		String lastName= xl_data.getValue(2,1)
		WebUI.setText(findTestObject('user/create_new_supplier/Page_Add Supplier/input_lname'), lastName)
		String email= xl_data.getValue(3,1)
		WebUI.setText(findTestObject('user/create_new_supplier/Page_Add Supplier/input_email'), email)
		String password= xl_data.getValue(4,1)
		WebUI.setText(findTestObject('user/create_new_supplier/Page_Add Supplier/input_password'), password)
		String mobile= xl_data.getValue(5,1)
		WebUI.setText(findTestObject('user/create_new_supplier/Page_Add Supplier/input_mobile'), mobile)
		WebUI.click(findTestObject('user/create_new_supplier/Page_Add Supplier/autocomplete_Country1'))
		WebUI.click(findTestObject('user/create_new_supplier/Page_Add Supplier/autocomplete_Country2'))
		String country= xl_data.getValue(6,1)
		WebUI.setText(findTestObject('user/create_new_supplier/Page_Add Supplier/autocomplete_Country2'), country)
		WebUI.click(findTestObject('user/create_new_supplier/Page_Add Supplier/autocomplete_Country3'))
		String address1= xl_data.getValue(7,1)
		WebUI.setText(findTestObject('user/create_new_supplier/Page_Add Supplier/input_address1'), address1)
		String address2= xl_data.getValue(8,1)
		WebUI.setText(findTestObject('user/create_new_supplier/Page_Add Supplier/input_address2'), address2)
		String status= xl_data.getValue(9,1)
		WebUI.selectOptionByValue(findTestObject('user/create_new_supplier/Page_Add Supplier/select_Status'), status, true)
		String supply_For= xl_data.getValue(10,1)
		WebUI.selectOptionByValue(findTestObject('user/create_new_supplier/Page_Add Supplier/select_SupplyFor'),supply_For, true)
		String name= xl_data.getValue(11,1)
		WebUI.setText(findTestObject('user/create_new_supplier/Page_Add Supplier/input_Name'), name)
		WebUI.click(findTestObject('user/create_new_supplier/Page_Add Supplier/autocomplete_AssignHotel'))
		WebUI.click(findTestObject('user/create_new_supplier/Page_Add Supplier/autocomplete_AssignHotel2'))
		WebUI.click(findTestObject('user/create_new_supplier/Page_Add Supplier/autocomplete_AssignTour1'))
		WebUI.click(findTestObject('user/create_new_supplier/Page_Add Supplier/autocomplete_AssignTour2'))
		WebUI.click(findTestObject('user/create_new_supplier/Page_Add Supplier/autocomplete_Cars1'))
		WebUI.click(findTestObject('user/create_new_supplier/Page_Add Supplier/autocomplete_Cars2'))
	}

	@Keyword
	def provideAccessDetailsForAdd () {
		def xl_data= TestDataFactory.findTestData('supplier_AccessDetails')
		for(int j=1;j<=5;j++) {
			String addAccess= xl_data.getValue(2,j)
			if(addAccess.intern()=='1'){
				WebUI.check(findTestObject('common/Access/add/Page_Add Admin/checkbox_all',[('value') : j]))
			}
		}
	}

	@Keyword
	def provideAccessDetailsForEdit(){
		def xl_data= TestDataFactory.findTestData('supplier_AccessDetails')
		for(int j=1;j<=5;j++) {
			String editAccess= xl_data.getValue(3,j)
			if(editAccess.intern()=='1'){
				WebUI.check(findTestObject('common/Access/edit/Page_Add Admin/checkbox_all',[('value') : j]))
			}
		}
	}

	@Keyword
	def provideAccessDetailsForRemove(){
		WebUI.scrollToPosition(9999999, 9999999)
		def xl_data= TestDataFactory.findTestData('supplier_AccessDetails')
		for(int j=1;j<=5;j++) {
			String removeAccess= xl_data.getValue(4,j)
			if(removeAccess.intern()=='1'){
				WebUI.check(findTestObject('common/Access/remove/Page_Add Admin/checkbox_all',[('value') : j]))
			}
		}
	}

	@Keyword
	def saveSupplier(){
		WebUI.click(findTestObject('common/button_Submit'))
		WebUI.waitForPageLoad(30, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('user/create_new_supplier/Page_Suppliers Management/table_Supplier'), 30)
		println("Supplier Saved Successfully")
	}
}
