package com.san.enverse.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "beam", catalog = "test")
public class Beam implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "beam_id", unique = true, nullable = false)
	private Integer beamId;
	
	@Column(name = "beam_tool_cat", unique = false, nullable = false)
	private String beamToolCat;
	
	@ManyToOne
    @JoinColumn(name="store_number")
    private Store store;
	
	@Version
	private Integer version;
	
	public Beam(){ }
	
	public Beam(Integer beanId, String beamToolCat) {
		super();
		this.beamId = beanId;
		this.beamToolCat = beamToolCat;
	}
	
	
	public Integer getBeamId() {
		return beamId;
	}
	public void setBeamId(Integer beanId) {
		this.beamId = beanId;
	}
	
	
	public String getBeamToolCat() {
		return beamToolCat;
	}
	public void setBeamToolCat(String beamToolCat) {
		this.beamToolCat = beamToolCat;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	public String toString(){
		return "{ Beam Id: "+beamId+" ToolCatGrp: "+beamToolCat+" Of Store "+store.getStoreName()+" }";
	}
	
}
