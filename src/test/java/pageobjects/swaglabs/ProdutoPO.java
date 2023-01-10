package pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static driver.Drivers.getDriver;
import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.*;

public class ProdutoPO {

    private String listaProdutos = "inventory_item";
    private String adicionarCarrinho = "button";
    private String btnCarrinho = "shopping_cart_badge";
    private String precoProduto = "inventory_item_price";
    private String ordemProduto = "product_sort_container";



    public void ordenarProdutos(String ordem) {
        WebElement element = getDriver().findElement(By.className(ordemProduto));
        Select select = new Select(element);
        select.selectByValue(ordem);
    }

    public void adicionaProdutos(List<String> produtos) {
        for (String produto:produtos
        ) {
            WebElement p = pegaProduto(produto);
            p.findElement(By.tagName("button")).click();
        }
    }



    public WebElement pegaProduto(String produto) {
        List<WebElement> produtos = getDriver().findElements(By.className(listaProdutos));
        WebElement item = null;
        for (WebElement p : produtos) {
            if (p.getText().contains(produto)) {
                item = p;
                break;
            }
        }
        return item;
    }


    public void adicionarProdutoCarrinho(String produto) {
      WebElement element =  pegaProduto(produto);
      new Actions(getDriver()).moveToElement(element).build().perform();
      element.findElement(By.tagName(adicionarCarrinho)).click();
      appendToReportElementHighlight(element);
    }

    public void acessarCarrinho() {
        elementClick(By.className(btnCarrinho));
    }

}
