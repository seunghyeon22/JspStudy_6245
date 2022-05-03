package repository;

import repository.user.User;

public interface AuthDao {
	public int signinByUsernameAndPassword(String username, String password); //로그인 
	public boolean usernameCheckByUsername(String username); //아이디 중복확인
	public int signup(User user); //회원가입
	public User getUserByUsername(String username);
}
