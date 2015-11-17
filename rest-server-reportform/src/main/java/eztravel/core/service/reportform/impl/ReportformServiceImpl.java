/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: eztravel.core.service.reportform.impl
 * @FileName: ReportformServiceImpl.java
 * @date: 2015/1/7, 上午 09:32:41
 * 
 * <pre>
 *  Copyright 2013-2014 The ezTravel Co., Ltd. all rights reserved.
 *
 *  NOTICE:  All information contained herein is, and remains
 *  the property of ezTravel Co., Ltd. and its suppliers,
 *  if any.  The intellectual and technical concepts contained
 *  herein are proprietary to ezTravel Co., Ltd. and its suppliers
 *  and may be covered by TAIWAN and Foreign Patents, patents in 
 *  process, and are protected by trade secret or copyright law.
 *  Dissemination of this information or reproduction of this material
 *  is strictly forbidden unless prior written permission is obtained
 *  from ezTravel Co., Ltd.
 *  </pre>
 */
package eztravel.core.service.reportform.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import eztravel.core.service.reportform.ReportformService;
import eztravel.persistence.repository.reportform.ReportformRepository;
import eztravel.rest.pojo.reportform.RevenueGroup;
import eztravel.rest.pojo.reportform.RevenueInfo;



/**
 * <pre>
 * PaymentServiceImpl, TODO: add Class Javadoc here.
 * </pre>
 * 
 */
public class ReportformServiceImpl implements ReportformService {

  /** The Constant logger. */
  @SuppressWarnings("unused")
  private static final Logger logger = LoggerFactory.getLogger(ReportformServiceImpl.class);

  /** The reportform repository. */
  private ReportformRepository reportformRepository;

  /** The reportform prop. */
  @Autowired
  private Properties reportformProp;

  /**
   * Instantiates a new reportform service impl.
   * 
   * @param reportformRepository the reportform repository
   */
  public ReportformServiceImpl(ReportformRepository reportformRepository) {
    super();
    this.reportformRepository = reportformRepository;
  }

  @Override
  public String doSomething() {
    Map<String, Object> map = new HashMap<String, Object>();
    return String.valueOf(reportformRepository.getSomething(map));
  }

  @Override
  public List<Map<String, Object>> getMonthRevenue(String date, String region) {
    
    List<RevenueInfo> revenueInfo = reportformRepository.getMonthRevenue(date,region);
    
    //塞入每月訂單數量
    String[] ord_cnt_arr= new String[12];
    //塞入每月訂單金額
    String[] ord_amt_arr= new String[12];
    
    int i=0;
    for(RevenueInfo revenueinfo : revenueInfo ){  
      ord_cnt_arr[i]=revenueinfo.getOrd_Cnt();
      ord_amt_arr[i]=revenueinfo.getOrd_Amt();
      i++; 
    }
    ord_cnt_arr=getCnt_Amt(ord_cnt_arr);
    ord_amt_arr=getCnt_Amt(ord_amt_arr);
    
    Map<String, Object> monthResult = new HashMap<String,Object>();
    
    monthResult.put(date+"每月訂單", ord_cnt_arr);
    monthResult.put(date+"每月金額", ord_amt_arr);
    monthResult.put("local", date+"-"+region);
    
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    
    list.add(monthResult);
    
//    Map<String,List<Map<String, Object>>> result = new HashMap<String, List<Map<String, Object>>>();
//    
//    result.put(date+"-"+region, list);
   
    
    return list;
  }
  
