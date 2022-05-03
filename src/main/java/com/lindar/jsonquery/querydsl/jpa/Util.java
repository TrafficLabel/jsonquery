package com.lindar.jsonquery.querydsl.jpa;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class Util {
    public static boolean isPredicateEmpty(Predicate predicate) {
        if (predicate == null) {
            return true;
        }

        if (predicate instanceof BooleanBuilder) {
            return !((BooleanBuilder) predicate).hasValue();
        }

        return "".equals(predicate.toString());
    }
}
