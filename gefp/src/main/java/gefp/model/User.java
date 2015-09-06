package gefp.model;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
@Table(name ="Users")
public class User implements UserDetails  {

	

	@Id
	@GeneratedValue
	Long id;

	String username;

	String password;

	boolean enabled;
	
	String email;
	
	String CIN ;


	@OneToOne
	Usertype userrole;

	@ManyToMany
	Set<Checkpoint> checkpoints;

	@ManyToOne
	Department major;

	@OneToOne
	Plan plan;

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Usertype getUserrole() {
		return userrole;
	}

	public void setUserrole(Usertype userrole) {
		this.userrole = userrole;
	}

	public Set<Checkpoint> getCheckpoints() {
		return checkpoints;
	}

	public void setCheckpoints(Set<Checkpoint> checkpoints) {
		this.checkpoints = checkpoints;
	}

	public Department getMajor() {
		return major;
	}

	public void setMajor(Department major) {
		this.major = major;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> author = new HashSet<GrantedAuthority>();
		author.add(new SimpleGrantedAuthority(userrole.getType()));
		return author;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
}
