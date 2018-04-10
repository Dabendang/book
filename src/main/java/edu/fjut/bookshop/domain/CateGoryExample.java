package edu.fjut.bookshop.domain;

import java.util.ArrayList;
import java.util.List;

public class CateGoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CateGoryExample() {
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

        public Criteria andCategoryidIsNull() {
            addCriterion("categoryId is null");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNotNull() {
            addCriterion("categoryId is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryidEqualTo(Integer value) {
            addCriterion("categoryId =", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotEqualTo(Integer value) {
            addCriterion("categoryId <>", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThan(Integer value) {
            addCriterion("categoryId >", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("categoryId >=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThan(Integer value) {
            addCriterion("categoryId <", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThanOrEqualTo(Integer value) {
            addCriterion("categoryId <=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidIn(List<Integer> values) {
            addCriterion("categoryId in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotIn(List<Integer> values) {
            addCriterion("categoryId not in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidBetween(Integer value1, Integer value2) {
            addCriterion("categoryId between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotBetween(Integer value1, Integer value2) {
            addCriterion("categoryId not between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategorynameIsNull() {
            addCriterion("categoryName is null");
            return (Criteria) this;
        }

        public Criteria andCategorynameIsNotNull() {
            addCriterion("categoryName is not null");
            return (Criteria) this;
        }

        public Criteria andCategorynameEqualTo(String value) {
            addCriterion("categoryName =", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameNotEqualTo(String value) {
            addCriterion("categoryName <>", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameGreaterThan(String value) {
            addCriterion("categoryName >", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameGreaterThanOrEqualTo(String value) {
            addCriterion("categoryName >=", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameLessThan(String value) {
            addCriterion("categoryName <", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameLessThanOrEqualTo(String value) {
            addCriterion("categoryName <=", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameLike(String value) {
            addCriterion("categoryName like", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameNotLike(String value) {
            addCriterion("categoryName not like", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameIn(List<String> values) {
            addCriterion("categoryName in", values, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameNotIn(List<String> values) {
            addCriterion("categoryName not in", values, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameBetween(String value1, String value2) {
            addCriterion("categoryName between", value1, value2, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameNotBetween(String value1, String value2) {
            addCriterion("categoryName not between", value1, value2, "categoryname");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("inventory is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("inventory is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Long value) {
            addCriterion("inventory =", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Long value) {
            addCriterion("inventory <>", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Long value) {
            addCriterion("inventory >", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Long value) {
            addCriterion("inventory >=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Long value) {
            addCriterion("inventory <", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Long value) {
            addCriterion("inventory <=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Long> values) {
            addCriterion("inventory in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Long> values) {
            addCriterion("inventory not in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Long value1, Long value2) {
            addCriterion("inventory between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Long value1, Long value2) {
            addCriterion("inventory not between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeIsNull() {
            addCriterion("salesVolume is null");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeIsNotNull() {
            addCriterion("salesVolume is not null");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeEqualTo(Long value) {
            addCriterion("salesVolume =", value, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeNotEqualTo(Long value) {
            addCriterion("salesVolume <>", value, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeGreaterThan(Long value) {
            addCriterion("salesVolume >", value, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeGreaterThanOrEqualTo(Long value) {
            addCriterion("salesVolume >=", value, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeLessThan(Long value) {
            addCriterion("salesVolume <", value, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeLessThanOrEqualTo(Long value) {
            addCriterion("salesVolume <=", value, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeIn(List<Long> values) {
            addCriterion("salesVolume in", values, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeNotIn(List<Long> values) {
            addCriterion("salesVolume not in", values, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeBetween(Long value1, Long value2) {
            addCriterion("salesVolume between", value1, value2, "salesvolume");
            return (Criteria) this;
        }

        public Criteria andSalesvolumeNotBetween(Long value1, Long value2) {
            addCriterion("salesVolume not between", value1, value2, "salesvolume");
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