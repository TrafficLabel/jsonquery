package com.lindar.jsonquery.querydsl.jpa.domain;

import javax.persistence.AttributeConverter;

public class AffiliateTypeConverter implements AttributeConverter<AffiliateType, String> {
    @Override
    public String convertToDatabaseColumn(AffiliateType affiliateType) {
        if(affiliateType == null){
            return null;
        }
        return affiliateType.getType();
    }

    @Override
    public AffiliateType convertToEntityAttribute(String variation) {
        return AffiliateType.getInstance(variation);
    }
}