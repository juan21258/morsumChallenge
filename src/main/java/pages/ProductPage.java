package pages;

import java.util.ArrayList;
import java.util.List;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class ProductPage {
	private Page page;
	
	public ProductPage(Page page) {
        this.page = page;
        setupElements();
    }
	
	ElementHandle product;
	ElementHandle sortIcon;
	ElementHandle priceH2L;
	ElementHandle cartIcon;
	
	 private void setupElements() {
		 sortIcon = page.querySelector("select.product_sort_container");
		 cartIcon = page.querySelector("#shopping_cart_container > a");
	 }
	
	 public void clickSortByPriceHighToLow() {
		 sortIcon.selectOption("hilo");
	 }
	 
	 public String addProduct() {
		 product = page.querySelector("#add-to-cart-sauce-labs-bike-light");
		 product.click();
		 return page.querySelector("div.inventory_item_name:has-text('Sauce Labs Bike Light')").innerText();
	 }
	 
	 public void goToCart() {
		 cartIcon.click();
	 }
	 
	 public List<String> selectFirst3Products() {
		 List<String>productNames = new ArrayList<>();
		 List<ElementHandle> addToCartButtons = page.querySelectorAll("button.btn_inventory");
		 List<ElementHandle> allProductNames = page.querySelectorAll("a > div.inventory_item_name");
		 for (int i = 0; i < 3;i++) {
			 productNames.add(allProductNames.get(i).innerText());
		    addToCartButtons.get(i).click();
		}
		return productNames;
	 }
}
