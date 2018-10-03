package com.readbook.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RbQandaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RbQandaExample() {
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

        public Criteria andQandaIdIsNull() {
            addCriterion("qanda_id is null");
            return (Criteria) this;
        }

        public Criteria andQandaIdIsNotNull() {
            addCriterion("qanda_id is not null");
            return (Criteria) this;
        }

        public Criteria andQandaIdEqualTo(Integer value) {
            addCriterion("qanda_id =", value, "qandaId");
            return (Criteria) this;
        }

        public Criteria andQandaIdNotEqualTo(Integer value) {
            addCriterion("qanda_id <>", value, "qandaId");
            return (Criteria) this;
        }

        public Criteria andQandaIdGreaterThan(Integer value) {
            addCriterion("qanda_id >", value, "qandaId");
            return (Criteria) this;
        }

        public Criteria andQandaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("qanda_id >=", value, "qandaId");
            return (Criteria) this;
        }

        public Criteria andQandaIdLessThan(Integer value) {
            addCriterion("qanda_id <", value, "qandaId");
            return (Criteria) this;
        }

        public Criteria andQandaIdLessThanOrEqualTo(Integer value) {
            addCriterion("qanda_id <=", value, "qandaId");
            return (Criteria) this;
        }

        public Criteria andQandaIdIn(List<Integer> values) {
            addCriterion("qanda_id in", values, "qandaId");
            return (Criteria) this;
        }

        public Criteria andQandaIdNotIn(List<Integer> values) {
            addCriterion("qanda_id not in", values, "qandaId");
            return (Criteria) this;
        }

        public Criteria andQandaIdBetween(Integer value1, Integer value2) {
            addCriterion("qanda_id between", value1, value2, "qandaId");
            return (Criteria) this;
        }

        public Criteria andQandaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("qanda_id not between", value1, value2, "qandaId");
            return (Criteria) this;
        }

        public Criteria andPushDateIsNull() {
            addCriterion("push_date is null");
            return (Criteria) this;
        }

        public Criteria andPushDateIsNotNull() {
            addCriterion("push_date is not null");
            return (Criteria) this;
        }

        public Criteria andPushDateEqualTo(Date value) {
            addCriterion("push_date =", value, "pushDate");
            return (Criteria) this;
        }

        public Criteria andPushDateNotEqualTo(Date value) {
            addCriterion("push_date <>", value, "pushDate");
            return (Criteria) this;
        }

        public Criteria andPushDateGreaterThan(Date value) {
            addCriterion("push_date >", value, "pushDate");
            return (Criteria) this;
        }

        public Criteria andPushDateGreaterThanOrEqualTo(Date value) {
            addCriterion("push_date >=", value, "pushDate");
            return (Criteria) this;
        }

        public Criteria andPushDateLessThan(Date value) {
            addCriterion("push_date <", value, "pushDate");
            return (Criteria) this;
        }

        public Criteria andPushDateLessThanOrEqualTo(Date value) {
            addCriterion("push_date <=", value, "pushDate");
            return (Criteria) this;
        }

        public Criteria andPushDateIn(List<Date> values) {
            addCriterion("push_date in", values, "pushDate");
            return (Criteria) this;
        }

        public Criteria andPushDateNotIn(List<Date> values) {
            addCriterion("push_date not in", values, "pushDate");
            return (Criteria) this;
        }

        public Criteria andPushDateBetween(Date value1, Date value2) {
            addCriterion("push_date between", value1, value2, "pushDate");
            return (Criteria) this;
        }

        public Criteria andPushDateNotBetween(Date value1, Date value2) {
            addCriterion("push_date not between", value1, value2, "pushDate");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNull() {
            addCriterion("question is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNotNull() {
            addCriterion("question is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionEqualTo(String value) {
            addCriterion("question =", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotEqualTo(String value) {
            addCriterion("question <>", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThan(String value) {
            addCriterion("question >", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("question >=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThan(String value) {
            addCriterion("question <", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThanOrEqualTo(String value) {
            addCriterion("question <=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLike(String value) {
            addCriterion("question like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotLike(String value) {
            addCriterion("question not like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionIn(List<String> values) {
            addCriterion("question in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotIn(List<String> values) {
            addCriterion("question not in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionBetween(String value1, String value2) {
            addCriterion("question between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotBetween(String value1, String value2) {
            addCriterion("question not between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andHelpfulCntIsNull() {
            addCriterion("helpful_cnt is null");
            return (Criteria) this;
        }

        public Criteria andHelpfulCntIsNotNull() {
            addCriterion("helpful_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andHelpfulCntEqualTo(Integer value) {
            addCriterion("helpful_cnt =", value, "helpfulCnt");
            return (Criteria) this;
        }

        public Criteria andHelpfulCntNotEqualTo(Integer value) {
            addCriterion("helpful_cnt <>", value, "helpfulCnt");
            return (Criteria) this;
        }

        public Criteria andHelpfulCntGreaterThan(Integer value) {
            addCriterion("helpful_cnt >", value, "helpfulCnt");
            return (Criteria) this;
        }

        public Criteria andHelpfulCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("helpful_cnt >=", value, "helpfulCnt");
            return (Criteria) this;
        }

        public Criteria andHelpfulCntLessThan(Integer value) {
            addCriterion("helpful_cnt <", value, "helpfulCnt");
            return (Criteria) this;
        }

        public Criteria andHelpfulCntLessThanOrEqualTo(Integer value) {
            addCriterion("helpful_cnt <=", value, "helpfulCnt");
            return (Criteria) this;
        }

        public Criteria andHelpfulCntIn(List<Integer> values) {
            addCriterion("helpful_cnt in", values, "helpfulCnt");
            return (Criteria) this;
        }

        public Criteria andHelpfulCntNotIn(List<Integer> values) {
            addCriterion("helpful_cnt not in", values, "helpfulCnt");
            return (Criteria) this;
        }

        public Criteria andHelpfulCntBetween(Integer value1, Integer value2) {
            addCriterion("helpful_cnt between", value1, value2, "helpfulCnt");
            return (Criteria) this;
        }

        public Criteria andHelpfulCntNotBetween(Integer value1, Integer value2) {
            addCriterion("helpful_cnt not between", value1, value2, "helpfulCnt");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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