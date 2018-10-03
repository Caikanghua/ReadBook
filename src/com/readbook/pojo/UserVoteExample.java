package com.readbook.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserVoteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserVoteExample() {
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

        public Criteria andUserVoteIdIsNull() {
            addCriterion("user_vote_id is null");
            return (Criteria) this;
        }

        public Criteria andUserVoteIdIsNotNull() {
            addCriterion("user_vote_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserVoteIdEqualTo(String value) {
            addCriterion("user_vote_id =", value, "userVoteId");
            return (Criteria) this;
        }

        public Criteria andUserVoteIdNotEqualTo(String value) {
            addCriterion("user_vote_id <>", value, "userVoteId");
            return (Criteria) this;
        }

        public Criteria andUserVoteIdGreaterThan(String value) {
            addCriterion("user_vote_id >", value, "userVoteId");
            return (Criteria) this;
        }

        public Criteria andUserVoteIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_vote_id >=", value, "userVoteId");
            return (Criteria) this;
        }

        public Criteria andUserVoteIdLessThan(String value) {
            addCriterion("user_vote_id <", value, "userVoteId");
            return (Criteria) this;
        }

        public Criteria andUserVoteIdLessThanOrEqualTo(String value) {
            addCriterion("user_vote_id <=", value, "userVoteId");
            return (Criteria) this;
        }

        public Criteria andUserVoteIdLike(String value) {
            addCriterion("user_vote_id like", value, "userVoteId");
            return (Criteria) this;
        }

        public Criteria andUserVoteIdNotLike(String value) {
            addCriterion("user_vote_id not like", value, "userVoteId");
            return (Criteria) this;
        }

        public Criteria andUserVoteIdIn(List<String> values) {
            addCriterion("user_vote_id in", values, "userVoteId");
            return (Criteria) this;
        }

        public Criteria andUserVoteIdNotIn(List<String> values) {
            addCriterion("user_vote_id not in", values, "userVoteId");
            return (Criteria) this;
        }

        public Criteria andUserVoteIdBetween(String value1, String value2) {
            addCriterion("user_vote_id between", value1, value2, "userVoteId");
            return (Criteria) this;
        }

        public Criteria andUserVoteIdNotBetween(String value1, String value2) {
            addCriterion("user_vote_id not between", value1, value2, "userVoteId");
            return (Criteria) this;
        }

        public Criteria andVoteTimesIsNull() {
            addCriterion("vote_times is null");
            return (Criteria) this;
        }

        public Criteria andVoteTimesIsNotNull() {
            addCriterion("vote_times is not null");
            return (Criteria) this;
        }

        public Criteria andVoteTimesEqualTo(Integer value) {
            addCriterion("vote_times =", value, "voteTimes");
            return (Criteria) this;
        }

        public Criteria andVoteTimesNotEqualTo(Integer value) {
            addCriterion("vote_times <>", value, "voteTimes");
            return (Criteria) this;
        }

        public Criteria andVoteTimesGreaterThan(Integer value) {
            addCriterion("vote_times >", value, "voteTimes");
            return (Criteria) this;
        }

        public Criteria andVoteTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_times >=", value, "voteTimes");
            return (Criteria) this;
        }

        public Criteria andVoteTimesLessThan(Integer value) {
            addCriterion("vote_times <", value, "voteTimes");
            return (Criteria) this;
        }

        public Criteria andVoteTimesLessThanOrEqualTo(Integer value) {
            addCriterion("vote_times <=", value, "voteTimes");
            return (Criteria) this;
        }

        public Criteria andVoteTimesIn(List<Integer> values) {
            addCriterion("vote_times in", values, "voteTimes");
            return (Criteria) this;
        }

        public Criteria andVoteTimesNotIn(List<Integer> values) {
            addCriterion("vote_times not in", values, "voteTimes");
            return (Criteria) this;
        }

        public Criteria andVoteTimesBetween(Integer value1, Integer value2) {
            addCriterion("vote_times between", value1, value2, "voteTimes");
            return (Criteria) this;
        }

        public Criteria andVoteTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_times not between", value1, value2, "voteTimes");
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