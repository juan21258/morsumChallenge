package pages;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class CartPage {
	private Page page;
	
	public CartPage(Page page) {
        this.page = page;
        setupElements();
    }
	
	ElementHandle cartIcon;
	List<ElementHandle> productsInCart;
	 private void setupElements() {
		 cartIcon = page.querySelector("#shopping_cart_container > a");
		 productsInCart = page.querySelectorAll("div.cart_item > div.cart_item_label > a >div");
	 }
	
	 public String getItemName() {
		return productsInCart.get(0).innerText();
	 }
	 
	 public List<String> getFirst3ProductsInCart() {
		 List<String>productNames = new ArrayList<>();
		 for (int i = 0; i < 3;i++) {
			 productNames.add(productsInCart.get(i).innerText());
		}
		return productNames;
	 }
	 
}
