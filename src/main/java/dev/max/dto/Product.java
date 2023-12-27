package dev.max.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String entryDate;
    private Integer itemCode;
    private String itemName;
    private Integer itemQuantity;
    private String status;
}