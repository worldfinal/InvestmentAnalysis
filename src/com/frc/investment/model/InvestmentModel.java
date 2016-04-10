package com.frc.investment.model;

public class InvestmentModel {
	private String date;
	private int year;
	private int month;
	private int day;
	private double startPrice;
	private double stopPrice;
	private double minPrice;
	private double maxPrice;
	private Double volumeOfDeal;
	private Long amountOfDeal;
	private Long acountOfDeal;
	private String type;
	/**
	 * @param date
	 * @param year
	 * @param month
	 * @param day
	 * @param startPrice
	 * @param stopPrice
	 * @param minPrice
	 * @param maxPrice
	 * @param volumeOfDeal
	 * @param amountOfDeal
	 * @param acountOfDeal
	 * @param type
	 */
	public InvestmentModel(String date, int year, int month,
			int day, double startPrice, double stopPrice, double minPrice,
			double maxPrice, Double volumeOfDeal, Long amountOfDeal,
			Long acountOfDeal, String type) {
		this.date = date;
		this.year = year;
		this.month = month;
		this.day = day;
		this.startPrice = startPrice;
		this.stopPrice = stopPrice;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.volumeOfDeal = volumeOfDeal;
		this.amountOfDeal = amountOfDeal;
		this.acountOfDeal = acountOfDeal;
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public double getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}
	public double getStopPrice() {
		return stopPrice;
	}
	public void setStopPrice(double stopPrice) {
		this.stopPrice = stopPrice;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Double getVolumeOfDeal() {
		return volumeOfDeal;
	}
	public void setVolumeOfDeal(Double volumeOfDeal) {
		this.volumeOfDeal = volumeOfDeal;
	}
	public Long getAmountOfDeal() {
		return amountOfDeal;
	}
	public void setAmountOfDeal(Long amountOfDeal) {
		this.amountOfDeal = amountOfDeal;
	}
	public Long getAcountOfDeal() {
		return acountOfDeal;
	}
	public void setAcountOfDeal(Long acountOfDeal) {
		this.acountOfDeal = acountOfDeal;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
