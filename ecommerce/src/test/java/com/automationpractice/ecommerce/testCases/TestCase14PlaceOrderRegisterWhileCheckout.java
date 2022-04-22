package com.automationpractice.ecommerce.testCases;

import com.automationpractice.ecommerce.pages.TestCase14PlaceOrderRegisterWhileCheckoutPages;
import com.automationpractice.ecommerce.pages.TestCase2LoginUserWithCorrectEmailAndPasswordPage;
import com.automationpractice.ecommerce.utilities.Data;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase14PlaceOrderRegisterWhileCheckout extends BaseClass{

    @Test
    public void testCase14PlaceOrderRegisterWhileCheckoutPages(){

        TestCase14PlaceOrderRegisterWhileCheckoutPages tc14porwcp = new TestCase14PlaceOrderRegisterWhileCheckoutPages(driver);
        TestCase2LoginUserWithCorrectEmailAndPasswordPage tc2luwceapp =new TestCase2LoginUserWithCorrectEmailAndPasswordPage(driver);


//    TC  -  4. Add products to cart
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        if(tc14porwcp.getViewProductButton().isDisplayed()){
            String viewProductButtonText= tc14porwcp.getViewProductButton().getText();
            Assert.assertEquals(Data.VIEW_PRODUCT_BUTTON_TEXT,viewProductButtonText);
            System.out.println( "✔" + viewProductButtonText + "✔" + Data.IS_VISIBLE);
            sleepTest(1000);
            tc14porwcp.getViewProductButton().click();
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

        String firstProductsPageLink = driver.getCurrentUrl();
        System.out.println("Given "+firstProductsPageLink);
        Assert.assertEquals(firstProductsPageLink, Data.FIRST_PRODUCT_PAGE_URL);
        System.out.println("Product Page URL is validate");
        sleepTest(1000);

        tc14porwcp.getQuantityInputField().isDisplayed();
        tc14porwcp.getQuantityInputField().clear();
        tc14porwcp.getQuantityInputField().sendKeys("4");
        sleepTest(1000);

//    TC  -  5. Click 'Cart' button

        tc14porwcp.getAddToCartButton().isDisplayed();
        tc14porwcp.getAddToCartButton().click();
        sleepTest(10000);

        if(tc14porwcp.getViewCartButton().isDisplayed()){
            String viewCartButtonText= tc14porwcp.getViewCartButton().getText();
            Assert.assertEquals(Data.VIEW_CART_BUTTON_TEXT,viewCartButtonText);
            System.out.println( "✔" + viewCartButtonText + "✔" + Data.IS_VISIBLE);
            sleepTest(1000);
            tc14porwcp.getViewCartButton().click();
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

//    TC  -  6. Verify that cart page is displayed

        String viewCartPageLink = driver.getCurrentUrl();
        System.out.println("Given "+viewCartPageLink);
        Assert.assertEquals(viewCartPageLink, Data.VIEW_CART_PAGE_URL);
        System.out.println("Product Page URL is validate");
        sleepTest(1000);

        tc14porwcp.getQuantityField().isDisplayed();
        String quantityNumber = tc14porwcp.getQuantityField().getText();
        System.out.printf(quantityNumber);
        Assert.assertEquals(quantityNumber,"4");
        sleepTest(2000);

//    TC  -  7. Click Proceed To Checkout
        tc14porwcp.getProceedToCheckout().isDisplayed();
        tc14porwcp.getProceedToCheckout().click();
        sleepTest( 1000);


//    TC  -  8. Click 'Register / Login' button
        tc14porwcp.getRegisterLoginButton().isDisplayed();
        tc14porwcp.getRegisterLoginButton().click();
        sleepTest(1000);

//    TC  -  9. Fill all login details and login to the account

        //Url Validation
        String loginURL = driver.getCurrentUrl();
        System.out.println("Given "+loginURL);
        Assert.assertEquals(loginURL , Data.BASE_URL + Data.LOGIN_PAGE_URL);
        System.out.println("login URL is validate");

        if (tc2luwceapp.getLoginToYourAccountText().isDisplayed())
        {
            String loginToYourText= tc2luwceapp.getLoginToYourAccountText().getText();
            System.out.println(loginToYourText + Data.POSITIVE_MASSAGE);
            Assert.assertEquals(Data.LOGIN_TO_YOUR_ACCoUNT_TEXT,loginToYourText);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

       //      Enter correct email address and password

        tc2luwceapp.getEmailAddressInputField().sendKeys(Data.DEMO_EMAIL);
        tc2luwceapp.getPasswordInputField().sendKeys(Data.DEMO_PASSWORD);

        //     Click 'login' button
        tc2luwceapp.getLoginButton().click();

//    TC  -  10. Verify ' Logged in as username' at top

        if (tc2luwceapp.getLoggedInAsUsernameText().isDisplayed())
        {
            String loggedInAsUserText= tc2luwceapp.getLoggedInAsUsernameText().getText();
            System.out.println(loggedInAsUserText + Data.POSITIVE_MASSAGE);
            Assert.assertEquals(Data.LOGGED_IN_AS_USER_TEXT,loggedInAsUserText);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

//    TC  -  11.Click 'Cart' button
      tc14porwcp.getCartButton().isDisplayed();
      tc14porwcp.getCartButton().click();

        String cartPageUrl = driver.getCurrentUrl();
        System.out.println("Given "+cartPageUrl);
        Assert.assertEquals(cartPageUrl , Data.VIEW_CART_PAGE_URL);
        System.out.println("Cart Page URL is validate");

//    TC  -  12. Click 'Proceed To Checkout' button

        tc14porwcp.getProceedToCheckout().isDisplayed();
        tc14porwcp.getProceedToCheckout().click();
        sleepTest( 1000);

//    TC  -  13. Verify Address Details and Review Your Order
//    TC  -  14. Enter description in comment text area and click 'Place Order'
//    TC  -  15. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//    TC  -  16. Click 'Pay and Confirm Order' button
//    TC  -  17. Verify success message 'Your order has been placed successfully!'
//    TC  -  18. Click 'Delete Account' button
//    TC  -  19. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    }
}
