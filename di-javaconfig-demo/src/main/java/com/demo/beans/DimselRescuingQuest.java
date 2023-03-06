package com.demo.beans;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class DimselRescuingQuest implements Quest, Ordered {
    @Override
    public String goQuest() {
        return "Knight rescue the dimsel.";
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
