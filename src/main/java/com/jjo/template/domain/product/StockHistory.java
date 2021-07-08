package com.jjo.template.domain.product;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(
    name = "stock_history",
    indexes = {
        @Index(name = "idx_stock_history_sales_product_number", columnList = "salesProductNumber"),
        @Index(name = "idx_stock_history_user_id", columnList = "userId"),
        @Index(name = "idx_stock_history_product_id", columnList = "productId")
    }
)
public class StockHistory {
    @NonNull
    @Column(name = "user_id")
    private Long userId;

    @NonNull
    @Column(name = "product_id")
    private Long productId;

    @NonNull
    @Column(name = "invest_date")
    private Date investDate;
}
