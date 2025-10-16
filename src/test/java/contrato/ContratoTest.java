package contrato;

import client.BreedsClient;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ContratoTest {

    @Test
    @Description("Valida contrato da API Listar todas as raças")
    public void testValidaContratoAPIListaTodasRacas() {

        BreedsClient breedsClient = new BreedsClient();

        breedsClient.getListaRacas()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("json_schemas/breedsListAllSchema.json"));

    }

    @Test
    @Description("Valida contrato da API Lista raça aleatória")
    public void testValidaContratoAPIListaRacaAleatoria() {

        BreedsClient breedsClient = new BreedsClient();

        breedsClient.getImagensAleatorias()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("json_schemas/breedRandonSchema.json"));

    }

}
