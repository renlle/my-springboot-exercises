package com.szs.springboot04.exception;

/**
 * @Author SongZeShan
 * @Email renlle@qq.com
 * @Create 2019/3/1 15:42
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException(){
        super("用户不存在");
    }
}
