package androidcalculator.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class MainPage extends BasePageObject {
    @FindBy(id = "com.google.android.calculator:id/digit_0")
    protected WebElement digit_0;
    @FindBy(id = "com.google.android.calculator:id/digit_1")
    protected WebElement digit_1;
    @FindBy(id = "com.google.android.calculator:id/digit_2")
    protected WebElement digit_2;
    @FindBy(id = "com.google.android.calculator:id/digit_3")
    protected WebElement digit_3;
    @FindBy(id = "com.google.android.calculator:id/digit_4")
    protected WebElement digit_4;
    @FindBy(id = "com.google.android.calculator:id/digit_5")
    protected WebElement digit_5;
    @FindBy(id = "com.google.android.calculator:id/digit_6")
    protected WebElement digit_6;
    @FindBy(id = "com.google.android.calculator:id/digit_7")
    protected WebElement digit_7;
    @FindBy(id = "com.google.android.calculator:id/digit_8")
    protected WebElement digit_8;
    @FindBy(id = "com.google.android.calculator:id/digit_9")
    protected WebElement digit_9;

    @FindBy(id = "com.google.android.calculator:id/op_add")
    protected WebElement add;
    @FindBy(id = "com.google.android.calculator:id/op_sub")
    protected WebElement subtract;
    @FindBy(id = "com.google.android.calculator:id/op_mul")
    protected WebElement multiply;
    @FindBy(id = "com.google.android.calculator:id/op_div")
    protected WebElement divide;
    @FindBy(id = "com.google.android.calculator:id/eq")
    protected WebElement equal;
    @FindBy(id = "com.google.android.calculator:id/del")
    protected WebElement clear;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    protected WebElement result;


    public MainPage(AutomationDriver driver) {
        super(driver);
        defaultWebpageElementLocator(driver);
        PageFactory.initElements(driver.getAndroidDriver(), this);
    }

    @Override
    public boolean isPageLoaded() {
        if (elementHelper.isElementPresentAndDisplayed(clear)){
            logger.info("Application started correctly");
            return true;
        }
        logger.error("Application did not load correctly");
        return false;
    }

    public void calculateEquation(String equation) {
        String[] parts = equation.split(" ");
        String leftVal = parts[0];
        String rightVal = parts[2];
        char operator = parts[1].charAt(0);

        handleValue(leftVal);
        clickOperator(operator);
        handleValue(rightVal);
        elementHelper.clickWithinTime(equal, 5000);
    }


    private void handleValue(String value) {
        logger.info("Clicking numbers: " + value);
        char[] values = value.toCharArray();
        for(char num: values){
            clickNumber(num);
        }
    }

    public void clickNumber(char number){
        WebElement button = null;
        switch (number){
            case '0': button = digit_0; break;
            case '1': button = digit_1; break;
            case '2': button = digit_2; break;
            case '3': button = digit_3; break;
            case '4': button = digit_4; break;
            case '5': button = digit_5; break;
            case '6': button = digit_6; break;
            case '7': button = digit_7; break;
            case '8': button = digit_8; break;
            case '9': button = digit_9; break;
        }
        elementHelper.clickWithinTime(button, 2000);
    }

    public void clickOperator(char op){
        WebElement button = null;
        logger.info("Clicking operator: " + op);
        switch (op){
            case '+': button = add; break;
            case '-': button = subtract; break;
            case '*': button = multiply; break;
            case '/': button = divide; break;
        }
        elementHelper.clickWithinTime(button, 2000);
    }

    public boolean getResult(String expectedResult){
        if(elementHelper.isTextPresentInElementWithinTime(result, expectedResult, 2000)){
            logger.info("Correct result");
            return true;
        }
        logger.error("Not correct result, expected: " + expectedResult + " found: " + result.getText());
        return false;
    }


}
