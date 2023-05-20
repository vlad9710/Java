package github;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {

  @Test
  void solntsevShouldBeTheTopContributor() {
    //  открыть страницу репозитория селенида
    open("https://github.com/selenide/selenide");
    //  подвести мышку к первому аватару из блока contributors
    $(".BorderGrid").$(Selectors.byText("Contributors")).ancestor(".BorderGrid-row").$$("ul li").first().hover();
    //  проверка: во всплывающем окне есть текст Andrei Solntsev
    $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
  }

}
