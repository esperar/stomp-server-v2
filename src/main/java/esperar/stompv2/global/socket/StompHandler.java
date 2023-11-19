package esperar.stompv2.global.socket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StompHandler implements ChannelInterceptor {

    // private final TokenProvider tokenProvider;

    // TODO: Security Jwt Authorization Logic
}
