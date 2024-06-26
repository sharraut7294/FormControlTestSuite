import com.microsoft.playwright.*;
import org.testng.annotations.*;
import pages.FormPlayGroundPage;
import testdata.*;
import org.testng.Assert;
import java.util.Hashtable;
import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class FormControlTests {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @BeforeSuite
    void launchBrowser(){

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
    }

    @AfterSuite
    void closeBrowser(){
        playwright.close();
    }

    @BeforeTest
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://play1.automationcamp.ir/forms.html");
    }

    @AfterTest
    void closeContext() {
        page.close();
        context.close();
    }

    @Test()
    public void validateBasicFormControls(){

        FormPlayGroundPage formPage = new FormPlayGroundPage(page);

        //Validating years of automation experience
        assertThat(formPage.getYearsOfExperienceInput()).hasAttribute("placeholder", "years of automation experience");
        formPage.enterYearsOfExperience("8");
        formPage.validateElementVisibilityAndText(formPage.getYearsOfExperienceValue(),"8");

        //Validating languages and tools
        assertThat(formPage.getJavaCheckBox()).isDisabled();
        formPage.checkLanguage("python,javascript");
        formPage.validateElementVisibilityAndText(formPage.getCheckLanguageValidationText(),"PYTHON JAVASCRIPT");

        formPage.unCheckLanguage("python");
        formPage.validateElementVisibilityAndText(formPage.getCheckLanguageValidationText(),"JAVASCRIPT");

        formPage.selectFrameworkRadio("selenium");
        formPage.validateElementVisibilityAndText(formPage.getSelectFrameworkValidationText(),"SELENIUM");

        formPage.selectFrameworkRadio("protractor");
        formPage.validateElementVisibilityAndText(formPage.getSelectFrameworkValidationText(),"PROTRACTOR");

        //Select primary Skill
        assertThat(formPage.getPrimarySkillLabel()).hasText("Primary Skill");
        Hashtable<String, String> frameWorkOptions = FormData.frameWorkOptions;
        for (Map.Entry<String, String> entry : frameWorkOptions.entrySet()) {
            formPage.getPrimarySkillDropdown().selectOption(entry.getKey());
            formPage.validateElementVisibilityAndText(formPage.getPrimarySkillValidationText(),entry.getValue());
        }

        //Choose Language
        assertThat(formPage.getChooseLanguageLabel()).hasText("Choose Language");
        assertThat(formPage.getChooseLanguageOptions()).hasAttribute("size","4");
        Hashtable<String, String> languageOptions = FormData.languageOptions;
        for (Map.Entry<String, String> entry : languageOptions.entrySet()) {
            formPage.getChooseLanguageOptions().selectOption(entry.getKey());
            formPage.validateElementVisibilityAndText(formPage.getChooseLanguageValidateText(),entry.getValue());
        }

        //Adding Notes:
        assertThat(formPage.getNotes()).hasAttribute("placeholder", "Notes");
        formPage.typeNotes("Testing form controls");
        formPage.validateElementVisibilityAndText(formPage.getNotesValidate(),"Testing form controls");

        //Checking Mandatory Skill
        assertThat(formPage.getCommonSenseLabel()).hasText("Mandatory Skill (Read-Only textbox)");
        assertThat(formPage.getMandatorySkill()).hasAttribute("placeholder", "Common Sense");
        Assert.assertTrue(formPage.isMandatorySkillReadOnly(),"Mandatory Skill is not read only");

        //Speaks German
        assertThat(formPage.getSpeaksGermanLabel()).hasText("Speaks German?");
        formPage.clickGermanLabel();
        formPage.validateElementVisibilityAndText(formPage.getSpeaksGermanValidate(),"true");

        formPage.clickGermanLabel();
        formPage.validateElementVisibilityAndText(formPage.getSpeaksGermanValidate(),"false");

        //German Fluency level
        assertThat(formPage.getFluencyLabel()).hasText("German Fluency Level");
        formPage.clickFluencyLabel();
        formPage.validateElementVisibilityAndText(formPage.getFluencyValidate(),"3");

        formPage.moveFluencySlider();
        formPage.validateElementVisibilityAndText(formPage.getFluencyValidate(),"2");

        //Upload single cv file
        assertThat(formPage.getUploadCVLabel()).hasText("Upload CV (SINGLE FILE)");
        formPage.uploadCV("JohnDoeCV.pdf");
        formPage.validateElementVisibilityAndText(formPage.getUploadCVValidate(),"JohnDoeCV.pdf");


        //Upload multiple certificates
        assertThat(formPage.getUploadCertificateLabel()).hasText("Upload Certificates (MULTIPLE FILES)");
        formPage.uploadCertificates(new String[] {"JohnDoeCertificate1.pdf", "JohnDoeCertificate2.pdf"});
        formPage.validateElementVisibilityAndText(formPage.getUploadCertificatesValidateValidate(),"JohnDoeCertificate1.pdf JohnDoeCertificate2.pdf");

        //Download file
        assertThat(formPage.getDownloadFileLabel()).hasText("Download File:");
        assertThat(formPage.getDownloadFileLink()).hasText("Click here to Download");
        assertThat(formPage.getDownloadFileLink()).hasAttribute("href","/sample_text.txt");
        Assert.assertEquals(formPage.downloadFile(),"https://play1.automationcamp.ir/sample_text.txt");

        //Current Salary
        assertThat(formPage.getSalaryLabel()).hasText("Current Salary (Disabled TextBox)");
        assertThat(formPage.getSalaryInput()).hasAttribute("placeholder", "You should not provide this");
        Assert.assertTrue(formPage.isSalaryDisabled(),"Salary input is not disabled");

    }

    @Test()
    public void validateFormValidations(){

        //Check form with error validations
        FormPlayGroundPage formPage = new FormPlayGroundPage(page);

        formPage.enterCity("Dublin");
        formPage.enterState("Leinster");
        formPage.clickOnSubmitForm();

        assertThat(formPage.getInvalidCity()).isHidden();
        assertThat(formPage.getInvalidState()).isHidden();
        formPage.validateElementVisibilityAndText(formPage.getInvalidZip(),"Please provide a valid zip.");
        formPage.validateElementVisibilityAndText(formPage.getInvalidTerms(),"You must agree before submitting.");

        formPage.clearCity();
        formPage.clearState();
        formPage.clickOnSubmitForm();

        formPage.validateElementVisibilityAndText(formPage.getInvalidCity(),"Please provide a valid city.");
        formPage.validateElementVisibilityAndText(formPage.getInvalidState(),"Please provide a valid state.");
        formPage.validateElementVisibilityAndText(formPage.getInvalidZip(),"Please provide a valid zip.");
        formPage.validateElementVisibilityAndText(formPage.getInvalidTerms(),"You must agree before submitting.");

    }

    @Test()
    public void validateNonEnglishLabelsAndLocators(){

        //Check non english locators and visible text
        FormPlayGroundPage formPage = new FormPlayGroundPage(page);

        assertThat(formPage.getNonEnglishNameLabel()).hasText("आपले नांव लिहा");
        formPage.enterName("John Doe");
        formPage.validateElementVisibilityAndText(formPage.getNonEnglishNameValidate(),"John Doe");

        formPage.checkNonEnglishLanguage(new String[]{"language1", "language2"});
        formPage.validateElementVisibilityAndText(formPage.getNonEnglishCheckValidate(),"मराठी ગુજરાતી");

        formPage.checkNonEnglishLanguage(new String[]{"language3"});
        formPage.validateElementVisibilityAndText(formPage.getNonEnglishCheckValidate(),"मराठी ગુજરાતી ਪੰਜਾਬੀ");

        formPage.unCheckNonEnglishLanguage(new String[]{"language1", "language2"});
        formPage.validateElementVisibilityAndText(formPage.getNonEnglishCheckValidate(),"ਪੰਜਾਬੀ");
    }


}
