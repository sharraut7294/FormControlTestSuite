package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
/*import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


@Test
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

            //Test 2
            //Check form with error validations
            page.locator(".btn-primary[type='submit']").click();
            assertThat(page.locator(".invalid-feedback#invalid_city")).hasText("Please provide a valid city.");
            assertThat(page.locator(".invalid-feedback#invalid_state")).hasText("Please provide a valid state.");
            assertThat(page.locator(".invalid-feedback#invalid_zip")).hasText("Please provide a valid zip.");
            assertThat(page.locator(".invalid-feedback#invalid_terms")).hasText("You must agree before submitting.");


            //Test 3
            //Check non english locators and visible text
            assertThat(page.locator("label[for='नाव']")).hasText("आपले नांव लिहा");
            page.locator("input#नाव").type("John Doe");
            assertThat(page.locator("#नाव_तपासा")).hasText("John Doe");
            Locator language1Checkbox = page.locator("input[type='checkbox']#मराठी");
            Locator language2Checkbox = page.locator("input[type='checkbox']#ગુજરાતી");
            Locator language3Checkbox = page.locator("input[type='checkbox']#ਪੰਜਾਬੀ");

            language1Checkbox.check();
            language2Checkbox.check();
            assertThat(page.locator("#check_validate_non_english")).hasText("मराठी ગુજરાતી");

            language3Checkbox.check();
            assertThat(page.locator("#check_validate_non_english")).hasText("मराठी ગુજરાતી ਪੰਜਾਬੀ");

            language1Checkbox.uncheck();
            language2Checkbox.uncheck();
            assertThat(page.locator("#check_validate_non_english")).hasText("ਪੰਜਾਬੀ");

            System.out.println("Form controls validated successfully");
        }
        }
    }
*/