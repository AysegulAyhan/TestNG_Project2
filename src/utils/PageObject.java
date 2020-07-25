package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageObject {

    public WebDriver driver;
    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    @FindBy(css=".login")
    public WebElement loginButton;
    @FindBy(id = "email")
    public WebElement inputEmail;
    @FindBy(id="passwd")
    public WebElement inputPassword;
    @FindBy(css ="#SubmitLogin")
    public WebElement submitButton;
    @FindBy(css = "#firstname")
    public WebElement inputFirstName;
    @FindBy(css = "#lastname")
    public WebElement inputLastName;
    @FindBy(css = "#address1")
    public WebElement inputAddress;
    @FindBy(css = "#city")
    public WebElement inputCity;
    @FindBy(css = "#id_state")
    public WebElement stateDropDown;
    @FindBy(css = "#postcode")
    public WebElement inputPostcode;
    @FindBy(css = "#phone")
    public WebElement inputHomePhone;
    @FindBy(css = "#phone_mobile")
    public WebElement inputMobilePhone;
    @FindBy(css = "#alias")
    public WebElement inputReferenceAddress;
    @FindBy(css = "#submitAddress")
    public WebElement submitAddressButton;
    @FindBy(css = "a[title='Addresses']")
    public WebElement myAddressButton;
    @FindBy(css = "a[title='Add an address']")
    public WebElement addNewAdressButton;
    @FindBy(css = "a[title='Update']")
    public WebElement addressUpdateButton1;
    @FindBy(css = ".bloc_adresses.row>div:nth-child(2) a[title='Update']")
    public WebElement adressUpdateButton2;
    @FindBy(css=".bloc_adresses.row>div:nth-child(2) a[title='Delete']")
    public WebElement adressDeleteButton2;
    @FindBy(css = "#block_top_menu>ul>li:nth-child(2)")
    public WebElement dressesButton;
    @FindBy(css = "a[title='Add to cart']")
    public List<WebElement> addCartButton;
    @FindBy(css = ".wishlist>a")
    public List<WebElement> wishListButton;
    @FindBy(css = "a[title='Close']")
    public WebElement wishListCloseButton;
    @FindBy(css = "ul[class='product_list grid row']>li")
    public List<WebElement> dressList;
    @FindBy(css = "a[title='View my customer account']")
    public WebElement customerAccountButton;
    @FindBy(css = "a[title='My wishlists']")
    public WebElement myWishListButton;
    @FindBy(css = ".bold.align_center")
    public WebElement dressQuantity;
    @FindBy(css = "tr[id*='wishlist']>td:nth-child(5)>a")
    public WebElement viewHiddenList;
    @FindBy(css = ".row>li")
    public List<WebElement> wishListDresses;
    @FindBy(css = ".row .lnkdel")
    public WebElement removefromWishList;
    @FindBy(css = "tr[id*='wishlist']>td:last-child>a")
    public WebElement deleteWishList;
}
