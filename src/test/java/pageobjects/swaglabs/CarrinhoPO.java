package pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static driver.Drivers.getDriver;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.elementClick;
import static utils.Utils.getElement;

public class CarrinhoPO {

    private ProdutoPO produtoPO;
    private String carrinho = "cart_item_label";
    private String logoCarrinho = "title";
    private String btnCheckout = "checkout";
    private String btnVoltar = "continue-shopping";

    public void validarPaginaCarrinho() {
        Assert.assertTrue(getElement(By.className(logoCarrinho)).isDisplayed(), "Não está na página do carrinho!");
    }

    public WebElement produtoNoCarrinho(String produto) {
        List<WebElement> produtos = getDriver().findElements(By.className(carrinho));
        WebElement item = null;
        for (WebElement p : produtos) {
            if (p.getText().contains(produto)) {
                item = p;
            }
        }
        return item;
    }

    public void validarProdutoNoCarrinho(String produto) {
        WebElement element = produtoNoCarrinho(produto).findElement(By.className("inventory_item_name"));
        String nomeProduto = element.getText();
        appendToReportElementHighlight(element);
        Assert.assertTrue(nomeProduto.contains(produto),"Produto não está no carrinho!");
    }




    public void validateCartProducts(List<String> products) {
        for (String product:products
        ) {
            validarProdutoNoCarrinho(product);
        }
    }
    public void validateProductsAndCheckout(List<String> products) {
        validateCartProducts(products);
        btnCheckout();
    }

    public void btnCheckout() {
        elementClick(By.id(btnCheckout));
    }

    public void btnVoltarShopping() {
        elementClick(By.id(btnVoltar));
    }

}
