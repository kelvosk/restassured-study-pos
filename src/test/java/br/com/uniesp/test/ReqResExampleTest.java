package br.com.uniesp.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import br.com.uniesp.entidate.PageResponse;
import br.com.uniesp.entidate.PessoaRequest;
import br.com.uniesp.entidate.PessoaResponse;
import org.apache.http.HttpStatus;

import br.com.uniesp.servicos.Servicos;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ReqResExampleTest {

	private Assertions Assert;

	@BeforeEach
	public void configuraApi() {
		baseURI = "https://reqres.in/";
	}

	@Test
	void getListUnknown() {
		given()
				.when()
				.get(Servicos.getUnknown_PAGE.getValor())
				.then()
				.contentType(ContentType.JSON)
				.statusCode(HttpStatus.SC_OK)
				.and()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/getUnknown.json"))
				.log().all()
				.extract()
				.response()
				.as(PageResponse.class);
	}

	@Test
	public void methodPost() {
		PessoaRequest pessoaRequest = new PessoaRequest("Kelvin", "Test");

		PessoaResponse as = given()
				.contentType("application/json")
				.body(pessoaRequest)
				.when()
				.post(Servicos.getCreateUsersPage.getValor())
				.then()
				.statusCode(HttpStatus.SC_CREATED)
				.extract().response().as(PessoaResponse.class);

		Assert.assertNotNull(as);
		Assert.assertNotNull(as.getId());
		Assert.assertEquals(pessoaRequest.getNome(), as.getNome());
		Assert.assertEquals(pessoaRequest.getJob(), as.getJob());

	}

	@Test
	public void putMethod() {

		PessoaRequest pessoaRequest = new PessoaRequest("Kelvin", "Test");

		PessoaResponse as = given()
				.contentType("application/json")
				.body(pessoaRequest)
				.when()
				.put(Servicos.users_ID.getValor(), 2)
				.then()
				.statusCode(HttpStatus.SC_OK)
				.log().all()
				.extract().response().as(PessoaResponse.class);

		Assert.assertNotNull(as);
		Assert.assertEquals(pessoaRequest.getNome(), as.getNome());
		Assert.assertEquals(pessoaRequest.getJob(), as.getJob());


	}

	@Test
	public void deleteMethod() {
				given()
				.contentType("application/json")
				.when()
				.delete(Servicos.users_ID.getValor(), 2)
				.then()
				.statusCode(HttpStatus.SC_NO_CONTENT)
				.log().all();

	}

}