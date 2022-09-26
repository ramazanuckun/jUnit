package day13;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C01_Cookie extends TestBaseBeforeAfter {

    @Test
    public void name() {

        //1-Amazon anasayfaya gidin

        driver.get("https://amazon.com");
        //-tum cookie’leri listeleyin
        Set<Cookie>tumcookie=driver.manage().getCookies();
        System.out.println(tumcookie);
        int sayac=1;
        for (Cookie wach:tumcookie
             ) {
            System.out.println("Cookie="+ wach);
        }
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi=tumcookie.size();
        Assert.assertTrue(cookieSayisi>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        for (Cookie each:tumcookie
             ) {
            if (each.getName().equals("i18n-prefs")){

                Assert.assertEquals("USD",each.getValue());
            }

        }
        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
  Cookie yeniCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);
        tumcookie=driver.manage().getCookies();
        sayac=1;
        for (Cookie each:tumcookie
             ) {
            System.out.println(sayac+ ".cookie"+ each);
            System.out.println(sayac+"value"+ each.getValue());
            System.out.println(sayac+ "name"+ each.getName());
            sayac++;
        }
        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(tumcookie.contains(yeniCookie));
        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        tumcookie=driver.manage().getCookies();
        sayac=1;
        for (Cookie each:tumcookie
             ) {
            System.out.println(sayac+" .cookie"+each);
            System.out.println(sayac+".name"+each.getName());
            System.out.println(sayac+".value"+each.getValue());
            sayac++;
        }
        Assert.assertFalse(tumcookie.contains("skin"));
        //8-tum cookie’leri silin ve silindigini test edin
    driver.manage().deleteAllCookies();
    tumcookie=driver.manage().getCookies();
    Assert.assertTrue(tumcookie.isEmpty());

    }
}
