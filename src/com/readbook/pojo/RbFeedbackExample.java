package com.readbook.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RbFeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RbFeedbackExample() {
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

        public Criteria andFeedbackIdIsNull() {
            addCriterion("feedback_id is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIsNotNull() {
            addCriterion("feedback_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdEqualTo(Integer value) {
            addCriterion("feedback_id =", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotEqualTo(Integer value) {
            addCriterion("feedback_id <>", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThan(Integer value) {
            addCriterion("feedback_id >", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("feedback_id >=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThan(Integer value) {
            addCriterion("feedback_id <", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThanOrEqualTo(Integer value) {
            addCriterion("feedback_id <=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIn(List<Integer> values) {
            addCriterion("feedback_id in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotIn(List<Integer> values) {
            addCriterion("feedback_id not in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdBetween(Integer value1, Integer value2) {
            addCriterion("feedback_id between", value1, value2, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotBetween(Integer value1, Integer value2) {
            addCriterion("feedback_id not between", value1, value2, "feedbackId");
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

        public Criteria andPrintscreenIsNull() {
            addCriterion("printscreen is null");
            return (Criteria) this;
        }

        public Criteria andPrintscreenIsNotNull() {
            addCriterion("printscreen is not null");
            return (Criteria) this;
        }

        public Criteria andPrintscreenEqualTo(String value) {
            addCriterion("printscreen =", value, "printscreen");
            return (Criteria) this;
        }

        public Criteria andPrintscreenNotEqualTo(String value) {
            addCriterion("printscreen <>", value, "printscreen");
            return (Criteria) this;
        }

        public Criteria andPrintscreenGreaterThan(String value) {
            addCriterion("printscreen >", value, "printscreen");
            return (Criteria) this;
        }

        public Criteria andPrintscreenGreaterThanOrEqualTo(String value) {
            addCriterion("printscreen >=", value, "printscreen");
            return (Criteria) this;
        }

        public Criteria andPrintscreenLessThan(String value) {
            addCriterion("printscreen <", value, "printscreen");
            return (Criteria) this;
        }

        public Criteria andPrintscreenLessThanOrEqualTo(String value) {
            addCriterion("printscreen <=", value, "printscreen");
            return (Criteria) this;
        }

        public Criteria andPrintscreenLike(String value) {
            addCriterion("printscreen like", value, "printscreen");
            return (Criteria) this;
        }

        public Criteria andPrintscreenNotLike(String value) {
            addCriterion("printscreen not like", value, "printscreen");
            return (Criteria) this;
        }

        public Criteria andPrintscreenIn(List<String> values) {
            addCriterion("printscreen in", values, "printscreen");
            return (Criteria) this;
        }

        public Criteria andPrintscreenNotIn(List<String> values) {
            addCriterion("printscreen not in", values, "printscreen");
            return (Criteria) this;
        }

        public Criteria andPrintscreenBetween(String value1, String value2) {
            addCriterion("printscreen between", value1, value2, "printscreen");
            return (Criteria) this;
        }

        public Criteria andPrintscreenNotBetween(String value1, String value2) {
            addCriterion("printscreen not between", value1, value2, "printscreen");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultIsNull() {
            addCriterion("feedback_result is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultIsNotNull() {
            addCriterion("feedback_result is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultEqualTo(String value) {
            addCriterion("feedback_result =", value, "feedbackResult");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultNotEqualTo(String value) {
            addCriterion("feedback_result <>", value, "feedbackResult");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultGreaterThan(String value) {
            addCriterion("feedback_result >", value, "feedbackResult");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_result >=", value, "feedbackResult");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultLessThan(String value) {
            addCriterion("feedback_result <", value, "feedbackResult");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultLessThanOrEqualTo(String value) {
            addCriterion("feedback_result <=", value, "feedbackResult");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultLike(String value) {
            addCriterion("feedback_result like", value, "feedbackResult");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultNotLike(String value) {
            addCriterion("feedback_result not like", value, "feedbackResult");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultIn(List<String> values) {
            addCriterion("feedback_result in", values, "feedbackResult");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultNotIn(List<String> values) {
            addCriterion("feedback_result not in", values, "feedbackResult");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultBetween(String value1, String value2) {
            addCriterion("feedback_result between", value1, value2, "feedbackResult");
            return (Criteria) this;
        }

        public Criteria andFeedbackResultNotBetween(String value1, String value2) {
            addCriterion("feedback_result not between", value1, value2, "feedbackResult");
            return (Criteria) this;
        }

        public Criteria andHasDealedIsNull() {
            addCriterion("has_dealed is null");
            return (Criteria) this;
        }

        public Criteria andHasDealedIsNotNull() {
            addCriterion("has_dealed is not null");
            return (Criteria) this;
        }

        public Criteria andHasDealedEqualTo(Integer value) {
            addCriterion("has_dealed =", value, "hasDealed");
            return (Criteria) this;
        }

        public Criteria andHasDealedNotEqualTo(Integer value) {
            addCriterion("has_dealed <>", value, "hasDealed");
            return (Criteria) this;
        }

        public Criteria andHasDealedGreaterThan(Integer value) {
            addCriterion("has_dealed >", value, "hasDealed");
            return (Criteria) this;
        }

        public Criteria andHasDealedGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_dealed >=", value, "hasDealed");
            return (Criteria) this;
        }

        public Criteria andHasDealedLessThan(Integer value) {
            addCriterion("has_dealed <", value, "hasDealed");
            return (Criteria) this;
        }

        public Criteria andHasDealedLessThanOrEqualTo(Integer value) {
            addCriterion("has_dealed <=", value, "hasDealed");
            return (Criteria) this;
        }

        public Criteria andHasDealedIn(List<Integer> values) {
            addCriterion("has_dealed in", values, "hasDealed");
            return (Criteria) this;
        }

        public Criteria andHasDealedNotIn(List<Integer> values) {
            addCriterion("has_dealed not in", values, "hasDealed");
            return (Criteria) this;
        }

        public Criteria andHasDealedBetween(Integer value1, Integer value2) {
            addCriterion("has_dealed between", value1, value2, "hasDealed");
            return (Criteria) this;
        }

        public Criteria andHasDealedNotBetween(Integer value1, Integer value2) {
            addCriterion("has_dealed not between", value1, value2, "hasDealed");
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