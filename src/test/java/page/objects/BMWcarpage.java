package page.objects;

import pages.base.Basepage;

public class BMWcarpage extends Basepage {

    public static String getCarTite(){
        return getText("bmw_Xpath");
    }
}
