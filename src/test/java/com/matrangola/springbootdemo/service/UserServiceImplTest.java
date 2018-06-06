package com.matrangola.springbootdemo.service;

import com.matrangola.springbootdemo.data.model.User;
import com.matrangola.springbootdemo.data.repository.UserRepository;
import com.matrangola.springbootdemo.exception.ResourceException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class UserServiceImplTest {

    private UserServiceImpl userServiceImpl;
    private List<User> users;

    private UserRepository repository = new UserRepository() {
        @Override
        public List<User> findAll() {
            return null;
        }

        @Override
        public List<User> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<User> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends User> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends User> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<User> entities) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public User getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<User> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> S save(S entity) {
            return null;
        }

        @Override
        public Optional<User> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(User entity) {

        }

        @Override
        public void deleteAll(Iterable<? extends User> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends User> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends User> boolean exists(Example<S> example) {
            return false;
        }
    };

    @Before
    public void setUp() throws Exception {
        userServiceImpl = new UserServiceImpl(repository);
    }

    @Test
    public void addUser() {
        User user = new User();

        userServiceImpl.addUser(user);

    }

    @Test
    public void updateUser() {
        User user = new User();

        userServiceImpl.updateUser(user);

    }

    @Test
    public void getUser() {
        try {
            User user = userServiceImpl.getUser(1L);
            assert(false);
        }
        catch (ResourceException e)
        {

        }
    }
}