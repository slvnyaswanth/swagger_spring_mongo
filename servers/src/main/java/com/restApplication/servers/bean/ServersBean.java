package com.restApplication.servers.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServersBean {
    private String name;
    private String id;
    private String language;
    private String framework;
}
