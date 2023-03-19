package com.liuche.wiki.service.impl;

import com.liuche.wiki.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class WsServer {
    @Autowired
    private WebSocketServer webSocketServer;
    @Async // 这个方法实现异步化
    public void sendInfo(String msg) {
        webSocketServer.sendInfo(msg); // 交给websocket发送
    }
}
