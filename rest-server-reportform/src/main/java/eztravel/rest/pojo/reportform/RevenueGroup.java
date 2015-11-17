package eztravel.rest.pojo.reportform;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class RevenueGroup implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = -3415987005471459755L;
  
  /** The group date. */
  private String g_date;
  
  /** The region name. */
  private String code_name;
  
  /** daily_cnt list */
  private Map<String,String> daily_cnt;
  
  /** daily_amt list */
  private Map<String,String> daily_amt;

  public String getG_date() {
    return g_date;
  }

  public void setG_date(String g_date) {
    this.g_date = g_date;
  }
  
  public String getCode_name() {
    return code_name;
  }

  public void setCode_name(String code_name) {
    this.code_name = code_name;
  }

  public Map<String,String> getDaily_cnt() {
    return daily_cnt;
  }

  public void setDaily_cnt(Map<String,String> daily_cnt) {
    this.daily_cnt = daily_cnt;
  }

  public Map<String,String> getDaily_amt() {
    return daily_amt;
  }

  public void setDaily_amt(Map<String,String> daily_amt) {
    this.daily_amt = daily_amt;
  }
  
  

 
}
