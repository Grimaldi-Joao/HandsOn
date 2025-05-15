package com.UnicapHandsOn.HandsOn.Entities.Enum;



public enum pedidoStatus {
    
    WATING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private pedidoStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static pedidoStatus valueOf(int code){
        for(pedidoStatus value: pedidoStatus.values()){
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
