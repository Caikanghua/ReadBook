package com.readbook.pojo;

import java.util.ArrayList;
import java.util.List;

public class VoteBookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VoteBookExample() {
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

        public Criteria andVoteBookIdIsNull() {
            addCriterion("vote_book_id is null");
            return (Criteria) this;
        }

        public Criteria andVoteBookIdIsNotNull() {
            addCriterion("vote_book_id is not null");
            return (Criteria) this;
        }

        public Criteria andVoteBookIdEqualTo(Integer value) {
            addCriterion("vote_book_id =", value, "voteBookId");
            return (Criteria) this;
        }

        public Criteria andVoteBookIdNotEqualTo(Integer value) {
            addCriterion("vote_book_id <>", value, "voteBookId");
            return (Criteria) this;
        }

        public Criteria andVoteBookIdGreaterThan(Integer value) {
            addCriterion("vote_book_id >", value, "voteBookId");
            return (Criteria) this;
        }

        public Criteria andVoteBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_book_id >=", value, "voteBookId");
            return (Criteria) this;
        }

        public Criteria andVoteBookIdLessThan(Integer value) {
            addCriterion("vote_book_id <", value, "voteBookId");
            return (Criteria) this;
        }

        public Criteria andVoteBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("vote_book_id <=", value, "voteBookId");
            return (Criteria) this;
        }

        public Criteria andVoteBookIdIn(List<Integer> values) {
            addCriterion("vote_book_id in", values, "voteBookId");
            return (Criteria) this;
        }

        public Criteria andVoteBookIdNotIn(List<Integer> values) {
            addCriterion("vote_book_id not in", values, "voteBookId");
            return (Criteria) this;
        }

        public Criteria andVoteBookIdBetween(Integer value1, Integer value2) {
            addCriterion("vote_book_id between", value1, value2, "voteBookId");
            return (Criteria) this;
        }

        public Criteria andVoteBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_book_id not between", value1, value2, "voteBookId");
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

        public Criteria andVotesIsNull() {
            addCriterion("votes is null");
            return (Criteria) this;
        }

        public Criteria andVotesIsNotNull() {
            addCriterion("votes is not null");
            return (Criteria) this;
        }

        public Criteria andVotesEqualTo(Integer value) {
            addCriterion("votes =", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesNotEqualTo(Integer value) {
            addCriterion("votes <>", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesGreaterThan(Integer value) {
            addCriterion("votes >", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesGreaterThanOrEqualTo(Integer value) {
            addCriterion("votes >=", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesLessThan(Integer value) {
            addCriterion("votes <", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesLessThanOrEqualTo(Integer value) {
            addCriterion("votes <=", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesIn(List<Integer> values) {
            addCriterion("votes in", values, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesNotIn(List<Integer> values) {
            addCriterion("votes not in", values, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesBetween(Integer value1, Integer value2) {
            addCriterion("votes between", value1, value2, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesNotBetween(Integer value1, Integer value2) {
            addCriterion("votes not between", value1, value2, "votes");
            return (Criteria) this;
        }

        public Criteria andBookImgIsNull() {
            addCriterion("book_img is null");
            return (Criteria) this;
        }

        public Criteria andBookImgIsNotNull() {
            addCriterion("book_img is not null");
            return (Criteria) this;
        }

        public Criteria andBookImgEqualTo(String value) {
            addCriterion("book_img =", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgNotEqualTo(String value) {
            addCriterion("book_img <>", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgGreaterThan(String value) {
            addCriterion("book_img >", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgGreaterThanOrEqualTo(String value) {
            addCriterion("book_img >=", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgLessThan(String value) {
            addCriterion("book_img <", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgLessThanOrEqualTo(String value) {
            addCriterion("book_img <=", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgLike(String value) {
            addCriterion("book_img like", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgNotLike(String value) {
            addCriterion("book_img not like", value, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgIn(List<String> values) {
            addCriterion("book_img in", values, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgNotIn(List<String> values) {
            addCriterion("book_img not in", values, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgBetween(String value1, String value2) {
            addCriterion("book_img between", value1, value2, "bookImg");
            return (Criteria) this;
        }

        public Criteria andBookImgNotBetween(String value1, String value2) {
            addCriterion("book_img not between", value1, value2, "bookImg");
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