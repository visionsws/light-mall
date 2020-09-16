package com.vicente.lightmall.service;

import com.vicente.lightmall.entity.UserOnline;

import java.util.List;

public interface SessionService {
    List<UserOnline> list();
    boolean forceLogout(String sessionId);
}