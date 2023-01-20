package pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static driver.Drivers.getDriver;
import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.elementClick;
import static utils.Utils.getElement;

public class CarrinhoPO {

    public void validarPaginaCarrinho(){
        String titulo = getElement(By.className("title")).getText();
        Assert.assertEquals(titulo.toLowerCase(), "your cart",
                "Não foi possível acessar o carrinho de compras");
    }

    public WebElement pegaProdutoCarrinho(String produto) {
        List<WebElement> list = getDriver().findElements(By.className("cart_item"));
        WebElement item = null;
        boolean flag = false;
        for (WebElement element:list
        ) {
            if (element.getText().contains(produto)) {
                item = element;
                flag = true;
            }
        }

        return item;
    }

    public void validaProdutoCarrinho(String produto) {
        appendToReportElementHighlight(pegaProdutoCarrinho(produto));
        Assert.assertNotNull(pegaProdutoCarrinho(produto), "O produto não foi adicionado no carrinho");
    }

    public void validaProdutosCarrinhos(List<String> produtos) {
        for (String produto:produtos
        ) {
            validaProdutoCarrinho(produto);
        }
    }

    public void acessarCarrinho(){
        elementClick(By.className("shopping_cart_link"));
    }

    public void validaProdutosNoCarrinho(List<String> produtos){
        acessarCarrinho();
        validaProdutosCarrinhos(produtos);
    }

    public void btnCheckout(){
        appendToReportElementHighlight(getElement(By.id("checkout")));
        elementClick(By.id("checkout"));
    }
}
