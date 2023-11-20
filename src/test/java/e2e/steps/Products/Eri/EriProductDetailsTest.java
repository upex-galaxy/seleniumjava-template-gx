package e2e.steps.Products.Eri;

//import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import e2e.fixtures.*;
import e2e.pages.Eri.*;
import e2e.utils.*;
import io.qameta.allure.*;

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
	public void testProductWithoutAddingI() throws InterruptedException {

		productDetailsPage = new ProductDetailsPage(web, get, Do);

		// Verificar el titulo del producto de la lista

		WebElement textTitle = get.Selector(".inventory_item_name");
		String productTitle = textTitle.getText();
		then.shouldContain(productTitle, "Sauce Labs Backpack");
		System.out.println("Product title List: " + productTitle);

		// Clic en la imagen del primer producto de la lista

		WebElement goToProductDetailsImage = get.Selector(".inventory_item_img");
		goToProductDetailsImage.click();

		// Verificar el titulo del detalle del producto
		WebElement getProductName = get.Selector(".inventory_details_name");
		String productName = getProductName.getText();
		then.shouldContain(productName, "Sauce Labs Backpack");
		System.out.println("Product title Details: " + productName);

		// Código para verificar la descripcion del producto
		WebElement getProductDescription = get.Selector(".inventory_details_desc");
		String productDesc = getProductDescription.getText();
		then.shouldContain(productDesc, "carry.allTheThings()");
		System.out.println("Product Desc Details: " + productDesc);

		// Código para verificar la imagen del producto
		WebElement getProductImagen = get.Selector(".inventory_details_img");
		Boolean isVisible = getProductImagen.isDisplayed();
		if (isVisible) {
			System.out.println("¿Se encontro la imagen correcta?" + isVisible);
		}
		Assertions.assertTrue(isVisible);

		// Código para verificar el precio del producto
		WebElement getProductPrice = get.Selector(".inventory_details_price");
		String productPrice = getProductPrice.getText();
		then.shouldContain(productPrice, "$29.99");
		System.out.println("Product Price: " + productPrice);

		// Código para agregar el producto
		WebElement selectAddToCardButton = get.Selector("[data-test=\"add-to-cart-sauce-labs-backpack\"]");
		selectAddToCardButton.click();
		WebElement goToYourCart = get.Selector(".shopping_cart_badge");
		String yourCard = goToYourCart.getText();
		then.shouldBeEqual(yourCard, "1");
		System.out.println(yourCard);

		// Código para volver a la lista de productos
		WebElement goBackToProducts = get.Selector("[data-test=\"back-to-products\"]");
		goBackToProducts.click();
		WebElement ProductList = get.Selector(".title");
		String textProductsList = ProductList.getText();
		then.shouldBeEqual(textProductsList, "Products");
		System.out.println(textProductsList);
	}

	@Test
	@DisplayName("TC2: Validar poder seleccionar un producto sin añadir al carrito desde el titulo")
	public void testProductWithoutAddingT() throws InterruptedException {
		productDetailsPage = new ProductDetailsPage(web, get, Do);
		// Verificar el titulo del producto de la lista

		WebElement textTitle = get.Selector(".inventory_item_name");
		String productTitle = textTitle.getText();
		then.shouldContain(productTitle, "Sauce Labs Backpack");
		System.out.println("Product title List: " + productTitle);

		// Clic en el titulo del primer producto de la lista

		WebElement goToProductDetailsTitle = get.Selector(".inventory_item_name");
		goToProductDetailsTitle.click();

		// Verificar el titulo del detalle del producto
		WebElement getProductName = get.Selector(".inventory_details_name");
		String productName = getProductName.getText();
		then.shouldContain(productName, "Sauce Labs Backpack");
		System.out.println("Product title Details: " + productName);

		// Código para verificar la descripcion del producto
		WebElement getProductDescription = get.Selector(".inventory_details_desc");
		String productDesc = getProductDescription.getText();
		then.shouldContain(productDesc, "carry.allTheThings()");
		System.out.println("Product Desc Details: " + productDesc);

		// Código para verificar la imagen del producto
		WebElement getProductImagen = get.Selector(".inventory_details_img");
		Assertions.assertTrue(getProductImagen.isDisplayed());

		// Código para verificar el precio del producto
		WebElement getProductPrice = get.Selector(".inventory_details_price");
		String productPrice = getProductPrice.getText();
		then.shouldContain(productPrice, "$29.99");
		System.out.println("Product Price: " + productPrice);

		// Código para agregar el producto
		WebElement selectAddToCardButton = get.Selector("[data-test=\"add-to-cart-sauce-labs-backpack\"]");
		selectAddToCardButton.click();
		WebElement goToYourCart = get.Selector(".shopping_cart_badge");
		String yourCard = goToYourCart.getText();
		then.shouldBeEqual(yourCard, "1");
		System.out.println(yourCard);

		// Código para volver a la lista de productos
		WebElement goBackToProducts = get.Selector("[data-test=\"back-to-products\"]");
		goBackToProducts.click();
		WebElement ProductList = get.Selector(".title");
		String textProductsList = ProductList.getText();
		then.shouldBeEqual(textProductsList, "Products");
		System.out.println(textProductsList);
	}

	@Test
	@DisplayName("TC3: Validar poder eliminar un producto añadido al carrito.")
	public void removeProductAddedToCart() throws InterruptedException {
		productDetailsPage = new ProductDetailsPage(web, get, Do);
		// precondition: Clic en la imagen del primer producto de la lista

		WebElement goToProductDetailsImage = get.Selector(".inventory_item_img");
		goToProductDetailsImage.click();

		// precondition: Código para agregar el producto
		WebElement selectAddToCardButton = get.Selector("[data-test=\"add-to-cart-sauce-labs-backpack\"]");
		selectAddToCardButton.click();

		// Ir al Carrito
		WebElement goToYourCart = get.Selector(".shopping_cart_badge");
		goToYourCart.click();
		WebElement yourCart = get.Selector(".title");
		String textYourCart = yourCart.getText();
		then.shouldBeEqual(textYourCart, "Your Cart");
		System.out.println(textYourCart);

		// Código para remover el producto
		WebElement selectRemoveButton = get.Selector("[data-test=\"remove-sauce-labs-backpack\"]");
		selectRemoveButton.click();
		WebElement removedProduct = get.Selector(".cart_quantity_label");
		String TextRemovedProduct = removedProduct.getText();
		then.shouldBeEqual(TextRemovedProduct, "QTY");
		System.out.println(TextRemovedProduct);
	}
}