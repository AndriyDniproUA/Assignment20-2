package com.sav;

import com.sav.entities.Order;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PrintProcessOrder implements ProcessOrder{
    private ProcessOrder processor;

    public PrintProcessOrder(ProcessOrder processor) {
        this.processor = processor;
    }

    @Override
    public void process(Order o) {
        System.out.println("ORDER PRINTING IN ACTION");
        System.out.println("This is your order:");
        System.out.println("Order ID: "+o.getID());
        System.out.println("Client: "+o.getFrom());
        System.out.println("Order contents: "+o.getText());

        if (processor!=null) processor.process(o);
    }
}
