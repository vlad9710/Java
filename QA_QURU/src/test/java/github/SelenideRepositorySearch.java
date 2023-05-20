package github;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

  @Test
  void shouldFindSelenideRepositoryAtTheTop() {
    //открыть главную страницу
    open("http://github.com");
    //ввести в поле поиска selenide и нажать ентер
    $("[data-scoped-placeholder=Search]").setValue("selenide").pressEnter();
    //кликнуть на первый репозиторий из списка найденных
    $$("ul.repo-list li").first().$("div.f4").click();
    //проверка: заголовок selenide/selenide
    $("#repository-container-header").shouldHave(text("selenide / selenide"));
  }
}
