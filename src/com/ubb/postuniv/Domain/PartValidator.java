package com.ubb.postuniv.Domain;

import java.util.ArrayList;
import java.util.List;

public class PartValidator {

    public void validate(Part part) throws Exception {
        StringBuilder sb = new StringBuilder();

        if (part.getPrice() < 0) {
            sb.append("The price cannot be negative!\n");
        }

        String type = part.getType();
        if (!type.equals("OEM") && !type.equals("AM") && !type.equals("SH")) {
            sb.append("The type must be one of: OEM, AM, SH\n");
        }

        if (sb.length() > 0) {
            throw new Exception(sb.toString());
        }
    }
}
