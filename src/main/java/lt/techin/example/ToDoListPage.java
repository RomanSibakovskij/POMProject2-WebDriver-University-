package lt.techin.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class ToDoListPage {

    @FindBy(css = "#container > input")
    private WebElement toDoListTaskInputField;

    @FindBy(xpath = "//*[@id='container']/ul/li[1]")
    private WebElement clickablePotionClass;


    @FindBy(xpath = "//*[@id='container']/ul/li[2]")
    private WebElement clickableNewRobesClass;


    @FindBy(xpath = "//*[@id='container']/ul/li[3]")
    private WebElement clickablePracticeMagicClass;

    @FindBy(xpath = "//*[@id='container']/ul/li[2]/span/i")
    private WebElement clickableDeleteButton;

    @FindBy(xpath = "//*[@id='container']/ul")
    private WebElement clickableTaskList; //not sure whether I need this
    WebDriver driver;


    public ToDoListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void isToDoListTaskDisplayedAndFilled() { //add new window (String inputToDo, check the text element)

        if (toDoListTaskInputField.isDisplayed()) {
            toDoListTaskInputField.sendKeys("Mow the lawn");
        } else {
            System.out.println("The input field isn't visible");
        }


    }

    public void isClickablePotionClassDisplayedAndClicked() {
        if (clickablePotionClass.isDisplayed()) {
            String text = clickablePotionClass.getText();
            new Actions(driver).click(clickablePotionClass).perform();
            System.out.println(text);
        } else {
            System.out.println("The potion class field isn't displayed");
        }



    }

    public void isClickableNewRobesClassDisplayedAndClicked() {
        if (clickableNewRobesClass.isDisplayed()) {
            String text = clickableNewRobesClass.getText();
            new Actions(driver).click(clickableNewRobesClass).perform();
            System.out.println(text);
        } else {
            System.out.println("The robes class field isn't displayed");
        }
    }

    public void isClickablePracticeMagicClassDisplayedAndClicked() {
        if (clickablePracticeMagicClass.isDisplayed()) {
            String text = clickablePracticeMagicClass.getText();
            new Actions(driver).click(clickablePracticeMagicClass).perform();
            System.out.println(text);
        } else {
            System.out.println("The practice magic class field isn't displayed");
        }
    }

    public void checkIfTaskListStatusHasBeenChangedAfterClick(List<String> checklist){

        List<WebElement> toDoTaskList = new ArrayList<>();
        String expectedOutput  = "";
        String actualOutput;
        for(int i = 0; i < toDoTaskList.size(); i++){
            if(clickablePracticeMagicClass.getAttribute("class").equals("completed")){
                System.out.println("The task status have been changed");
            }
        }

    }

    //create a list to check whether the status of other elements is changed after clicking a specified element

    //create a list to check whether the element has been removed after clicked

    public String getClickablePotionClassText(){
        return clickablePotionClass.getText();
    }

    public String getClickableNewRobesClassText(){
        return clickableNewRobesClass.getText();
    }

    public String getClickablePracticeMagicClassText(){
        return clickablePracticeMagicClass.getText();
    }

    public void isClickableDeleteButtonPresentAfterHoverDelay(){
        Actions c = new Actions(driver);
        WebElement dynamicDeleteButton = (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='container']/ul/li[2]/span/i")));
        c.moveToElement(dynamicDeleteButton).build().perform();
        c.click(dynamicDeleteButton);
    }




}