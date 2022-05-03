package com.lindar.jsonquery.querydsl.sql;

import com.querydsl.core.types.Predicate;

public class Util {
    public static boolean isPredicateEmpty(Predicate predicate){
        return predicate == null || "".equals(predicate.toString());
    }
}
