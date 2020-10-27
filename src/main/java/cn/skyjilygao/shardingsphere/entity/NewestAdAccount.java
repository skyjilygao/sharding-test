package cn.skyjilygao.shardingsphere.entity;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author huangyifeng
 * @date 2019/9/23
 **/
@Data
@ApiModel(value="广告账户最新数据",description="广告账户最新数据对象")
public class NewestAdAccount implements Serializable {
    @ApiModelProperty(value="id",name="id")
    private Integer id;
    @ApiModelProperty(value="广告账户id",name="accountId")
    private String accountId;
    @ApiModelProperty(value="名称",name="name")
    private String name;
    @ApiModelProperty(value="账户状态",name="accountStatus")
    private Integer accountStatus;
    private String accountStatusStr;
    @ApiModelProperty(value="广告账户状态对应原因",name="disableReason")
    private Integer disableReason;
    private String disableReasonStr;
    @ApiModelProperty(value="账户使用年龄",name="age")
    private Double age;
    @ApiModelProperty(value="账户金额单位",name="currency")
    private String currency;
    @ApiModelProperty(value="账单金额到期",name="balance")
    private Long balance;
    @ApiModelProperty(value="账户花费上限",name="spendCap")
    private Long spendCap;
    @ApiModelProperty(value="账户时区编号",name="timezoneId")
    private Integer timezoneId;
    @ApiModelProperty(value="账户时区名称",name="timezoneName")
    private String timezoneName;
    @ApiModelProperty(value="账户",name="timezoneOffsetHoursUtc")
    private Integer timezoneOffsetHoursUtc;
    @ApiModelProperty(value="花费金额",name="amountSpent")
    private Long amountSpent;
    @ApiModelProperty(value="创建时间",name="createdTime")
    private Date createdTime;
    @ApiModelProperty(value="数据添加时间",name="gmtCreate")
    private Date gmtCreate;
    @ApiModelProperty(value="数据修改时间",name="gmtModified")
    private Date gmtModified;

    private double allSpendYday;
    private double day7SpendYday;
    private double day1SpendYday;
    private double nowQuarterSpendYday;


    public void adAccount(JSONObject json){
        this.accountId =  json.getString("id");
        this.name = json.getString("name");
        this.accountStatus = json.getIntValue("account_status");
        this.disableReason = json.getIntValue("disable_reason");
        this.age = json.getDouble("age");
        this.currency = json.getString("currency");
        this.balance = json.getLongValue("balance");
        this.spendCap = json.getLongValue("spend_cap");
        this.timezoneId = json.getIntValue("timezone_id");
        this.timezoneName = json.getString("timezone_name");
        this.timezoneOffsetHoursUtc = json.getIntValue("timezone_offset_hours_utc");
        this.amountSpent = json.getLongValue("amount_spent");

        String createdTimeStr = json.getString("created_time");
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        ZonedDateTime parse2 = ZonedDateTime.parse(createdTimeStr, FORMATTER);
        // 只保留年月日时分秒，不要时区。再以系统默认时区转成date。这样就保证数据库表中时间拼接时区后跟fb时间相同
        LocalDateTime localDateTime = LocalDateTime.of(parse2.getYear(), parse2.getMonth(), parse2.getDayOfMonth(), parse2.getHour(), parse2.getMinute(), parse2.getSecond());
        ZonedDateTime dateTime = localDateTime.atZone(ZoneId.systemDefault());
        this.createdTime = Date.from(dateTime.toInstant());

        this.gmtCreate = new Date();
        this.gmtModified = new Date();
    }


}
