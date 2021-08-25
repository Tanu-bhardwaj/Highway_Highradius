package com.higradius;

public class invoice_structure {
	private String customer_number;
	private String customer_name;
	private String invoice_number;
	private String invoice_Amount;
	private String due_date;
	private String Predicted_Date;
	private String Delay;
	private String Notes;
	public String getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getInvoice_number() {
		return invoice_number;
	}
	public void setInvoice_number(String invoice_number) {
		this.invoice_number = invoice_number;
	}
	public String getInvoice_Amount() {
		return invoice_Amount;
	}
	public void setInvoice_Amount(String invoice_Amount) {
		this.invoice_Amount = invoice_Amount;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getPredicted_Date() {
		return Predicted_Date;
	}
	public void setPredicted_Date(String predicted_Date) {
		Predicted_Date = predicted_Date;
	}
	public String getDelay() {
		return Delay;
	}
	public void setDelay(String delay) {
		Delay = delay;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	




}
