package com.imShare.service.impl;

import com.imShare.model.*;
import com.imShare.repository.FollowerRepository;
import com.imShare.repository.RoleRepository;
import com.imShare.repository.UserRepository;
import com.imShare.response.BaseResponse;
import com.imShare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

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

}
