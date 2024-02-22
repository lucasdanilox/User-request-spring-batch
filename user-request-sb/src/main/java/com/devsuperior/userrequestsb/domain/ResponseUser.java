package com.devsuperior.userrequestsb.domain;

import com.devsuperior.userrequestsb.dto.UserDTO;

import java.util.List;

public class ResponseUser {

    private List<UserDTO> content;

    public List<UserDTO> getContent() {
        return content;
    }
}
