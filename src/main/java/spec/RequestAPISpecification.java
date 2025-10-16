package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import static utils.BaseAPIConfig.BASE_URI;

public class RequestAPISpecification {

    private RequestAPISpecification() {
        throw new IllegalStateException("Utility class");
    }

    public static RequestSpecification getSpec(){
        return new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                log(LogDetail.ALL).
                addFilter(new ResponseLoggingFilter()).
                build();
    }

}
