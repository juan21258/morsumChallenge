package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class CartPage {
	private Page page;
	
	public CartPage(Page page) {
        this.page = page;
        setupElements();
    }
	
	ElementHandle productName;
	ElementHandle cartIcon;
	
	 private void setupElements() {
		 productName = page.querySelector("div.cart_item > div.cart_item_label > a >div");
		 cartIcon = page.querySelector("#shopping_cart_container > a");
	 }
	
	 public String getItemName() {
        return productName.innerText();
	 }
}
