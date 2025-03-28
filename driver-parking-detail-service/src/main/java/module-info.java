module driver.parking.detail.service {
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
    requires spring.boot.starter.validation;
    requires org.hibernate.orm.core;

    //exports com.parking.driver.parkingdetail;
    //exports com.parking.driver.parkingdetail.app;
    //exports com.parking.driver.parkingdetail.infra.adapter.in;

    opens com.parking.driver.parkingdetail;
    opens com.parking.driver.parkingdetail.domain;
    opens com.parking.driver.parkingdetail.app;
    opens com.parking.driver.parkingdetail.infra.adapter.in;
}
