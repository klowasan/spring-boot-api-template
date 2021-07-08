package com.jjo.template.domain.product;

import com.jjo.template.domain.constant.ProductStatus;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @NonNull
    @Column(unique = true)
    private String name;

    @NonNull
    @Column(name = "product_category_id")
    private BigDecimal productCategoryId;

    @NonNull
    @Column(name = "total_investing_amount")
    private BigDecimal totalInvestingAmount;

    @NonNull
    @Column(name = "current_recruitment_amount")
    private BigDecimal currentRecruitmentAmount;

    private ProductStatus productStatus;
}
