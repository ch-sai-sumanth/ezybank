package com.sumanth.bank.ezybank.mapper;




import com.sumanth.bank.ezybank.model.User;

public interface UserMapper {
    /**
     * Updates non-sensitive user details from source to target
     * @param source User with updated values
     * @param target Existing user to be updated
     */
    void updateUserDetails(User source, User target);
}
