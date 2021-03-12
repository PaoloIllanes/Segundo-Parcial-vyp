package runner;

import configuration.Config;
import factoryRequest.FactoryRequest;
import factoryRequest.RequestInformation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import utilsJson.JsonHelper;

import java.util.HashMap;
import java.util.Map;

public class MyStepdefs {

        Response response;
        RequestInformation request = new RequestInformation();
        Map<String, String> data = new HashMap<>();

  
    @Given("tengo acceso a todoly")
    public void tengoAccesoATodoly() {
    }

    @When("mando una GET request al url {}")
    public void mandoUnaGETRequestAlUrlHttpTodoLyApiAuthenticationTokenJson(String url) {
        request.setAuthType(Config.AUTH_BASIC);
        request.setAuthValue(Config.AUTH_BASIC_VALUE);
        request.setUrl(replaceAllData(url));
        response = FactoryRequest.make("GET").send(request);
        
    }

    @And("obtengo una propiedad {} y la guardo en {}")
    public void obtengoUnaPropiedadTokenStringYLaGuardoEnTokenValue(String value,String property) {
        data.put(value, response.then().extract().path(property) + "");
    }

    @Then("espero un response body")
    public void esperoUnResponseBody(String body) {
        Assert.assertTrue("No es el body esperado", JsonHelper.areEqualJson(replaceAllData(body), response.getBody().asString()));
    }

    @When("mando una solicitud de delete al url {}")
    public void mandoUnaSolicitudDeDeleteAlUrlHttpTodoLyApiAuthenticationTokenJson(String url) {
        request.setAuthType(Config.TOKEN);
        request.setAuthValue(replaceAllData("TokenValue"));
        request.setUrl(replaceAllData(url));
        response = FactoryRequest.make("DELETE").send(request);
    }

    private String replaceAllData(String value) {
        for (String key : data.keySet()) {
            value = value.replace(key, data.get(key));
        }
        return value;
    }
}
