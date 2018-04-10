package edu.fjut.bookshop.domain;

import java.util.ArrayList;
import java.util.List;

public class StockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockExample() {
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

        public Criteria andStockidIsNull() {
            addCriterion("stockId is null");
            return (Criteria) this;
        }

        public Criteria andStockidIsNotNull() {
            addCriterion("stockId is not null");
            return (Criteria) this;
        }

        public Criteria andStockidEqualTo(Integer value) {
            addCriterion("stockId =", value, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidNotEqualTo(Integer value) {
            addCriterion("stockId <>", value, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidGreaterThan(Integer value) {
            addCriterion("stockId >", value, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidGreaterThanOrEqualTo(Integer value) {
            addCriterion("stockId >=", value, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidLessThan(Integer value) {
            addCriterion("stockId <", value, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidLessThanOrEqualTo(Integer value) {
            addCriterion("stockId <=", value, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidIn(List<Integer> values) {
            addCriterion("stockId in", values, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidNotIn(List<Integer> values) {
            addCriterion("stockId not in", values, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidBetween(Integer value1, Integer value2) {
            addCriterion("stockId between", value1, value2, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidNotBetween(Integer value1, Integer value2) {
            addCriterion("stockId not between", value1, value2, "stockid");
            return (Criteria) this;
        }

        public Criteria andStocknumIsNull() {
            addCriterion("stockNum is null");
            return (Criteria) this;
        }

        public Criteria andStocknumIsNotNull() {
            addCriterion("stockNum is not null");
            return (Criteria) this;
        }

        public Criteria andStocknumEqualTo(Long value) {
            addCriterion("stockNum =", value, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumNotEqualTo(Long value) {
            addCriterion("stockNum <>", value, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumGreaterThan(Long value) {
            addCriterion("stockNum >", value, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumGreaterThanOrEqualTo(Long value) {
            addCriterion("stockNum >=", value, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumLessThan(Long value) {
            addCriterion("stockNum <", value, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumLessThanOrEqualTo(Long value) {
            addCriterion("stockNum <=", value, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumIn(List<Long> values) {
            addCriterion("stockNum in", values, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumNotIn(List<Long> values) {
            addCriterion("stockNum not in", values, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumBetween(Long value1, Long value2) {
            addCriterion("stockNum between", value1, value2, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumNotBetween(Long value1, Long value2) {
            addCriterion("stockNum not between", value1, value2, "stocknum");
            return (Criteria) this;
        }

        public Criteria andTotalcategoryIsNull() {
            addCriterion("totalCategory is null");
            return (Criteria) this;
        }

        public Criteria andTotalcategoryIsNotNull() {
            addCriterion("totalCategory is not null");
            return (Criteria) this;
        }

        public Criteria andTotalcategoryEqualTo(Integer value) {
            addCriterion("totalCategory =", value, "totalcategory");
            return (Criteria) this;
        }

        public Criteria andTotalcategoryNotEqualTo(Integer value) {
            addCriterion("totalCategory <>", value, "totalcategory");
            return (Criteria) this;
        }

        public Criteria andTotalcategoryGreaterThan(Integer value) {
            addCriterion("totalCategory >", value, "totalcategory");
            return (Criteria) this;
        }

        public Criteria andTotalcategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalCategory >=", value, "totalcategory");
            return (Criteria) this;
        }

        public Criteria andTotalcategoryLessThan(Integer value) {
            addCriterion("totalCategory <", value, "totalcategory");
            return (Criteria) this;
        }

        public Criteria andTotalcategoryLessThanOrEqualTo(Integer value) {
            addCriterion("totalCategory <=", value, "totalcategory");
            return (Criteria) this;
        }

        public Criteria andTotalcategoryIn(List<Integer> values) {
            addCriterion("totalCategory in", values, "totalcategory");
            return (Criteria) this;
        }

        public Criteria andTotalcategoryNotIn(List<Integer> values) {
            addCriterion("totalCategory not in", values, "totalcategory");
            return (Criteria) this;
        }

        public Criteria andTotalcategoryBetween(Integer value1, Integer value2) {
            addCriterion("totalCategory between", value1, value2, "totalcategory");
            return (Criteria) this;
        }

        public Criteria andTotalcategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("totalCategory not between", value1, value2, "totalcategory");
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