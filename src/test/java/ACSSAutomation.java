import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.Pages;
import steps.BasicAuthenticationSteps;

import java.util.List;

/**
 * Created by Filipe on 6/9/2015.
 */
public class ACSSAutomation extends JUnitStories {

    private Pages pages;

    private WebDriver driver;

    public ACSSAutomation(){
        this.driver = createDriver();
        this.pages = new Pages(driver);
    }

    private WebDriver createDriver(){
        String browser = System.getProperty("browser");

        if(browser.equals("chrome")){
            return new ChromeDriver();
        }
        else if(browser.equals("firefox")){
            return new FirefoxDriver();
        }
        else if(browser.equals("phantomjs")){
            return null;
        }
        else if(browser.equals("ie")){
            return new InternetExplorerDriver();
        }
        else {
            return new FirefoxDriver();
        }
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("src/test/resources"),
                "**/*.story",
                "**/exclude_*.story");
    }

    @Override
    public Configuration configuration(){
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                .withFormats(Format.XML, Format.IDE_CONSOLE, Format.CONSOLE, Format.HTML, Format.TXT )
                .withRelativeDirectory("/build/jbehave"));
    }

    @Override
    public InjectableStepsFactory stepsFactory(){
        return new InstanceStepsFactory(
          configuration(),
          new BasicAuthenticationSteps(pages)
        );
    }
}
