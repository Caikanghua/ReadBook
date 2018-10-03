package com.readbook.pojo;

import java.util.ArrayList;
import java.util.List;

public class AttentionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttentionExample() {
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

        public Criteria andAIdIsNull() {
            addCriterion("a_id is null");
            return (Criteria) this;
        }

        public Criteria andAIdIsNotNull() {
            addCriterion("a_id is not null");
            return (Criteria) this;
        }

        public Criteria andAIdEqualTo(Integer value) {
            addCriterion("a_id =", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotEqualTo(Integer value) {
            addCriterion("a_id <>", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThan(Integer value) {
            addCriterion("a_id >", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_id >=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThan(Integer value) {
            addCriterion("a_id <", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThanOrEqualTo(Integer value) {
            addCriterion("a_id <=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdIn(List<Integer> values) {
            addCriterion("a_id in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotIn(List<Integer> values) {
            addCriterion("a_id not in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdBetween(Integer value1, Integer value2) {
            addCriterion("a_id between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotBetween(Integer value1, Integer value2) {
            addCriterion("a_id not between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAttentionUserIsNull() {
            addCriterion("attention_user is null");
            return (Criteria) this;
        }

        public Criteria andAttentionUserIsNotNull() {
            addCriterion("attention_user is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionUserEqualTo(String value) {
            addCriterion("attention_user =", value, "attentionUser");
            return (Criteria) this;
        }

        public Criteria andAttentionUserNotEqualTo(String value) {
            addCriterion("attention_user <>", value, "attentionUser");
            return (Criteria) this;
        }

        public Criteria andAttentionUserGreaterThan(String value) {
            addCriterion("attention_user >", value, "attentionUser");
            return (Criteria) this;
        }

        public Criteria andAttentionUserGreaterThanOrEqualTo(String value) {
            addCriterion("attention_user >=", value, "attentionUser");
            return (Criteria) this;
        }

        public Criteria andAttentionUserLessThan(String value) {
            addCriterion("attention_user <", value, "attentionUser");
            return (Criteria) this;
        }

        public Criteria andAttentionUserLessThanOrEqualTo(String value) {
            addCriterion("attention_user <=", value, "attentionUser");
            return (Criteria) this;
        }

        public Criteria andAttentionUserLike(String value) {
            addCriterion("attention_user like", value, "attentionUser");
            return (Criteria) this;
        }

        public Criteria andAttentionUserNotLike(String value) {
            addCriterion("attention_user not like", value, "attentionUser");
            return (Criteria) this;
        }

        public Criteria andAttentionUserIn(List<String> values) {
            addCriterion("attention_user in", values, "attentionUser");
            return (Criteria) this;
        }

        public Criteria andAttentionUserNotIn(List<String> values) {
            addCriterion("attention_user not in", values, "attentionUser");
            return (Criteria) this;
        }

        public Criteria andAttentionUserBetween(String value1, String value2) {
            addCriterion("attention_user between", value1, value2, "attentionUser");
            return (Criteria) this;
        }

        public Criteria andAttentionUserNotBetween(String value1, String value2) {
            addCriterion("attention_user not between", value1, value2, "attentionUser");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserIsNull() {
            addCriterion("be_attention_user is null");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserIsNotNull() {
            addCriterion("be_attention_user is not null");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserEqualTo(String value) {
            addCriterion("be_attention_user =", value, "beAttentionUser");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserNotEqualTo(String value) {
            addCriterion("be_attention_user <>", value, "beAttentionUser");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserGreaterThan(String value) {
            addCriterion("be_attention_user >", value, "beAttentionUser");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserGreaterThanOrEqualTo(String value) {
            addCriterion("be_attention_user >=", value, "beAttentionUser");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserLessThan(String value) {
            addCriterion("be_attention_user <", value, "beAttentionUser");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserLessThanOrEqualTo(String value) {
            addCriterion("be_attention_user <=", value, "beAttentionUser");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserLike(String value) {
            addCriterion("be_attention_user like", value, "beAttentionUser");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserNotLike(String value) {
            addCriterion("be_attention_user not like", value, "beAttentionUser");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserIn(List<String> values) {
            addCriterion("be_attention_user in", values, "beAttentionUser");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserNotIn(List<String> values) {
            addCriterion("be_attention_user not in", values, "beAttentionUser");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserBetween(String value1, String value2) {
            addCriterion("be_attention_user between", value1, value2, "beAttentionUser");
            return (Criteria) this;
        }

        public Criteria andBeAttentionUserNotBetween(String value1, String value2) {
            addCriterion("be_attention_user not between", value1, value2, "beAttentionUser");
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