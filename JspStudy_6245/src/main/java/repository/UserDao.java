package repository;

import repository.user.User;

public interface UserDao {
	public int updateUserByUserCode(User user); //회원정보 수정
	public int updatePasswordByUserCode(int userCode, String password); //비밀번호 변경
	public int deleteUser(int userCode); //회원탈퇴
}
