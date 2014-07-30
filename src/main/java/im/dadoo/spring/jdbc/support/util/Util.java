/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.spring.jdbc.support.util;

/**
 *
 * @author shuwen.zsw
 */
public final class Util {
  
  private Util() {}
  
  public static String placeholder(String field) {
    return ":" + field;
  }
}
