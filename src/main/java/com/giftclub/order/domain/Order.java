package com.giftclub.order.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class Order {
    private int id;
    private int senderId;
    private int receiverId;
    private String recipientAddressId;
    private List<OrderItem> orderItems;
    private int deliveryId;
    private int price;
    private Date orderDate;
    private OrderStatus orderStatus;
    private boolean orderConfirmYn = false;    //구매확정여부
    private LocalDate orderConfirmDt;    //구매확정일시
    private boolean returnYn = false;    //반품여부
    private Date returnRequestDt;    //반품요청일시
    private Date returnArrivalDt;    //반품입고일시
    private String refundAccountNumber;    //환불계좌번호
    private String refundBankName;    //환불은행명
    private String refundAccountHolderName;    //환불예금주성명
    private BigDecimal refundAmount;    //환불금액
    private LocalDate refundCompletionDt;    //환불완료일시

    public enum OrderStatus {
        BEFORE_PAYMENT, ORDER_REQUEST, ORDER_APPROVAL, IN_DELIVERY, DELIVERY_COMPLETE
    }


}
