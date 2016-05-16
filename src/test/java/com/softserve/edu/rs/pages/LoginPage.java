package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.Component;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.rs.data.users.IUser;

public class LoginPage extends TopPage {

	private class LoginPageUIMap {
		public final ITextField login;
		public final ITextField password;
		public final IButton signin;
    	
    	public LoginPageUIMap() {
    		this.login = TextField.get().getById("login");
    		this.password = TextField.get().getById("password");
    		this.signin = Button.get().getByCssSelector("button.btn.btn-primary");
    	}
    	
    	public void showAlert(String message) {
    		Component.get().runJavaScript(String.format("alert('Hello %s')", message));
    	}
    }

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
    // Elements
    private LoginPageUIMap controls;

	public LoginPage() {
		//super();
		controls = new LoginPageUIMap();
	}

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Get Elements

	public ITextField getLogin() {
		return this.controls.login;
	}

	public ITextField getPassword() {
		return this.controls.password;
	}

	public IButton getSignin() {
		return this.controls.signin;
	}

	public String getLoginText() {
		return getLogin().getText();
	}

	public String getPasswordText() {
		return getPassword().getText();
	}

	// Set Data

	public void setLogin(String login) {
		getLogin().sendKeys(login);
	}

	public void setLoginClear(String login) {
		getLogin().sendKeysClear(login);
	}

	public void setPassword(String password) {
		getPassword().sendKeys(password);
	}

	public void setPasswordClear(String password) {
		getPassword().sendKeysClear(password);
	}

	public void clearLogin() {
		getLogin().clear();
	}

	public void clearPassword() {
		getPassword().clear();
	}

	public void clickLogin() {
		getLogin().click();
	}

	public void clickPassword() {
		getPassword().click();
	}

	public void clickSignin() {
		getSignin().click();
	}

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public void showAlert(String message) {
		this.controls.showAlert(message);
	}
	
	// Functional
	
	public LoginPage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        return new LoginPage();
    }

    private void setLoginData(IUser user) {
		setLoginClear(user.getAccount().getLogin());
		setPasswordClear(user.getAccount().getPassword());
		clickSignin();
	}

    public HomePage successUserLogin(IUser user) {
        setLoginData(user);
        return new HomePage();
    }
    
    public LoginValidatorPage unsuccessUserLogin(IUser user) {
        setLoginData(user);
        return new LoginValidatorPage();
    }

    public AdminHomePage successAdminLogin(IUser admin) {
		setLoginData(admin);
		return new AdminHomePage();
	}

	public CommissionerHomePage successCommissionerLogin(IUser commissioner) {
		setLoginData(commissioner);
		return new CommissionerHomePage();
	}
	
	public RegistratorHomePage successRegistratorLogin(IUser registrator) {
		setLoginData(registrator);
		return new RegistratorHomePage();
	}
	
	public UserHomePage successUserPageLogin(IUser user) {
		setLoginData(user);
		return new UserHomePage();
	}

	public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
		setLoginData(invalidUser);
		return new LoginValidatorPage();
	}

}
