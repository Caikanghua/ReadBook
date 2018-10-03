package com.readbook.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RbBookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RbBookExample() {
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

        public Criteria andIsbnIsNull() {
            addCriterion("ISBN is null");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNotNull() {
            addCriterion("ISBN is not null");
            return (Criteria) this;
        }

        public Criteria andIsbnEqualTo(String value) {
            addCriterion("ISBN =", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotEqualTo(String value) {
            addCriterion("ISBN <>", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThan(String value) {
            addCriterion("ISBN >", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("ISBN >=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThan(String value) {
            addCriterion("ISBN <", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThanOrEqualTo(String value) {
            addCriterion("ISBN <=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLike(String value) {
            addCriterion("ISBN like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotLike(String value) {
            addCriterion("ISBN not like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnIn(List<String> values) {
            addCriterion("ISBN in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotIn(List<String> values) {
            addCriterion("ISBN not in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnBetween(String value1, String value2) {
            addCriterion("ISBN between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotBetween(String value1, String value2) {
            addCriterion("ISBN not between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
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

        public Criteria andPubDateIsNull() {
            addCriterion("pub_date is null");
            return (Criteria) this;
        }

        public Criteria andPubDateIsNotNull() {
            addCriterion("pub_date is not null");
            return (Criteria) this;
        }

        public Criteria andPubDateEqualTo(Date value) {
            addCriterion("pub_date =", value, "pubDate");
            return (Criteria) this;
        }

        public Criteria andPubDateNotEqualTo(Date value) {
            addCriterion("pub_date <>", value, "pubDate");
            return (Criteria) this;
        }

        public Criteria andPubDateGreaterThan(Date value) {
            addCriterion("pub_date >", value, "pubDate");
            return (Criteria) this;
        }

        public Criteria andPubDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pub_date >=", value, "pubDate");
            return (Criteria) this;
        }

        public Criteria andPubDateLessThan(Date value) {
            addCriterion("pub_date <", value, "pubDate");
            return (Criteria) this;
        }

        public Criteria andPubDateLessThanOrEqualTo(Date value) {
            addCriterion("pub_date <=", value, "pubDate");
            return (Criteria) this;
        }

        public Criteria andPubDateIn(List<Date> values) {
            addCriterion("pub_date in", values, "pubDate");
            return (Criteria) this;
        }

        public Criteria andPubDateNotIn(List<Date> values) {
            addCriterion("pub_date not in", values, "pubDate");
            return (Criteria) this;
        }

        public Criteria andPubDateBetween(Date value1, Date value2) {
            addCriterion("pub_date between", value1, value2, "pubDate");
            return (Criteria) this;
        }

        public Criteria andPubDateNotBetween(Date value1, Date value2) {
            addCriterion("pub_date not between", value1, value2, "pubDate");
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

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andTagsIsNull() {
            addCriterion("tags is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("tags is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(Integer value) {
            addCriterion("tags =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(Integer value) {
            addCriterion("tags <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(Integer value) {
            addCriterion("tags >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(Integer value) {
            addCriterion("tags >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(Integer value) {
            addCriterion("tags <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(Integer value) {
            addCriterion("tags <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<Integer> values) {
            addCriterion("tags in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<Integer> values) {
            addCriterion("tags not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(Integer value1, Integer value2) {
            addCriterion("tags between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(Integer value1, Integer value2) {
            addCriterion("tags not between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andProviderIsNull() {
            addCriterion("provider is null");
            return (Criteria) this;
        }

        public Criteria andProviderIsNotNull() {
            addCriterion("provider is not null");
            return (Criteria) this;
        }

        public Criteria andProviderEqualTo(String value) {
            addCriterion("provider =", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotEqualTo(String value) {
            addCriterion("provider <>", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThan(String value) {
            addCriterion("provider >", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThanOrEqualTo(String value) {
            addCriterion("provider >=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThan(String value) {
            addCriterion("provider <", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThanOrEqualTo(String value) {
            addCriterion("provider <=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLike(String value) {
            addCriterion("provider like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotLike(String value) {
            addCriterion("provider not like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderIn(List<String> values) {
            addCriterion("provider in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotIn(List<String> values) {
            addCriterion("provider not in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderBetween(String value1, String value2) {
            addCriterion("provider between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotBetween(String value1, String value2) {
            addCriterion("provider not between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andReadCntIsNull() {
            addCriterion("read_cnt is null");
            return (Criteria) this;
        }

        public Criteria andReadCntIsNotNull() {
            addCriterion("read_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andReadCntEqualTo(Integer value) {
            addCriterion("read_cnt =", value, "readCnt");
            return (Criteria) this;
        }

        public Criteria andReadCntNotEqualTo(Integer value) {
            addCriterion("read_cnt <>", value, "readCnt");
            return (Criteria) this;
        }

        public Criteria andReadCntGreaterThan(Integer value) {
            addCriterion("read_cnt >", value, "readCnt");
            return (Criteria) this;
        }

        public Criteria andReadCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_cnt >=", value, "readCnt");
            return (Criteria) this;
        }

        public Criteria andReadCntLessThan(Integer value) {
            addCriterion("read_cnt <", value, "readCnt");
            return (Criteria) this;
        }

        public Criteria andReadCntLessThanOrEqualTo(Integer value) {
            addCriterion("read_cnt <=", value, "readCnt");
            return (Criteria) this;
        }

        public Criteria andReadCntIn(List<Integer> values) {
            addCriterion("read_cnt in", values, "readCnt");
            return (Criteria) this;
        }

        public Criteria andReadCntNotIn(List<Integer> values) {
            addCriterion("read_cnt not in", values, "readCnt");
            return (Criteria) this;
        }

        public Criteria andReadCntBetween(Integer value1, Integer value2) {
            addCriterion("read_cnt between", value1, value2, "readCnt");
            return (Criteria) this;
        }

        public Criteria andReadCntNotBetween(Integer value1, Integer value2) {
            addCriterion("read_cnt not between", value1, value2, "readCnt");
            return (Criteria) this;
        }

        public Criteria andCommentCntIsNull() {
            addCriterion("comment_cnt is null");
            return (Criteria) this;
        }

        public Criteria andCommentCntIsNotNull() {
            addCriterion("comment_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCntEqualTo(Integer value) {
            addCriterion("comment_cnt =", value, "commentCnt");
            return (Criteria) this;
        }

        public Criteria andCommentCntNotEqualTo(Integer value) {
            addCriterion("comment_cnt <>", value, "commentCnt");
            return (Criteria) this;
        }

        public Criteria andCommentCntGreaterThan(Integer value) {
            addCriterion("comment_cnt >", value, "commentCnt");
            return (Criteria) this;
        }

        public Criteria andCommentCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_cnt >=", value, "commentCnt");
            return (Criteria) this;
        }

        public Criteria andCommentCntLessThan(Integer value) {
            addCriterion("comment_cnt <", value, "commentCnt");
            return (Criteria) this;
        }

        public Criteria andCommentCntLessThanOrEqualTo(Integer value) {
            addCriterion("comment_cnt <=", value, "commentCnt");
            return (Criteria) this;
        }

        public Criteria andCommentCntIn(List<Integer> values) {
            addCriterion("comment_cnt in", values, "commentCnt");
            return (Criteria) this;
        }

        public Criteria andCommentCntNotIn(List<Integer> values) {
            addCriterion("comment_cnt not in", values, "commentCnt");
            return (Criteria) this;
        }

        public Criteria andCommentCntBetween(Integer value1, Integer value2) {
            addCriterion("comment_cnt between", value1, value2, "commentCnt");
            return (Criteria) this;
        }

        public Criteria andCommentCntNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_cnt not between", value1, value2, "commentCnt");
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

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreCntIsNull() {
            addCriterion("score_cnt is null");
            return (Criteria) this;
        }

        public Criteria andScoreCntIsNotNull() {
            addCriterion("score_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andScoreCntEqualTo(Integer value) {
            addCriterion("score_cnt =", value, "scoreCnt");
            return (Criteria) this;
        }

        public Criteria andScoreCntNotEqualTo(Integer value) {
            addCriterion("score_cnt <>", value, "scoreCnt");
            return (Criteria) this;
        }

        public Criteria andScoreCntGreaterThan(Integer value) {
            addCriterion("score_cnt >", value, "scoreCnt");
            return (Criteria) this;
        }

        public Criteria andScoreCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("score_cnt >=", value, "scoreCnt");
            return (Criteria) this;
        }

        public Criteria andScoreCntLessThan(Integer value) {
            addCriterion("score_cnt <", value, "scoreCnt");
            return (Criteria) this;
        }

        public Criteria andScoreCntLessThanOrEqualTo(Integer value) {
            addCriterion("score_cnt <=", value, "scoreCnt");
            return (Criteria) this;
        }

        public Criteria andScoreCntIn(List<Integer> values) {
            addCriterion("score_cnt in", values, "scoreCnt");
            return (Criteria) this;
        }

        public Criteria andScoreCntNotIn(List<Integer> values) {
            addCriterion("score_cnt not in", values, "scoreCnt");
            return (Criteria) this;
        }

        public Criteria andScoreCntBetween(Integer value1, Integer value2) {
            addCriterion("score_cnt between", value1, value2, "scoreCnt");
            return (Criteria) this;
        }

        public Criteria andScoreCntNotBetween(Integer value1, Integer value2) {
            addCriterion("score_cnt not between", value1, value2, "scoreCnt");
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