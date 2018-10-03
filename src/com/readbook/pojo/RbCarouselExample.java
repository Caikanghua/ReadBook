package com.readbook.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RbCarouselExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RbCarouselExample() {
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

        public Criteria andCarouselIdIsNull() {
            addCriterion("carousel_id is null");
            return (Criteria) this;
        }

        public Criteria andCarouselIdIsNotNull() {
            addCriterion("carousel_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarouselIdEqualTo(Integer value) {
            addCriterion("carousel_id =", value, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdNotEqualTo(Integer value) {
            addCriterion("carousel_id <>", value, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdGreaterThan(Integer value) {
            addCriterion("carousel_id >", value, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("carousel_id >=", value, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdLessThan(Integer value) {
            addCriterion("carousel_id <", value, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdLessThanOrEqualTo(Integer value) {
            addCriterion("carousel_id <=", value, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdIn(List<Integer> values) {
            addCriterion("carousel_id in", values, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdNotIn(List<Integer> values) {
            addCriterion("carousel_id not in", values, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdBetween(Integer value1, Integer value2) {
            addCriterion("carousel_id between", value1, value2, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdNotBetween(Integer value1, Integer value2) {
            addCriterion("carousel_id not between", value1, value2, "carouselId");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andIsShownIsNull() {
            addCriterion("is_shown is null");
            return (Criteria) this;
        }

        public Criteria andIsShownIsNotNull() {
            addCriterion("is_shown is not null");
            return (Criteria) this;
        }

        public Criteria andIsShownEqualTo(Boolean value) {
            addCriterion("is_shown =", value, "isShown");
            return (Criteria) this;
        }

        public Criteria andIsShownNotEqualTo(Boolean value) {
            addCriterion("is_shown <>", value, "isShown");
            return (Criteria) this;
        }

        public Criteria andIsShownGreaterThan(Boolean value) {
            addCriterion("is_shown >", value, "isShown");
            return (Criteria) this;
        }

        public Criteria andIsShownGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_shown >=", value, "isShown");
            return (Criteria) this;
        }

        public Criteria andIsShownLessThan(Boolean value) {
            addCriterion("is_shown <", value, "isShown");
            return (Criteria) this;
        }

        public Criteria andIsShownLessThanOrEqualTo(Boolean value) {
            addCriterion("is_shown <=", value, "isShown");
            return (Criteria) this;
        }

        public Criteria andIsShownIn(List<Boolean> values) {
            addCriterion("is_shown in", values, "isShown");
            return (Criteria) this;
        }

        public Criteria andIsShownNotIn(List<Boolean> values) {
            addCriterion("is_shown not in", values, "isShown");
            return (Criteria) this;
        }

        public Criteria andIsShownBetween(Boolean value1, Boolean value2) {
            addCriterion("is_shown between", value1, value2, "isShown");
            return (Criteria) this;
        }

        public Criteria andIsShownNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_shown not between", value1, value2, "isShown");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNull() {
            addCriterion("upload_date is null");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNotNull() {
            addCriterion("upload_date is not null");
            return (Criteria) this;
        }

        public Criteria andUploadDateEqualTo(Date value) {
            addCriterion("upload_date =", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotEqualTo(Date value) {
            addCriterion("upload_date <>", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThan(Date value) {
            addCriterion("upload_date >", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThanOrEqualTo(Date value) {
            addCriterion("upload_date >=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThan(Date value) {
            addCriterion("upload_date <", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThanOrEqualTo(Date value) {
            addCriterion("upload_date <=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateIn(List<Date> values) {
            addCriterion("upload_date in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotIn(List<Date> values) {
            addCriterion("upload_date not in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateBetween(Date value1, Date value2) {
            addCriterion("upload_date between", value1, value2, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotBetween(Date value1, Date value2) {
            addCriterion("upload_date not between", value1, value2, "uploadDate");
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

        public Criteria andPushUrlIsNull() {
            addCriterion("push_url is null");
            return (Criteria) this;
        }

        public Criteria andPushUrlIsNotNull() {
            addCriterion("push_url is not null");
            return (Criteria) this;
        }

        public Criteria andPushUrlEqualTo(String value) {
            addCriterion("push_url =", value, "pushUrl");
            return (Criteria) this;
        }

        public Criteria andPushUrlNotEqualTo(String value) {
            addCriterion("push_url <>", value, "pushUrl");
            return (Criteria) this;
        }

        public Criteria andPushUrlGreaterThan(String value) {
            addCriterion("push_url >", value, "pushUrl");
            return (Criteria) this;
        }

        public Criteria andPushUrlGreaterThanOrEqualTo(String value) {
            addCriterion("push_url >=", value, "pushUrl");
            return (Criteria) this;
        }

        public Criteria andPushUrlLessThan(String value) {
            addCriterion("push_url <", value, "pushUrl");
            return (Criteria) this;
        }

        public Criteria andPushUrlLessThanOrEqualTo(String value) {
            addCriterion("push_url <=", value, "pushUrl");
            return (Criteria) this;
        }

        public Criteria andPushUrlLike(String value) {
            addCriterion("push_url like", value, "pushUrl");
            return (Criteria) this;
        }

        public Criteria andPushUrlNotLike(String value) {
            addCriterion("push_url not like", value, "pushUrl");
            return (Criteria) this;
        }

        public Criteria andPushUrlIn(List<String> values) {
            addCriterion("push_url in", values, "pushUrl");
            return (Criteria) this;
        }

        public Criteria andPushUrlNotIn(List<String> values) {
            addCriterion("push_url not in", values, "pushUrl");
            return (Criteria) this;
        }

        public Criteria andPushUrlBetween(String value1, String value2) {
            addCriterion("push_url between", value1, value2, "pushUrl");
            return (Criteria) this;
        }

        public Criteria andPushUrlNotBetween(String value1, String value2) {
            addCriterion("push_url not between", value1, value2, "pushUrl");
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