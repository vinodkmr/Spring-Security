package com.enstage.pg.standalone.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserCredentialsDetails implements UserDetails {

    private String username;
    private String password;
    private boolean isAccountEnabled;
    private List<GrantedAuthority> grantedAuthorityList;

    UserCredentialsDetails(){
    }

    UserCredentialsDetails(UserCredentials userCredentials){
        this.username = userCredentials.getUsername();
        this.password = userCredentials.getPassword();
        this.isAccountEnabled = userCredentials.isAccountBlocked();
        this.grantedAuthorityList = Arrays.stream(userCredentials.getRole().split(","))
                                        .map(role -> new SimpleGrantedAuthority(role))
                                            .collect(Collectors.toList());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public boolean isEnabled() {
        return isAccountEnabled;
    }

	@Override
	public String toString() {
		return "UserCredentialsDetails [username=" + username + ", password=" + password + ", isAccountEnabled="
				+ isAccountEnabled + ", grantedAuthorityList=" + grantedAuthorityList + "]";
	}
}
