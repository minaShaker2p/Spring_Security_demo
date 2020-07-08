package com.mina.springsecuritydemo.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.mina.springsecuritydemo.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }


}
