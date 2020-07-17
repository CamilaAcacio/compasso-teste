package assertiva_teste.assertiva_teste;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class) 
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}, glue = {"assertiva_teste.stepsDefinitions" }) 

public class BuscaProdutoRun {

}
