package com.sav;

import com.sav.entities.Order;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ValidateProcessOrder implements ProcessOrder {
    private ProcessOrder processor;

    public ValidateProcessOrder(ProcessOrder processor) {
        this.processor = processor;
    }

    @Override
    public void process(Order o) {
        System.out.println("ORDER VALIDATION IN ACTION");
        if (o.getID() == null || o.getFrom() == null || o.getText() == null) {
            System.out.println("Order is not valid");
        } else {
            System.out.println("Order is valid");
        }

        if (processor!=null) processor.process(o);
    }
}
