package com.flight.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="users")
public class Users {
		public Users() {
			
		}

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "user_id")
		private int userId;
		
		@Column(name ="username")
		private String userName;
		
		@Column(name="password", nullable=false)
		private String password;
		
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "user_role", 
		      joinColumns = @JoinColumn(name="user_id", referencedColumnName="user_id"),
		      inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName="role_id"))
	  	private Set<Role> roles = new HashSet<>();

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUsername() {
			return userName;
		}

		public void setUsername(String username) {
			this.userName = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
		
		
		
}