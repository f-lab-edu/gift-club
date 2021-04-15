package com.giftclub.giftCard;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GiftCard {

    private Long id;

    @Setter
    @NonNull
    private Long toMemberId;

    @NonNull
    private Long fromMemberId;

    @NonNull
    private String content;

    private GiftCardStatus giftCardStatus;

    @NonNull
    private Long productId;

    @NonNull
    private Long payId;

    public enum GiftCardStatus {
        COMPLETE, ERROR;
    }
}
