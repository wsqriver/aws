package com.spring.service.impl;

import com.spring.service.Calculate;

public class CalculateImpl implements Calculate {
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void select() {
        System.out.println("select");
    }
}
