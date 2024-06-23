package testdata;

import java.util.Hashtable;

public class FormData {
    public static Hashtable<String, String> frameWorkOptions = new Hashtable<>();
    public static Hashtable<String, String> languageOptions = new Hashtable<>();


    static {
        //Initialize framework Options
        frameWorkOptions.put("Selenium","sel");
        frameWorkOptions.put("Protractor","pro");
        frameWorkOptions.put("Cypress","cyp");

        //Initialize language options
        languageOptions.put("Java","java");
        languageOptions.put("Python","python");
        languageOptions.put("JavaScript","javascript");
        languageOptions.put("TypeScript","typescript");
    }
}
