package com.shop.car.dto;


public class Model {
    private int id;
    private String mdname;
    private String image_url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMdname() {
		return mdname;
	}
	public void setMdname(String mdname) {
		this.mdname = mdname;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	@Override
	public String toString() {
		return "Model [id=" + id + ", mdname=" + mdname + ", image_url=" + image_url + "]";
	}
	public Model(int id, String mdname, String image_url) {
		super();
		this.id = id;
		this.mdname = mdname;
		this.image_url = image_url;
	}
	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}

    
   
}
