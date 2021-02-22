package com.sav.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Order {
    private String ID;
    private String from;
    private String text;
}
