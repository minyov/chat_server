package com.veselov.chatserver.websocket.config;

import com.veselov.chatserver.websocket.handlers.ChatWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private static final String PATH = "/websocket";

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(getHandler(), PATH);
    }

    @Bean
    public WebSocketHandler getHandler() {
        return new ChatWebSocketHandler();
    }
}
