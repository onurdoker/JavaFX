module com.onurdoker.javafx {

    // JavaFX'in temel bileşenlerini kullanmak için gerekli modüller
    // JavaFX kontrol bileşenlerini (Button, label, TextField vb) kullanabilemk için gereklidir.
    requires javafx.controls;
    // JavaFX FXML dosyalarını (FXML UI tasarımları) yükleyebimek  için gereklidir.
    requires javafx.fxml;

    // UI geliştirmek için kullanılan harici kütüphaneler
    // ControlFX, gelişmiş UI bileşenleri (Örn. Notifikasyonlar, Doğrulama Alanları) sağlar.
    requires org.controlsfx.controls;
    //FormsFX, formlar için gelişmiş bileşenleri sunan kütüphanedir.
    requires com.dlsc.formsfx;
    // ValidaotrFX, form doğrulama işlemerli için kullanılan kütüphanedir.
    requires net.synedra.validatorfx;
    // İkon kütüpjanesi, UI'de çeşitli ikonları kullanmak için kullanılır.
    requires org.kordamp.ikonli.javafx;
    // BootstrapFX, Bootstrap temalı UI bileşenleri sağlar. <---
    requires org.kordamp.bootstrapfx.core;
    requires static lombok;
    requires java.sql;


    // Paket erişimlerine izim vermek
    opens com.onurdoker.javafx to javafx.fxml;
    //Controller sınıfı FXML tarafından kullanacağı için açılması gerekiyor.
    opens com.onurdoker.javafx.controller to javafx.fxml;

    opens com.onurdoker.javafx.dto to javafx.base, lombok;
    // DAO (Data Access Object) sınıgları, SQL bağlantısı kullanıdığı için açılır.
    opens com.onurdoker.javafx.dao to java.sql;
    opens com.onurdoker.javafx.database to java.sql;

    // Export
    exports com.onurdoker.javafx;
    exports com.onurdoker.javafx.dao;
    exports com.onurdoker.javafx.database;
}