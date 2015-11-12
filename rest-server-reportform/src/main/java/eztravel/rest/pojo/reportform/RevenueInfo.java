package eztravel.rest.pojo.reportform;

import java.io.Serializable;
import java.math.BigDecimal;

public class RevenueInfo implements Serializable {

  /**The Class RevenueInfo.
   * 
   */
  private static final long serialVersionUID = 2886062176683953993L;
  
  
  /** The order date. */
  private String order_Dt;
  
  /** region name */
  private String code_name;
  
  /** order count */
  private String ord_Cnt;
  
  /** The order amount. */
  private String ord_Amt;

  public String getOrder_Dt() {
    return order_Dt;
  }

  public void setOrder_Dt(String order_Dt) {
    this.order_Dt = order_Dt;
  }

  public String getCode_name() {
    return code_name;
  }

  public void setCode_name(String code_name) {
    this.code_name = code_name;
  }

  public String getOrd_Cnt() {
    return ord_Cnt;
  }

  public void setOrd_Cnt(String ord_Cnt) {
    this.ord_Cnt = ord_Cnt;
  }

  public String getOrd_Amt() {
    return ord_Amt;
  }

  public void setOrd_Amt(String ord_Amt) {
    this.ord_Amt = ord_Amt;
  } 
  

}
