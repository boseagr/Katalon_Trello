import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper

listID = WS.sendRequestAndVerify(findTestObject('Trello/Board/Get All Board'))

def slurper = new JsonSlurper()

def result = slurper.parseText(listID.getResponseBodyContent())

GlobalVariable.listID = result[1].lists[2].id

cardID = WS.sendRequestAndVerify(findTestObject('Trello/Card/Add Card'))

def result2 = slurper.parseText(cardID.getResponseBodyContent())

GlobalVariable.cardID = result2.id

WS.sendRequestAndVerify(findTestObject('Trello/Card/Add comment'))

commentID = WS.sendRequestAndVerify(findTestObject('Trello/Card/Add comment', [('cardID') : GlobalVariable.cardID]))

def result3 = slurper.parseText(commentID.getResponseBodyContent())

GlobalVariable.commentID = result3.id

WS.sendRequestAndVerify(findTestObject('Trello/Card/Update comment'))

