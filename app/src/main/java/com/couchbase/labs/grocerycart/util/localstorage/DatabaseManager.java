package com.couchbase.labs.grocerycart.util.localstorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.couchbase.lite.CouchbaseLite;
import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.DatabaseChange;
import com.couchbase.lite.DatabaseChangeListener;
import com.couchbase.lite.DatabaseConfiguration;
import com.couchbase.lite.Document;
import com.couchbase.lite.ListenerToken;
import com.couchbase.lite.MutableDocument;

import java.util.Map;

public class DatabaseManager {
    private static Database database;
    private static DatabaseManager instance = null;
    private ListenerToken listenerToken;
//    public  String currentUser = null;
    private static String dbName = "grocerycart";

    public static final String KEY_HASH = "hash";
    public static final String RECIPE_SLIDER = "recipeSlider";
    public static final String KEY_USER = "User";
    public static final String KEY_USER_ADDRESS = "user_address";
    public static final String KEY_PREFERENCES = "preferences";
    public static final String USER_PREFERENCES = "user_preferences";
    public static final String USER_NAME = "user_name";
    public static final String USER_EMAIL = "user_email";
    public static final String SLIDER_IMAGE = "slider_image";
    public static final String ADVERTISE_IMAGE = "advertise_image";
    public static final String CATEGORY = "category";
    public static final String FAVORITE_CATEGORY = "fav_category";

    private static final String IS_USER_LOGIN = "IsUserLoggedIn";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    Context _context;

    protected DatabaseManager() {

    }

    public DatabaseManager(Context context) {
        sharedPreferences = context.getSharedPreferences("Preferences", 0);
    }

    public static DatabaseManager getSharedInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }

        return instance;
    }

    public static Database getDatabase() {
        return database;
    }

    // tag::initCouchbaseLite[]
    public void initCouchbaseLite(Context context) {

        CouchbaseLite.init(context);
    }
    // end::initCouchbaseLite[]

    // tag::userProfileDocId[]
//    public String getCurrentUserDocId() {
//        return "user::" + currentUser;
//    }
    // end::userProfileDocId[]

    // tag::openOrCreateDatabase[]
    public void openOrCreateDatabase(Context context)
    // end::openOrCreateDatabase[]
    {
        // tag::databaseConfiguration[]
        DatabaseConfiguration config = new DatabaseConfiguration();
        config.setDirectory(context.getFilesDir().getAbsolutePath());
        // end::databaseConfiguration[]

        try {
            // tag::createDatabase[]
            database = new Database(dbName, config);
            // end::createDatabase[]
            registerForDatabaseChanges();
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }
    }

    // tag::registerForDatabaseChanges[]
    private void registerForDatabaseChanges()
    // end::registerForDatabaseChanges[]
    {
        // tag::addDatabaseChangelistener[]
        // Add database change listener
        listenerToken = database.addChangeListener(new DatabaseChangeListener() {
            @Override
            public void changed(final DatabaseChange change) {
                if (change != null) {
                    for(String docId : change.getDocumentIDs()) {
                        Document doc = database.getDocument(docId);
                        if (doc != null) {
                            Log.i("DatabaseChangeEvent", "Document was added/updated");
                        }
                        else {

                            Log.i("DatabaseChangeEvent","Document was deleted");
                        }
                    }
                }
            }
        });
        // end::addDatabaseChangelistener[]
    }

    // tag::closeDatabaseForUser[]
    public void closeDatabaseForUser()
    // end::closeDatabaseForUser[]
    {
        try {
            if (database != null) {
                deregisterForDatabaseChanges();
                // tag::closeDatabase[]
                database.close();
                // end::closeDatabase[]
                database = null;
            }
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }
    }

    // tag::deregisterForDatabaseChanges[]
    private void deregisterForDatabaseChanges()
    // end::deregisterForDatabaseChanges[]
    {
        if (listenerToken != null) {
            // tag::removedbchangelistener[]
            database.removeChangeListener(listenerToken);
            // end::removedbchangelistener[]
        }
    }

    public void saveOrder(Map<String,Object> order,String orders)
    // end::saveProfile[]
    {
        Database database = DatabaseManager.getDatabase();

//        String docId = DatabaseManager.getSharedInstance().getCurrentUserDocId();
        String docId = orders + "::" + (String) order.get("id");

        // tag::docset[]
        MutableDocument mutableDocument = new MutableDocument(docId, order);
        // end::docset[]

        try {
            // tag::docsave[]
            database.save(mutableDocument);
            // end::docsave[]
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }

    }

    public String getUserLogin() {
        return sharedPreferences.getString(KEY_USER, "");
    }

    public void createUserLoginSession(String user) {
        editor = sharedPreferences.edit();
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(KEY_USER, user);
        editor.commit();
    }

    public void logoutUser() {
        editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public boolean checkLogin() {
        // Check login status
        return !this.isUserLoggedIn();
    }


    public boolean isUserLoggedIn() {
        return sharedPreferences.getBoolean(IS_USER_LOGIN, false);
    }

    public String getUserAddress() {
        if (sharedPreferences.contains(KEY_USER_ADDRESS))
            return sharedPreferences.getString(KEY_USER_ADDRESS, null);
        else return null;
    }


    public void setUserAddress(String user_address) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_ADDRESS, user_address);
        editor.commit();
    }

    public String getCart() {
        if (sharedPreferences.contains("CART"))
            return sharedPreferences.getString("CART", null);
        else return null;
    }


    public void setCart(String cart) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("CART", cart);
        editor.commit();
    }

    public void deleteCart() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("CART");
        editor.commit();
    }


    public String getOrder() {
        if (sharedPreferences.contains("ORDER"))
            return sharedPreferences.getString("ORDER", null);
        else return null;
    }


    public void setOrder(String order) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ORDER", order);
        editor.commit();
    }

    public void deleteOrder() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("ORDER");
        editor.commit();
    }
}
