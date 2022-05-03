package com.lindar.jsonquery.ast.rule;

import com.lindar.jsonquery.visitor.JsonQueryVisitor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class DateLocalDateComparisonNode extends BaseDateComparisonNode<LocalDate> {

    @Override
    public <R, C> R accept(JsonQueryVisitor<R, C> v, C context) {
        return v.visit(this, context);
    }
}
