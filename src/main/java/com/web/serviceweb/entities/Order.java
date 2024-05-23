package com.web.serviceweb.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.serviceweb.Enum.OrderEnum;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order() {
    }

    public Order(Long id, Instant moment, OrderEnum orderStatus, User client) {
        super();
        this.id = id;
        this.moment = moment;
        this.client = client;
        setOrderStatus(orderStatus);
    }

    public OrderEnum getOrderStatus() {
        return OrderEnum.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderEnum orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
        OrderEnum.valueOf(this.orderStatus);
    }

}
