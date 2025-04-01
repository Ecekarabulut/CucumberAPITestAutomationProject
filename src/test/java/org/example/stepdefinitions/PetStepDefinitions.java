package org.example.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.api.PetStoreApi;
import org.example.models.Category;
import org.example.models.Pet;
import org.example.models.Tag;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PetStepDefinitions {
    private PetStoreApi petStoreApi;
    private Pet pet;
    private Response response;
    private Long petId;

    public PetStepDefinitions() {
        petStoreApi = new PetStoreApi();
        pet = new Pet();
    }

    @Given("I have a pet with the following details")
    public void iHaveAPetWithTheFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = rows.get(0);

        pet.setName(data.get("name"));
        pet.setStatus(data.get("status"));

        // Set default category
        Category category = new Category();
        category.setId(1L);
        category.setName("Dogs");
        pet.setCategory(category);

        // Set default tags
        Tag tag = new Tag();
        tag.setId(1L);
        tag.setName("friendly");
        pet.setTags(Arrays.asList(tag));

        // Set default photo URLs
        pet.setPhotoUrls(Arrays.asList("http://example.com/photo.jpg"));

        System.out.println("Created pet with name: " + pet.getName() + " and status: " + pet.getStatus());
    }

    @When("I create the pet")
    public void iCreateThePet() {
        System.out.println("Sending pet creation request with name: " + pet.getName());
        response = petStoreApi.createPet(pet);
        Assert.assertEquals("Pet creation should return 200", 200, response.getStatusCode());
        
        petId = response.jsonPath().getLong("id");
        pet.setId(petId);
        
        // Verify the response matches what we sent
        String responseName = response.jsonPath().getString("name");
        String responseStatus = response.jsonPath().getString("status");
        
        Assert.assertEquals("Created pet name should match", pet.getName(), responseName);
        Assert.assertEquals("Created pet status should match", pet.getStatus(), responseStatus);
        
        System.out.println("Pet created with ID: " + petId + ", name: " + responseName);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(Integer expectedStatusCode) {
        Assert.assertEquals("Response status code should match", expectedStatusCode.intValue(), response.getStatusCode());
    }

    @Then("the pet should be created successfully")
    public void thePetShouldBeCreatedSuccessfully() {
        Assert.assertNotNull("Pet ID should not be null", petId);
        
        String responseName = response.jsonPath().getString("name");
        String responseStatus = response.jsonPath().getString("status");
        
        Assert.assertEquals("Pet name should match", pet.getName(), responseName);
        Assert.assertEquals("Pet status should match", pet.getStatus(), responseStatus);
        
        System.out.println("Successfully verified pet creation. Name: " + responseName + ", Status: " + responseStatus);
    }

    @Given("I have created a pet")
    public void iHaveCreatedAPet() {
        iCreateThePet();
    }

    @When("I get the pet by ID")
    public void iGetThePetById() {
        System.out.println("Getting pet with ID: " + petId);
        response = petStoreApi.getPetById(petId);
        Assert.assertEquals("Get pet should return 200", 200, response.getStatusCode());
        
        // Print response details for debugging
        System.out.println("Get pet response - Status Code: " + response.getStatusCode());
        System.out.println("Get pet response - Body: " + response.getBody().asString());
    }

    @When("I update the pet name to {string}")
    public void iUpdateThePetNameTo(String newName) {
        System.out.println("Updating pet name from: " + pet.getName() + " to: " + newName);
        pet.setName(newName);
        response = petStoreApi.updatePet(pet);
    }

    @Then("the pet details should match the created pet")
    public void thePetDetailsShouldMatchTheCreatedPet() {
        String responseName = response.jsonPath().getString("name");
        String responseStatus = response.jsonPath().getString("status");
        
        System.out.println("Comparing pet details - Expected name: " + pet.getName() + ", Actual name: " + responseName);
        System.out.println("Comparing pet details - Expected status: " + pet.getStatus() + ", Actual status: " + responseStatus);
        
        Assert.assertEquals("Pet name should match", pet.getName(), responseName);
        Assert.assertEquals("Pet status should match", pet.getStatus(), responseStatus);
    }

    @Then("the pet name should be updated to {string}")
    public void thePetNameShouldBeUpdatedTo(String expectedName) {
        String responseName = response.jsonPath().getString("name");
        System.out.println("Verifying pet name update - Expected: " + expectedName + ", Actual: " + responseName);
        Assert.assertEquals("Updated pet name should match", expectedName, responseName);
    }
} 