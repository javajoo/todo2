package com.todo.todo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="goods")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Goods {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String goodsId;

    private String goodsName;

    // goods='NO-2', goodsName="치토스"
    // select * from goods where goodsId='NO-2' and goodsName='치토스';

    private Long goodsPrice;

    private Long goodsCount;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;


    public Goods changeGoods(Goods goods) {
        this.goodsId = goods.getGoodsId();
        this.goodsName = goods.getGoodsName();
        this.goodsPrice = goods.getGoodsPrice();
        this.goodsCount = goods.getGoodsCount();
        return this;
    }

}
