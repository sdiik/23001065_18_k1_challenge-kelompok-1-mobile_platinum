package stepDefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.appium.java_client.AppiumDriver


class CRUDProduct {
	//User can post and preview product
	@Given("user has opened jual page")
	public void user_has_opened_jual_page() {
		Mobile.tap(findTestObject('Object Repository/Dashboard/btn_jual'), 0)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Post Product Page/btn_preview'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Post Product Page/btn_preview'), 0)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Post Product Page/btn_terbitkan'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Post Product Page/btn_terbitkan'), 0)
	}

	@When("user input valid credential in all required fields and user select (.*) in selling page")
	public void user_input_valid_credential_in_all_required_fields_and_user_select_in_selling_page(String button) {
		Mobile.setText(findTestObject('Object Repository/Post Product Page/textbox_namaProduk'), 'kucing lucu', 0)
		Mobile.setText(findTestObject('Object Repository/Post Product Page/textbox_hargaProduk'), '1000', 0)
		Mobile.tap(findTestObject('Object Repository/Post Product Page/select_kategori'), 0)
		Mobile.tap(findTestObject('Object Repository/Post Product Page/select_elektronikKategori'), 0)
		Mobile.setText(findTestObject('Object Repository/Post Product Page/textbox_lokasi'), 'Malang', 0)
		Mobile.hideKeyboard()
		Mobile.setText(findTestObject('Object Repository/Post Product Page/textbox_deskripsi'), 'kucing yang lucu', 0)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('Object Repository/Post Product Page/btn_img'), 0)
		Mobile.tap(findTestObject('Object Repository/Post Product Page/btn_galeri'), 0)
		Mobile.tap(findTestObject('Object Repository/Post Product Page/img_fotoProduk'), 0)
		if(button=="Terbitkan") {
			Mobile.tap(findTestObject('Object Repository/Post Product Page/btn_terbitkan'), 0)
		}else if(button=="Preview") {
			Mobile.tap(findTestObject('Object Repository/Post Product Page/btn_preview'), 0)
		}
		Mobile.hideKeyboard()
	}

	@Then("user successfully (.*) product")
	public void user_successfully_product(String result) {
		if(result=="create") {
			Mobile.waitForElementPresent(findTestObject('Object Repository/Daftar Jual Saya/txt_diminati'), 0)
			Mobile.verifyElementVisible(findTestObject('Object Repository/Daftar Jual Saya/txt_diminati'), 0)
			Mobile.waitForElementPresent(findTestObject('Object Repository/Daftar Jual Saya/txt_terjual'), 0)
			Mobile.verifyElementVisible(findTestObject('Object Repository/Daftar Jual Saya/txt_terjual'), 0)
		}else if(result=="preview") {
			Mobile.waitForElementPresent(findTestObject('Object Repository/Preview Page/btn_kembaliHalamanSebelumnya'), 0)
			Mobile.verifyElementVisible(findTestObject('Object Repository/Preview Page/btn_kembaliHalamanSebelumnya'), 0)
			Mobile.waitForElementPresent(findTestObject('Object Repository/Preview Page/text_detailProduk'), 0)
			Mobile.verifyElementVisible(findTestObject('Object Repository/Preview Page/text_detailProduk'), 0)
		}
	}

	//User can't leave product picture blank
	@When("user input valid credential in all required fields except upload picture and click terbitkan button in selling page")
	public void user_input_valid_credential_in_all_required_fields_except_upload_picture_and_click_terbitkan_button_in_selling_page() {
		Mobile.setText(findTestObject('Object Repository/Post Product Page/textbox_namaProduk'), 'kucing lucu', 0)
		Mobile.setText(findTestObject('Object Repository/Post Product Page/textbox_hargaProduk'), '1000', 0)
		Mobile.tap(findTestObject('Object Repository/Post Product Page/select_kategori'), 0)
		Mobile.tap(findTestObject('Object Repository/Post Product Page/select_elektronikKategori'), 0)
		Mobile.setText(findTestObject('Object Repository/Post Product Page/textbox_lokasi'), 'Malang', 0)
		Mobile.hideKeyboard()
		Mobile.setText(findTestObject('Object Repository/Post Product Page/textbox_deskripsi'), 'kucing yang lucu', 0)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('Object Repository/Post Product Page/btn_terbitkan'), 0)
		Mobile.hideKeyboard()
	}

	@Then("user will fail create product")
	public void user_will_fail_create_product() {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		driver.findElementByXPath("//android.widget.Toast[@text='Silahkan masukkan foto produk terlebih dahulu.']")
	}
}



