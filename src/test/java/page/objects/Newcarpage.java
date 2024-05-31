package page.objects;

import pages.base.Basepage;

public class Newcarpage extends Basepage {

    public void gotoToyota() {
        click("toyota_LINK");
    }

    public void gotoKia() {
        click("Kia_LINK");
    }

    public void gotoBMW() {
        click("bmw_LINK");
    }

    public void gotoAudi() {
        click("Audi_LINK");
    }
}
