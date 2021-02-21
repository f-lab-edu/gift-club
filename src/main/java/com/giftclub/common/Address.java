package com.giftclub.common;

import lombok.Data;

@Data
public class Address {
    private int id;
    // 기본 주소
    private Boolean isDefaultAddress;
    // 주소명
    private String addressName;
    // 시도명
    private String cityName;
    // 시군구명
    private String cityCountryName;
    // 읍면동명
    private String townName;
    // 도로명코드
    private String roadNameCode;
    // 도로명
    private String roadName;
    // 우편번호
    private String zipCode;
    // 상세건물명
    private String detailBuildingName;
}
