/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.spring.jdbc.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author shuwen.zsw
 * @param <V1>
 * @param <V2>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Pair<V1, V2> {
  
  private V1 v1;
  private V2 v2;
  
  public static <V1, V2> Pair of(V1 v1, V2 v2) {
    return new Pair(v1, v2);
  }
}
