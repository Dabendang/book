package edu.fjut.bookshop.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("orderId like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("orderId not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("orderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderId not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andBooknameIsNull() {
            addCriterion("bookName is null");
            return (Criteria) this;
        }

        public Criteria andBooknameIsNotNull() {
            addCriterion("bookName is not null");
            return (Criteria) this;
        }

        public Criteria andBooknameEqualTo(String value) {
            addCriterion("bookName =", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotEqualTo(String value) {
            addCriterion("bookName <>", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameGreaterThan(String value) {
            addCriterion("bookName >", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameGreaterThanOrEqualTo(String value) {
            addCriterion("bookName >=", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLessThan(String value) {
            addCriterion("bookName <", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLessThanOrEqualTo(String value) {
            addCriterion("bookName <=", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLike(String value) {
            addCriterion("bookName like", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotLike(String value) {
            addCriterion("bookName not like", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameIn(List<String> values) {
            addCriterion("bookName in", values, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotIn(List<String> values) {
            addCriterion("bookName not in", values, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameBetween(String value1, String value2) {
            addCriterion("bookName between", value1, value2, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotBetween(String value1, String value2) {
            addCriterion("bookName not between", value1, value2, "bookname");
            return (Criteria) this;
        }

        public Criteria andBuydataIsNull() {
            addCriterion("buyData is null");
            return (Criteria) this;
        }

        public Criteria andBuydataIsNotNull() {
            addCriterion("buyData is not null");
            return (Criteria) this;
        }

        public Criteria andBuydataEqualTo(Date value) {
            addCriterion("buyData =", value, "buydata");
            return (Criteria) this;
        }

        public Criteria andBuydataNotEqualTo(Date value) {
            addCriterion("buyData <>", value, "buydata");
            return (Criteria) this;
        }

        public Criteria andBuydataGreaterThan(Date value) {
            addCriterion("buyData >", value, "buydata");
            return (Criteria) this;
        }

        public Criteria andBuydataGreaterThanOrEqualTo(Date value) {
            addCriterion("buyData >=", value, "buydata");
            return (Criteria) this;
        }

        public Criteria andBuydataLessThan(Date value) {
            addCriterion("buyData <", value, "buydata");
            return (Criteria) this;
        }

        public Criteria andBuydataLessThanOrEqualTo(Date value) {
            addCriterion("buyData <=", value, "buydata");
            return (Criteria) this;
        }

        public Criteria andBuydataIn(List<Date> values) {
            addCriterion("buyData in", values, "buydata");
            return (Criteria) this;
        }

        public Criteria andBuydataNotIn(List<Date> values) {
            addCriterion("buyData not in", values, "buydata");
            return (Criteria) this;
        }

        public Criteria andBuydataBetween(Date value1, Date value2) {
            addCriterion("buyData between", value1, value2, "buydata");
            return (Criteria) this;
        }

        public Criteria andBuydataNotBetween(Date value1, Date value2) {
            addCriterion("buyData not between", value1, value2, "buydata");
            return (Criteria) this;
        }

        public Criteria andBuynumberIsNull() {
            addCriterion("buyNumber is null");
            return (Criteria) this;
        }

        public Criteria andBuynumberIsNotNull() {
            addCriterion("buyNumber is not null");
            return (Criteria) this;
        }

        public Criteria andBuynumberEqualTo(Integer value) {
            addCriterion("buyNumber =", value, "buynumber");
            return (Criteria) this;
        }

        public Criteria andBuynumberNotEqualTo(Integer value) {
            addCriterion("buyNumber <>", value, "buynumber");
            return (Criteria) this;
        }

        public Criteria andBuynumberGreaterThan(Integer value) {
            addCriterion("buyNumber >", value, "buynumber");
            return (Criteria) this;
        }

        public Criteria andBuynumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyNumber >=", value, "buynumber");
            return (Criteria) this;
        }

        public Criteria andBuynumberLessThan(Integer value) {
            addCriterion("buyNumber <", value, "buynumber");
            return (Criteria) this;
        }

        public Criteria andBuynumberLessThanOrEqualTo(Integer value) {
            addCriterion("buyNumber <=", value, "buynumber");
            return (Criteria) this;
        }

        public Criteria andBuynumberIn(List<Integer> values) {
            addCriterion("buyNumber in", values, "buynumber");
            return (Criteria) this;
        }

        public Criteria andBuynumberNotIn(List<Integer> values) {
            addCriterion("buyNumber not in", values, "buynumber");
            return (Criteria) this;
        }

        public Criteria andBuynumberBetween(Integer value1, Integer value2) {
            addCriterion("buyNumber between", value1, value2, "buynumber");
            return (Criteria) this;
        }

        public Criteria andBuynumberNotBetween(Integer value1, Integer value2) {
            addCriterion("buyNumber not between", value1, value2, "buynumber");
            return (Criteria) this;
        }

        public Criteria andBuypriceIsNull() {
            addCriterion("buyPrice is null");
            return (Criteria) this;
        }

        public Criteria andBuypriceIsNotNull() {
            addCriterion("buyPrice is not null");
            return (Criteria) this;
        }

        public Criteria andBuypriceEqualTo(BigDecimal value) {
            addCriterion("buyPrice =", value, "buyprice");
            return (Criteria) this;
        }

        public Criteria andBuypriceNotEqualTo(BigDecimal value) {
            addCriterion("buyPrice <>", value, "buyprice");
            return (Criteria) this;
        }

        public Criteria andBuypriceGreaterThan(BigDecimal value) {
            addCriterion("buyPrice >", value, "buyprice");
            return (Criteria) this;
        }

        public Criteria andBuypriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("buyPrice >=", value, "buyprice");
            return (Criteria) this;
        }

        public Criteria andBuypriceLessThan(BigDecimal value) {
            addCriterion("buyPrice <", value, "buyprice");
            return (Criteria) this;
        }

        public Criteria andBuypriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("buyPrice <=", value, "buyprice");
            return (Criteria) this;
        }

        public Criteria andBuypriceIn(List<BigDecimal> values) {
            addCriterion("buyPrice in", values, "buyprice");
            return (Criteria) this;
        }

        public Criteria andBuypriceNotIn(List<BigDecimal> values) {
            addCriterion("buyPrice not in", values, "buyprice");
            return (Criteria) this;
        }

        public Criteria andBuypriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buyPrice between", value1, value2, "buyprice");
            return (Criteria) this;
        }

        public Criteria andBuypriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buyPrice not between", value1, value2, "buyprice");
            return (Criteria) this;
        }

        public Criteria andBuyaddressIsNull() {
            addCriterion("buyAddress is null");
            return (Criteria) this;
        }

        public Criteria andBuyaddressIsNotNull() {
            addCriterion("buyAddress is not null");
            return (Criteria) this;
        }

        public Criteria andBuyaddressEqualTo(String value) {
            addCriterion("buyAddress =", value, "buyaddress");
            return (Criteria) this;
        }

        public Criteria andBuyaddressNotEqualTo(String value) {
            addCriterion("buyAddress <>", value, "buyaddress");
            return (Criteria) this;
        }

        public Criteria andBuyaddressGreaterThan(String value) {
            addCriterion("buyAddress >", value, "buyaddress");
            return (Criteria) this;
        }

        public Criteria andBuyaddressGreaterThanOrEqualTo(String value) {
            addCriterion("buyAddress >=", value, "buyaddress");
            return (Criteria) this;
        }

        public Criteria andBuyaddressLessThan(String value) {
            addCriterion("buyAddress <", value, "buyaddress");
            return (Criteria) this;
        }

        public Criteria andBuyaddressLessThanOrEqualTo(String value) {
            addCriterion("buyAddress <=", value, "buyaddress");
            return (Criteria) this;
        }

        public Criteria andBuyaddressLike(String value) {
            addCriterion("buyAddress like", value, "buyaddress");
            return (Criteria) this;
        }

        public Criteria andBuyaddressNotLike(String value) {
            addCriterion("buyAddress not like", value, "buyaddress");
            return (Criteria) this;
        }

        public Criteria andBuyaddressIn(List<String> values) {
            addCriterion("buyAddress in", values, "buyaddress");
            return (Criteria) this;
        }

        public Criteria andBuyaddressNotIn(List<String> values) {
            addCriterion("buyAddress not in", values, "buyaddress");
            return (Criteria) this;
        }

        public Criteria andBuyaddressBetween(String value1, String value2) {
            addCriterion("buyAddress between", value1, value2, "buyaddress");
            return (Criteria) this;
        }

        public Criteria andBuyaddressNotBetween(String value1, String value2) {
            addCriterion("buyAddress not between", value1, value2, "buyaddress");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}