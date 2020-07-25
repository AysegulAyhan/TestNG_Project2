import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseDriver;
import utils.PageObject;

public class Practice_1 extends BaseDriver {


    @Test
    public void createAddress(){
    page.myAddressButton.click();
    page.addNewAdressButton.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#center_column")));
    page.inputFirstName.clear();
    page.inputFirstName.sendKeys("Miray");
    page.inputLastName.clear();
    page.inputLastName.sendKeys("Atalar");
    page.inputAddress.sendKeys("6602 Linworth");
    page.inputCity.sendKeys("Columbus");
    Select select=new Select(page.stateDropDown);
    select.selectByIndex(5);
    page.inputPostcode.sendKeys("45267");
    page.inputHomePhone.sendKeys("16148596633");
    page.inputMobilePhone.sendKeys("16332568974");
    page.inputReferenceAddress.clear();
    page.inputReferenceAddress.sendKeys("4456 Houston");
    page.submitAddressButton.click();

    }
    @Test(dependsOnMethods = "createAddress")
    public void updateAddress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='4456 Houston']")));
        page.adressUpdateButton2.click();
        wait.until(ExpectedConditions.visibilityOf(page.inputFirstName));
        page.inputFirstName.clear();
        page.inputFirstName.sendKeys("Azize");
        page.inputLastName.clear();
        page.inputLastName.sendKeys("Kabakci");
        page.inputAddress.clear();
        page.inputAddress.sendKeys("6607 Drew");
        page.inputReferenceAddress.clear();
        page.inputReferenceAddress.sendKeys("1604 RedRose");
        page.submitAddressButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='1604 RedRose']")));
        page.adressDeleteButton2.click();
        driver.switchTo().alert().accept();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='1604 RedRose']")));
        }catch (TimeoutException a){
            System.out.println("Adress removed successfully ");
        }
    }
}
