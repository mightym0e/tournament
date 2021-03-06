package de.htw.tournament.model;
// default package
// Generated 09.02.2015 16:09:37 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
@Entity
@Table(schema = "tournament")
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("rawtypes")
public class Competition implements Comparable, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "identity", unique = true, nullable = false)
	private Long identity;
	
	@XmlTransient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "logoReference", nullable = false)
	private Document logo;

	@XmlTransient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tournamentReference", nullable = false)
	private Tournament tournament;
	
	@Column(name = "season", nullable = false)
	private short season;
	
	@Column(name = "pointsPerWin", nullable = false, precision = 12, scale = 0)
	private float pointsPerWin;
	
	@Column(name = "pointsPerDraw", nullable = false, precision = 12, scale = 0)
	private float pointsPerDraw;
	
	@Column(name = "pointsPerLoss", nullable = false, precision = 12, scale = 0)
	private float pointsPerLoss;
	
	@XmlTransient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "competition")
	private Set<Division> divisions = new HashSet<Division>(0);

	
	public Competition() {
	}

	public Competition(Document document, Tournament tournament, short season,
			float pointsPerWin, float pointsPerDraw, float pointsPerLoss) {
		this.logo = document;
		this.tournament = tournament;
		this.season = season;
		this.pointsPerWin = pointsPerWin;
		this.pointsPerDraw = pointsPerDraw;
		this.pointsPerLoss = pointsPerLoss;
	}

	public Competition(Document document, Tournament tournament, short season,
			float pointsPerWin, float pointsPerDraw, float pointsPerLoss,
			Set<Division> divisions) {
		this.logo = document;
		this.tournament = tournament;
		this.season = season;
		this.pointsPerWin = pointsPerWin;
		this.pointsPerDraw = pointsPerDraw;
		this.pointsPerLoss = pointsPerLoss;
		this.divisions = divisions;
	}

	
	public Long getIdentity() {
		return this.identity;
	}

	public void setIdentity(Long identity) {
		this.identity = identity;
	}

	
	public Document getLogo() {
		return this.logo;
	}

	public void setLogo(Document logo) {
		this.logo = logo;
	}

	
	public Tournament getTournament() {
		return this.tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	
	public short getSeason() {
		return this.season;
	}

	public void setSeason(short season) {
		this.season = season;
	}

	
	public float getPointsPerWin() {
		return this.pointsPerWin;
	}

	public void setPointsPerWin(float pointsPerWin) {
		this.pointsPerWin = pointsPerWin;
	}

	
	public float getPointsPerDraw() {
		return this.pointsPerDraw;
	}

	public void setPointsPerDraw(float pointsPerDraw) {
		this.pointsPerDraw = pointsPerDraw;
	}

	
	public float getPointsPerLoss() {
		return this.pointsPerLoss;
	}

	public void setPointsPerLoss(float pointsPerLoss) {
		this.pointsPerLoss = pointsPerLoss;
	}

	
	public Set<Division> getDivisions() {
		return this.divisions;
	}

	public void setDivisions(Set<Division> divisions) {
		this.divisions = divisions;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Competition){
			Competition temp = (Competition) o;
			if(temp.identity == this.identity){
				return 0;
			} else if (this.identity < temp.identity){
				return -1;
			} else {
				return +1;
			}
		} else {
			return -1;
		}
	}

}
