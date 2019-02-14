package com.springboot.security.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class User implements UserDetails, Serializable { //实现UserDetails 配合security的用户验证
    private Integer id;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", active=" + active +
                ", phone='" + phone + '\'' +
                ", icon='" + icon + '\'' +
                ", roles=" + roles +
                '}';
    }


    private String username;

    private String password;

    private String email;

    private Timestamp createTime;

    private Integer active;

    private String phone;

    private String icon;

    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @JsonIgnore//序列化时忽略注解

    public boolean isAccountNonExpired() { //是否没有用户存活时间
        return true;
    }

    @JsonIgnore

    public boolean isAccountNonLocked() { //没有锁住账户
        return true;
    }

    @JsonIgnore

    public boolean isCredentialsNonExpired() { //没有有过期
        return true;
    }

    @JsonIgnore

    public boolean isEnabled() { //是否激活
        return true;

    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @JsonIgnore

    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}