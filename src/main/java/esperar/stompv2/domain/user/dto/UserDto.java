package esperar.stompv2.domain.user.dto;

import esperar.stompv2.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

public class UserDto {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Response {
        private UUID id;
        private String name;
        private Integer age;

        public static Response of(User user) {
            return Response.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .age(user.getAge())
                    .build();
        }
    }
}
