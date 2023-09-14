package com.tencoding.bank.repository.interfaces;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.tencoding.bank.repository.model.User;


//ibatis -> 2.4 버전 이후로 MyBatis 로 이름 변경됨
//mapper 반드시 기술을 해주어야 동작 한다
@Mapper
public interface UserRepository {
	public int insert(User user);
	public int updateById(User user);
	public int deleteById(Integer id);
	public User findById(Integer id);
	public List<User> findAll();
}
