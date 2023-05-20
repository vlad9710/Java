package QA_GURU;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTests {

  @Test
  void successfulLoginTests() {
    //  открыть страницу входа в личный кабинет и проверить что в логин форме есть текст "Войти"
    open("https://qa.guru/cms/system/login");
    $(".login-form").shouldHave(text("Войти"));

    //  ввести логин и пароль и войти в систему
    $("[name=email]").setValue("qagurubot@gmail.com");
    $("[name=password]").setValue("qagurupassword").pressEnter();
    //    Войти в личный кабинет
    $(".main-header__login").click();

    //  проверить наличие приветственного текста
    $(".logined-form").shouldHave(text("Здравствуйте, QA_GURU_BOT"));
    Selenide.closeWebDriver();
  }

  @Test
  void unsuccessfulLoginTests() {
    //  открыть страницу входа в личный кабинет и проверить что в логин форме есть текст "Войти"
    open("https://qa.guru/cms/system/login");
    $(".login-form").shouldHave(text("Войти"));
    //  ввести пароль и войти в систему
    $("[name=password]").setValue("password").pressEnter();
    //  ошибка о незаполнености поля e-mail
    $(".login-form").shouldHave(text("Не заполнено поле E-Mail"));
  }
}
