package e2e.steps.Products.Eri;

//import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.fixtures.Eri.TestBase;
import e2e.pages.Eri.ProductDetailsPage;
import e2e.utils.Assertion;
//import e2e.utils.Action;
//import e2e.utils.Locator;

//* Tech Debt: GX3-248 =https://upexgalaxy26.atlassian.net/browse/GX3-248 */
public class EriProductDetailsTest extends TestBase {
        ProductDetailsPage productDetailsPage;
        Assertion assertion;

        // el usuario esta LOGEADO y situarse en el PLP.
        @BeforeEach
        public void precondition() throws InterruptedException {
                web.get("https://www.saucedemo.com");
                productDetailsPage = new ProductDetailsPage(web, get, Do);
                productDetailsPage.enterUsername("standard_user");
                productDetailsPage.enterPassword("secret_sauce");
                productDetailsPage.submitLogin();
                assertion = new Assertion();
                assertion.shouldContain(web.getCurrentUrl(), "inventory.html");
        }

        @Test
        @DisplayName("TC1: Validar poder seleccionar un producto sin añadir al carrito desde la imagen")
        public void testProductWithoutAdding() throws InterruptedException {
                productDetailsPage = new ProductDetailsPage(web, get, Do);

                // Clic en la imagen del primer producto de la lista
                productDetailsPage.selectProductImage();

                // Código para verificar el nombre del producto

                WebElement viewProductTitleElement = productDetailsPage.productTitle.get();
                String productTitle = viewProductTitleElement
                                .getText();
                assertion.shouldContain(productTitle, "Sauce Labs Backpack");
                System.out.println("Product title: " + productTitle);

                // Código para verificar la descripcion del producto
                WebElement viewProductDescriptionElement = productDetailsPage.productDescription.get();
                String productDesc = viewProductDescriptionElement
                                .getText();
                assertion.shouldContain(productDesc, "carry.allTheThings()");
                System.out.println("Product Desc: " + productDesc);

                // Código para verificar la imagen del producto
                WebElement viewProductImageElement = productDetailsPage.productImage
                                .get();
                assertion.shouldBeVisible(viewProductImageElement);

                // Código para verificar el precio del producto
                WebElement viewProductPriceElement = productDetailsPage.productPrice.get();
                String productPrice = viewProductPriceElement
                                .getText();
                assertion.shouldContain(productPrice, "$29.99");
                System.out.println("Product Price: " + productPrice);

                // Código para agregar el producto
                productDetailsPage.selectAddToCartButton();

                // Código para remover el producto
                productDetailsPage.selectBackButton();

        }

}
