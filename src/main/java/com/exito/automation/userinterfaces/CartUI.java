package com.exito.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartUI {

    public static final Target LBL_CART_PRODUCT_NAME = Target.the("Product label in cart")
            .locatedBy("//span[@data-molecule-product-detail-name-span]");

    public static final Target LBL_CART_PRODUCT_PRICE = Target.the("Product price label in cart")
            .locatedBy("//span[@class='exito-checkout-io-0-x-currencyContainer']");

    public static final Target LBL_CART_QUANTITY = Target.the("Product quantity label in cart")
            .locatedBy("//span[@data-molecule-quantity-und-value]");

    public static final Target PRODUCTS_TABLE = Target.the("Products table in cart")
            .locatedBy("(//tr[@class='product-item'])[1]");
}
