package tests.day11;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test(){

        // Seleniumu kullanmıyoruz. PURE java kullanıyoruz.

        System.out.println(System.getProperty("user.home")); // output :  C:\Users\USER
        // "C:\Users\USER\Desktop\picture.jpg"

        /*
        masaustundeki bir dosya yolunun tum bilgisayarda sorunsuz calismasi icin dosya yolunu 2ye ayiracagiz.
        1. herkesin pc de farkli olan kisimi pc den 'System.getProperty("user.home")' kodu ile alabiliriz.

        2. herkes icin ayni olan kisim shift+sag click yaparak dosya yolunu almak ve

        ikisinide birlestirmek.

         */
        String filePath = System.getProperty("user.home") + "\\Desktop\\picture.jpg";

        System.out.println("file path :"+filePath);

        System.out.println(Files.exists (Paths.get (filePath)));

        Assert.assertTrue(Files.exists (Paths.get (filePath)));


        System.out.println(System.getProperty("user.dir")); // output : C:\Users\USER\IdeaProjects\com.Batch39TestNG


    }
}
