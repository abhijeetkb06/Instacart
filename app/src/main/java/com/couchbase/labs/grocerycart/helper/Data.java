package com.couchbase.labs.grocerycart.helper;

import com.couchbase.labs.grocerycart.model.Category;
import com.couchbase.labs.grocerycart.model.Offer;
import com.couchbase.labs.grocerycart.model.Product;

import java.util.ArrayList;
import java.util.List;


public class Data {
    List<Category> categoryList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    List<Product> newList = new ArrayList<>();
    List<Product> popularList = new ArrayList<>();
    List<Offer> offerList = new ArrayList<>();

    public List<Category> getCategoryList() {
        Category category = new Category("1", "Food", "https://image.flaticon.com/icons/png/512/262/262344.png");
        categoryList.add(category);
        category = new Category("2", "Home & Cleaning", "https://lisasnatural.com/wp-content/uploads/2018/05/housecleanicon-300x228.jpg");
        categoryList.add(category);
        category = new Category("3", "Baby Care", "https://tips4tots.files.wordpress.com/2015/08/medical-insurance-free-icon.png");
        categoryList.add(category);
        category = new Category("4", "sports & Nutrition", "https://kathleenhalme.com/images/nutrition-clipart-sport.jpg");
        categoryList.add(category);
        category = new Category("5", "Pet care", "http://kasperstromman.files.wordpress.com/2013/05/dog-cat-above-board.jpg");
        categoryList.add(category);
        category = new Category("6", "Health & Household", "https://thumbs.dreamstime.com/b/household-cleaning-products-accessories-basket-there-mop-detergents-rubber-gloves-glass-cleaner-sponges-89944820.jpg");
        categoryList.add(category);
        return categoryList;
    }

    public List<Product> getProductList() {
        Product product = new Product("1", "1", "Apple", "", "1 lb", "$", "20", "10% OFF", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        productList.add(product);
        product = new Product("2", "1", "Banana", "", "1 Bunch", "$", "10", "20% OFF", "https://images-na.ssl-images-amazon.com/images/I/21DejQuoT2L.jpg");
        productList.add(product);
        product = new Product("3", "2", "House Clean Liquid", "", "1 Gal", "$", "25", "", "https://www.clean-hoouse.com/wp-content/uploads/2017/09/13.png");
        productList.add(product);
        product = new Product("5", "3", "Pampers", "", "1 Piece", "$", "20", "10% OFF", "https://cdn.bmstores.co.uk/images/hpcProductImage/imgFull/311448-Pampers-Baby-Dry-Size-4-Maxi-251.jpg");
        productList.add(product);
        product = new Product("7", "4", "Apple", "", "1 lb", "$", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        productList.add(product);
        product = new Product("13", "1", "Litche", "", "1 lb", "$", "20", "30%OFF", "https://cdn.shopify.com/s/files/1/0665/4989/products/lichee-485x400_grande.jpg");
        productList.add(product);
        return productList;
    }

    public List<Product> getNewList() {
        Product product = new Product("1", "1", "Apple", "", "1 lb", "$", "20", "10% OFF", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        newList.add(product);
        product = new Product("2", "1", "Banana", "", "1 Bunch", "$", "10", "20% OFF", "https://images-na.ssl-images-amazon.com/images/I/21DejQuoT2L.jpg");
        newList.add(product);
        product = new Product("3", "2", "House Clean Liquid", "", "1 Lit.", "$", "25", "", "https://www.clean-hoouse.com/wp-content/uploads/2017/09/13.png");
        newList.add(product);
        product = new Product("5", "3", "Pampers", "", "1 Piece", "20", "$", "10% OFF", "https://cdn.bmstores.co.uk/images/hpcProductImage/imgFull/311448-Pampers-Baby-Dry-Size-4-Maxi-251.jpg");
        newList.add(product);
        return newList;
    }

    public List<Product> getPopularList() {
        Product product = new Product("1", "1", "Apple", "", "1 lb", "$", "20", "10% OFF", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        newList.add(product);
        product = new Product("2", "1", "Banana", "", "1 Bunch", "$", "10", "20% OFF", "https://images-na.ssl-images-amazon.com/images/I/21DejQuoT2L.jpg");
        newList.add(product);
        product = new Product("3", "2", "House Clean Liquid", "", "1 Lit.", "$", "25", "", "https://www.clean-hoouse.com/wp-content/uploads/2017/09/13.png");
        newList.add(product);
        product = new Product("5", "3", "Pampers", "", "1 Piece", "20", "$", "10% OFF", "https://cdn.bmstores.co.uk/images/hpcProductImage/imgFull/311448-Pampers-Baby-Dry-Size-4-Maxi-251.jpg");
        newList.add(product);
        return newList;
    }

    public List<Offer> getOfferList() {
        Offer offer = new Offer("https://img.freepik.com/free-vector/shopping-bags-supermarket-basket-box-with-grocery_107791-4494.jpg?w=2000&t=st=1660411332~exp=1660411932~hmac=3265181eb4bd9354f9b8e746f85ea645af34a2d21c17626932b14bf9ce54d6d5");
        offerList.add(offer);
        offer = new Offer("https://img.freepik.com/premium-vector/gradient-colorful-sale-wallpaper_52683-56971.jpg?w=2000");
        offerList.add(offer);
        offer = new Offer("https://img.freepik.com/premium-psd/flash-sale-shopping-poster-banner-with-flash-icon-3d-text_471402-421.jpg?w=1480");
        offerList.add(offer);
        offer = new Offer("https://img.freepik.com/premium-vector/banner-with-percentage-symbol-with-tag-it-place-text_348082-348.jpg?w=2000");
        offerList.add(offer);
        offer = new Offer("https://as1.ftcdn.net/v2/jpg/03/77/53/42/1000_F_377534276_B5a9nm2pFZ5ON5xkHZnourDZo7p4xk6z.jpg");
        offerList.add(offer);
        return offerList;
    }
}
