package lt.techin.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoListPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
    }

    @Test
    public void ToDoListTest() {
        ToDoListPage toDoListPage = new ToDoListPage(driver);

        //initial text check
        String initialPotionClassText = toDoListPage.getClickablePotionClassText();
        String initialNewRobesClassText = toDoListPage.getClickableNewRobesClassText();
        String initialPracticeMagicClassText = toDoListPage.getClickablePracticeMagicClassText();


        //test actions
        toDoListPage.isToDoListTaskDisplayedAndFilled();

        toDoListPage.isClickablePotionClassDisplayedAndClicked();

        toDoListPage.isClickableNewRobesClassDisplayedAndClicked();

        toDoListPage.isClickablePracticeMagicClassDisplayedAndClicked();



        //text check after clicks
        String afterPotionClassText = toDoListPage.getClickablePotionClassText();
        String afterNewRobesClassText = toDoListPage.getClickableNewRobesClassText();
        String afterPracticeMagicClassText = toDoListPage.getClickablePracticeMagicClassText();

        //assertion of changes after click
        assertEquals(initialPotionClassText, afterPotionClassText, "The potion class text changed after clicking it");
        assertEquals(initialNewRobesClassText, afterNewRobesClassText, "The potion class text changed after clicking it");
        assertEquals(initialPracticeMagicClassText, afterPracticeMagicClassText, "The potion class text changed after clicking it");


        //click while hover button
        toDoListPage.isClickableDeleteButtonPresentAfterHoverDelay();
        System.out.println("The button is clicked");

    }

    /*
    @AfterEach
    public void close() {

        driver.close();
    }

     */


}

