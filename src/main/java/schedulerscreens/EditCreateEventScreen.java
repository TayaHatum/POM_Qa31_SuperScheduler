package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.Event;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EditCreateEventScreen extends BaseScreen {
    public EditCreateEventScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_title_input']")
    MobileElement title;
    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_type_input']")
    MobileElement type;
    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_break_plus_btn']")
    MobileElement breaksPlusBtn;
    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_edit']")
    MobileElement wageEdit;
    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_input']")
    MobileElement wageInput;
    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_save']")
    MobileElement wageSave;
    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_save_btn']")
    MobileElement confirmCreation;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_day_number_txt']")
    List<MobileElement> days;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_month_txt']")
    List<MobileElement> months;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/delete_menu']")
    MobileElement deleteBtn;


    public HomeScreen createNewEvent(Event event) {
        // fill form  + click AddButton ----> HomeScreen
        should(title, 15);
        type(title, event.getTitle());
        type(type, event.getType());
        hideKeyBoard();

        int breaks = event.getBreaks();

        if (breaks > 0 && breaks < 5) {
            for (int i = 0; i < breaks; i++) {
                breaksPlusBtn.click();
            }
        }
        wageEdit.click();
        type(wageInput, String.valueOf(event.getWage()));
        wageSave.click();
        confirmCreation.click();

        return new HomeScreen(driver);
    }

    public HomeScreen deleteEvent() {
        should(deleteBtn, 10);
        deleteBtn.click();
        return new HomeScreen(driver);
    }

    public EditCreateEventScreen checkData(String date) {//dd/MM/yyyy -> 28/05/2022
        pause(4000);
        logger.info("The text of 'Day' -->" + days.get(0).getText()); //24
        logger.info("The text of 'Month' -->" + months.get(0).getText()); //MAY

        LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));  //-> 28/05/2022

        LocalDate current = getDate(days.get(0), months.get(0)); //24 MAY

        while (!inputDate.equals(current)) {
            actionsWithData();
            pause(1000);
            current = getDate(days.get(0), months.get(0));
        }
        return this;
    }

    public EditCreateEventScreen actionsWithData() {
        pause(3000);
        System.out.println("size -->"+days.size());
        MobileElement dayEl = days.get(2);
        Rectangle rect = dayEl.getRect();
        logger.info("The 'Width' of first element  -->" + rect.getWidth());
        logger.info("The 'Height' of first element  -->" + rect.getHeight());
        logger.info("The 'X' of first element  -->" + rect.getX());
        logger.info("The 'Y' of first element  -->" + rect.getY());


        Dimension window = driver.manage().window().getSize();
        logger.info("The 'Width' of screen  -->" + window.getWidth());
        logger.info("The 'Height' of screen  -->" + window.getHeight());

        int y = rect.getY() + rect.getHeight() / 2;
        int xFrom = window.getWidth() - 150;
        int xTo = window.getWidth() / 2;

        TouchAction<?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(xFrom, y))
                .moveTo(PointOption.point(xTo, y))
                .release()
                .perform();
        return this;
    }

    private LocalDate getDate(MobileElement dayEl, MobileElement monthEl) {

        logger.info("Impotent to know day is --->" + dayEl.getText()); //24
        logger.info("Impotent to know month is --->" + monthEl.getText()); // MAY
        // 24 MAY ---> 24/MAY/2022 ---> ofPattern("d/MMMM/yyyy") ---> 24/May/2022
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MMMM/yyyy");

        String m = monthEl.getText().toLowerCase();
        System.out.println("Impotent to know 1) monthEl.getText().toLowerCase() --->" + m); //may
        m = m.substring(0, 1).toUpperCase() + m.substring(1);
        System.out.println("Impotent to know  2) m.substring(0, 1).toUpperCase() + m.substring(1); --->" + m); //May
        return LocalDate.parse(dayEl.getText() + "/" + m + "/2022", formatter);
    }


}

//str.substring(indexA[, indexB])
//Метод substring() извлекает символы, начиная с индекса indexA
//Если аргумент indexB опущен, метод substring() извлечёт символы до конца строки.
