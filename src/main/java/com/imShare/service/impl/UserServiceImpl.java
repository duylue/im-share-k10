package com.imShare.service.impl;

import com.imShare.exception.BusinessException;
import com.imShare.model.*;
import com.imShare.repository.FollowerRepository;
import com.imShare.repository.RoleRepository;
import com.imShare.repository.UserPagingRepository;
import com.imShare.repository.UserRepository;
import com.imShare.response.BaseResponse;
import com.imShare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends BaseResponse implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserPagingRepository userPagingRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private FollowerRepository followerRepository;

    @Override
    public void addUser(User user) {
        User usercheck = userRepository.findByUserName(user.getUserName());
        if(usercheck==null){
        Role role = roleRepository.findRoleByName("ROLE_USER");
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        Follower follower = new Follower();
        user.setFollower(follower);
        follower.setUser(user);
        List<Follower> following = new ArrayList<>();
        user.setFollowings(following);
        Save save = new Save();
        user.setSave(save);
        save.setUser(user);
        List<Post> posts = new ArrayList<>();
        user.setPosts(posts);
        Profile profile = new Profile();
        user.setProfile(profile);
        profile.setUser(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);}

    }

    @Override
    public ResponseEntity<?> findByUsername(String username) {
        return getResponseEntity(userRepository.findByUserName(username));
    }

    @Override
    public ResponseEntity<?> editProfile(String username, Profile profile) {
        User user = userRepository.findByUserName(username);
        Profile uProfile = user.getProfile();
        uProfile.setProfilePhoto(profile.getProfilePhoto());
        uProfile.setName(profile.getName());
        uProfile.setBio(profile.getBio());
        uProfile.setBirthday(profile.getBirthday());
        uProfile.setGender(profile.getGender());
        userRepository.save(user);
        return getResponseEntity("Lưu thành công");
    }

    @Override
    public ResponseEntity<?> changePass(String username,String oldpassword, String password) {
        User user = userRepository.findByUserName(username);
        if (passwordEncoder.matches(oldpassword, user.getPassword())){
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
            return getResponseEntity("Đổi thành công");
        } else {
            return getResponseEntity("Mật khẩu không đúng");
        }
    }

    @Override
    public ResponseEntity<?> getFollowingByUsername(String uname, int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page,size);
            return getResponseEntity(userPagingRepository.getFollowingByUsername(uname, pageable));
        } catch (Exception e) {
            throw new BusinessException(500, e.getMessage());
        }

    }

    @Override
    public ResponseEntity<?> following(String usename, String usernameFollower) {
        User user = userRepository.findByUserName(usename);
        User userF = userRepository.findByUserName(usernameFollower);
        Follower follower = followerRepository.findFollowerByUser(userF);
        user.getFollowings().add(follower);
        follower.getFollowerUsers().add(user);
        userRepository.save(user);
        return getResponseEntity("Follow thành công");
    }

    @Override
    public ResponseEntity<?> unfollow(String username, String usernameFollower) {
        User user = userRepository.findByUserName(username);
        User userF = userRepository.findByUserName(usernameFollower);
        Follower follower = followerRepository.findFollowerByUser(userF);
        user.getFollowings().remove(follower);
        follower.getFollowerUsers().remove(user);
        userRepository.save(user);
        return getResponseEntity("Unfollow thành công");
    }

    @Override
    public ResponseEntity<?> getUserNotFollow(String username) {
        User user = userRepository.findByUserName(username);
        List<Follower> fullList = followerRepository.findAll();
        List<Follower> following = user.getFollowings();
        fullList.removeAll(following);
        List users = new ArrayList<>();
        for (Follower f:fullList
             ) { users.add(f.getUser());

        }
        return getResponseEntity(users);
    }


}
