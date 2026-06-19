# SwagLabs-Automation-Selenium-Java

End-to-end test automation framework built using Java, Selenium WebDriver, and Maven.

This project automates core functionalities of the Swag Labs demo application including:

* Login functionality
* Product cart operations
* Checkout workflows
* Form validations
* Error handling scenarios
* Reusable automation utilities

---

# Tech Stack

* Java
* Selenium WebDriver
* Maven
* Eclipse IDE
* Git & GitHub

---

# Project Structure

```bash
src
 ├── practice
 │     └── MethodPractice.java
 │
 ├── testcases
 │     ├── TC01_Verify_Login_Functionality.java
 │     ├── TC02_Verify_Product_Cart_Operations.java
 │     ├── TC03_Verify_End_To_End_Checkout_Process.java
 │     ├── TC04_Verify_Checkout_Error_For_Missing_First_Name.java
 │     ├── TC05_Verify_Checkout_Error_For_Missing_Last_Name.java
 │     ├── TC06_Verify_Checkout_Field_Validations.java
 │     └── TC07_Verify_Products_Present_In_Cart.java
 │
 └── utilities
       └── ReusableMethods.java
```

---

# Automated Test Scenarios

## Login Validation

* Valid login
* Invalid login
* Empty credentials validation

## Product Cart Operations

* Add single product to cart
* Add multiple products to cart
* Remove products from cart
* Verify cart badge count
* Verify products added correctly

## Checkout Process

* Complete end-to-end checkout flow
* Verify checkout overview page
* Verify successful order completion

## Form Validations

* Missing first name validation
* Missing last name validation
* Empty checkout field validation

## Dynamic Product Verification

* Verify product exists in cart
* Verify unavailable product validation

---

# Reusable Utilities

`ReusableMethods.java` contains reusable automation methods for:

* Login
* Add product to cart
* Open cart
* Checkout
* Complete order
* Product verification
* Cart count verification
* Checkout validation handling

---

# How To Run The Project

## Clone Repository

```bash
git clone https://github.com/divyaa003/SwagLabs-Automation-Selenium-Java.git
```

## Open In Eclipse

* Import as Existing Maven Project
* Wait for Maven dependencies to download

## Run Testcases

Run any testcase file from:

```bash
src/testcases
```

Example:

```bash
TC07_Verify_Products_Present_In_Cart.java
```

---

# Application Under Test

Swag Labs Demo Application:

https://www.saucedemo.com/

---

# Future Enhancements

* TestNG integration
* Page Object Model (POM)
* Explicit waits
* Screenshot capture
* Reporting framework
* Data-driven testing
* Cross-browser testing

---

# Author

Divya R
