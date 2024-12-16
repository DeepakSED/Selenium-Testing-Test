import org.apache.commons.io.FileUtils;
import java.io.File;

public void takeScreenshot(String fileName) {
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(screenshot, new File("./screenshots/" + Result + ".png"));
    } catch (Exception e) {
        e.printStackTrace();
    }
}


pulaing:

@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
)
