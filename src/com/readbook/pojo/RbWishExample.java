package com.readbook.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RbWishExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RbWishExample() {
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

        public Criteria andWishIdIsNull() {
            addCriterion("wish_id is null");
            return (Criteria) this;
        }

        public Criteria andWishIdIsNotNull() {
            addCriterion("wish_id is not null");
            return (Criteria) this;
        }

        public Criteria andWishIdEqualTo(Integer value) {
            addCriterion("wish_id =", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdNotEqualTo(Integer value) {
            addCriterion("wish_id <>", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdGreaterThan(Integer value) {
            addCriterion("wish_id >", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wish_id >=", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdLessThan(Integer value) {
            addCriterion("wish_id <", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdLessThanOrEqualTo(Integer value) {
            addCriterion("wish_id <=", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdIn(List<Integer> values) {
            addCriterion("wish_id in", values, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdNotIn(List<Integer> values) {
            addCriterion("wish_id not in", values, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdBetween(Integer value1, Integer value2) {
            addCriterion("wish_id between", value1, value2, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wish_id not between", value1, value2, "wishId");
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

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andPubHouseIsNull() {
            addCriterion("pub_house is null");
            return (Criteria) this;
        }

        public Criteria andPubHouseIsNotNull() {
            addCriterion("pub_house is not null");
            return (Criteria) this;
        }

        public Criteria andPubHouseEqualTo(String value) {
            addCriterion("pub_house =", value, "pubHouse");
            return (Criteria) this;
        }

        public Criteria andPubHouseNotEqualTo(String value) {
            addCriterion("pub_house <>", value, "pubHouse");
            return (Criteria) this;
        }

        public Criteria andPubHouseGreaterThan(String value) {
            addCriterion("pub_house >", value, "pubHouse");
            return (Criteria) this;
        }

        public Criteria andPubHouseGreaterThanOrEqualTo(String value) {
            addCriterion("pub_house >=", value, "pubHouse");
            return (Criteria) this;
        }

        public Criteria andPubHouseLessThan(String value) {
            addCriterion("pub_house <", value, "pubHouse");
            return (Criteria) this;
        }

        public Criteria andPubHouseLessThanOrEqualTo(String value) {
            addCriterion("pub_house <=", value, "pubHouse");
            return (Criteria) this;
        }

        public Criteria andPubHouseLike(String value) {
            addCriterion("pub_house like", value, "pubHouse");
            return (Criteria) this;
        }

        public Criteria andPubHouseNotLike(String value) {
            addCriterion("pub_house not like", value, "pubHouse");
            return (Criteria) this;
        }

        public Criteria andPubHouseIn(List<String> values) {
            addCriterion("pub_house in", values, "pubHouse");
            return (Criteria) this;
        }

        public Criteria andPubHouseNotIn(List<String> values) {
            addCriterion("pub_house not in", values, "pubHouse");
            return (Criteria) this;
        }

        public Criteria andPubHouseBetween(String value1, String value2) {
            addCriterion("pub_house between", value1, value2, "pubHouse");
            return (Criteria) this;
        }

        public Criteria andPubHouseNotBetween(String value1, String value2) {
            addCriterion("pub_house not between", value1, value2, "pubHouse");
            return (Criteria) this;
        }

        public Criteria andWishDetailIsNull() {
            addCriterion("wish_detail is null");
            return (Criteria) this;
        }

        public Criteria andWishDetailIsNotNull() {
            addCriterion("wish_detail is not null");
            return (Criteria) this;
        }

        public Criteria andWishDetailEqualTo(String value) {
            addCriterion("wish_detail =", value, "wishDetail");
            return (Criteria) this;
        }

        public Criteria andWishDetailNotEqualTo(String value) {
            addCriterion("wish_detail <>", value, "wishDetail");
            return (Criteria) this;
        }

        public Criteria andWishDetailGreaterThan(String value) {
            addCriterion("wish_detail >", value, "wishDetail");
            return (Criteria) this;
        }

        public Criteria andWishDetailGreaterThanOrEqualTo(String value) {
            addCriterion("wish_detail >=", value, "wishDetail");
            return (Criteria) this;
        }

        public Criteria andWishDetailLessThan(String value) {
            addCriterion("wish_detail <", value, "wishDetail");
            return (Criteria) this;
        }

        public Criteria andWishDetailLessThanOrEqualTo(String value) {
            addCriterion("wish_detail <=", value, "wishDetail");
            return (Criteria) this;
        }

        public Criteria andWishDetailLike(String value) {
            addCriterion("wish_detail like", value, "wishDetail");
            return (Criteria) this;
        }

        public Criteria andWishDetailNotLike(String value) {
            addCriterion("wish_detail not like", value, "wishDetail");
            return (Criteria) this;
        }

        public Criteria andWishDetailIn(List<String> values) {
            addCriterion("wish_detail in", values, "wishDetail");
            return (Criteria) this;
        }

        public Criteria andWishDetailNotIn(List<String> values) {
            addCriterion("wish_detail not in", values, "wishDetail");
            return (Criteria) this;
        }

        public Criteria andWishDetailBetween(String value1, String value2) {
            addCriterion("wish_detail between", value1, value2, "wishDetail");
            return (Criteria) this;
        }

        public Criteria andWishDetailNotBetween(String value1, String value2) {
            addCriterion("wish_detail not between", value1, value2, "wishDetail");
            return (Criteria) this;
        }

        public Criteria andHasCheckIsNull() {
            addCriterion("has_check is null");
            return (Criteria) this;
        }

        public Criteria andHasCheckIsNotNull() {
            addCriterion("has_check is not null");
            return (Criteria) this;
        }

        public Criteria andHasCheckEqualTo(Integer value) {
            addCriterion("has_check =", value, "hasCheck");
            return (Criteria) this;
        }

        public Criteria andHasCheckNotEqualTo(Integer value) {
            addCriterion("has_check <>", value, "hasCheck");
            return (Criteria) this;
        }

        public Criteria andHasCheckGreaterThan(Integer value) {
            addCriterion("has_check >", value, "hasCheck");
            return (Criteria) this;
        }

        public Criteria andHasCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_check >=", value, "hasCheck");
            return (Criteria) this;
        }

        public Criteria andHasCheckLessThan(Integer value) {
            addCriterion("has_check <", value, "hasCheck");
            return (Criteria) this;
        }

        public Criteria andHasCheckLessThanOrEqualTo(Integer value) {
            addCriterion("has_check <=", value, "hasCheck");
            return (Criteria) this;
        }

        public Criteria andHasCheckIn(List<Integer> values) {
            addCriterion("has_check in", values, "hasCheck");
            return (Criteria) this;
        }

        public Criteria andHasCheckNotIn(List<Integer> values) {
            addCriterion("has_check not in", values, "hasCheck");
            return (Criteria) this;
        }

        public Criteria andHasCheckBetween(Integer value1, Integer value2) {
            addCriterion("has_check between", value1, value2, "hasCheck");
            return (Criteria) this;
        }

        public Criteria andHasCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("has_check not between", value1, value2, "hasCheck");
            return (Criteria) this;
        }

        public Criteria andWishDateIsNull() {
            addCriterion("wish_date is null");
            return (Criteria) this;
        }

        public Criteria andWishDateIsNotNull() {
            addCriterion("wish_date is not null");
            return (Criteria) this;
        }

        public Criteria andWishDateEqualTo(Date value) {
            addCriterion("wish_date =", value, "wishDate");
            return (Criteria) this;
        }

        public Criteria andWishDateNotEqualTo(Date value) {
            addCriterion("wish_date <>", value, "wishDate");
            return (Criteria) this;
        }

        public Criteria andWishDateGreaterThan(Date value) {
            addCriterion("wish_date >", value, "wishDate");
            return (Criteria) this;
        }

        public Criteria andWishDateGreaterThanOrEqualTo(Date value) {
            addCriterion("wish_date >=", value, "wishDate");
            return (Criteria) this;
        }

        public Criteria andWishDateLessThan(Date value) {
            addCriterion("wish_date <", value, "wishDate");
            return (Criteria) this;
        }

        public Criteria andWishDateLessThanOrEqualTo(Date value) {
            addCriterion("wish_date <=", value, "wishDate");
            return (Criteria) this;
        }

        public Criteria andWishDateIn(List<Date> values) {
            addCriterion("wish_date in", values, "wishDate");
            return (Criteria) this;
        }

        public Criteria andWishDateNotIn(List<Date> values) {
            addCriterion("wish_date not in", values, "wishDate");
            return (Criteria) this;
        }

        public Criteria andWishDateBetween(Date value1, Date value2) {
            addCriterion("wish_date between", value1, value2, "wishDate");
            return (Criteria) this;
        }

        public Criteria andWishDateNotBetween(Date value1, Date value2) {
            addCriterion("wish_date not between", value1, value2, "wishDate");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
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