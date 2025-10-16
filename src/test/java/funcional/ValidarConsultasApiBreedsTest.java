package funcional;

import client.BreedsClient;
import dto.BreedsDTO;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ValidarConsultasApiBreedsTest {

        private final BreedsClient breedClient = new BreedsClient();

        @Test
        @Description("Deve retornar uma lista de todas as raças de cachorros com sucesso")
        public void testListarTodasRacas() {
            Response response = breedClient.getListaRacas();
            BreedsDTO breedsDTOResponse = response.as(BreedsDTO.class);

            assertThat(response.getStatusCode(), is(200));
            assertThat(breedsDTOResponse.getMessage(), notNullValue());
            assertThat(breedsDTOResponse.getStatus(), equalTo("success"));
        }

        @Test
        @Description("Deve retornar uma lista de imagens de raças especificas com sucesso")
        public void testConsultarImagensPorRaca() {
            Response response = breedClient.getConsultaImagensPorRaca("dachshund");
            BreedsDTO breedsDTOResponse = response.as(BreedsDTO.class);

            assertThat(response.getStatusCode(), is(200));
            assertThat(breedsDTOResponse.getStatus(), equalTo("success"));
            assertThat(breedsDTOResponse.getMessage(), notNullValue());
            assertThat(breedsDTOResponse.getMessage().toString(), containsString("dachshund"));
        }

        @Test
        @Description("Deve retornar uma imagem de raça aleatória com sucesso")
        public void testConsultaImagensDeRacasAleatorias() {
            Response response = breedClient.getImagensAleatorias();
            BreedsDTO breedsDTOResponse = response.as(BreedsDTO.class);

            assertThat(response.getStatusCode(), is(200));
            assertThat(breedsDTOResponse.getMessage(), notNullValue());
            assertThat(breedsDTOResponse.getStatus(), equalTo("success"));
            assertThat(breedsDTOResponse.getMessage().toString(), startsWith("https://images.dog.ceo/breeds/"));
        }

}
