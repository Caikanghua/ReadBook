package com.readbook.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RbWonderfulPostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RbWonderfulPostExample() {
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

        public Criteria andWonderfulPostIdIsNull() {
            addCriterion("wonderful_post_id is null");
            return (Criteria) this;
        }

        public Criteria andWonderfulPostIdIsNotNull() {
            addCriterion("wonderful_post_id is not null");
            return (Criteria) this;
        }

        public Criteria andWonderfulPostIdEqualTo(Integer value) {
            addCriterion("wonderful_post_id =", value, "wonderfulPostId");
            return (Criteria) this;
        }

        public Criteria andWonderfulPostIdNotEqualTo(Integer value) {
            addCriterion("wonderful_post_id <>", value, "wonderfulPostId");
            return (Criteria) this;
        }

        public Criteria andWonderfulPostIdGreaterThan(Integer value) {
            addCriterion("wonderful_post_id >", value, "wonderfulPostId");
            return (Criteria) this;
        }

        public Criteria andWonderfulPostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wonderful_post_id >=", value, "wonderfulPostId");
            return (Criteria) this;
        }

        public Criteria andWonderfulPostIdLessThan(Integer value) {
            addCriterion("wonderful_post_id <", value, "wonderfulPostId");
            return (Criteria) this;
        }

        public Criteria andWonderfulPostIdLessThanOrEqualTo(Integer value) {
            addCriterion("wonderful_post_id <=", value, "wonderfulPostId");
            return (Criteria) this;
        }

        public Criteria andWonderfulPostIdIn(List<Integer> values) {
            addCriterion("wonderful_post_id in", values, "wonderfulPostId");
            return (Criteria) this;
        }

        public Criteria andWonderfulPostIdNotIn(List<Integer> values) {
            addCriterion("wonderful_post_id not in", values, "wonderfulPostId");
            return (Criteria) this;
        }

        public Criteria andWonderfulPostIdBetween(Integer value1, Integer value2) {
            addCriterion("wonderful_post_id between", value1, value2, "wonderfulPostId");
            return (Criteria) this;
        }

        public Criteria andWonderfulPostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wonderful_post_id not between", value1, value2, "wonderfulPostId");
            return (Criteria) this;
        }

        public Criteria andPostBookNameIsNull() {
            addCriterion("post_book_name is null");
            return (Criteria) this;
        }

        public Criteria andPostBookNameIsNotNull() {
            addCriterion("post_book_name is not null");
            return (Criteria) this;
        }

        public Criteria andPostBookNameEqualTo(String value) {
            addCriterion("post_book_name =", value, "postBookName");
            return (Criteria) this;
        }

        public Criteria andPostBookNameNotEqualTo(String value) {
            addCriterion("post_book_name <>", value, "postBookName");
            return (Criteria) this;
        }

        public Criteria andPostBookNameGreaterThan(String value) {
            addCriterion("post_book_name >", value, "postBookName");
            return (Criteria) this;
        }

        public Criteria andPostBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("post_book_name >=", value, "postBookName");
            return (Criteria) this;
        }

        public Criteria andPostBookNameLessThan(String value) {
            addCriterion("post_book_name <", value, "postBookName");
            return (Criteria) this;
        }

        public Criteria andPostBookNameLessThanOrEqualTo(String value) {
            addCriterion("post_book_name <=", value, "postBookName");
            return (Criteria) this;
        }

        public Criteria andPostBookNameLike(String value) {
            addCriterion("post_book_name like", value, "postBookName");
            return (Criteria) this;
        }

        public Criteria andPostBookNameNotLike(String value) {
            addCriterion("post_book_name not like", value, "postBookName");
            return (Criteria) this;
        }

        public Criteria andPostBookNameIn(List<String> values) {
            addCriterion("post_book_name in", values, "postBookName");
            return (Criteria) this;
        }

        public Criteria andPostBookNameNotIn(List<String> values) {
            addCriterion("post_book_name not in", values, "postBookName");
            return (Criteria) this;
        }

        public Criteria andPostBookNameBetween(String value1, String value2) {
            addCriterion("post_book_name between", value1, value2, "postBookName");
            return (Criteria) this;
        }

        public Criteria andPostBookNameNotBetween(String value1, String value2) {
            addCriterion("post_book_name not between", value1, value2, "postBookName");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNull() {
            addCriterion("post_time is null");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNotNull() {
            addCriterion("post_time is not null");
            return (Criteria) this;
        }

        public Criteria andPostTimeEqualTo(Date value) {
            addCriterion("post_time =", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotEqualTo(Date value) {
            addCriterion("post_time <>", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThan(Date value) {
            addCriterion("post_time >", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("post_time >=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThan(Date value) {
            addCriterion("post_time <", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThanOrEqualTo(Date value) {
            addCriterion("post_time <=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeIn(List<Date> values) {
            addCriterion("post_time in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotIn(List<Date> values) {
            addCriterion("post_time not in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeBetween(Date value1, Date value2) {
            addCriterion("post_time between", value1, value2, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotBetween(Date value1, Date value2) {
            addCriterion("post_time not between", value1, value2, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostAuthorIsNull() {
            addCriterion("post_author is null");
            return (Criteria) this;
        }

        public Criteria andPostAuthorIsNotNull() {
            addCriterion("post_author is not null");
            return (Criteria) this;
        }

        public Criteria andPostAuthorEqualTo(String value) {
            addCriterion("post_author =", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorNotEqualTo(String value) {
            addCriterion("post_author <>", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorGreaterThan(String value) {
            addCriterion("post_author >", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("post_author >=", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorLessThan(String value) {
            addCriterion("post_author <", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorLessThanOrEqualTo(String value) {
            addCriterion("post_author <=", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorLike(String value) {
            addCriterion("post_author like", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorNotLike(String value) {
            addCriterion("post_author not like", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorIn(List<String> values) {
            addCriterion("post_author in", values, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorNotIn(List<String> values) {
            addCriterion("post_author not in", values, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorBetween(String value1, String value2) {
            addCriterion("post_author between", value1, value2, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorNotBetween(String value1, String value2) {
            addCriterion("post_author not between", value1, value2, "postAuthor");
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