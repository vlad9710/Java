package QA_QURU;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTests {

  @Test
   void successfulLoginTests() {
    open("https://qa.guru/cms/system/login");
    $(".login-form").shouldHave(text("Войти"));

    $("[name=email]").setValue("qagurubot@gmail.com");
    $("[name=password]").setValue("qagurupassword").pressEnter();
    $(".main-header__login").click();

    $(".logined-form").shouldHave(text("Здравствуйте, QA_GURU_BOT"));
    Selenide.closeWebDriver();
  }

  @Test
  void unsuccessfulLoginTests() {
    open("https://qa.guru/cms/system/login");
    $(".login-form").shouldHave(text("Войти"));

    $("[name=password]").setValue("password").pressEnter();

    $(".login-form").shouldHave(text("Не заполнено поле E-Mail"));
  }
}
