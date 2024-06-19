package com.fastporte.fastportewebservice.controller.mappers.request;

import com.fastporte.fastportewebservice.entities.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContractRequest {

    private String subject;
    private String from;
    private String to;
    private String contractDate;
    private String timeDeparture;
    private String timeArrival;
    private String amount;
    private String quantity;
    private String description;

    @Override
    public String toString() {
        return "subject: " + subject + "\n" +
                "from: " + from + "\n" +
                "to: " + to + "\n" +
                "contractDate: " + contractDate + "\n" +
                "timeDeparture: " + timeDeparture + "\n" +
                "timeArrival: " + timeArrival + "\n" +
                "amount: " + amount + "\n" +
                "quantity: " + quantity + "\n" +
                "description: " + description;
    }

}
