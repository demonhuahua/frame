package com.lvmoney.quartz.entity;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2018年9月30日 上午8:51:33
 */

public class SynRule {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column res_syn_rule.syn_rule_no
     *
     * @mbggenerated Mon Nov 05 15:25:21 CST 2018
     */
    private Integer synRuleNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column res_syn_rule.type
     *
     * @mbggenerated Mon Nov 05 15:25:21 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column res_syn_rule.cron
     *
     * @mbggenerated Mon Nov 05 15:25:21 CST 2018
     */
    private String cron;

    private Integer valid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column res_syn_rule.syn_rule_no
     *
     * @return the value of res_syn_rule.syn_rule_no
     * @mbggenerated Mon Nov 05 15:25:21 CST 2018
     */
    public Integer getSynRuleNo() {
        return synRuleNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column res_syn_rule.syn_rule_no
     *
     * @param synRuleNo the value for res_syn_rule.syn_rule_no
     * @mbggenerated Mon Nov 05 15:25:21 CST 2018
     */
    public void setSynRuleNo(Integer synRuleNo) {
        this.synRuleNo = synRuleNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column res_syn_rule.type
     *
     * @return the value of res_syn_rule.type
     * @mbggenerated Mon Nov 05 15:25:21 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column res_syn_rule.type
     *
     * @param type the value for res_syn_rule.type
     * @mbggenerated Mon Nov 05 15:25:21 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column res_syn_rule.cron
     *
     * @return the value of res_syn_rule.cron
     * @mbggenerated Mon Nov 05 15:25:21 CST 2018
     */
    public String getCron() {
        return cron;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column res_syn_rule.cron
     *
     * @param cron the value for res_syn_rule.cron
     * @mbggenerated Mon Nov 05 15:25:21 CST 2018
     */
    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}