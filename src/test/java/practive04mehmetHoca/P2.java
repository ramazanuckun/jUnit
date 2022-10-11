package practive04mehmetHoca;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Path;

public class P2 extends TestBaseBeforeAfter {

    @Test
    public void name() {

//Verify that we have pom.xml file in our project => please try in 4 min s

String path="C:\\Users\\Kullanıcı\\Desktop\\Website\\com.Batch81JUnit\\pom.xml";
       Assert.assertTrue(Files.exists(Path.of(path)));



    }

    @Test
    public void name1() {
        //Verify that we have pom.xml file in our project => please try in 4 min s
        String expected="C:\\Users\\Kullanıcı\\Desktop\\Website\\com.Batch81JUnit\\pom.xml";
        Assert.assertTrue(Files.exists(Path.of(expected)));

        String calisma="C:\\Users\\Kullanıcı\\Desktop\\Website\\com.Batch81JUnit\\src\\test\\java\\practive04mehmetHoca\\P01.java";
        Assert.assertTrue(Files.exists(Path.of(calisma)));


    }
}
