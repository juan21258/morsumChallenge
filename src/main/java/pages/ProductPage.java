package pages;

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
        sortIcon.click();
        //page.waitForSelector("select.product_sort_container > option[value='hilo']");
	 }
	 
	 public void addProduct() {
		 product = page.querySelector("#add-to-cart-sauce-labs-bike-light");
		 product.click();
	 }
	 
	 public void goToCart() {
		 cartIcon.click();
	 }
	 
	 public void selectFirst3Products() {
		 List<ElementHandle> addToCartButtons = page.querySelectorAll("button.btn_inventory");
		 for (int i = 0; i < 3;i++) {
		    addToCartButtons.get(i).click();
		}
	 }
	 
	 

}
