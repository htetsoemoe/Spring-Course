package com.demo;

import com.demo.service.WarehouseService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan
@EnableTransactionManagement
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        context.registerShutdownHook();

        WarehouseService warehouseService = context.getBean(WarehouseService.class);
        warehouseService.purgeDate();

        try {
            warehouseService.saveData();
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " exception caught.");
        }

        warehouseService.listAllData();
    }
}
