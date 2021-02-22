package com.sav;

import com.sav.entities.Order;
import com.sav.utils.OrderBuilder;
import lombok.AllArgsConstructor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String file = "orders.txt";
        Order order = createOrder();

        ProcessOrder p = new PrintProcessOrder();
        p = new SaveProcessOrder(file, p);
        p = new ValidateProcessOrder(p);

        ProcessOrder p1 = new ValidateProcessOrder(new SaveProcessOrder(file,new PrintProcessOrder()));

        //p.process(order);
        p1.process(order);


    }

    public static Order createOrder() {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter order ID: ");
//        String ID = sc.nextLine();
//        System.out.print("Enter client's name: ");
//        String from = sc.nextLine();
//        System.out.print("Enter client's order: ");
//        String text = sc.nextLine();

        String ID = "000";
        String from = "Client";
        String text = "Peperoni";


        return OrderBuilder.builder()
                .ID(ID)
                .from(from)
                .text(text)
                .build();
    }


}
