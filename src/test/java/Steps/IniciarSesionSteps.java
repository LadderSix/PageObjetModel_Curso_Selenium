package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import Pages.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Base.*;

public class IniciarSesionSteps{
    private HomePage home;
    private MiServipagPage miServipagPage;
    private PerfilPage perfilPage;
    private BaseSelenium base;

    public IniciarSesionSteps() {
    }


    @Given("el usuario se encuentra en la pagina de servipag")
    public void el_usuario_se_encuentra_en_la_pagina_de_servipag() {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("el usuario presiona en boton Mi Servipag")
    public void el_usuario_presiona_en_boton_Mi_Servipag(){
        // Write code here that turns the phrase above into concrete actions
        home.btnMiServipag();
    }
    @And("el usuario ingreso rut y password")
    public void el_usuario_ingreso_rut_y_password(){
        // Write code here that turns the phrase above into concrete actions
        String rut = "175553878";
        String pass = "@Rojas651";

        home.iniciarSesion(rut,pass);
    }
    @Then("el usuario puede ver su informacion")
    public void el_usuario_puede_ver_su_informacion(){
        // Write code here that turns the phrase above into concrete actions
        miServipagPage.irAlPerfil();
    }
}
