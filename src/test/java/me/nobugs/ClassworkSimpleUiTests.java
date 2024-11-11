package me.nobugs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import me.nobugs.ui.data.BankAccount;
import me.nobugs.ui.pages.RegisterAccountPage;
import me.nobugs.ui.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ClassworkSimpleUiTests {
    @BeforeAll
    public static void setupUiTests() {
        Configuration.baseUrl = "https://parabank.parasoft.com/";
    }

    @Test
    public void userCanCreateAccount() {
        var registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        String password = RandomData.generateRandomPassword();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.generateRandomString())
                .lastName(RandomData.generateRandomString())
                .address(RandomData.generateRandomString())
                .city(RandomData.generateRandomString())
                .state(RandomData.generateRandomString())
                .zipCode(RandomData.generateRandomZipCode())
                .ssn(RandomData.generateRandomSSN())
                .username(RandomData.generateRandomString())
                .password(password)
                .confirmedPassword(password)
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getWelcomeTitle().shouldHave(Condition.innerText("Welcome"));
    }

    @Test
    public void userCanNotCreateAccountWithFirstNameOnly() {
        var registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.generateRandomString())
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithLastNameOnly() {
        var registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        BankAccount bankAccount = BankAccount.builder()
                .lastName(RandomData.generateRandomString())
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithAddressOnly() {
        var registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        BankAccount bankAccount = BankAccount.builder()
                .address(RandomData.generateRandomString())
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithCityOnly() {
        var registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        BankAccount bankAccount = BankAccount.builder()
                .city(RandomData.generateRandomString())
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithStateOnly() {
        var registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        BankAccount bankAccount = BankAccount.builder()
                .state(RandomData.generateRandomString())
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithZipCodeOnly() {
        var registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        BankAccount bankAccount = BankAccount.builder()
                .zipCode(RandomData.generateRandomZipCode())
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithSsnOnly() {
        var registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        BankAccount bankAccount = BankAccount.builder()
                .ssn(RandomData.generateRandomSSN())
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithUsernameOnly() {
        var registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        BankAccount bankAccount = BankAccount.builder()
                .username(RandomData.generateRandomString())
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithPasswordAndConfirmationOnly() {
        var registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        String password = RandomData.generateRandomPassword();

        BankAccount bankAccount = BankAccount.builder()
                .password(password)
                .confirmedPassword(password)
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
    }
}
