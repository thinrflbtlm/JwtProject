package cc.test.invt2.service;

import cc.test.invt2.domain.User;

public interface UserService {

    User login(String username, String userpwd);
}
