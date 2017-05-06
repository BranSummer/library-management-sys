package org.bran.valueBean;

import java.sql.Date;
/**
 * 
 *<p>Title: BookInfor.java</p>
 *<p>Description:图书信息 </p>
 * @author BranSummer
 * @date 2017年5月6日
 */
public class BookInfor {
	//书号
	private String bookId;
	//书名
	private String bookName;
	//书籍类别
	private String bookSort;
	//作者
	private String author;
	//出版社姓名
	private String publishName;
	//出版日期
	private Date publisnDate;
	//登入日期
	private Date InputDate;
	//价格
	private float price;
	//页数
	private int pageNum;
	//关键词
	private String keyWord;
	//是否借出
	private boolean isLend;
	//备注
	private String remarks;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookSort() {
		return bookSort;
	}
	public void setBookSort(String bookSort) {
		this.bookSort = bookSort;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishName() {
		return publishName;
	}
	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
	public Date getPublisnDate() {
		return publisnDate;
	}
	public void setPublisnDate(Date publisnDate) {
		this.publisnDate = publisnDate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public boolean isLend() {
		return isLend;
	}
	public void setLend(boolean isLend) {
		this.isLend = isLend;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getInputDate() {
		return InputDate;
	}
	public void setInputDate(Date inputDate) {
		InputDate = inputDate;
	}
	
}
