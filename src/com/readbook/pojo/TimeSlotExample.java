package com.readbook.pojo;

import java.util.ArrayList;
import java.util.List;

public class TimeSlotExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TimeSlotExample() {
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

        public Criteria andSlotIdIsNull() {
            addCriterion("slot_id is null");
            return (Criteria) this;
        }

        public Criteria andSlotIdIsNotNull() {
            addCriterion("slot_id is not null");
            return (Criteria) this;
        }

        public Criteria andSlotIdEqualTo(Integer value) {
            addCriterion("slot_id =", value, "slotId");
            return (Criteria) this;
        }

        public Criteria andSlotIdNotEqualTo(Integer value) {
            addCriterion("slot_id <>", value, "slotId");
            return (Criteria) this;
        }

        public Criteria andSlotIdGreaterThan(Integer value) {
            addCriterion("slot_id >", value, "slotId");
            return (Criteria) this;
        }

        public Criteria andSlotIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("slot_id >=", value, "slotId");
            return (Criteria) this;
        }

        public Criteria andSlotIdLessThan(Integer value) {
            addCriterion("slot_id <", value, "slotId");
            return (Criteria) this;
        }

        public Criteria andSlotIdLessThanOrEqualTo(Integer value) {
            addCriterion("slot_id <=", value, "slotId");
            return (Criteria) this;
        }

        public Criteria andSlotIdIn(List<Integer> values) {
            addCriterion("slot_id in", values, "slotId");
            return (Criteria) this;
        }

        public Criteria andSlotIdNotIn(List<Integer> values) {
            addCriterion("slot_id not in", values, "slotId");
            return (Criteria) this;
        }

        public Criteria andSlotIdBetween(Integer value1, Integer value2) {
            addCriterion("slot_id between", value1, value2, "slotId");
            return (Criteria) this;
        }

        public Criteria andSlotIdNotBetween(Integer value1, Integer value2) {
            addCriterion("slot_id not between", value1, value2, "slotId");
            return (Criteria) this;
        }

        public Criteria andSlotTimeIsNull() {
            addCriterion("slot_time is null");
            return (Criteria) this;
        }

        public Criteria andSlotTimeIsNotNull() {
            addCriterion("slot_time is not null");
            return (Criteria) this;
        }

        public Criteria andSlotTimeEqualTo(String value) {
            addCriterion("slot_time =", value, "slotTime");
            return (Criteria) this;
        }

        public Criteria andSlotTimeNotEqualTo(String value) {
            addCriterion("slot_time <>", value, "slotTime");
            return (Criteria) this;
        }

        public Criteria andSlotTimeGreaterThan(String value) {
            addCriterion("slot_time >", value, "slotTime");
            return (Criteria) this;
        }

        public Criteria andSlotTimeGreaterThanOrEqualTo(String value) {
            addCriterion("slot_time >=", value, "slotTime");
            return (Criteria) this;
        }

        public Criteria andSlotTimeLessThan(String value) {
            addCriterion("slot_time <", value, "slotTime");
            return (Criteria) this;
        }

        public Criteria andSlotTimeLessThanOrEqualTo(String value) {
            addCriterion("slot_time <=", value, "slotTime");
            return (Criteria) this;
        }

        public Criteria andSlotTimeLike(String value) {
            addCriterion("slot_time like", value, "slotTime");
            return (Criteria) this;
        }

        public Criteria andSlotTimeNotLike(String value) {
            addCriterion("slot_time not like", value, "slotTime");
            return (Criteria) this;
        }

        public Criteria andSlotTimeIn(List<String> values) {
            addCriterion("slot_time in", values, "slotTime");
            return (Criteria) this;
        }

        public Criteria andSlotTimeNotIn(List<String> values) {
            addCriterion("slot_time not in", values, "slotTime");
            return (Criteria) this;
        }

        public Criteria andSlotTimeBetween(String value1, String value2) {
            addCriterion("slot_time between", value1, value2, "slotTime");
            return (Criteria) this;
        }

        public Criteria andSlotTimeNotBetween(String value1, String value2) {
            addCriterion("slot_time not between", value1, value2, "slotTime");
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