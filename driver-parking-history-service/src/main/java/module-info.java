module driver.parking.history.service {
    // Módulos base de Java
    requires java.base;
    requires java.sql;
    requires java.naming;
    requires jakarta.persistence;
    requires jdk.unsupported;

    // Módulos Sprnig
    requires spring.core;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;
    requires spring.web;
    requires spring.data.jpa;
    requires spring.data.commons;
    //requires spring.boot.starter.validation;
    requires spring.tx;
    requires org.hibernate.orm.core;

    /*exports com.parking.driver.parkinghistory;
    exports com.parking.driver.parkinghistory.app;
    exports com.parking.driver.parkinghistory.infra.adapter.in;*/

    // Abre todos los paquetes para reflexión
    opens com.parking.driver.parkinghistory;
    opens com.parking.driver.parkinghistory.domain;
    opens com.parking.driver.parkinghistory.app;
    opens com.parking.driver.parkinghistory.infra.adapter.in;
    opens com.parking.driver.parkinghistory.infra.adapter.out;

}
