package cn.letcode.winter.user.repository;

import cn.letcode.winter.user.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

     User findUserById(Long id);

}
