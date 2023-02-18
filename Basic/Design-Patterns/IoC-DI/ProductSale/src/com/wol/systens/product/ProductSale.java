package com.wol.systens.product;

public class ProductSale {
    private Log log;

    public ProductSale(Log logSale) {
        this.log = logSale;
    }
    public void productSale(Product product) {
        log.grava(product);
    }
}