  //判斷當月沒訂單或金額數量0
  public String[] getCnt_Amt(String[] arr){
    
    for(int x =0 ;x<arr.length ; x++){
      arr[x]= (arr[x]== null? "0" : arr [x]);
    }   
    return arr;
    
  }

  
  @Override
  public List<Map<String, Object>> getRevenue(String date) {
    
    List<RevenueInfo> revenueInfo = reportformRepository.getRevenue(date);
   
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    if(revenueInfo==null || revenueInfo.size()==0){
      return list;
    }
   
    
//    Map<String,String> dy_count=null ,dy_amount= null;
//    List<String> hasDays=new ArrayList<String>();
//    
//    List<RevenueGroup> groups= new ArrayList<RevenueGroup>();
//    
//    String g_date=null;
//    
//      
//    for(RevenueInfo revenueinfo : revenueInfo ){
//  
//      //日期字串切割成年月比較
//      if (!revenueinfo.getOrder_Dt().substring(0, 6).equals(g_date)) {
//        g_date = revenueinfo.getOrder_Dt().substring(0, 6);
//        
//        RevenueGroup group=new RevenueGroup();
//        groups.add(group);
//        dy_count = new TreeMap<String,String>();
//        dy_amount = new TreeMap<String,String>();
//        
//        group.setDaily_cnt(dy_count);
//        group.setDaily_amt(dy_amount);
//        group.setG_date(revenueinfo.getOrder_Dt().substring(0, 6));
//        
//      }
//     
//        //先把有訂單跟金額的日期存起來
//        hasDays.add(revenueinfo.getOrder_Dt());
//          
//      
//        dy_count.put(revenueinfo.getOrder_Dt().substring(6, 8),revenueinfo.getOrd_Cnt());
//        dy_amount.put(revenueinfo.getOrder_Dt().substring(6, 8),revenueinfo.getOrd_Amt());
//      
//    }
//    
//    //the month all days
//    List<String> monthdays=CalendarDay(date.substring(0,4),date.substring(4,6));
//    
//    for(String day: monthdays){
//      if(!hasDays.contains(day)){
//        dy_count.put(day.substring(6, 8),"0");
//        dy_amount.put(day.substring(6, 8),"0");
//      }
//    }
//    
//    
//    Map<String, Object> result = new TreeMap<String, Object>();
//    
//    for(RevenueGroup group :groups){
//      result.put(group.getG_date()+"金額", group.getDaily_amt());
//      result.put(group.getG_date()+"訂單", group.getDaily_cnt());
//      result.put("local", date+"-"+region);
//    }
//    
//    list.add(result);
    
    Map<String,String> dy_count=null ,dy_amount= null;
    List<String> hasDays=new ArrayList<String>();
  
    List<RevenueGroup> groups= new ArrayList<RevenueGroup>();
  
    String code_name=null;
    
    for(RevenueInfo revenueinfo : revenueInfo ){
    
        //比較區域
        if (!revenueinfo.getCode_name().equals(code_name)) {
          code_name = revenueinfo.getCode_name();
          
          RevenueGroup group=new RevenueGroup();
          groups.add(group);
          dy_count = new TreeMap<String,String>();
          dy_amount = new TreeMap<String,String>();
          
          group.setCode_name(revenueinfo.getCode_name());
          group.setDaily_cnt(dy_count);
          group.setDaily_amt(dy_amount);
          group.setG_date(revenueinfo.getOrder_Dt().substring(0, 6));

        }
        
        //先把有訂單跟金額的日期存起來 ==> 地區:日期
        hasDays.add(revenueinfo.getCode_name()+":"+revenueinfo.getOrder_Dt());  
        
        dy_count.put(revenueinfo.getOrder_Dt().substring(6, 8),revenueinfo.getOrd_Cnt());
        dy_amount.put(revenueinfo.getOrder_Dt().substring(6, 8),revenueinfo.getOrd_Amt());
         
    }
    
      
  //the month all days
  List<String> monthdays=CalendarDay(date.substring(0,4),date.substring(4,6));
  
    for(RevenueGroup group :groups){
      
      Map<String, Object> result = new LinkedHashMap<String, Object>();
      
      //對該區日期沒有訂單金額0
     for(String day: monthdays){
       if(!hasDays.contains(group.getCode_name()+":"+day)){   
         group.getDaily_cnt().put(day.substring(6, 8),"0");
         group.getDaily_amt().put(day.substring(6, 8),"0");
       }
     }  
      //----------end 
     
      result.put(group.getG_date()+"金額", group.getDaily_amt());
      result.put(group.getG_date()+"訂單", group.getDaily_cnt());  
      result.put("local", date+"-"+group.getCode_name());
      list.add(result);
    }
     
    return list;
  }
  
  //get the year month all day
  public List<String> CalendarDay(String year , String month){
    
    int ann=Integer.valueOf(year);   //年
    int mois=Integer.valueOf(month); //月
    
    int remois = mois - 1;
    Calendar cal = new GregorianCalendar(ann,remois,1);  
    int day = cal. getActualMaximum(Calendar.DATE); //取得當月最大天數
    int day_of_month = cal.get(Calendar.DAY_OF_MONTH);//當月的第一天
    
    List<String> listday= new ArrayList<String>();
    
    for(day_of_month = 1 ; day_of_month <= day ; day_of_month++){//此for迴圈是要將日期印出來
        if(day_of_month<10){  //若那一天是個位數的印法
        listday.add(year+month+"0"+day_of_month);
        //System.out.println(year+month+"0"+day_of_month);
        }else{  //十位數的印法
       // System.out.println(year+month+day_of_month);
        listday.add(year+month+day_of_month);
        }                 
    }   
    return listday; 
  }
  
}
