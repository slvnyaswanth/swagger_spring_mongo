package com.restApplication.servers.service;

import com.restApplication.servers.bean.ServersBean;

import java.util.List;

public interface ServersService {
    public String addServerDetails(ServersBean serversBean);
    public List<ServersBean> getAllServers();
    public List<ServersBean> getServerByName(String name);
    public List<ServersBean> getAllServersById(String id);
    public String deleteServerById(String id);
}
