package com.twog.shopping.ebproj.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;

@Data
public class MenuDTO {

    private int menuCode;
    private String menuName;
    private String menuPrice;
    private int categoryCode;
    private String orderableStatus;
}
