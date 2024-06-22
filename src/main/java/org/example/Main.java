package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
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
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://play1.automationcamp.ir/forms.html");

            assertThat(page.getByRole(AriaRole.HEADING,
                    new Page.GetByRoleOptions().setName("Basic Form Controls"))).isVisible();

            //Adding years of experience
            Locator yearsOfExperienceInput = page.locator("id=exp");
            assertThat(yearsOfExperienceInput).hasAttribute("placeholder", "years of automation experience");
            yearsOfExperienceInput.type("7");
            Locator yearsOfExperienceValue = page.locator("id=exp_help");
            assertThat(yearsOfExperienceValue).hasText("7");

            //selecting languages
            assertThat(page.locator(".form-check-input[id='check_java']")).isDisabled();
            Locator pythonCheckBox = page.locator(".form-check-input[id='check_python']");
            Locator javaScriptCheckBox = page.locator(".form-check-input[id='check_javascript']");
            // check if label check needs to be added
            pythonCheckBox.check();
            javaScriptCheckBox.check();

            assertThat(page.locator("[id='check_validate'].form-text")).hasText("PYTHON JAVASCRIPT");

            pythonCheckBox.uncheck();
            assertThat(page.locator("[id='check_validate'].form-text")).hasText("JAVASCRIPT");

            Locator seleniumRadioButton = page.locator("[type='radio'][id='rad_selenium']");
            Locator protractorRadioButton = page.locator("[type='radio'][id='rad_protractor']");

            seleniumRadioButton.click();
            assertThat(page.locator("#rad_validate.form-text")).hasText("SELENIUM");

            protractorRadioButton.click();
            assertThat(page.locator("#rad_validate.form-text")).hasText("PROTRACTOR");

            //Select primary Skill
            Locator primarySkillDropdown = page.locator("select#select_tool");

            //add a loop in page object
            primarySkillDropdown.selectOption("Selenium");
            assertThat(page.locator("#select_tool_validate.form-text")).hasText("sel");
            primarySkillDropdown.selectOption("Protractor");
            assertThat(page.locator("#select_tool_validate.form-text")).hasText("pro");
            primarySkillDropdown.selectOption("Cypress");
            assertThat(page.locator("#select_tool_validate.form-text")).hasText("cyp");

            //Choose Language

            Locator languageOptions = page.locator("select#select_lang");
            assertThat(languageOptions).hasAttribute("size","4");

            //Add loop and key value pair
            languageOptions.selectOption("Java");
            assertThat(page.locator("#select_lang_validate.form-text")).hasText("java");
            languageOptions.selectOption("Python");
            assertThat(page.locator("#select_lang_validate.form-text")).hasText("python");
            languageOptions.selectOption("JavaScript");
            assertThat(page.locator("#select_lang_validate.form-text")).hasText("javascript");
            languageOptions.selectOption("TypeScript");
            assertThat(page.locator("#select_lang_validate.form-text")).hasText("typescript");


            //Adding Notes:
            Locator notes = page.locator(".form-control#notes");
            assertThat(notes).hasAttribute("placeholder", "Notes");
            notes.type("Testing form controls");
            assertThat(page.locator("#area_notes_validate")).hasText("Testing form controls");

            //Checking Mandatory Skill
            assertThat(page.locator("[for='common_sense']")).hasText("Mandatory Skill (Read-Only textbox)");
            Locator mandatorySkill = page.locator("input#common_sense");
            assertThat(mandatorySkill).hasAttribute("placeholder", "Common Sense");
            boolean isReadOnly = (Boolean) page.evalOnSelector("input#common_sense", "el => el.hasAttribute('readonly')");
            Assert.assertTrue(isReadOnly,"Mandatory Skill is not read only");


            //Speaks German
            Locator speaksGerman = page.locator(".custom-control-label[for='german']");
            assertThat(speaksGerman).hasText("Speaks German?");
            speaksGerman.click();
            assertThat(page.locator("#german_validate")).hasText("true");
            speaksGerman.click();
            assertThat(page.locator("#german_validate")).hasText("false");

            //German Fluency level
            Locator fluencyLabel = page.locator("label[for='fluency']");
            assertThat(fluencyLabel).hasText("German Fluency Level");
            fluencyLabel.click();
            Locator fluencyValidate = page.locator("#fluency_validate");
            assertThat(fluencyValidate).hasText("3");

            //Check if location coordinates will work ofr different values
            Locator fluencySlider = page.locator(".custom-range#fluency");
            fluencySlider.click();
            assertThat(fluencyValidate).hasText("2");

            //Upload single cv file
            assertThat(page.locator("label[for='upload_cv']")).hasText("Upload CV (SINGLE FILE)");
            Locator chooseSingleFile = page.locator("[type='file']#upload_cv");

            String relativePath = "src/main/java/org/example/Sharvari_RautCV.pdf";
            chooseSingleFile.setInputFiles(Paths.get(relativePath));
            assertThat(page.locator("#validate_cv")).hasText("Sharvari_RautCV.pdf");

            //Upload multiple certificates
            assertThat(page.locator("label[for='upload_files']")).hasText("Upload Certificates (MULTIPLE FILES)");
            Locator chooseMultipleFiles = page.locator("[type='file']#upload_files");

            String relativeCertificatePath = "src/main/java/org/example/Certificate.pdf";
            chooseMultipleFiles.setInputFiles(new Path[] {Paths.get(relativePath), Paths.get(relativeCertificatePath)});
            assertThat(page.locator("#validate_files")).hasText("Sharvari_RautCV.pdf Certificate.pdf");

            //Download file
            assertThat(page.locator("label[for='download_file']")).hasText("Download File:");
            Locator downloadFile = page.locator("#download_file");
            assertThat(downloadFile).hasText("Click here to Download");
            assertThat(downloadFile).hasAttribute("href","/sample_text.txt");

            Download download = page.waitForDownload(downloadFile::click);
            String relativeDownloadPath = "src/main/java/org/";
            download.saveAs(Paths.get(relativeDownloadPath, download.suggestedFilename()));
            String downloadUrl = download.url();
            Assert.assertEquals(downloadUrl,"https://play1.automationcamp.ir/sample_text.txt");


            //Current Salary
            assertThat(page.locator("label[for='salary']")).hasText("Current Salary (Disabled TextBox)");
            Locator salary = page.locator("#salary");
            assertThat(salary).hasAttribute("placeholder", "You should not provide this");

            boolean isDisabled = (Boolean) page.evalOnSelector("#salary", "el => el.hasAttribute('disabled')");
            Assert.assertTrue(isDisabled,"Salary input is not disabled");

            System.out.println("Form controls validated successfully");
        }
        }
    }
