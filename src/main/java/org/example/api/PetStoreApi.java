package org.example.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.models.Pet;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreApi {
    
    public PetStoreApi() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    public Response createPet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(pet)
                .log().all()
            .when()
                .post("/pet")
            .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo(pet.getName()))
                .body("status", equalTo(pet.getStatus()))
                .extract()
                .response();
    }

    public Response getPetById(Long petId) {
        return given()
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
                .log().all()
            .when()
                .get("/pet/{petId}")
            .then()
                .log().all()
                .extract()
                .response();
    }

    public Response getPetByIdWithoutValidation(Long petId) {
        return given()
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
                .log().all()
            .when()
                .get("/pet/{petId}")
            .then()
                .log().all()
                .statusCode(anyOf(equalTo(200), equalTo(404)))
                .extract()
                .response();
    }

    public Response updatePet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(pet)
                .log().all()
            .when()
                .put("/pet")
            .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo(pet.getName()))
                .body("status", equalTo(pet.getStatus()))
                .extract()
                .response();
    }
} 