package com.lindar.jsonquery.ast.rule;

import com.lindar.jsonquery.ast.BaseNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by stevenhills on 24/09/2016.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class ComparisonNode extends BaseNode {

    private boolean negate = false;
    private String field;
}
