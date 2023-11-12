package e2e.steps.Products.Eri;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import e2e.fixtures.Eri.TestBase;
import e2e.pages.Eri.ProductDetailsPage;
import e2e.pages.Eri.LoginPage;
import e2e.utils.*;
import io.qameta.allure.Allure;

//* Tech Debt: GX3-248 =https://upexgalaxy26.atlassian.net/browse/GX3-248 */
public class EriProductDetailsTest extends TestBase {
        ProductDetailsPage productDetailsPage;
        Assertion assertion;

        // el usuario esta LOGEADO y situarse en el PLP.
        @BeforeEach
        public void precondition() throws InterruptedException {
                web.get("https://www.saucedemo.com");
                LoginPage loginPage = new LoginPage(web, get, Do);

                Allure.step("Loguearse", (step) -> {
                        loginPage.enterUsername("standard_user");
                        loginPage.enterPassword("secret_sauce");
                        loginPage.submitLogin();
                        then.shouldContain(web.getCurrentUrl(), "inventory.html");
                });
        }

        @Test
        @DisplayName("TC1: Validar poder seleccionar un producto sin añadir al carrito desde la imagen")
        public void testProductWithoutAdding() throws InterruptedException {

                productDetailsPage = new ProductDetailsPage(web, get, Do);

                // Clic en la imagen del primer producto de la lista
                productDetailsPage.goToProductDetailsImage(0);

                // Código para verificar el nombre del producto

                List<WebElement> viewProductTitleElements = productDetailsPage.productTitle.get();
                WebElement viewProductTitleElement = viewProductTitleElements.get(0);
                String productTitle = viewProductTitleElement.getText();
                assertion.shouldContain(productTitle, "Sauce Labs Backpack");
                System.out.println("Product title: " + productTitle);

                // Código para verificar la descripcion del producto
                List<WebElement> viewProductDescriptionElements = productDetailsPage.productDescription.get();
                WebElement viewProductDescriptionElement = viewProductDescriptionElements.get(0);
                String productDesc = viewProductDescriptionElement.getText();
                assertion.shouldContain(productDesc, "carry.allTheThings()");
                System.out.println("Product Desc: " + productDesc);

                // Código para verificar la imagen del producto
                List<WebElement> viewProductImageElements = productDetailsPage.productImage.get();
                WebElement viewProductImageElement = viewProductImageElements.get(0);
                assertion.shouldBeVisible(viewProductImageElement);

                // Código para verificar el precio del producto
                List<WebElement> viewProductPriceElements = productDetailsPage.productPrice.get();
                WebElement viewProductPriceElement = viewProductPriceElements.get(0);
                String productPrice = viewProductPriceElement.getText();
                assertion.shouldContain(productPrice, "$29.99");
                System.out.println("Product Price: " + productPrice);

                // Código para agregar el producto
                productDetailsPage.selectAddToCartButton(0);

                // Código para remover el producto
                productDetailsPage.goBackToProducts();
        }
}
/*
 * @Test
 * 
 * @DisplayName("TC2: Validar poder seleccionar un producto sin añadir al carrito desde el titulo"
 * )
 * public void testProductWithoutAddingTitle() throws InterruptedException {
 * productDetailsPage = new ProductDetailsPage(web, get, Do);
 * 
 * // Clic en la imagen del primer producto de la lista
 * productDetailsPage.selectProductTitle();
 * 
 * // Código para verificar el nombre del producto
 * 
 * WebElement viewProductTitleElement = productDetailsPage.productTitle.get();
 * String productTitle = viewProductTitleElement
 * .getText();
 * assertion.shouldContain(productTitle, "Sauce Labs Backpack");
 * System.out.println("Product title: " + productTitle);
 * 
 * // Código para verificar la descripcion del producto
 * WebElement viewProductDescriptionElement =
 * productDetailsPage.productDescription.get();
 * String productDesc = viewProductDescriptionElement
 * .getText();
 * assertion.shouldContain(productDesc, "carry.allTheThings()");
 * System.out.println("Product Desc: " + productDesc);
 * 
 * // Código para verificar la imagen del producto
 * WebElement viewProductImageElement = productDetailsPage.productImage
 * .get();
 * assertion.shouldBeVisible(viewProductImageElement);
 * 
 * // Código para verificar el precio del producto
 * WebElement viewProductPriceElement = productDetailsPage.productPrice.get();
 * String productPrice = viewProductPriceElement
 * .getText();
 * assertion.shouldContain(productPrice, "$29.99");
 * System.out.println("Product Price: " + productPrice);
 * 
 * // Código para agregar el producto
 * productDetailsPage.selectAddToCartButton();
 * 
 * // Código para remover el producto
 * productDetailsPage.selectBackButton();
 * 
 * }
 * 
 * @Test
 * 
 * @DisplayName("TC3: Validar poder seleccionar un producto añadido al carrito desde la imagen"
 * )
 * public void testProductWithoutAdding() throws InterruptedException {
 * productDetailsPage = new ProductDetailsPage(web, get, Do);
 * 
 * // Clic en la imagen del primer producto de la lista
 * productDetailsPage.selectProductImage();
 * 
 * // Código para verificar el nombre del producto
 * 
 * WebElement viewProductTitleElement = productDetailsPage.productTitle.get();
 * String productTitle = viewProductTitleElement
 * .getText();
 * assertion.shouldContain(productTitle, "Sauce Labs Backpack");
 * System.out.println("Product title: " + productTitle);
 * 
 * // Código para verificar la descripcion del producto
 * WebElement viewProductDescriptionElement =
 * productDetailsPage.productDescription.get();
 * String productDesc = viewProductDescriptionElement
 * .getText();
 * assertion.shouldContain(productDesc, "carry.allTheThings()");
 * System.out.println("Product Desc: " + productDesc);
 * 
 * // Código para verificar la imagen del producto
 * WebElement viewProductImageElement = productDetailsPage.productImage
 * .get();
 * assertion.shouldBeVisible(viewProductImageElement);
 * 
 * // Código para verificar el precio del producto
 * WebElement viewProductPriceElement = productDetailsPage.productPrice.get();
 * String productPrice = viewProductPriceElement
 * .getText();
 * assertion.shouldContain(productPrice, "$29.99");
 * System.out.println("Product Price: " + productPrice);
 * 
 * // Código para agregar el producto
 * productDetailsPage.selectAddToCartButton();
 * 
 * // Código para remover el producto
 * productDetailsPage.selectBackButton();
 * 
 * }
 * 
 * @Test
 * 
 * @DisplayName("TC34: Validar poder seleccionar un producto añadido al carrito desde el titulo"
 * )
 * public void testProductWithoutAdding() throws InterruptedException {
 * productDetailsPage = new ProductDetailsPage(web, get, Do);
 * 
 * // Clic en la imagen del primer producto de la lista
 * productDetailsPage.selectProductImage();
 * 
 * // Código para verificar el nombre del producto
 * 
 * WebElement viewProductTitleElement = productDetailsPage.productTitle.get();
 * String productTitle = viewProductTitleElement
 * .getText();
 * assertion.shouldContain(productTitle, "Sauce Labs Backpack");
 * System.out.println("Product title: " + productTitle);
 * 
 * // Código para verificar la descripcion del producto
 * WebElement viewProductDescriptionElement =
 * productDetailsPage.productDescription.get();
 * String productDesc = viewProductDescriptionElement
 * .getText();
 * assertion.shouldContain(productDesc, "carry.allTheThings()");
 * System.out.println("Product Desc: " + productDesc);
 * 
 * // Código para verificar la imagen del producto
 * WebElement viewProductImageElement = productDetailsPage.productImage
 * .get();
 * assertion.shouldBeVisible(viewProductImageElement);
 * 
 * // Código para verificar el precio del producto
 * WebElement viewProductPriceElement = productDetailsPage.productPrice.get();
 * String productPrice = viewProductPriceElement
 * .getText();
 * assertion.shouldContain(productPrice, "$29.99");
 * System.out.println("Product Price: " + productPrice);
 * 
 * // Código para agregar el producto
 * productDetailsPage.selectAddToCartButton();
 * 
 * // Código para remover el producto
 * productDetailsPage.selectBackButton();
 * 
 * }
 */
