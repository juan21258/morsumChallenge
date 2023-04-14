This is a test suite for the user order functionality on the website. It uses Playwright and TestNG for automation.

Prerequisites
Java JDK 1.8 or later
Eclipse IDE with TestNG plugin installed
Playwright Java library
Getting Started
Clone the repository
Open the project in Eclipse
Run the tests as TestNG tests
Tests
Add Product to Cart from PDP
This test verifies that a user can add a product to the cart from the Product Detail Page (PDP).
It performs the following steps:

Logs in using the given credentials
Sorts the products by price high to low
Adds a product to the cart
Navigates to the cart page
Asserts that the product in the cart is the selected product
Add Product to Cart from Index
This test verifies that a user can add products to the cart from the home page index.
It performs the following steps:

Logs in using the given credentials
Sorts the products by price high to low
Selects the first three products and adds them to the cart
Navigates to the cart page
Asserts that the first three products in the cart are the selected products
Constants
The constants.TestData class contains the base URL and login credentials used by the tests.

Pages
The pages package contains the Page Object Model (POM) classes for the login, product, and cart pages.

Running the Tests
Navigate to UserOrderTests.java
Right-click and select "Run As" > "TestNG Test"
Dependencies
Playwright Java library
TestNG
License
This project is licensed under the MIT License - see the LICENSE.md file for details.