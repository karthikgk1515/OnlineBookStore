package com.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="customerInfo")
public class Customer {
	
		@Size(min=8, max=30)
	    private String fullname;
		
		@Id
		@Size(min=10, max=64)
		private String email;
		@Size(min=8, max=16)
		private String password;
		@Size(min=10, max=15)
		private String phoneno;
		@Size(min=10, max=128)
		private String address;
		@Size(min=3, max=32)
		private String city;
		@Size(min=2, max=24)
		private String zipcode;
		@Size(min=3, max=64)
		private String country;
		
		
		public Customer() {
			super();
		}


		public Customer(@Size(min = 8, max = 30) String fullname, @Size(min = 10, max = 64) String email,
				@Size(min = 8, max = 16) String password, @Size(min = 10, max = 15) String phoneno,
				@Size(min = 10, max = 128) String address, @Size(min = 3, max = 32) String city,
				@Size(min = 2, max = 24) String zipcode, @Size(min = 3, max = 64) String country) {
			super();
			this.fullname = fullname;
			this.email = email;
			this.password = password;
			this.phoneno = phoneno;
			this.address = address;
			this.city = city;
			this.zipcode = zipcode;
			this.country = country;
		}


		@Override
		public String toString() {
			return "Customer [fullname=" + fullname + ", email=" + email + ", password=" + password + ", phoneno="
					+ phoneno + ", address=" + address + ", city=" + city + ", zipcode=" + zipcode + ", country="
					+ country + "]";
		}
		
		

}
