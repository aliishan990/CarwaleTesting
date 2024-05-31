package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import page.objects.*;
import utils.seleniumDriver;

public class carwalesteps {

    Homepage home = new Homepage();
    Newcarpage car = new Newcarpage();
    Toyatocarpage toyotacar = new Toyatocarpage();

    @Given("user navigates to carwala website")
    public void user_navigates_to_carwala_website() {
        seleniumDriver.openpage(seleniumDriver.config.getProperty("testsiteurl"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user mouseover to newcars")
    public void user_mouseover_to_newcars() {
        home.mouseoverNewCars();
    }

    @And("user clicks on findnewcars")
    public void userClicksOnFindnewcars() throws InterruptedException {
        home.clickFindNewCars();

    }

    @Then("user clicks on Toyota  car")
    public void user_clicks_on_toyota_car() throws InterruptedException {
        car.gotoToyota();
    }

    @And("user validates cartitle as Toyota Cars")
    public void userValidatesCartitleAsToyotaCars() {
        Assert.assertTrue(toyotacar.getCarTite().equals("Toyota Cars"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Then("user clicks on {string}  car")
    public void userClicksOnCar(String carbrand) {
        if (carbrand.equals("Toyota")) {
            car.gotoToyota();
        }  if (carbrand.equals("BMW")) {
            car.gotoBMW();
        }  if (carbrand.equals("Audi")) {
            car.gotoAudi();
        } if (carbrand.equals("Kia")) {
            car.gotoKia();
        }


    }

    @And("user validates cartitle as {string}")
    public void userValidatesCartitleAs(String carTitle) throws InterruptedException {
        if (carTitle.equals("Toyota Cars")) {
            Assert.assertTrue(toyotacar.getCarTite().equals("Toyota Cars"));
            //System.out.println(toyotacar.getCarTite());
        }  if (carTitle.equals("BMW Cars")) {
            Assert.assertTrue(BMWcarpage.getCarTite().equals("BMW Cars"));
            //System.out.println(BMWcarpage.getCarTite());
        }  if (carTitle.equals("Audi Cars")) {
            Assert.assertTrue(Audicarpage.getCarTite().equals("Audi Cars"));
            //System.out.println(Audicarpage.getCarTite());
        }  if (carTitle.equals("Kia Carss")) {
            Assert.assertTrue(kiacarpage.getCarTite().equals("Kia Carss"));
            //Thread.sleep(2000);
            //System.out.println(kiacarpage.getCarTite());
        }
    }
}
