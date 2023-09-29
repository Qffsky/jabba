package com.step4kap.main;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChromiumTest {

    private final String rootTitle = "Главная страница";
    private final String employeeInfoTitle = "Служащие";
    private final String projectsTitle = "Проекты";
    private final String policyTitle = "Выплаты";

    @Test
    void MainPage() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/");
        assertEquals(rootTitle, driver.getTitle());
        driver.quit();
    }

    @Test
    void HeaderTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.get("http://localhost:8080/");

        WebElement peopleButton = driver.findElement(By.id("employeeInfoListLink"));
        peopleButton.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        assertEquals(employeeInfoTitle, driver.getTitle());

        WebElement rootButton = driver.findElement(By.id("rootLink"));
        rootButton.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        assertEquals(rootTitle, driver.getTitle());

        WebElement projectsButton = driver.findElement(By.id("projectsListLink"));
        projectsButton.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        assertEquals(projectsTitle, driver.getTitle());

        rootButton = driver.findElement(By.id("rootLink"));
        rootButton.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        assertEquals(rootTitle, driver.getTitle());

        driver.quit();
    }

    @Test
    void addProject() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/projects");
        assertEquals(projectsTitle, driver.getTitle());
        WebElement addProject = driver.findElement(By.id("addProjectButton"));
        addProject.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        String editProjectTitle = "Редактировать проект";
        assertEquals(editProjectTitle, driver.getTitle());

        driver.findElement(By.id("projectName")).sendKeys("Тестовое имя проекта");
        driver.findElement(By.id("projectStart")).sendKeys("1");
        driver.findElement(By.id("projectEnd")).sendKeys("2");
        driver.findElement(By.id("submitButton")).click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

        assertEquals(projectsTitle, driver.getTitle());
        WebElement projectInfo = driver.findElement(By.id("projectInfo"));
        List<WebElement> cells = projectInfo.findElements(By.tagName("p"));

        assertEquals(cells.get(0).getText(), "Название: Тестовое имя проекта");
        assertEquals(cells.get(1).getText(), "Начало: 1");
        assertEquals(cells.get(1).getText(), "Конец: 2");

        driver.quit();
    }

    @Test
    void getEmployeeInfo() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/employeeInfo?employeeInfoId=30039");
        String employeeInfoTitle = "Информация о служащем";
        assertEquals(employeeInfoTitle, driver.getTitle());

        WebElement employeeInfo = driver.findElement(By.id("employeeInfo"));
        List<WebElement> cells = employeeInfo.findElements(By.tagName("p"));

        assertEquals(cells.get(0).getText(), "ФИО служащего: Noel Livingston");
        assertEquals(cells.get(1).getText(), "Адрес: 52282 Sporer Roads");
        assertEquals(cells.get(2).getText(), "Образование: Wake Forest University");
        assertEquals(cells.get(3).getText(), "Должность: supervisor");
        assertEquals(cells.get(4).getText(), "Зарплата: 100");
        List<WebElement> placeForPerson = cells.get(6).findElements(By.tagName("a"));
        assertEquals(placeForPerson.size(), 3);
        driver.quit();
    }

}