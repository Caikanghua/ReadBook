package com.readbook.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RbReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RbReportExample() {
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

        public Criteria andReportIdIsNull() {
            addCriterion("report_id is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("report_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(Integer value) {
            addCriterion("report_id =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(Integer value) {
            addCriterion("report_id <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(Integer value) {
            addCriterion("report_id >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_id >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(Integer value) {
            addCriterion("report_id <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(Integer value) {
            addCriterion("report_id <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<Integer> values) {
            addCriterion("report_id in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<Integer> values) {
            addCriterion("report_id not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(Integer value1, Integer value2) {
            addCriterion("report_id between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(Integer value1, Integer value2) {
            addCriterion("report_id not between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andProposedDateIsNull() {
            addCriterion("proposed_date is null");
            return (Criteria) this;
        }

        public Criteria andProposedDateIsNotNull() {
            addCriterion("proposed_date is not null");
            return (Criteria) this;
        }

        public Criteria andProposedDateEqualTo(Date value) {
            addCriterion("proposed_date =", value, "proposedDate");
            return (Criteria) this;
        }

        public Criteria andProposedDateNotEqualTo(Date value) {
            addCriterion("proposed_date <>", value, "proposedDate");
            return (Criteria) this;
        }

        public Criteria andProposedDateGreaterThan(Date value) {
            addCriterion("proposed_date >", value, "proposedDate");
            return (Criteria) this;
        }

        public Criteria andProposedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("proposed_date >=", value, "proposedDate");
            return (Criteria) this;
        }

        public Criteria andProposedDateLessThan(Date value) {
            addCriterion("proposed_date <", value, "proposedDate");
            return (Criteria) this;
        }

        public Criteria andProposedDateLessThanOrEqualTo(Date value) {
            addCriterion("proposed_date <=", value, "proposedDate");
            return (Criteria) this;
        }

        public Criteria andProposedDateIn(List<Date> values) {
            addCriterion("proposed_date in", values, "proposedDate");
            return (Criteria) this;
        }

        public Criteria andProposedDateNotIn(List<Date> values) {
            addCriterion("proposed_date not in", values, "proposedDate");
            return (Criteria) this;
        }

        public Criteria andProposedDateBetween(Date value1, Date value2) {
            addCriterion("proposed_date between", value1, value2, "proposedDate");
            return (Criteria) this;
        }

        public Criteria andProposedDateNotBetween(Date value1, Date value2) {
            addCriterion("proposed_date not between", value1, value2, "proposedDate");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andIsdoneIsNull() {
            addCriterion("isDone is null");
            return (Criteria) this;
        }

        public Criteria andIsdoneIsNotNull() {
            addCriterion("isDone is not null");
            return (Criteria) this;
        }

        public Criteria andIsdoneEqualTo(Boolean value) {
            addCriterion("isDone =", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneNotEqualTo(Boolean value) {
            addCriterion("isDone <>", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneGreaterThan(Boolean value) {
            addCriterion("isDone >", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isDone >=", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneLessThan(Boolean value) {
            addCriterion("isDone <", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneLessThanOrEqualTo(Boolean value) {
            addCriterion("isDone <=", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneIn(List<Boolean> values) {
            addCriterion("isDone in", values, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneNotIn(List<Boolean> values) {
            addCriterion("isDone not in", values, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneBetween(Boolean value1, Boolean value2) {
            addCriterion("isDone between", value1, value2, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isDone not between", value1, value2, "isdone");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Boolean value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Boolean value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Boolean value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Boolean value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Boolean> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Boolean> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
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