import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/scenario1')

suiteProperties.put('name', 'scenario1')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\Saranya\\git\\Katalon_Saranya\\Reports\\scenario1\\20181102_145610\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/scenario1', suiteProperties, [new TestCaseBinding('Test Cases/Common/LoginAsSuperAdmin', 'Test Cases/Common/LoginAsSuperAdmin',  null), new TestCaseBinding('Test Cases/CreateUser/CreateNewAdmin', 'Test Cases/CreateUser/CreateNewAdmin',  null), new TestCaseBinding('Test Cases/Common/LoginAsNewAdmin', 'Test Cases/Common/LoginAsNewAdmin',  null), new TestCaseBinding('Test Cases/CreateTour/CreateATour', 'Test Cases/CreateTour/CreateATour',  null), new TestCaseBinding('Test Cases/CreateUser/CreateNewSupplier', 'Test Cases/CreateUser/CreateNewSupplier',  null), new TestCaseBinding('Test Cases/Common/DeleteAdminData', 'Test Cases/Common/DeleteAdminData',  null), new TestCaseBinding('Test Cases/Common/DeleteSupplierData', 'Test Cases/Common/DeleteSupplierData',  null)])
