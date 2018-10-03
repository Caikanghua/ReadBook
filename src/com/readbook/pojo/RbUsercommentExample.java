package com.readbook.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RbUsercommentExample {
	 protected String orderByClause;

	    protected boolean distinct;

	    protected List<Criteria> oredCriteria;

	    public RbUsercommentExample() {
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

	        public Criteria andUCommentIdIsNull() {
	            addCriterion("u_comment_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andUCommentIdIsNotNull() {
	            addCriterion("u_comment_id is not null");
	            return (Criteria) this;
	        }

	        public Criteria andUCommentIdEqualTo(String value) {
	            addCriterion("u_comment_id =", value, "uCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andUCommentIdNotEqualTo(String value) {
	            addCriterion("u_comment_id <>", value, "uCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andUCommentIdGreaterThan(String value) {
	            addCriterion("u_comment_id >", value, "uCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andUCommentIdGreaterThanOrEqualTo(String value) {
	            addCriterion("u_comment_id >=", value, "uCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andUCommentIdLessThan(String value) {
	            addCriterion("u_comment_id <", value, "uCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andUCommentIdLessThanOrEqualTo(String value) {
	            addCriterion("u_comment_id <=", value, "uCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andUCommentIdLike(String value) {
	            addCriterion("u_comment_id like", value, "uCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andUCommentIdNotLike(String value) {
	            addCriterion("u_comment_id not like", value, "uCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andUCommentIdIn(List<String> values) {
	            addCriterion("u_comment_id in", values, "uCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andUCommentIdNotIn(List<String> values) {
	            addCriterion("u_comment_id not in", values, "uCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andUCommentIdBetween(String value1, String value2) {
	            addCriterion("u_comment_id between", value1, value2, "uCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andUCommentIdNotBetween(String value1, String value2) {
	            addCriterion("u_comment_id not between", value1, value2, "uCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andCommentTypeIsNull() {
	            addCriterion("comment_type is null");
	            return (Criteria) this;
	        }

	        public Criteria andCommentTypeIsNotNull() {
	            addCriterion("comment_type is not null");
	            return (Criteria) this;
	        }

	        public Criteria andCommentTypeEqualTo(Integer value) {
	            addCriterion("comment_type =", value, "commentType");
	            return (Criteria) this;
	        }

	        public Criteria andCommentTypeNotEqualTo(Integer value) {
	            addCriterion("comment_type <>", value, "commentType");
	            return (Criteria) this;
	        }

	        public Criteria andCommentTypeGreaterThan(Integer value) {
	            addCriterion("comment_type >", value, "commentType");
	            return (Criteria) this;
	        }

	        public Criteria andCommentTypeGreaterThanOrEqualTo(Integer value) {
	            addCriterion("comment_type >=", value, "commentType");
	            return (Criteria) this;
	        }

	        public Criteria andCommentTypeLessThan(Integer value) {
	            addCriterion("comment_type <", value, "commentType");
	            return (Criteria) this;
	        }

	        public Criteria andCommentTypeLessThanOrEqualTo(Integer value) {
	            addCriterion("comment_type <=", value, "commentType");
	            return (Criteria) this;
	        }

	        public Criteria andCommentTypeIn(List<Integer> values) {
	            addCriterion("comment_type in", values, "commentType");
	            return (Criteria) this;
	        }

	        public Criteria andCommentTypeNotIn(List<Integer> values) {
	            addCriterion("comment_type not in", values, "commentType");
	            return (Criteria) this;
	        }

	        public Criteria andCommentTypeBetween(Integer value1, Integer value2) {
	            addCriterion("comment_type between", value1, value2, "commentType");
	            return (Criteria) this;
	        }

	        public Criteria andCommentTypeNotBetween(Integer value1, Integer value2) {
	            addCriterion("comment_type not between", value1, value2, "commentType");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdIsNull() {
	            addCriterion("from_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdIsNotNull() {
	            addCriterion("from_id is not null");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdEqualTo(String value) {
	            addCriterion("from_id =", value, "fromId");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdNotEqualTo(String value) {
	            addCriterion("from_id <>", value, "fromId");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdGreaterThan(String value) {
	            addCriterion("from_id >", value, "fromId");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdGreaterThanOrEqualTo(String value) {
	            addCriterion("from_id >=", value, "fromId");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdLessThan(String value) {
	            addCriterion("from_id <", value, "fromId");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdLessThanOrEqualTo(String value) {
	            addCriterion("from_id <=", value, "fromId");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdLike(String value) {
	            addCriterion("from_id like", value, "fromId");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdNotLike(String value) {
	            addCriterion("from_id not like", value, "fromId");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdIn(List<String> values) {
	            addCriterion("from_id in", values, "fromId");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdNotIn(List<String> values) {
	            addCriterion("from_id not in", values, "fromId");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdBetween(String value1, String value2) {
	            addCriterion("from_id between", value1, value2, "fromId");
	            return (Criteria) this;
	        }

	        public Criteria andFromIdNotBetween(String value1, String value2) {
	            addCriterion("from_id not between", value1, value2, "fromId");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameIsNull() {
	            addCriterion("from_name is null");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameIsNotNull() {
	            addCriterion("from_name is not null");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameEqualTo(String value) {
	            addCriterion("from_name =", value, "fromName");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameNotEqualTo(String value) {
	            addCriterion("from_name <>", value, "fromName");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameGreaterThan(String value) {
	            addCriterion("from_name >", value, "fromName");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameGreaterThanOrEqualTo(String value) {
	            addCriterion("from_name >=", value, "fromName");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameLessThan(String value) {
	            addCriterion("from_name <", value, "fromName");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameLessThanOrEqualTo(String value) {
	            addCriterion("from_name <=", value, "fromName");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameLike(String value) {
	            addCriterion("from_name like", value, "fromName");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameNotLike(String value) {
	            addCriterion("from_name not like", value, "fromName");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameIn(List<String> values) {
	            addCriterion("from_name in", values, "fromName");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameNotIn(List<String> values) {
	            addCriterion("from_name not in", values, "fromName");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameBetween(String value1, String value2) {
	            addCriterion("from_name between", value1, value2, "fromName");
	            return (Criteria) this;
	        }

	        public Criteria andFromNameNotBetween(String value1, String value2) {
	            addCriterion("from_name not between", value1, value2, "fromName");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdIsNull() {
	            addCriterion("to_comment_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdIsNotNull() {
	            addCriterion("to_comment_id is not null");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdEqualTo(String value) {
	            addCriterion("to_comment_id =", value, "toCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdNotEqualTo(String value) {
	            addCriterion("to_comment_id <>", value, "toCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdGreaterThan(String value) {
	            addCriterion("to_comment_id >", value, "toCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdGreaterThanOrEqualTo(String value) {
	            addCriterion("to_comment_id >=", value, "toCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdLessThan(String value) {
	            addCriterion("to_comment_id <", value, "toCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdLessThanOrEqualTo(String value) {
	            addCriterion("to_comment_id <=", value, "toCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdLike(String value) {
	            addCriterion("to_comment_id like", value, "toCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdNotLike(String value) {
	            addCriterion("to_comment_id not like", value, "toCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdIn(List<String> values) {
	            addCriterion("to_comment_id in", values, "toCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdNotIn(List<String> values) {
	            addCriterion("to_comment_id not in", values, "toCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdBetween(String value1, String value2) {
	            addCriterion("to_comment_id between", value1, value2, "toCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andToCommentIdNotBetween(String value1, String value2) {
	            addCriterion("to_comment_id not between", value1, value2, "toCommentId");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdIsNull() {
	            addCriterion("at_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdIsNotNull() {
	            addCriterion("at_id is not null");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdEqualTo(String value) {
	            addCriterion("at_id =", value, "atId");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdNotEqualTo(String value) {
	            addCriterion("at_id <>", value, "atId");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdGreaterThan(String value) {
	            addCriterion("at_id >", value, "atId");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdGreaterThanOrEqualTo(String value) {
	            addCriterion("at_id >=", value, "atId");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdLessThan(String value) {
	            addCriterion("at_id <", value, "atId");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdLessThanOrEqualTo(String value) {
	            addCriterion("at_id <=", value, "atId");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdLike(String value) {
	            addCriterion("at_id like", value, "atId");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdNotLike(String value) {
	            addCriterion("at_id not like", value, "atId");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdIn(List<String> values) {
	            addCriterion("at_id in", values, "atId");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdNotIn(List<String> values) {
	            addCriterion("at_id not in", values, "atId");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdBetween(String value1, String value2) {
	            addCriterion("at_id between", value1, value2, "atId");
	            return (Criteria) this;
	        }

	        public Criteria andAtIdNotBetween(String value1, String value2) {
	            addCriterion("at_id not between", value1, value2, "atId");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameIsNull() {
	            addCriterion("at_name is null");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameIsNotNull() {
	            addCriterion("at_name is not null");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameEqualTo(String value) {
	            addCriterion("at_name =", value, "atName");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameNotEqualTo(String value) {
	            addCriterion("at_name <>", value, "atName");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameGreaterThan(String value) {
	            addCriterion("at_name >", value, "atName");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameGreaterThanOrEqualTo(String value) {
	            addCriterion("at_name >=", value, "atName");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameLessThan(String value) {
	            addCriterion("at_name <", value, "atName");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameLessThanOrEqualTo(String value) {
	            addCriterion("at_name <=", value, "atName");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameLike(String value) {
	            addCriterion("at_name like", value, "atName");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameNotLike(String value) {
	            addCriterion("at_name not like", value, "atName");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameIn(List<String> values) {
	            addCriterion("at_name in", values, "atName");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameNotIn(List<String> values) {
	            addCriterion("at_name not in", values, "atName");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameBetween(String value1, String value2) {
	            addCriterion("at_name between", value1, value2, "atName");
	            return (Criteria) this;
	        }

	        public Criteria andAtNameNotBetween(String value1, String value2) {
	            addCriterion("at_name not between", value1, value2, "atName");
	            return (Criteria) this;
	        }

	        public Criteria andTimeIsNull() {
	            addCriterion("TIME is null");
	            return (Criteria) this;
	        }

	        public Criteria andTimeIsNotNull() {
	            addCriterion("TIME is not null");
	            return (Criteria) this;
	        }

	        public Criteria andTimeEqualTo(Date value) {
	            addCriterion("TIME =", value, "time");
	            return (Criteria) this;
	        }

	        public Criteria andTimeNotEqualTo(Date value) {
	            addCriterion("TIME <>", value, "time");
	            return (Criteria) this;
	        }

	        public Criteria andTimeGreaterThan(Date value) {
	            addCriterion("TIME >", value, "time");
	            return (Criteria) this;
	        }

	        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("TIME >=", value, "time");
	            return (Criteria) this;
	        }

	        public Criteria andTimeLessThan(Date value) {
	            addCriterion("TIME <", value, "time");
	            return (Criteria) this;
	        }

	        public Criteria andTimeLessThanOrEqualTo(Date value) {
	            addCriterion("TIME <=", value, "time");
	            return (Criteria) this;
	        }

	        public Criteria andTimeIn(List<Date> values) {
	            addCriterion("TIME in", values, "time");
	            return (Criteria) this;
	        }

	        public Criteria andTimeNotIn(List<Date> values) {
	            addCriterion("TIME not in", values, "time");
	            return (Criteria) this;
	        }

	        public Criteria andTimeBetween(Date value1, Date value2) {
	            addCriterion("TIME between", value1, value2, "time");
	            return (Criteria) this;
	        }

	        public Criteria andTimeNotBetween(Date value1, Date value2) {
	            addCriterion("TIME not between", value1, value2, "time");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdIsNull() {
	            addCriterion("comment_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdIsNotNull() {
	            addCriterion("comment_id is not null");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdEqualTo(String value) {
	            addCriterion("comment_id =", value, "commentId");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdNotEqualTo(String value) {
	            addCriterion("comment_id <>", value, "commentId");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdGreaterThan(String value) {
	            addCriterion("comment_id >", value, "commentId");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdGreaterThanOrEqualTo(String value) {
	            addCriterion("comment_id >=", value, "commentId");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdLessThan(String value) {
	            addCriterion("comment_id <", value, "commentId");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdLessThanOrEqualTo(String value) {
	            addCriterion("comment_id <=", value, "commentId");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdLike(String value) {
	            addCriterion("comment_id like", value, "commentId");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdNotLike(String value) {
	            addCriterion("comment_id not like", value, "commentId");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdIn(List<String> values) {
	            addCriterion("comment_id in", values, "commentId");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdNotIn(List<String> values) {
	            addCriterion("comment_id not in", values, "commentId");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdBetween(String value1, String value2) {
	            addCriterion("comment_id between", value1, value2, "commentId");
	            return (Criteria) this;
	        }

	        public Criteria andCommentIdNotBetween(String value1, String value2) {
	            addCriterion("comment_id not between", value1, value2, "commentId");
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