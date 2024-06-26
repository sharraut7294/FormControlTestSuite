package pages;
import com.microsoft.playwright.*;
import com.microsoft.playwright.Page;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FormPlayGroundPage {
    private final Page page;
    private final Locator yearsOfExperienceInput;
    private final Locator yearsOfExperienceValue;
    private final Locator javaCheckBox;
    private final Locator pythonCheckBox;
    private final Locator javaScriptCheckBox;
    private final Locator checkLanguageValidate;
    private final Locator seleniumRadioButton;
    private final Locator protractorRadioButton;
    private final Locator selectFrameworkValidate;
    private final Locator primarySkillDropdown;
    private final Locator primarySkillValidate;
    private final Locator primarySkillLabel;
    private final Locator chooseLanguageLabel;
    private final Locator languageOptions;
    private final Locator chooseLanguageValidate;
    private final Locator notes;
    private final Locator notesValidate;
    private final Locator commonSenseLabel;
    private final Locator mandatorySkill;
    private final Locator speaksGermanLabel;
    private final Locator speaksGermanValidate;
    private final Locator fluencyLabel;
    private final Locator fluencyValidate;
    private final Locator fluencySlider;
    private final Locator uploadCVLabel;
    private final Locator chooseSingleFile;
    private final Locator uploadCVValidate;
    private final Locator uploadCertificateLabel;
    private final Locator chooseMultipleFiles;
    private final Locator uploadCertificatesValidate;
    private final Locator downloadFileLabel;
    private final Locator downloadFileLink;
    private final Locator currentSalaryLabel;
    private final Locator currentSalaryInput;
    private final Locator submitFormButton;
    private final Locator invalidCity;
    private final Locator invalidState;
    private final Locator invalidZip;
    private final Locator invalidTerms;
    private final Locator cityInput;
    private final Locator stateInput;
    private final Locator nonEnglishNameLabel;
    private final Locator nonEnglishNameInput;
    private final Locator nonEnglishNameValidate;
    private final Locator  language1Checkbox;
    private final Locator  language2Checkbox;
    private final Locator  language3Checkbox;
    private final Locator nonEnglishCheckValidate;

    Map<String, Consumer<Void>> checkNonEnglishLanguage = new HashMap<>();
    Map<String, Consumer<Void>> unCheckNonEnglishLanguage = new HashMap<>();

    public FormPlayGroundPage(Page page) {
        this.page = page;
        this.yearsOfExperienceInput = page.locator("id=exp");
        this.yearsOfExperienceValue = page.locator("id=exp_help");
        this.javaCheckBox = page.locator(".form-check-input[id='check_java']");
        this.pythonCheckBox = page.locator(".form-check-input[id='check_python']");
        this.javaScriptCheckBox = page.locator(".form-check-input[id='check_javascript']");
        this.checkLanguageValidate = page.locator("[id='check_validate'].form-text");
        this.seleniumRadioButton =  page.locator("[type='radio'][id='rad_selenium']");
        this.protractorRadioButton = page.locator("[type='radio'][id='rad_protractor']");
        this.selectFrameworkValidate = page.locator("#rad_validate.form-text");
        this.primarySkillDropdown = page.locator("select#select_tool");
        this.primarySkillValidate = page.locator("#select_tool_validate.form-text");
        this.primarySkillLabel = page.locator("label[for='select_tool']");
        this.chooseLanguageLabel = page.locator("label[for='select_lang']");
        this.languageOptions = page.locator("select#select_lang");
        this.chooseLanguageValidate = page.locator("#select_lang_validate.form-text");
        this.notes = page.locator(".form-control#notes");
        this.notesValidate = page.locator("#area_notes_validate");
        this.commonSenseLabel = page.locator("[for='common_sense']");
        this.mandatorySkill = page.locator("input#common_sense");
        this.speaksGermanLabel = page.locator(".custom-control-label[for='german']");
        this.speaksGermanValidate = page.locator("#german_validate");
        this.fluencyLabel = page.locator("label[for='fluency']");
        this.fluencyValidate =  page.locator("#fluency_validate");
        this.fluencySlider = page.locator(".custom-range#fluency");
        this.uploadCVLabel = page.locator("label[for='upload_cv']");
        this.chooseSingleFile = page.locator("[type='file']#upload_cv");
        this.uploadCVValidate = page.locator("#validate_cv");
        this.uploadCertificateLabel = page.locator("label[for='upload_files']");
        this.chooseMultipleFiles = page.locator("[type='file']#upload_files");
        this.uploadCertificatesValidate = page.locator("#validate_files");
        this.downloadFileLabel = page.locator("label[for='download_file']");
        this.downloadFileLink = page.locator("#download_file");
        this.currentSalaryLabel = page.locator("label[for='salary']");
        this.currentSalaryInput = page.locator("#salary");
        this.submitFormButton = page.locator(".btn-primary[type='submit']");
        this.invalidCity = page.locator(".invalid-feedback#invalid_city");
        this.invalidState = page.locator(".invalid-feedback#invalid_state");
        this.invalidZip = page.locator(".invalid-feedback#invalid_zip");
        this.invalidTerms = page.locator(".invalid-feedback#invalid_terms");
        this.cityInput = page.locator("input#validationCustom03");
        this.stateInput = page.locator("input#validationCustom04");
        this.nonEnglishNameLabel = page.locator("label[for='नाव']");
        this.nonEnglishNameInput = page.locator("input#नाव");
        this.nonEnglishNameValidate = page.locator("#नाव_तपासा");
        this.language1Checkbox = page.locator("input[type='checkbox']#मराठी");
        this.language2Checkbox = page.locator("input[type='checkbox']#ગુજરાતી");
        this.language3Checkbox = page.locator("input[type='checkbox']#ਪੰਜਾਬੀ");
        this.nonEnglishCheckValidate = page.locator("#check_validate_non_english");
    }

    public void enterYearsOfExperience(String years) {
        yearsOfExperienceInput.type(years);
    }

    public Locator getYearsOfExperienceInput(){
        return yearsOfExperienceInput;
    }

    public Locator getYearsOfExperienceValue(){
        return yearsOfExperienceValue;
    }

    public Locator getJavaCheckBox(){
        return javaCheckBox;
    }

    public Locator getCheckLanguageValidationText(){
        return checkLanguageValidate;
    }

    public Locator getSelectFrameworkValidationText(){
        return selectFrameworkValidate;
    }

    public Locator getPrimarySkillValidationText(){
        return primarySkillValidate;
    }

    public Locator getPrimarySkillLabel(){
        return primarySkillLabel;
    }

    public Locator getChooseLanguageLabel(){
        return chooseLanguageLabel;
    }
    public void checkLanguage(String language){
        switch (language.toLowerCase()){
            case "python":
                pythonCheckBox.check();
                break;

            case "javascript":
                javaScriptCheckBox.check();
                break;

            default:
                pythonCheckBox.check();
                javaScriptCheckBox.check();
                break;
        }
    }

    public void unCheckLanguage(String language) {
        switch (language.toLowerCase()) {
            case "python":
                pythonCheckBox.uncheck();
                break;

            case "javascript":
                javaScriptCheckBox.uncheck();
                break;

            default:
                pythonCheckBox.uncheck();
                javaScriptCheckBox.uncheck();
                break;
        }
    }

    public void selectFrameworkRadio(String framework){
        switch (framework.toLowerCase()){
            case "selenium":
                seleniumRadioButton.click();
                break;

            case "protractor":
                protractorRadioButton.click();
                break;

            default:
                break;
        }
    }

    public Locator getPrimarySkillDropdown() {
        return primarySkillDropdown;
    }

    public Locator getChooseLanguageOptions(){
        return languageOptions;
    }

    public Locator getChooseLanguageValidateText(){
        return chooseLanguageValidate;
    }

    public Locator getNotes(){
        return notes;
    }

    public void typeNotes(String notesText){
        notes.type(notesText);
    }

    public Locator getNotesValidate(){
        return notesValidate;
    }

    public Locator getCommonSenseLabel(){
        return commonSenseLabel;
    }

    public Locator getMandatorySkill(){
        return  mandatorySkill;
    }

    public boolean isMandatorySkillReadOnly(){
        return (boolean) (Boolean) page.evalOnSelector("input#common_sense", "el => el.hasAttribute('readonly')");
    }

    public Locator getSpeaksGermanLabel(){
        return speaksGermanLabel;
    }

    public void clickGermanLabel(){
        speaksGermanLabel.click();
    }

    public Locator getSpeaksGermanValidate(){
        return speaksGermanValidate;
    }

    public Locator getFluencyLabel(){
        return fluencyLabel;
    }

    public void clickFluencyLabel(){
        fluencyLabel.click();
    }

    public Locator getFluencyValidate(){
        return fluencyValidate;
    }

    public void moveFluencySlider(){
        //ToDo: Add mouse move to specific coordinates
        fluencySlider.click();
    }

    public Locator getUploadCVLabel(){
        return uploadCVLabel;
    }

    //This method will upload single file on the webpage based on the file name passed
    public void uploadCV(String pdfName){
        String relativePath = "src/main/java/testdata/testfiles/"+pdfName;
        chooseSingleFile.setInputFiles(Paths.get(relativePath));
    }

    public Locator getUploadCVValidate(){
        return uploadCVValidate;
    }

    public Locator getUploadCertificateLabel(){
        return uploadCertificateLabel;
    }

    //This method will upload multiple files on the webpage based on the file names passed
    public void uploadCertificates(String[] certificates){
        Path[] filePaths = new Path[certificates.length];
        for (int i = 0; i < certificates.length; i++) {
            String relativeCertificatePath = "src/main/java/testdata/testfiles/" + certificates[i];
            filePaths[i] = Paths.get(relativeCertificatePath);
        }
        chooseMultipleFiles.setInputFiles(filePaths);

    }

    public Locator getUploadCertificatesValidateValidate(){
        return uploadCertificatesValidate;
    }

    public Locator getDownloadFileLabel(){
        return downloadFileLabel;
    }

    public Locator getDownloadFileLink(){
        return downloadFileLink;
    }

    //This method will download the file from the Webpage, save it in the testfiles directory and return the url associated with the downloaded file
    public String downloadFile(){
        Download download = page.waitForDownload(downloadFileLink::click);
        String relativeDownloadPath = "src/main/java/testdata/testfiles/";
        download.saveAs(Paths.get(relativeDownloadPath, download.suggestedFilename()));
        return download.url();
    }

    public Locator getSalaryLabel(){
        return currentSalaryLabel;
    }

    public Locator getSalaryInput(){
        return currentSalaryInput;
    }

    public boolean isSalaryDisabled(){
        return (boolean) (Boolean) page.evalOnSelector("#salary", "el => el.hasAttribute('disabled')");
    }

    public void clickOnSubmitForm(){
        submitFormButton.click();
    }

    public Locator getInvalidCity(){
        return invalidCity;
    }

    public Locator getInvalidZip(){
        return invalidZip;
    }

    public Locator getInvalidState(){
        return invalidState;
    }
    public Locator getInvalidTerms(){
        return invalidTerms;
    }

    public void enterCity(String city){
        cityInput.type(city);
    }

    public void enterState(String state){
        stateInput.type(state);
    }

    public void clearCity(){
        cityInput.clear();
    }

    public void clearState(){
        stateInput.clear();
    }

    public Locator getNonEnglishNameLabel(){
        return nonEnglishNameLabel;
    }

    public void enterName(String name){
        nonEnglishNameInput.type(name);
    }

    public Locator getNonEnglishNameValidate(){
        return nonEnglishNameValidate;
    }

    //This method will check the language checkbox based on the language received
    public void checkNonEnglishLanguage(String[] languages) {
        checkNonEnglishLanguage.put("language1", v -> language1Checkbox.check());
        checkNonEnglishLanguage.put("language2", v -> language2Checkbox.check());
        checkNonEnglishLanguage.put("language3", v -> language3Checkbox.check());

        for (String lang : languages) {
            Consumer<Void> action = checkNonEnglishLanguage.get(lang);
            if (action != null) {
                action.accept(null);
            }
        }
    }

    //This method will uncheck the language checkbox based on the language received
    public void unCheckNonEnglishLanguage(String[] languages) {
        unCheckNonEnglishLanguage.put("language1", v -> language1Checkbox.uncheck());
        unCheckNonEnglishLanguage.put("language2", v -> language2Checkbox.uncheck());
        unCheckNonEnglishLanguage.put("language3", v -> language3Checkbox.uncheck());

        for (String lang : languages) {
            Consumer<Void> action = unCheckNonEnglishLanguage.get(lang);
            if (action != null) {
                action.accept(null);
            }
        }
    }

    public Locator getNonEnglishCheckValidate(){
        return nonEnglishCheckValidate;
    }

    //Common assertion across all tests to check the visibility and text content of the values displayed after input is added to each field
    public void validateElementVisibilityAndText(Locator validateLocator, String expectedText){
        assertThat(validateLocator).isVisible();
        assertThat(validateLocator).hasText(expectedText);
    }

}