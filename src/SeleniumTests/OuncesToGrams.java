package SeleniumTests;

import GeneralMethods.GeneralMethods;
import org.openqa.selenium.WebDriver;

public class OuncesToGrams {


    private WebDriver driver;

    public OuncesToGrams(WebDriver driver){
        this.driver = driver;
    }
    public void runAllTests() throws InterruptedException {
        System.out.println("Run First Test Check Legal Values");
        firstTest("99"," OZ");
        GeneralMethods.backToMainPage(driver);
        firstTest("7.5","oz");
        GeneralMethods.backToMainPage(driver);
        firstTest("789","Oz ");
        GeneralMethods.backToMainPage(driver);
        firstTest("5"," oZ");
        GeneralMethods.backToMainPage(driver);
        firstTest("123","o");
        GeneralMethods.backToMainPage(driver);
        firstTest("55"," o");
        GeneralMethods.backToMainPage(driver);
        firstTest("111"," o ");
        GeneralMethods.backToMainPage(driver);
        firstTest("123","o ");
        GeneralMethods.backToMainPage(driver);
        firstTest("88","O ");
        GeneralMethods.backToMainPage(driver);
        firstTest("77"," O ");
        GeneralMethods.backToMainPage(driver);
        System.out.println("--------------");
        System.out.println("Run Second Test Check Legal Values after press Length");
        secondTest("33","OZ");
        GeneralMethods.backToMainPage(driver);
        secondTest("1"," oz");
        GeneralMethods.backToMainPage(driver);
        secondTest("123"," o ");
        GeneralMethods.backToMainPage(driver);
        secondTest("7.5","o ");
        GeneralMethods.backToMainPage(driver);
        secondTest("8.5"," O");
        GeneralMethods.backToMainPage(driver);
        secondTest("9.5","O");
        GeneralMethods.backToMainPage(driver);
        System.out.println("--------------");
        System.out.println("Run Third Test Check Legal Values after enter value no need to go back to the main page without the Oz ");
        firstTest("99"," Oz");
        thirdTest("789","");
        thirdTest("9.5","");
        GeneralMethods.backToMainPage(driver);
        System.out.println("--------------");
        System.out.println("Run Fifth Test Check ILLegal Values the search container should not appears do not needs to go back to main page");
        firstTest("99"," Oz");
        fifthTest("E+++"," o");
        fifthTest("7.5----+++","OZ");
        fifthTest("+++"," oz ");
        fifthTest("   "," o");
        GeneralMethods.backToMainPage(driver);



    }
    public void firstTest( String checkValue , String symbol ) throws InterruptedException {
        System.out.println("Value is "+checkValue);
        Thread.sleep(2000);
        GeneralMethods.sendValueToInput("queryFrom",checkValue,symbol,driver);
        Thread.sleep(1000);
        GeneralMethods.ClickButton("//*[@id=\"results\"]/ol/li[1]/div/a[2]",driver);
        Thread.sleep(2000);
        GeneralMethods.checkTheExpectedResultAndActualResultOuncesToGrams(checkValue,symbol,driver);
        Thread.sleep(2000);
    }
    public void secondTest(String checkValue , String symbol) throws InterruptedException {
        System.out.println("Value is "+checkValue);
        Thread.sleep(2000);
        GeneralMethods.linkText("Weight",driver);
        GeneralMethods.sendValueToInput("queryFrom",checkValue,symbol,driver);
        Thread.sleep(1000);
        GeneralMethods.ClickButton("//*[@id=\"results\"]/ol/li[1]/div/a[2]",driver);
        Thread.sleep(2000);
        GeneralMethods.checkTheExpectedResultAndActualResultOuncesToGrams(checkValue,symbol,driver);
        Thread.sleep(2000);

    }


    public void thirdTest(String checkValue , String symbol) throws InterruptedException {
        System.out.println("Value is "+checkValue);
        GeneralMethods.emptyTheinput(driver,"argumentConv");
        GeneralMethods.sendValueToInput("argumentConv",checkValue,"",driver);
        GeneralMethods.checkTheExpectedResultAndActualResultOuncesToGrams(checkValue,symbol,driver);
        Thread.sleep(2000);

    }


    public void fifthTest(String checkValue,  String symbol ) throws InterruptedException {
        System.out.println("Value is "+checkValue);
        GeneralMethods.emptyTheinput(driver,"argumentConv");
        GeneralMethods.sendValueToInput("argumentConv",checkValue,"",driver);
        checkValue = "0";
        GeneralMethods.checkTheExpectedResultAndActualResultOuncesToGrams(checkValue,symbol,driver);
    }


}
