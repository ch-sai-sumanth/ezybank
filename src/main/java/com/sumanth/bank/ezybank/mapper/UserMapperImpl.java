package com.sumanth.bank.ezybank.mapper;


import com.sumanth.bank.ezybank.model.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public void updateUserDetails(User source, User target) {
        if (source == null || target == null) {
            return;
        }

        // Update only allowed fields with validation
        updateIfValid(source.getName(), target::setName);
        updateIfValid(source.getEmail(), target::setEmail);
        updateIfValid(source.getCountryCode(), target::setCountryCode);
        updateIfValid(source.getPhoneNumber(), target::setPhoneNumber);
        updateIfValid(source.getAddress(), target::setAddress);

        // Explicitly excluded:
        // - password (security)
        // - id (immutable)
        // - account (should be managed separately)
    }

    private void updateIfValid(String newValue, java.util.function.Consumer<String> setter) {
        if (StringUtils.hasText(newValue)) {
            setter.accept(newValue.trim());
        }
    }
}
