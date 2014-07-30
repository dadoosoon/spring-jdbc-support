/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.spring.jdbc.support.condition;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author shuwen.zsw
 */
@Data
@AllArgsConstructor
public class Condition {
  
  protected String field;
  protected Operation op;
  protected Object value;

}
