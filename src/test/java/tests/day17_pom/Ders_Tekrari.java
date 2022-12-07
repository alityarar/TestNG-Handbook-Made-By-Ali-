package tests.day17_pom;

public class Ders_Tekrari {
    /*

    -POM:Page Object Model java OOP konsept ile selenium u birlestiren
    testlerimizi daha hizli,anlasilir,reusable ve easy maintable
    ozelliklerine sahip popular bir framework dizayn modelidir.

    -Temel hedef test methodlarinda elle girilen hicbir deger olmamasidir.
    (url,locate veya testdata)

    -Temelde projemizde 3 package bulunur

    1-Pages:locate islemlerini login methodu gibi siradan methodlari koyariz
    Her page icin ozel class kullaniriz

    2-Utilities:projemiz icin gerekli ekstra kaynaklar (Driver method)

    3-Tests: Testlerimizi olusturdugumuz package

    -Eger test ettigimiz page'de cok fazla ozellik varsa her bir epic icin
    ayri page classi olusturabiliriz.

    -Her page sayfasi olusturdugumuzda ilk yapmamiz gereken parametresiz
    constructor olusturup,contructor icinde pageFactory classindan
    initElement() kullanip Driver class'indaki getDriver()'in
    getirecegi driver'in bu class(this) da gecerli olacagini tanimlamaktir

    -Page sayfalarinda bu gune kadar locate icin kullandigimiz
    findElement veya findElements yerine @FindBy notasyonu kullanilir

    Public WebElement aElementi olurken digeri de
    Public List<WebElement> aElementlerListesi olur

    -Driver class'i olusturup bize driver dondurecek getDriver() ve
    driver'i kapatacak closeDriver() methodlarini olusturduk
    Bu iki method a her yerden ulasabilmek icin methodlari static yaptik
     */
}
