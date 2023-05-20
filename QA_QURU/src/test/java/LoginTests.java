import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests {

  @Test
  void successfulLoginTests() {
    Configuration.holdBrowserOpen = true;
    Configuration.browser = "firefox";

    open("https://qa.guru/cms/system/login");
    $(".login-form").shouldHave(text("Войти"));

    $("[name=email]").setValue("qagurubot@gmail.com");
    $("[name=password]").setValue("qagurupassword").pressEnter();
    $(".main-header__login").click();

    $(".logined-form").shouldHave(text("Здравствуйте, QA_GURU_BOT"));
  }

  @Test
  void unsuccessfulLoginTests() {
    Configuration.holdBrowserOpen = true;

    open("https://qa.guru/cms/system/login");
    $(".login-form").shouldHave(text("Войти"));

    $("[name=password]").setValue("password").pressEnter();

    $(".login-form").shouldHave(text("Не заполнено поле E-Mail"));
  }
}
