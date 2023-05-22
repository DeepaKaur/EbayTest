package rba.model.pages;

import rba.common.Util;

public class BasePage {

    public void cleanUp() {
        System.out.println(this.getClass().getName() + " cleanUp");
        Util.closeWebDriver();
    }

}
