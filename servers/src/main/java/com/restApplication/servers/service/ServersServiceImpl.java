package com.restApplication.servers.service;

import com.restApplication.servers.bean.ServersBean;
import com.restApplication.servers.entity.ServersEntity;
import com.restApplication.servers.repository.ServersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ServersServiceImpl implements ServersService {
    @Autowired
    private ServersRepository serversRepository;
    @Override
    public String addServerDetails(ServersBean serversBean) {
        ServersEntity serversEntity=new ServersEntity();
        BeanUtils.copyProperties(serversBean,serversEntity);
        serversRepository.save(serversEntity);
        System.out.println("Saved data to mongo cluster");
        return "Data saved to database";
    }

    @Override
    public List<ServersBean> getAllServers() {
        List<ServersBean> serversBeanList= new ArrayList<>();
        List<ServersEntity> serversEntities=serversRepository.findAll();
        serversEntities.forEach(serversEntity -> {
            ServersBean serversBean = new ServersBean();
            BeanUtils.copyProperties(serversEntity, serversBean);
            serversBeanList.add(serversBean);
        });
        return serversBeanList;
    }

    @Override
    public List<ServersBean> getServerByName(String name) {
        List<ServersBean> serversBeanList= new ArrayList<>();
        List<ServersEntity> serversEntities=serversRepository.findServerByName(name);
        serversEntities.forEach(serversEntity -> {
            ServersBean serversBean = new ServersBean();
            BeanUtils.copyProperties(serversEntity, serversBean);
            serversBeanList.add(serversBean);
        });
        return serversBeanList;
    }

    @Override
    public List<ServersBean> getAllServersById(String id) {
        List<ServersBean> serversBeanList= new ArrayList<>();
        Iterable<ServersEntity> iterable=serversRepository.findAllById(Collections.singleton(id));
        iterable.forEach(serversEntity -> {
                ServersBean serversBean = new ServersBean();
                BeanUtils.copyProperties(serversEntity, serversBean);
                serversBeanList.add(serversBean);
        });
        return serversBeanList;
    }

    @Override
    public String deleteServerById(String id) {
        serversRepository.deleteById(id);
        return "Deleted the server from database";
    }
}
