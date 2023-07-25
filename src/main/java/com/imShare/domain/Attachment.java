package com.imShare.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@Deprecated
public class Attachment implements Serializable {
    private String name;
    private String type;
    private String hash;
    private Long size;
    private String url;
}
