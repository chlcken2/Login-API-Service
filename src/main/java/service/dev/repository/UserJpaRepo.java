package service.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.dev.entity.User;
import service.dev.entity.dto.UserInquiryProfile;

import java.util.List;
import java.util.Optional;

public interface UserJpaRepo extends JpaRepository<User, Long> {
    Optional<User> findById(String email);

    User getById(Long idx);


//    List<UserInquiryProfile> findByUserDetail(UserInquiryProfile u);
}
