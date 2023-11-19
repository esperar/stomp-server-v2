package esperar.stompv2.domain.room.repository;

import esperar.stompv2.domain.room.ChatRoom;
import org.springframework.data.repository.CrudRepository;

public interface ChatRoomRepository extends CrudRepository<ChatRoom, Long> {
}
