package com.restApplication.servers.controller;

import com.restApplication.servers.bean.ServersBean;
import com.restApplication.servers.service.ServersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class ServersController {
    @Autowired
    ServersService serversService;
    @PutMapping("/addserver")
    public ResponseEntity<String> addServerDetails(@RequestBody ServersBean serversBean){
        String msg= serversService.addServerDetails(serversBean);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/deleteserver/{id}")
    public ResponseEntity<String> deleteServerDetails(@PathVariable("id")String id){
        String msg=serversService.deleteServerById(id);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
    @GetMapping("/allserverdetails")
    public ResponseEntity<?> getAllServers(){
        List<ServersBean> serversBeanList= serversService.getAllServers();
        if(serversBeanList.isEmpty() || (serversBeanList.size()==1 && serversBeanList.get(0).toString().isBlank())){
            return new ResponseEntity<String>("No Such server found", HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<ServersBean>>(serversBeanList, HttpStatus.OK);
        }
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/allserverdetails/{id}")
    public ResponseEntity<?> getAllServersById(@PathVariable("id")String id){
        List<ServersBean> serversBeanList= serversService.getAllServersById(id);
        if(serversBeanList.isEmpty() || (serversBeanList.size()==1 && serversBeanList.get(0).toString().isBlank())){
            return new ResponseEntity<String>("No Such server found", HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<ServersBean>>(serversBeanList, HttpStatus.OK);
        }
    }
    @GetMapping("/getserver/{name}")
    public ResponseEntity<?> getAllServersByName(@PathVariable("name")String name){
        List<ServersBean> serversBeanList= serversService.getServerByName(name);
        if(serversBeanList.isEmpty() || (serversBeanList.size()==1 && serversBeanList.get(0).toString().isBlank())){
            return new ResponseEntity<String>("No Such server found", HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<ServersBean>>(serversBeanList, HttpStatus.OK);
        }
    }

}
