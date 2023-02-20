package com.example.springSecurity.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.springSecurity.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(STUDENT_READ)),
    STUDENT(Sets.newHashSet());

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    private final Set<ApplicationUserPermission> permissions;

    public Set<ApplicationUserPermission> getPermission(){
        return  permissions;
    }

    public Set<SimpleGrantedAuthority> getSimpleGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permission = getPermission().stream()
                .map(permissions -> new SimpleGrantedAuthority(permissions.getPermission()))
                .collect(Collectors.toSet());
        permission.add(new SimpleGrantedAuthority("ROLE_"+ this.name()));
        return permission;

    }
}
