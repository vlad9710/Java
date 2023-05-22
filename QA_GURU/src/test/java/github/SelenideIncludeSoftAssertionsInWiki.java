package github;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenideIncludeSoftAssertionsInWiki {

  @Test
  void softAssertionShouldIncludeJUnit5()  {

    //  открыть страницу Selenide в Github
    open("https://github.com/selenide/selenide");
    //  перейти в раздел Wiki проекта
    $("#wiki-tab").click();
    //  убедиться, что в списке страниц (Pages) есть страница SoftAssertions
    $("#wiki-pages-filter").setValue("SoftAssertions");

    //  открыть страницу SoftAssertions
    $("#wiki-pages-box").$(byText("SoftAssertions")).click();

    //  проверить что внутри есть пример кода для JUnit5
    $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
  }
}
