package com.lindar.jsonquery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lindar.jsonquery.ast.group.LogicalNode;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonQuery implements Serializable{
    private LogicalNode conditions = new LogicalNode();
}
