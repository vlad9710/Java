package github;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;


public class SelenideIncludeSoftAssertionsInWiki {

  @Test
  void softAssertionShouldIncludeJUnit5()  {

    //  открыть страницу Selenide в Github
    open("https://github.com/selenide/selenide");
    //  перейти в раздел Wiki проекта
    $("#wiki-tab").click();
    //  убедиться, что в списке страниц (Pages) есть страница SoftAssertions
    //  открыть страницу SoftAssertions
    //  проверить что внутри есть пример кода для JUnit5
  }
}
