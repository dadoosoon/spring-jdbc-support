/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package im.dadoo.spring.jdbc.support;

import im.dadoo.spring.jdbc.support.condition.Condition;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author shuwen.zsw
 */
public final class Criteria {
  
  private Criteria() {}

  public static final String where(final List<Condition> conditions) {
    StringBuilder sb = new StringBuilder("");
    if (conditions != null && !conditions.isEmpty()) {
      Condition condition = conditions.get(0);
      if (condition != null) {
        sb.append(" WHERE ").append(makeConditionSql(condition));
        for (int i = 1; i < conditions.size(); i++) {
          sb.append(" AND ").append(makeConditionSql(conditions.get(i)));
        }
      }
    }
    return sb.toString();
  }
  
  private static String makeConditionSql(Condition condition) {
    StringBuilder sb = new StringBuilder();
    if (condition != null && condition.getField() != null 
            && condition.getOp() != null && condition.getValue() != null) {
      switch(condition.getOp()) {
        case EQ:
        case NE:
        case GT:
        case GE:
        case LT:
        case LE:
        case LIKE:
          sb.append(condition.getField()).append(" ")
                  .append(condition.getOp().getName()).append(" ")
                  .append(condition.getValue());
          break;
        case BETWEEN:
          Pair<String, String> pair = (Pair<String, String>)condition.getValue();
          sb.append(condition.getField()).append(" ")
                  .append(condition.getOp().getName()).append(" ")
                  .append(pair.getLeft()).append(" ")
                  .append("AND").append(" ")
                  .append(pair.getRight());
          break;
        case IN:
          sb.append(condition.getField()).append(" ")
                    .append(condition.getOp().getName()).append(" ")
                    .append("( ").append(condition.getValue()).append(" )");
          break;
      }
    }
    return sb.toString();
  }
}
