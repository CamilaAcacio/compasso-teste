package compasso_teste.compasso_teste;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class) 
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}, glue = {"compasso_teste.stepsDefinitions" }) 

public class BuscaProdutoRun {

}
