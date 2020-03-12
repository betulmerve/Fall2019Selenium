package com.automation.tests.day7;

public interface Localize {

    static String userNameLocator="//label[text()='Username']/following-sibling::input";

    static String passwordLocator="//label[text()='Password']/following-sibling::input";

    static String loginBtnLocator="//button[contains(text(), 'Login')]";

}
