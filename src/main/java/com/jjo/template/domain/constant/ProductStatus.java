package com.jjo.template.domain.constant;

public enum ProductStatus {
    ON("on", "화설화"),
    OFF("off", "비활성"),
    SOLD_OUT("solOut", "품절");

    private final String value;
    private final String label;

    ProductStatus(final String value, final String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
