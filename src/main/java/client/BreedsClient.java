package client;

import io.restassured.response.Response;
import spec.RequestAPISpecification;

import static io.restassured.RestAssured.given;

public class BreedsClient {

    private static final String TODAS_RACAS_ENDPOINT = "breeds/list/all";
    private static final String RACA_ENPOINT = "breed/";
    private static final String IMAGENS_RACAS_ALEATORIAS = "/breeds/image/random";

    public Response getListaRacas(){
        return given()
                .spec(RequestAPISpecification.getSpec())
                .when()
                .get(TODAS_RACAS_ENDPOINT);
    }

    public Response getConsultaImagensPorRaca(String raca){
        return given()
                .spec(RequestAPISpecification.getSpec())
                .when()
                .get(RACA_ENPOINT+ raca + "/images");
    }

    public Response getImagensAleatorias(){
        return given()
                .spec(RequestAPISpecification.getSpec())
                .when()
                .get(IMAGENS_RACAS_ALEATORIAS);
    }

}
