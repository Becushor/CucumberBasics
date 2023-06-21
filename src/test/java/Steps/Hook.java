package Steps;

import Base.BaseUtil;
import io.cucumber.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {
        System.out.println("Opening the browser: Firefox");
        base.Driver = new FirefoxDriver();
    }
}
