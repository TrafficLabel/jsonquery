package com.lindar.jsonquery;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.lindar.jsonquery.ast.Node;
import com.lindar.jsonquery.ast.group.LogicalNode;
import com.lindar.jsonquery.ast.rule.StringComparisonNode;
import com.lindar.jsonquery.ast.rule.StringComparisonOperation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.ArrayList;

@RunWith(value = JUnit4.class)
public class TestJsonQuery {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testParsing() throws IOException {
        String jsonWithBadQuotes = "{'conditions':{" +
                "'type':'.LogicalNode'," +
                "'operation':'AND'," +
                "'reference':'f47b8890-8028-4122-ab09-2bfb1764dc09'," +
                "'enabled':true," +
                "'items':[" +
                "  {'type':'.BigDecimalComparisonNode'," +
                "   'reference':'hTRcpjplfZ'," +
                "   'enabled':true," +
                "   'negate':false," +
                "   'field':'numDeposits'," +
                "   'operation':'GREATER_THAN_OR_EQUAL'," +
                "   'value':[2]" +
                "  }," +
                "  {" +
                "    'type':'.LogicalNode'," +
                "    'reference':'d545e2e7-da91-43bd-970a-4755bb94b39a'," +
                "    'operation':'OR'," +
                "    'items':[" +
                "        {'type':'.BigDecimalComparisonNode'," +
                "         'reference':'f3b80c55-044d-413d-8d5a-522264123676'," +
                "         'operation':'GREATER_THAN'," +
                "         'negate':false," +
                "         'field':'deposits'," +
                "         'value':['100']}," +
                "        {'type':'.BigDecimalComparisonNode'," +
                "         'reference':'894fd17a-d77c-4392-a91c-1cdce745d023'," +
                "         'operation':'GREATER_THAN'," +
                "         'negate':false," +
                "         'field':'numDeposits'," +
                "         'value':['5']}]}," +
                "        {'type':'.RelatedRelationshipNode'," +
                "         'reference':'1c407b8b-8f85-452c-860f-47164fa63d2c'," +
                "         'field':'players'," +
                "         'conditions':{" +
                "           'type':'.LogicalNode'," +
                "           'reference':'f45f5254-2ff0-475b-9626-d97508a6a76b'," +
                "           'operation':'AND'," +
                "           'items':[" +
                "             {'type':'.LookupComparisonNode'," +
                "              'reference':'441ca9dd-c0c0-4728-909d-39695d0297ec'," +
                "              'operation':'EQUALS'," +
                "              'negate':false," +
                "              'field':'brand.id'," +
                "              'value':[4]" +
                "             }" +
                "           ]" +
                "         }," +
                "         'aggregations':{" +
                "           'type':'.LogicalAggregateNode'," +
                "           'reference':'ea9f0005-7135-4f74-b5c3-840c7352dfb7'," +
                "           'operation':'AND'," +
                "           'negate':false," +
                "           'items':[" +
                "             {'type':'.BigDecimalComparisonAggregateNode'," +
                "              'aggregateOperation':'SUM'," +
                "              'reference':'81b364fe-331d-42f1-aa4f-bcf3c5eed36c'," +
                "              'operation':'GREATER_THAN'," +
                "              'negate':false," +
                "              'field':'deposits'," +
                "             'value':['50']}]}}]}}";
        String json = jsonWithBadQuotes.replace("'", "\"");
        JsonQuery query = objectMapper.readValue(json, JsonQuery.class);
        Assert.assertNotNull(query);
    }

    @Test
    public void test() throws JsonProcessingException {

        StringComparisonNode stringNode = new StringComparisonNode();
        stringNode.setField("username");
        stringNode.setOperation(StringComparisonOperation.BEGINS_WITH);
        ArrayList<String> values = new ArrayList<>();
        values.add("random");
        stringNode.setValue(values);

        ArrayList<Node> nodes = Lists.newArrayList();
        nodes.add(stringNode);

        LogicalNode andNode = new LogicalNode();
        andNode.setItems(nodes);

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(andNode));
    }
}
