package platform.web.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.web.springmvc.dao.UserDao;
import platform.web.springmvc.model.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Transactional
	public List<User> getAll(){
		return userDao.getAll();
	}

	@Transactional
	public List<User> getUserByPermissionID(int perId){
		return userDao.getUserByPermissionID(perId);
	}

	@Transactional
	public User getUserByID(int id){
		return userDao.getUserByID(id);
	}

	@Transactional
	public List<User> getUserByAddress(String address){
		return userDao.getUserByAddress(address);
	}


	/**
	 * Login system
	 * @param userName	user-name of account
	 * @param pass		Pass word
	 * @return			User object
	 */
	@Transactional
	public User login(String userName, String pass){
		return userDao.login(userName, pass);
	}

	/**
	 * Get all users, using Native SQL
	 * @return List<User>
	 */
	@Transactional
	public List<User> getAllUserWithNativeSQL(){
		return userDao.getAllUserWithNativeSQL();
	}
	
	@Transactional
	public void insertUser(User user){
		userDao.insertUser(user);
	}

}
