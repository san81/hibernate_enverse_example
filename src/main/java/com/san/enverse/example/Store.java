package com.san.enverse.example;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "store", catalog = "test", uniqueConstraints = {
		@UniqueConstraint(columnNames = "store_name") })
public class Store implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "store_number", unique = true, nullable = false)
	private Integer storeNumber;
	
	@Column(name = "store_name", unique = false, nullable = true)
	private String storeName;
	
	@OneToMany(mappedBy="store", cascade=CascadeType.ALL, fetch = FetchType.EAGER, targetEntity=Beam.class)
    private Set<Beam> beams=new LinkedHashSet<Beam>();
	
	public Store(){
		
	}
	
	public Store(Integer storeNumber, String storeName){
		this.storeNumber=storeNumber;
		this.storeName=storeName;
	}
	
	
	public Integer getStoreNumber(){
		return this.storeNumber;
	}
	
	public void setStoreNumber(Integer storeNumber){
		this.storeNumber=storeNumber;
	}
	
	
	public String getStoreName(){
		return this.storeName;
	}
	
	public void setStoreName(String storeName){
		this.storeName=storeName;
	}

	public Set<Beam> getBeams() {
		return beams;
	}

	public void setBeams(Set<Beam> beams) {
		this.beams = beams;
	}
	
	public void addBeam(Beam beam){
		beam.setStore(this);
		this.beams.add(beam);
	}
	
}
