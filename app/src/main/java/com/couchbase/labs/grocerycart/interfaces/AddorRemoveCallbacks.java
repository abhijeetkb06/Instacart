package com.couchbase.labs.grocerycart.interfaces;




public interface AddorRemoveCallbacks {

    void onAddProduct();

    void onRemoveProduct();

    void updateTotalPrice();
}