package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.assertj.core.api.Assertions.assertThatNullPointerException

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


public class Transaction {
	
	@Given('buyers succesfully register to the app')
	public void buyers_succesfully_register_to_the_app() {
		
		int randomNumber
		randomNumber = (int)(Math.random()*10000)
		
		Mobile.startApplication('Apk/app-debug.apk', true)
		
		Mobile.tap(findTestObject('Object Repository/Dashboard/btn_akun'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Login page/btn_loginmsk'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Login page/btn_loginmsk'), 0)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Login page/txt_AkunSaya'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Login page/txt_AkunSaya'), 0)
		
		Mobile.tap(findTestObject('Object Repository/Login page/btn_loginmsk'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Login page/TextArea_email'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Login page/TextArea_email'), 0)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Login page/TextArea_password'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Login page/TextArea_password'), 0)
		
		Mobile.tap(findTestObject('Object Repository/Login page/text_daftar'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Register/TextBox _nama'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Register/TextBox _nama'), 0)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Register/TextBox_ email'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Register/TextBox_ email'), 0)
		
		Mobile.setText(findTestObject('Object Repository/Register/TextBox _nama'), 'Archi Buyer', 0)
		Mobile.hideKeyboard()
		Mobile.setText(findTestObject('Object Repository/Register/TextBox_ email'), 'ArchiBuyer2' + randomNumber + '@mail.com', 0)
		Mobile.hideKeyboard()
		Mobile.setText(findTestObject('Object Repository/Register/TextBox_password'), '041099', 0)
		Mobile.hideKeyboard()
		Mobile.setText(findTestObject('Object Repository/Register/TextBox_nomorHP'), '085814205153', 0)
		Mobile.hideKeyboard()
		Mobile.setText(findTestObject('Object Repository/Register/TextBox_kota'), 'Jombang', 0)
		Mobile.hideKeyboard()
		
		Mobile.scrollToText('Masukkan Alamat')
		Mobile.setText(findTestObject('Object Repository/Register/TexBox_alamat'), 'villa bintaro indah', 0)
		Mobile.hideKeyboard()
		
		Mobile.tap(findTestObject('Object Repository/Register/btn_daftar'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/AkunMenu/btn_daftarJualSaya'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/AkunMenu/btn_daftarJualSaya'), 0)
		Mobile.waitForElementPresent(findTestObject('Object Repository/AkunMenu/btn_edit'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/AkunMenu/btn_edit'), 0)
		
	}
	
	@When('buyers input all correct values for offer information')
	public void buyers_input_all_correct_value_for_offer_information() {
		
		Mobile.tap(findTestObject('Object Repository/Dashboard/btn_beranda'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Search Product Page/input_search'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Search Product Page/input_search'), 0)
		
		Mobile.tap(findTestObject('Object Repository/Search Product Page/input_search'), 0)
		Mobile.setText(findTestObject('Object Repository/Search Product Page/input_search2'), 'kucing archi 1', 0)
		Mobile.hideKeyboard()
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Search Product Page/view_products'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Search Product Page/view_products'), 0)
		
		Mobile.tap(findTestObject('Object Repository/Search Product Page/view_products'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/btn_nego'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Buyer Transaction Page/btn_nego'), 0)
		
		Mobile.tap(findTestObject('Object Repository/Buyer Transaction Page/btn_nego'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/TextArea_harga'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Buyer Transaction Page/TextArea_harga'), 0)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/btn_kirim'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Buyer Transaction Page/btn_kirim'), 0)
		
		Mobile.setText(findTestObject('Object Repository/Buyer Transaction Page/TextArea_harga'), '5000', 0)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('Object Repository/Buyer Transaction Page/btn_nego'), 0)	
		Mobile.tap(findTestObject('Object Repository/Buyer Transaction Page/btn_kirim'), 0)
		
	}
	
	@Then('buyers will successfully send trade offers to sellers')
	public void buyers_will_successfully_send_trade_offers_to_sellers() {
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/text_offersuccess'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Buyer Transaction Page/text_offersuccess'), 0)
		Mobile.closeApplication()
	}
	
	@Given('buyers logged out from the app')
	public void buyers_logged_out_from_the_app() {
		Mobile.startApplication('Apk/app-debug.apk', true)
		
		Mobile.tap(findTestObject('Object Repository/Dashboard/btn_akun'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Login page/btn_loginmsk'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Login page/btn_loginmsk'), 0)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Login page/txt_AkunSaya'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Login page/txt_AkunSaya'), 0)
		
		Mobile.tap(findTestObject('Object Repository/Login page/btn_loginmsk'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Login page/TextArea_email'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Login page/TextArea_email'), 0)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Login page/TextArea_password'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Login page/TextArea_password'), 0)
		
		Mobile.setText(findTestObject('Object Repository/Login page/TextArea_email'), 'ArchiMobile1@mail.com', 0)
		Mobile.hideKeyboard()
		Mobile.setText(findTestObject('Object Repository/Login page/TextArea_password'), '041099', 0)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('Object Repository/Login page/btn_loginmsk2'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/AkunMenu/btn_daftarJualSaya'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/AkunMenu/btn_daftarJualSaya'), 0)
		Mobile.waitForElementPresent(findTestObject('Object Repository/AkunMenu/btn_keluar'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/AkunMenu/btn_keluar'), 0)
		
		Mobile.tap(findTestObject('Object Repository/AkunMenu/btn_keluar'), 0)
		
	}
	
	@When('buyers click negotiation button')
	public void buyers_click_negotiation_button() {
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Search Product Page/input_search'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Search Product Page/input_search'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Search Product Page/input_search'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Search Product Page/input_search'), 0)
		
		Mobile.tap(findTestObject('Object Repository/Search Product Page/input_search'), 0)
		Mobile.setText(findTestObject('Object Repository/Search Product Page/input_search2'), 'kucing archi 1', 0)
		Mobile.hideKeyboard()
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Search Product Page/view_products'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Search Product Page/view_products'), 0)
		
		Mobile.tap(findTestObject('Object Repository/Search Product Page/view_products'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/btn_nego'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Buyer Transaction Page/btn_nego'), 0)
		
		Mobile.tap(findTestObject('Object Repository/Buyer Transaction Page/btn_nego'), 0)
		
		
	}
	
	@Then('buyers will be redirected to login page')
	public void buyers_will_be_redirected_to_login_page() {
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Login page/TextArea_email'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Login page/TextArea_email'), 0)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Login page/TextArea_password'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Login page/TextArea_password'), 0)
		Mobile.closeApplication()
		
	}
	
	@When('buyers input string values in the offer price box')
	public void buyers_input_string_values_in_the_offer_price_box() {
		
		Mobile.tap(findTestObject('Object Repository/Dashboard/btn_beranda'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Search Product Page/input_search'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Search Product Page/input_search'), 0)
		
		Mobile.tap(findTestObject('Object Repository/Search Product Page/input_search'), 0)
		Mobile.setText(findTestObject('Object Repository/Search Product Page/input_search2'), 'kucing archi 1', 0)
		Mobile.hideKeyboard()
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Search Product Page/view_products'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Search Product Page/view_products'), 0)
		
		Mobile.tap(findTestObject('Object Repository/Search Product Page/view_products'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/btn_nego'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Buyer Transaction Page/btn_nego'), 0)
		
		Mobile.tap(findTestObject('Object Repository/Buyer Transaction Page/btn_nego'), 0)
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/TextArea_harga'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Buyer Transaction Page/TextArea_harga'), 0)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Buyer Transaction Page/btn_kirim'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Buyer Transaction Page/btn_kirim'), 0)
		
		Mobile.setText(findTestObject('Object Repository/Buyer Transaction Page/TextArea_harga'), 'test', 0)
		Mobile.hideKeyboard()
		
	}
	
	@Then('buyers will not be able to input the string values')
	public void buyers_will_not_be_able_to_input_the_string_values() {
		Mobile.tap(findTestObject('Object Repository/Buyer Transaction Page/btn_nego'), 0)
		Mobile.tap(findTestObject('Object Repository/Buyer Transaction Page/btn_kirim'), 0)
		Mobile.closeApplication()
	}
	
}
