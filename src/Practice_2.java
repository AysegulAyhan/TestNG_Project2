import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseDriver;

import java.util.List;
import java.util.Random;

public class Practice_2 extends BaseDriver {

    @Test
    void addWishList() throws InterruptedException {
        page.dressesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rte")));
        js.executeScript("scroll(0,100)");
        Actions actions= new Actions(driver);
        List<WebElement> dresses= page.dressList;
        int random=new Random().nextInt(dresses.size());
        Thread.sleep(2000);
        js.executeScript("scroll(0,1000)");
        actions.moveToElement(dresses.get(random)).perform();
        List<WebElement> wishListButtons = page.wishListButton;
        wait.until(ExpectedConditions.elementToBeClickable(wishListButtons.get(random)));
        wishListButtons.get(random).click();
        wait.until(ExpectedConditions.visibilityOf(page.wishListCloseButton));
        page.wishListCloseButton.click();
        //js.executeScript("scroll(0,-300)");
        wait.until(ExpectedConditions.elementToBeClickable(page.customerAccountButton));
        page.customerAccountButton.click();
        wait.until(ExpectedConditions.visibilityOf(page.myWishListButton));
        page.myWishListButton.click();
        wait.until(ExpectedConditions.visibilityOf(page.viewHiddenList));
        js.executeScript("scroll(0,100)");
        page.viewHiddenList.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".row"),0));
        wait.until(ExpectedConditions.visibilityOf(page.wishListDresses.get(random)));
        js.executeScript("scroll(0,500)");
        wait.until(ExpectedConditions.visibilityOf(page.removefromWishList));
        page.removefromWishList.click();
        try {
            wait.until(ExpectedConditions.visibilityOf(page.removefromWishList));
        }catch (TimeoutException a){
            System.out.println("dress is removed");
        }
        Thread.sleep(4000);
        page.deleteWishList.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}

