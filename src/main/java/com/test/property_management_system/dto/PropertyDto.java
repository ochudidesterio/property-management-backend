package com.test.property_management_system.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Getter
@Setter
public class PropertyDto {
    private String propertyName;
    private String location;
    private MultipartFile[] files;
}
