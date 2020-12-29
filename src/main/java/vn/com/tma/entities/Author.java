package vn.com.tma.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "display_name", nullable = false)
	private String displayName;
	
	@Column(name ="birthday", nullable = false)
	private Date  birthday;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
    private Collection<New> news;

	public Author(Long id, String name, String displayName, Date birthday, Collection<New> news) {
		super();
		this.id = id;
		this.name = name;
		this.displayName = displayName;
		this.birthday = birthday;
		this.news = news;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Collection<New> getNews() {
		return news;
	}

	public void setNews(Collection<New> news) {
		this.news = news;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", displayName=" + displayName + ", birthday=" + birthday
				+ ", news=" + news + "]";
	}
    
    
}
