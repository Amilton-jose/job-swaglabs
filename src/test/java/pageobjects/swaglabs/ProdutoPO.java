package pageobjects.swaglabs;

import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static driver.Drivers.getDriver;
import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.*;

public class ProdutoPO {


    public void validarLogin() {
        Assert.assertTrue(getElement(By.className("title")).isDisplayed(), "O login não foi efetuado!");
    }

    public void validarListaDeProdutos() {
        appendToReportElementHighlight(getElement(By.className("inventory_list")));
        Assert.assertTrue(getElement(By.className("inventory_list")).isDisplayed(), "A lista não foi encontrada!");
    }

    public void ordenarProdutos(String ordem) {
        WebElement element = getDriver().findElement(By.className("product_sort_container"));
        Select select = new Select(element);
        select.selectByVisibleText(ordem);
    }



    public String pegaNomeProduto(String produto) {
        WebElement item = pegaProduto(produto);
        String nome = item.findElement(By.className("inventory_item_name")).getText();
        return nome;
    }

    public String pegaValor(String produto) {
        WebElement item = pegaProduto(produto);
        String price = item.findElement(By.className("inventory_item_price")).getText();
        return price;
    }


    public List<String> pegoValores(List<String> produtos) {
        List<String> prices = new ArrayList<>();
        for (String produto:produtos
        ) {
            prices.add(pegaValor(produto));
        }
        return prices;
    }


    public List<String> validaProdutos(List<String> produtos) {
        List<String> nomes = new ArrayList<>();
        for (String produto : produtos
        ) {
            nomes.add(pegaNomeProduto(produto));
            appendToReportElementHighlight(pegaProduto(produto));
        }
        return nomes;
    }

    public WebElement pegaProduto(String produtos) {
        WebElement list = getElement(By.className("inventory_list"));
        List<WebElement> products = list.findElements(By.className("inventory_item"));
        WebElement item = null;
        for (WebElement p : products
        ) {
            if (p.getText().contains(produtos)) {
                item = p;
                break;
            }
        }
        return item;
    }

    public void adicionarProdutos(List<String> produtos) {
        for (String product : produtos
        ) {
            WebElement p = pegaProduto(product);
            p.findElement(By.tagName("button")).click();
            appendToReportElementHighlight(p);
        }
    }




}
