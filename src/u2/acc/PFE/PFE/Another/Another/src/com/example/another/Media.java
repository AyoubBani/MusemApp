package com.example.another;


public class Media {
	private String titre;
	private String url;
	private String artist ;
	private String code_qr;
	
	public Media() {
 
	}
 
	//Getters and setters
        public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
	public String getCodeQr() {
		return code_qr;
	}
	public void setCodeQr(String code_qr) {
		this.code_qr= code_qr;
	}
	
	
}